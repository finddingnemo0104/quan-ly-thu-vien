/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO {
    public static final String TABLE_NAME = "NHAN_VIEN";

    private NhanVienDTO resultSetToNhanVienDTO(ResultSet rs) {
        NhanVienDTO nhanvienDTO = null;
        try {
            nhanvienDTO = new NhanVienDTO(
                    rs.getInt("id"),
                    rs.getString("hoTen"),
                    rs.getDate("ngaySinh").toLocalDate(),
                    rs.getString("diaChi"),
                    rs.getString("CCCD"),
                    rs.getInt("vaiTro"),
                    rs.getString("matKhau"),
                    rs.getInt("tinhTrangLamViec")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvienDTO;
    }

    public boolean ThemNhanVien(NhanVienDTO nhanVien) {
        try {
            Connection con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO NHAN_VIEN(id, hoTen, ngaySinh, diaChi, CCCD, vaiTro, matKhau, tinhTrangLamViec) VALUES(?,?,?,?,?,?,?,?)";
            try {
                Date ngaySinh = Date.valueOf(nhanVien.getngaysinh_NV());

                PreparedStatement prest = con.prepareStatement(queryInsert);
                prest.setInt(1, nhanVien.getID_NV());
                prest.setString(2, nhanVien.getHoTen_NV());
                prest.setDate(3, ngaySinh);
                prest.setString(4, nhanVien.getDiaChi_NV());
                prest.setString(5, nhanVien.getCCCD());
                prest.setInt(6, nhanVien.getVaiTro());
                prest.setString(7, nhanVien.getMatKhau());
                prest.setInt(8, nhanVien.getTinhTrangLamViec().ordinal());
                prest.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e);
                return false;
            }
            con.close();
            return true;
        } catch (Exception e) {
            System.out.print(e);

        }
        return false;
    }

    public ArrayList<NhanVienDTO> findAll() {
        ArrayList<NhanVienDTO> listNhanVien = new ArrayList();
        try {
            Connection con = MyConnection.getConnection();
            Statement st = con.createStatement();
            String queryFindAll = "SELECT * FROM NHAN_VIEN";
            ResultSet rs = st.executeQuery(queryFindAll);
            while (rs.next()) {
                NhanVienDTO nhanvienDTO = new NhanVienDTO(
                        rs.getInt("id"),
                        rs.getString("hoTen"),
                        rs.getDate("ngaySinh").toLocalDate(),
                        rs.getString("diaChi"),
                        rs.getString("CCCD"),
                        rs.getInt("vaiTro"),
                        rs.getString("matKhau"),
                        rs.getInt("tinhTrangLamViec")
                );
                listNhanVien.add(nhanvienDTO);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public NhanVienDTO findOne(int id_NV) {
        NhanVienDTO nhanvienDTO = null;
        try {
            Connection con = MyConnection.getConnection();

            String queryFindOne = "SELECT * FROM NHAN_VIEN WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryFindOne);
            prest.setInt(1, id_NV);
            ResultSet rs = prest.executeQuery();
            if (rs.next()) {
                nhanvienDTO = resultSetToNhanVienDTO(rs);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanvienDTO;
    }

    public ArrayList<NhanVienDTO> findMany(int id, String timHotenNV, int tinhtrangNV, int vaiTro) {
        ArrayList<NhanVienDTO> listResult = null;
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = ""
                    + " SELECT * "
                    + " FROM NHAN_VIEN "
                    + " WHERE ";
            ArrayList<String> queries = new ArrayList<>();
            if (id != -1) {
                queries.add(String.format("id = %d \n", id));
            }
            if (!timHotenNV.equalsIgnoreCase("")) {
                queries.add(String.format("hoten LIKE N'%%%s%%'\n", timHotenNV));
            }
            if (tinhtrangNV != -1) {
                queries.add(String.format("tinhTrangLamViec = %d\n", tinhtrangNV));
            }
            if (vaiTro != -1) {
                queries.add(String.format("vaiTro = %d\n", vaiTro));
            }
            for (int i = 0; i < queries.size(); i++) {
                if (i + 1 < queries.size()) {
                    queryFind += queries.get(i) + "AND";
                } else {
                    queryFind += queries.get(i);
                }
            }
            System.out.println(queryFind);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryFind);
            listResult = new ArrayList<>();
            while (rs.next()) {
                NhanVienDTO nhanvienDTO = resultSetToNhanVienDTO(rs);
                listResult.add(nhanvienDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public boolean updateOne(NhanVienDTO nhanvienDTO) {
        try {
            Connection con = MyConnection.getConnection();
            String queryUpdateOne
                    = " UPDATE NHAN_VIEN"
                    + " SET hoTen=?, ngaySinh=?, diaChi=?, CCCD=?,vaiTro=?,matKhau=?,tinhTrangLamViec=?"
                    + " WHERE id=?";
            PreparedStatement prest = con.prepareStatement(queryUpdateOne);
            Date ngaySinh = Date.valueOf(nhanvienDTO.getngaysinh_NV());
            prest.setString(1, nhanvienDTO.getHoTen_NV());
            prest.setDate(2, ngaySinh);
            prest.setString(3, nhanvienDTO.getDiaChi_NV());
            prest.setString(4, nhanvienDTO.getCCCD());
            prest.setInt(5, nhanvienDTO.getVaiTro());
            prest.setString(6, nhanvienDTO.getMatKhau());
            prest.setInt(7, nhanvienDTO.getTinhTrangLamViec().ordinal());
            prest.setInt(8,nhanvienDTO.getID_NV());
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id) {
        try {
            Connection con = MyConnection.getConnection();
            String queryDeleteOne = "DELETE FROM NHAN_VIEN WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryDeleteOne);
            prest.setInt(1, id);
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean dangNhap(int id, String matKhau) {
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = "SELECT * FROM " + TABLE_NAME + " \n"
                    + "WHERE id = ? AND matKhau = ?";
            PreparedStatement prest = con.prepareStatement(queryFind);
            prest.setInt(1, id);
            prest.setString(2, matKhau);
            ResultSet rs = prest.executeQuery();
            boolean result = rs.next();
            con.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // update password
    public boolean updatePassword(int id, String matKhau) {
        try {
            Connection con = MyConnection.getConnection();
            String queryUpdate = "UPDATE NHAN_VIEN\n" +
                                "SET matKhau = ?\n" +
                                "WHERE id = ?";
            PreparedStatement prest = con.prepareStatement(queryUpdate);
            prest.setString(1, matKhau);
            prest.setInt(2, id);
            int count = prest.executeUpdate();
            con.close();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhanVienDTO findByVaiTro(int vaiTro) {
        try {
            Connection con = MyConnection.getConnection();
            String queryFind = "SELECT *\n" +
                    "FROM NHAN_VIEN\n" +
                    "WHERE vaiTro = ?";
            PreparedStatement prest = con.prepareStatement(queryFind);
            prest.setInt(1, vaiTro);
            ResultSet rs = prest.executeQuery();
            if (rs.next()) {
                NhanVienDTO nhanvienDTO = resultSetToNhanVienDTO(rs);
                return nhanvienDTO;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countQuanLy() {
        try {
            Connection con = MyConnection.getConnection();
            String queryCount = "SELECT COUNT(*) FROM NHAN_VIEN WHERE vaiTro = 1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryCount);
            if (rs.next()) {
                return rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
