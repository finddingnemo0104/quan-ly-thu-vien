/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class NhanVienDTO {
    // 0 là nhân viên
    // 1 là quản lý
    public enum VaiTro {
        NHAN_VIEN,
        QUAN_LY;
        @Override
        public String toString() {
            return switch (this) {
                case NHAN_VIEN -> "Nhân viên";
                case QUAN_LY -> "Quản lý";
            };
        }

        public static VaiTro fromString(String vaiTro) {
            return switch (vaiTro) {
                case "Nhân viên" -> NHAN_VIEN;
                case "Quản lý" -> QUAN_LY;
                default -> null;
            };
        }
    }
    // 0 là nghỉ việc
    // 1 là đang làm
    public enum TinhTrangLamViec {
        NGHI_VIEC, DANG_LAM;

        // Get value by toString value
        public static TinhTrangLamViec fromString(String text) {
            return switch (text) {
                case "Nghỉ việc" -> NGHI_VIEC;
                case "Đang làm" -> DANG_LAM;
                default -> throw new IllegalStateException("Unexpected value: " + text);
            };
        }

        @Override
        public String toString() {
            return switch (this) {
                case NGHI_VIEC -> "Nghỉ việc";
                case DANG_LAM -> "Đang làm";
            };
        }
    }

    private int id_NV;
    private String hoten_NV;
    private LocalDate ngaysinh_NV;
    private String diachi_NV;
    private String CCCD;
    private VaiTro vaiTro;
    private String matKhau;
    private TinhTrangLamViec tinhTrangLamViec;

    public NhanVienDTO() {}

    public NhanVienDTO(int ID_NV, String HoTen_NV, LocalDate NgaySinh_NV, String DiaChi_NV, String CCCD, int vaiTro, String MatKhau, int tinhTrangLamViec) {
        this.id_NV = ID_NV;
        this.hoten_NV = HoTen_NV;
        this.ngaysinh_NV = NgaySinh_NV;
        this.diachi_NV = DiaChi_NV;
        this.CCCD = CCCD;
        this.vaiTro = vaiTro == 1 ? VaiTro.QUAN_LY : VaiTro.NHAN_VIEN;
        this.matKhau = MatKhau;
        this.tinhTrangLamViec = TinhTrangLamViec.values()[tinhTrangLamViec];
    }

   
    
    public int getID_NV() {
        return id_NV;
    }

    public void setID_NV(int ID_NV) {
        this.id_NV = ID_NV;
    }

    public String getHoTen_NV() {
        return hoten_NV;
    }

    public void setHoTen_NV(String HoTen_NV) {
        this.hoten_NV = HoTen_NV;
    }

    public LocalDate getngaysinh_NV() {
        return ngaysinh_NV;
    }

    public void setNgaySinh_NV(LocalDate NgaySinh_NV) {
        this.ngaysinh_NV = NgaySinh_NV;
    }

    public String getDiaChi_NV() {
        return diachi_NV;
    }

    public void setDiaChi_NV(String DiaChi_NV) {
        this.diachi_NV = DiaChi_NV;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public int getVaiTro() {
        return vaiTro == VaiTro.QUAN_LY ? 1 : 0;
    }

    public String getVaiTroName() {
        return vaiTro == VaiTro.QUAN_LY ? "Quản lý" : "Nhân viên";
    }

    public void setVaiTro(int TinhTrang_NV) {
        this.vaiTro = TinhTrang_NV == 1 ? VaiTro.QUAN_LY : VaiTro.NHAN_VIEN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.matKhau = MatKhau;
    }

    public TinhTrangLamViec getTinhTrangLamViec() {
        return tinhTrangLamViec;
    }

    public void setTinhTrangLamViec(TinhTrangLamViec tinhTrangLamViec) {
        this.tinhTrangLamViec = tinhTrangLamViec;
    }
}
