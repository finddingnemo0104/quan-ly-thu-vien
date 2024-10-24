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
public class SachDTO {
    public enum TrangThaiSach {
        CO_THE_MUON, HET_SACH, DANG_NHAP_KHO;

        // Get value by toString value
        public static TrangThaiSach fromString(String text) {
            return switch (text) {
                case "Có thể mượn" -> CO_THE_MUON;
                case "Hết sách" -> HET_SACH;
                case "Đang nhập kho" -> DANG_NHAP_KHO;
                default -> throw new IllegalStateException("Unexpected value: " + text);
            };
        }

        @Override
        public String toString() {
            return switch (this) {
                case CO_THE_MUON -> "Có thể mượn";
                case HET_SACH -> "Hết sách";
                case DANG_NHAP_KHO -> "Đang nhập kho";
            };
        }
    }


    int id;
    String tenSach;
    int giaSach;
    int soluong;
    TrangThaiSach trangthai;
    int idTacGia;
    int idNhaXuatBan;
    int idLoaiSach;

    TacGiaDTO tacGia;
    NhaXuatBanDTO nhaXuatBan;

    public SachDTO() {
    }

    public SachDTO(int id, String tenSach, int giaSach, int soluong, int trangthai, int idTacGia, int idNhaXuatBan, int idLoaiSach) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaSach = giaSach;
        this.soluong = soluong;
        this.trangthai = TrangThaiSach.values()[trangthai];
        this.idTacGia = idTacGia;
        this.idNhaXuatBan = idNhaXuatBan;
        this.idLoaiSach = idLoaiSach;
        this.tacGia = new TacGiaDTO();
        this.nhaXuatBan = new NhaXuatBanDTO();
    }

    public SachDTO(int id, String tenSach, int giaSach, int soluong, int trangthai, int idTacGia, int idNhaXuatBan, int idLoaiSach, String tenTacGia, String tenNhaXuatBan) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaSach = giaSach;
        this.soluong = soluong;
        this.trangthai = TrangThaiSach.values()[trangthai];
        this.idTacGia = idTacGia;
        this.idNhaXuatBan = idNhaXuatBan;
        this.idLoaiSach = idLoaiSach;
        this.tacGia = new TacGiaDTO();
        this.nhaXuatBan = new NhaXuatBanDTO();
        this.tacGia.setHoTen(tenTacGia);
        this.nhaXuatBan.setTen(tenNhaXuatBan);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(int giaSach) {
        this.giaSach = giaSach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public TrangThaiSach getTrangThaiSach() {
        return trangthai;
    }
    public int getTrangthai() {
        return trangthai.ordinal();
    }

    public String getTrangThaiName() {
        return trangthai.name();
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = TrangThaiSach.values()[trangthai];
    }

    public int getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(int idTacGia) {
        this.idTacGia = idTacGia;
    }

    public int getIdNhaXuatBan() {
        return idNhaXuatBan;
    }

    public void setIdNhaXuatBan(int idNhaXuatBan) {
        this.idNhaXuatBan = idNhaXuatBan;
    }

    public int getIdLoaiSach() {
        return idLoaiSach;
    }

    public void setIdLoaiSach(int idLoaiSach) {
        this.idLoaiSach = idLoaiSach;
    }

    public TacGiaDTO getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGiaDTO tacGia) {
        this.tacGia = tacGia;
    }

    public NhaXuatBanDTO getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(NhaXuatBanDTO nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    @Override
    public String toString() {
        return getTenSach();
    }
}
