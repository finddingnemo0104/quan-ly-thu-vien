/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class NhanVienBUS {
    private ArrayList<NhanVienDTO> listNhanVien;
    private NhanVienDAO nhanvienDAO = new NhanVienDAO();
    
    public NhanVienBUS(){
        listNhanVien =  new ArrayList<>();
    }
    
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return listNhanVien;
    }
    
    public void findALl(){
        listNhanVien = nhanvienDAO.findAll();
    }
    
    public NhanVienDTO findOne(int id){
        return nhanvienDAO.findOne(id);
    }
    
    public void findMany(int id, String timHotenNV, int tinhtrangNV, int vaiTro){
        listNhanVien = nhanvienDAO.findMany(id, timHotenNV, tinhtrangNV, vaiTro);
    }
    
    public boolean ThemNhanVien(NhanVienDTO nhanvienDTO){
        if (nhanvienDAO.findOne(nhanvienDTO.getID_NV()) == null) {
            return nhanvienDAO.ThemNhanVien(nhanvienDTO);
        }
        return false;
    }
    
    public boolean updateOne(NhanVienDTO nhanvienDTO) {
        return nhanvienDAO.updateOne(nhanvienDTO);
    }

    public boolean deleteOne(int id) {
        return nhanvienDAO.deleteOne(id);
    }

    public boolean dangNhap(int id, String matKhau){
        return nhanvienDAO.dangNhap(id, matKhau);
    }

    // update password
    public boolean updatePassword(int id, String matKhau) {
        return nhanvienDAO.updatePassword(id, matKhau);
    }

    // check otp
    public boolean checkOTP(int id, String otp) {
        if (otp.equals("1234567890")) {
            return true;
        }
        return false;
    }

    public NhanVienDTO findByVaiTro(int vaiTro) {
        return nhanvienDAO.findByVaiTro(vaiTro);
    }

    public int countQuanLy() {
        return nhanvienDAO.countQuanLy();
    }
}
