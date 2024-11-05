package DAO;

import DTO.NguoiDocDTO;
import DTO.PhieuTraDTO;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PhieuTraDAO {
    final public static String TABLE_NAME = "PHIEU_TRA";
    final public static String TABLE_COLUMNS = "id, idNguoiDoc, ngayTraThatSu, tienPhat";

    public static PhieuTraDTO resultSetToPhieuTraDTO(ResultSet rs) throws SQLException {
        PhieuTraDTO phieuTraDTO = new PhieuTraDTO(
                rs.getInt(1),
                rs.getLong(2),
                rs.getDate(3).toLocalDate(),
                rs.getInt(4),
                rs.getInt(5)
        );
        return phieuTraDTO;
    }

    public static boolean insertOne(PhieuTraDTO phieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryInsertOne = "" +
                "INSERT INTO " + TABLE_NAME + "\n" +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prest = con.prepareStatement(queryInsertOne);
        prest.setInt(1, phieuTraDTO.getId());
        prest.setLong(2, phieuTraDTO.getIdNguoiDoc());
        prest.setDate(3, Date.valueOf(phieuTraDTO.getNgayTraThatSu()));
        prest.setInt(4, phieuTraDTO.getTienPhat());
        prest.setInt(5, phieuTraDTO.getIdPhieuMuon());

        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static ArrayList<PhieuTraDTO> findAll() throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "SELECT *, NGUOI_DOC.hoTen as tenNguoiDoc FROM " + TABLE_NAME + " JOIN NGUOI_DOC ON PHIEU_TRA.idNguoiDoc = NGUOI_DOC.id ORDER BY PHIEU_TRA.id";
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        ResultSet rs = prest.executeQuery();
        ArrayList<PhieuTraDTO> listPhieuTra = new ArrayList<>();
        while (rs.next()) {
            PhieuTraDTO phieuTraDTO = resultSetToPhieuTraDTO(rs);
            phieuTraDTO.setNguoiDocDTO(new NguoiDocDTO());
            phieuTraDTO.getNguoiDocDTO().setHoTen(rs.getString("tenNguoiDoc"));
            listPhieuTra.add(phieuTraDTO);
        }
        con.close();
        return listPhieuTra;
    }

    public static ArrayList<PhieuTraDTO> findMany(int id, long idNguoiDoc, java.util.Date ngayTraFrom, java.util.Date ngayTraTo) throws Exception {
        ArrayList<PhieuTraDTO> listPhieuTra = new ArrayList<>();
        Connection con = MyConnection.getConnection();
        String queryFindMany = "" +
                "SELECT *, NGUOI_DOC.hoTen as tenNguoiDoc " +
                "FROM " + TABLE_NAME + "\n" +
                "JOIN NGUOI_DOC ON PHIEU_TRA.idNguoiDoc = NGUOI_DOC.id  " +
                "WHERE ";
        ArrayList<String> queries = new ArrayList<>();
        if (id != -1) {
            queries.add(String.format("PHIEU_TRA.id = %d \n", id));
        }
        if (idNguoiDoc != -1) {
            queries.add(String.format("PHIEU_TRA.idNguoiDoc = %d \n", idNguoiDoc));
        }
        if (ngayTraFrom != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTraThatSuFrom = sdf.format(ngayTraFrom);
            queries.add(String.format("ngayTraThatSu >= '%s' \n", ngayTraThatSuFrom));
        }
        if (ngayTraTo != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTraThatSuTo = sdf.format(ngayTraTo);
            queries.add(String.format("ngayTraThatSu <= '%s' \n", ngayTraThatSuTo));
        }

        for (int i = 0; i < queries.size(); i++) {
            if (i + 1 < queries.size()) {
                queryFindMany += queries.get(i) + "AND ";
            } else {
                queryFindMany += queries.get(i);
            }
        }
        System.out.println(queryFindMany);
        PreparedStatement prest = con.prepareStatement(queryFindMany);
        ResultSet rs = prest.executeQuery();
        while (rs.next()) {
            PhieuTraDTO phieuTraDTO = resultSetToPhieuTraDTO(rs);
            phieuTraDTO.setNguoiDocDTO(new NguoiDocDTO());
            phieuTraDTO.getNguoiDocDTO().setHoTen(rs.getString("tenNguoiDoc"));
            listPhieuTra.add(phieuTraDTO);
        }
        return listPhieuTra;
    }

    public static PhieuTraDTO findOne(int id) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, id);
        ResultSet rs = prest.executeQuery();
        if (rs.next()) {
            PhieuTraDTO phieuTraDTO = resultSetToPhieuTraDTO(rs);
            return phieuTraDTO;
        }
        rs.close();
        con.close();
        return null;
    }

    public static boolean updateOne(PhieuTraDTO phieuTraDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryUpdateOne = "" +
                "UPDATE " + TABLE_NAME + "\n" +
                "SET idNguoiDoc = ?, ngayTraThatSu = ?, tienPhat = ?, idPhieuMuon = ? \n" +
                "WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryUpdateOne);
        prest.setLong(1, phieuTraDTO.getIdNguoiDoc());
        prest.setDate(2, Date.valueOf(phieuTraDTO.getNgayTraThatSu()));
        prest.setInt(3, phieuTraDTO.getTienPhat());
        prest.setInt(4, phieuTraDTO.getIdPhieuMuon());
        prest.setInt(5, phieuTraDTO.getId());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static boolean deleteOne(int id) throws Exception {
        Connection con = MyConnection.getConnection();
        String querydeleteOne = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(querydeleteOne);
        prest.setInt(1, id);
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static PhieuTraDTO findByIdPhieuMuon(int idPhieuMuon) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "SELECT * FROM " + TABLE_NAME + " WHERE idPhieuMuon = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, idPhieuMuon);
        ResultSet rs = prest.executeQuery();
        if (rs.next()) {
            PhieuTraDTO phieuTraDTO = resultSetToPhieuTraDTO(rs);
            return phieuTraDTO;
        }
        rs.close();
        con.close();
        return null;
    }
}
