/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PhieuMuonDTO {
    private int id_pm;
    private long id_ND;
    private Date Ngay_muon;
    private Date Ngay_Tra;
    private int id_nv;
    public enum TinhTrang {
        CHUA_TRA, DA_TRA, TRA_THIEU;

        // Get value by toString value
        public static TinhTrang fromString(String text) {
            return switch (text) {
                case "Chưa trả" -> CHUA_TRA;
                case "Đã trả" -> DA_TRA;
                case "Trả thiếu" -> TRA_THIEU;
                default -> throw new IllegalStateException("Unexpected value: " + text);
            };
        }

        @Override
        public String toString() {
            return switch (this) {
                case CHUA_TRA -> "Chưa trả";
                case DA_TRA -> "Đã trả";
                case TRA_THIEU -> "Trả thiếu";
            };
        }
    }
    private TinhTrang tinhTrang;
    private ArrayList<CTPhieuMuonDTO> listCTPhieuMuon;
    private NguoiDocDTO nguoiDocDTO;
    private NhanVienDTO nhanVienDTO;
    
    public PhieuMuonDTO() {
        listCTPhieuMuon = new ArrayList<>();
    }

    public PhieuMuonDTO(int id_pm, long id_ND, Date ngay_muon, Date ngay_Tra, int id_nv, int tinhTrang) {
        this.id_pm = id_pm;
        this.id_ND = id_ND;
        Ngay_muon = ngay_muon;
        Ngay_Tra = ngay_Tra;
        this.id_nv = id_nv;
        listCTPhieuMuon = new ArrayList<>();
        this.tinhTrang = TinhTrang.values()[tinhTrang];
        this.nguoiDocDTO = new NguoiDocDTO();
        this.nhanVienDTO = new NhanVienDTO();
    }

    public ArrayList<CTPhieuMuonDTO> getListCTPhieuMuon() {
        return listCTPhieuMuon;
    }

    public void setListCTPhieuMuon(ArrayList<CTPhieuMuonDTO> listCTPhieuMuon) {
        this.listCTPhieuMuon = listCTPhieuMuon;
    }

    public int getId_pm() {
        return id_pm;
    }

    public void setId_pm(int id_pm) {
        this.id_pm = id_pm;
    }

    public long getId_ND() {
        return id_ND;
    }

    public void setId_ND(long id_ND) {
        this.id_ND = id_ND;
    }

    public Date getNgay_muon() {
        return Ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        Ngay_muon = ngay_muon;
    }

    public Date getNgay_Tra() {
        return Ngay_Tra;
    }

    public void setNgay_Tra(Date ngay_Tra) {
        Ngay_Tra = ngay_Tra;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public TinhTrang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public NguoiDocDTO getNguoiDocDTO() {
        return nguoiDocDTO;
    }

    public void setNguoiDocDTO(NguoiDocDTO nguoiDocDTO) {
        this.nguoiDocDTO = nguoiDocDTO;
    }

    public NhanVienDTO getNhanVienDTO() {
        return nhanVienDTO;
    }

    public void setNhanVienDTO(NhanVienDTO nhanVienDTO) {
        this.nhanVienDTO = nhanVienDTO;
    }
}

