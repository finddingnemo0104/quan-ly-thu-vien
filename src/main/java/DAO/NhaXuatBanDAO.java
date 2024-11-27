package DAO;

import DTO.NhaXuatBanDTO;

import java.sql.*;
import java.util.ArrayList;

public class NhaXuatBanDAO {
    private NhaXuatBanDTO resultSetNhaXuatBan(ResultSet rs) {
        NhaXuatBanDTO nhaXuatBan = null;
        try {
            nhaXuatBan = new NhaXuatBanDTO(
                    rs.getInt("id"),
                    rs.getString("ten"),
                    rs.getString("diachi"),
                    rs.getString("sdt"),
                    rs.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhaXuatBan;
    }


public boolean insertOne(NhaXuatBanDTO nhaXuatBan) {
    Connection con = null;
    try {
        // Kiểm tra dữ liệu đầu vào
        String tenNhaXuatBan = nhaXuatBan.getTen() != null ? nhaXuatBan.getTen().trim() : "";
        if (tenNhaXuatBan.isEmpty()) {
            System.out.println("Lỗi: Tên nhà xuất bản không được để trống.");
            return false;
        }
        if (!tenNhaXuatBan.matches("^[\\p{L}\\s]+$")) {
            System.out.println("Lỗi: Tên nhà xuất bản chỉ được chứa chữ cái và khoảng trắng.");
            return false;
        }
        if (isNameExists(tenNhaXuatBan)) {
            System.out.println("Lỗi: Tên nhà xuất bản đã tồn tại.");
            return false;
        }

        // Kết nối cơ sở dữ liệu
        con = MyConnection.getConnection();
        String queryInsert = "INSERT INTO NHA_XUAT_BAN (id, ten, diachi, sdt, email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(queryInsert);
        ps.setInt(1, nhaXuatBan.getId());
        ps.setString(2, nhaXuatBan.getTen());
        ps.setString(3, nhaXuatBan.getDiaChi());
        ps.setString(4, nhaXuatBan.getSdt());
        ps.setString(5, nhaXuatBan.getEmail());

        int c = ps.executeUpdate();
        if (c > 0) {
            System.out.println("Thêm nhà xuất bản thành công!");
            return true;
        } else {
            System.out.println("Lỗi: Không thể thêm nhà xuất bản.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close(); // Đảm bảo đóng kết nối
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return false;
}


// Hàm kiểm tra tên nhà xuất bản đã tồn tại
private boolean isNameExists(String tenNhaXuatBan) {
    Connection con = null;
    try {
        con = MyConnection.getConnection();
        String queryCheck = "SELECT COUNT(*) FROM NHA_XUAT_BAN WHERE TEN = ?";
        PreparedStatement ps = con.prepareStatement(queryCheck);
        ps.setString(1, tenNhaXuatBan.trim());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // Nếu số lượng > 0, tên đã tồn tại
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null) {
                con.close(); // Đóng kết nối
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    return false;
}


    public ArrayList<NhaXuatBanDTO> findAll(){
        ArrayList<NhaXuatBanDTO> listNhaXuatBan = new ArrayList();
        try{
            Connection con = MyConnection.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT * FROM NHA_XUAT_BAN";
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("diachi"),
                        rs.getString("sdt"),
                        rs.getString("email")
                );
                listNhaXuatBan.add(nhaXuatBan);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhaXuatBan;
    }

    public NhaXuatBanDTO findOne(int id){
        NhaXuatBanDTO nhaXuatBanDTO = null;
        try{
            Connection con = MyConnection.getConnection();
            String query = "SELECT * FROM NHA_XUAT_BAN WHERE id=?";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                nhaXuatBanDTO = resultSetNhaXuatBan(rs);
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nhaXuatBanDTO;
    }

    public boolean updateOne(NhaXuatBanDTO nhaXuatBanDTO)
    {
        try{
            Connection con = MyConnection.getConnection();
            String queryUpdate = "UPDATE NHA_XUAT_BAN SET ten=?, diachi=?, sdt=?, email=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(queryUpdate);
            ps.setString(1, nhaXuatBanDTO.getTen());
            ps.setString(2, nhaXuatBanDTO.getDiaChi());
            ps.setString(3, nhaXuatBanDTO.getSdt());
            ps.setString(4, nhaXuatBanDTO.getEmail());
            ps.setInt(5, nhaXuatBanDTO.getId());

            int count= ps.executeUpdate();
            con.close();
            return count != 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id)
    {
        try{
            Connection con = MyConnection.getConnection();
            String queryDelete = "DELETE FROM NHA_XUAT_BAN WHERE id=?";
            PreparedStatement ps = con.prepareStatement(queryDelete);
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            con.close();
            return count != 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
