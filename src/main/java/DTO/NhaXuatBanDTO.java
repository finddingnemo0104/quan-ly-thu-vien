/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhaXuatBanDTO {
    public final String []columns = {"id", "ten", "diachi", "sdt", "email"};
    public static final String TABLE_NAME = "NHA_XUAT_BAN";
    int id;
    String ten;
    String diaChi;
    String sdt;
    String email;

    public NhaXuatBanDTO() {
    }

    public NhaXuatBanDTO(int id, String ten, String diachi, String sdt, String email) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
