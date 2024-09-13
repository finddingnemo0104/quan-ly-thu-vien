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
        try{
            con = MyConnection.getConnection();
            String queryInsert = "INSERT INTO NHA_XUAT_BAN VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(queryInsert);
            ps.setInt(1, nhaXuatBan.getId());
            ps.setString(2, nhaXuatBan.getTen());
            ps.setString(3, nhaXuatBan.getDiaChi());
            ps.setString(4, nhaXuatBan.getSdt());
            ps.setString(5, nhaXuatBan.getEmail());

            int c = ps.executeUpdate();
            con.close();
            return c !=0;
        }  catch (Exception e) {
            e.printStackTrace();
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
