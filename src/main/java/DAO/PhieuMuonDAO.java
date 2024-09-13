package DAO;

import DTO.PhieuMuonDTO;

import java.sql.*;
import java.util.ArrayList;

public class PhieuMuonDAO {
    final public static String TABLE_NAME = "PHIEU_MUON";
    final public static String TABLE_COLUMNS = "id, idNhanVien, idNguoiDoc, ngayMuon, ngayTra";

    public static PhieuMuonDTO resultSetToPhieuMuonDTO(ResultSet rs) throws SQLException {
        PhieuMuonDTO phieuMuonDTO = new PhieuMuonDTO(
                rs.getInt("id"),
                rs.getInt("idNguoiDoc"),
                rs.getDate("ngayMuon"),
                rs.getDate("ngayTra"),
                rs.getInt("idNhanVien")
        );
        return phieuMuonDTO;
    }

    public static boolean insertOne(PhieuMuonDTO phieuMuonDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryInsertOne = "" +
                "INSERT INTO " + TABLE_NAME + "\n" +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement prest = con.prepareStatement(queryInsertOne);
        prest.setInt(1, phieuMuonDTO.getId_pm());
        prest.setInt(2, phieuMuonDTO.getId_nv());
        prest.setInt(3, phieuMuonDTO.getId_ND());
        prest.setDate(4, phieuMuonDTO.getNgay_muon());
        prest.setDate(5, phieuMuonDTO.getNgay_Tra());
        int count = prest.executeUpdate();
        con.close();
        return count != 0;
    }

    public static ArrayList<PhieuMuonDTO> findAll() throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindAll = "SELECT * FROM " + TABLE_NAME;
        PreparedStatement prest = con.prepareStatement(queryFindAll);
        ResultSet rs = prest.executeQuery();
        ArrayList<PhieuMuonDTO> listPhieuMuon = new ArrayList<>();
        while (rs.next()) {
            listPhieuMuon.add(resultSetToPhieuMuonDTO(rs));
        }
        con.close();
        return listPhieuMuon;
    }

    public static PhieuMuonDTO findOne(int id) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryFindOne = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryFindOne);
        prest.setInt(1, id);
        ResultSet rs = prest.executeQuery();
        if (rs.next()) {
            PhieuMuonDTO phieuMuonDTO = resultSetToPhieuMuonDTO(rs);
            return phieuMuonDTO;
        }
        rs.close();
        con.close();
        return null;
    }

    public static boolean updateOne(PhieuMuonDTO phieuMuonDTO) throws Exception {
        Connection con = MyConnection.getConnection();
        String queryUpdateOne = "" +
                "UPDATE " + TABLE_NAME + "\n" +
                "SET idNhanVien = ?, idNguoiDoc = ?, ngayMuon = ?, ngayTra = ? \n" +
                "WHERE id = ?";
        PreparedStatement prest = con.prepareStatement(queryUpdateOne);
        prest.setInt(1, phieuMuonDTO.getId_nv());
        prest.setInt(2, phieuMuonDTO.getId_ND());
        prest.setDate(3, phieuMuonDTO.getNgay_muon());
        prest.setDate(4, phieuMuonDTO.getNgay_Tra());
        prest.setInt(5, phieuMuonDTO.getId_pm());
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

    // Find all PhieuMuonDTO by idSach in ChiTietPhieuMuon
    public static ArrayList<PhieuMuonDTO> findByIdSach(int idSach) {
        ArrayList<PhieuMuonDTO> listPhieuMuon = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String query = "SELECT * FROM CT_PHIEU_MUON WHERE idSach = ?";
            PreparedStatement prest = con.prepareStatement(query);
            prest.setInt(1, idSach);
            ResultSet rs = prest.executeQuery();
            while (rs.next()) {
                int id_pm = rs.getInt("idPhieuMuon");
                PhieuMuonDTO phieuMuonDTO = findOne(id_pm);
                listPhieuMuon.add(phieuMuonDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPhieuMuon;
    }

    // Find many PhieuMuonDTO by idPhieu, idNguoiDoc, idNhanVien, ngayTraFrom, ngayTraTo
    public static ArrayList<PhieuMuonDTO> findMany(int id, int idNguoiDoc, int idNhanVien, java.util.Date ngayMuonFrom, java.util.Date ngayMuonTo, java.util.Date ngayTraFrom, java.util.Date ngayTraTo) {
        ArrayList<PhieuMuonDTO> listPhieuMuon = new ArrayList<>();
        try {
            Connection con = MyConnection.getConnection();
            String queryFindMany = "SELECT * FROM " + TABLE_NAME + " WHERE ";
            ArrayList<String> queries = new ArrayList<>();
            if (id != -1) {
                queries.add("id = " + id + " ");
            }
            if (idNguoiDoc != -1) {
                queries.add("idNguoiDoc = " + idNguoiDoc + " ");
            }
            if (idNhanVien != -1) {
                queries.add("idNhanVien = " + idNhanVien + " ");
            }
            if (ngayMuonFrom != null) {
                queries.add("ngayMuon >= '" + new java.sql.Date(ngayMuonFrom.getTime()) + "' ");
            }
            if (ngayMuonTo != null) {
                queries.add("ngayMuon <= '" + new java.sql.Date(ngayMuonTo.getTime()) + "' ");
            }
            if (ngayTraFrom != null) {
                queries.add("ngayTra >= '" + new java.sql.Date(ngayTraFrom.getTime()) + "' ");
            }
            if (ngayTraTo != null) {
                queries.add("ngayTra <= '" + new java.sql.Date(ngayTraTo.getTime()) + "' ");
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
                listPhieuMuon.add(resultSetToPhieuMuonDTO(rs));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPhieuMuon;
    }
}
