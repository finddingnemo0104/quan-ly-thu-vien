package DTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PhieuTraDTO {
    private int id;
    private long idNguoiDoc;
    private LocalDate ngayTraThatSu;
    private int tienPhat;
    private int idPhieuMuon;
    private NguoiDocDTO nguoiDocDTO;
    private ArrayList<CTPhieuTraDTO> listCTPhieuTra;

    public PhieuTraDTO(int id, long idNguoiDoc, LocalDate ngayTraThatSu, int tienPhat, int idPhieuMuon) {
        this.id = id;
        this.idNguoiDoc = idNguoiDoc;
        this.ngayTraThatSu = ngayTraThatSu;
        this.tienPhat = tienPhat;
        listCTPhieuTra = new ArrayList<>();
        this.idPhieuMuon = idPhieuMuon;
    }

    public String toString() {
        return String.format("%d,%d,%s,%d", id, idNguoiDoc, ngayTraThatSu, tienPhat);
    }

    public ArrayList<CTPhieuTraDTO> getListCTPhieuTra() {
        return listCTPhieuTra;
    }

    public void setListCTPhieuTra(ArrayList<CTPhieuTraDTO> listCTPhieuTra) {
        this.listCTPhieuTra = listCTPhieuTra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdNguoiDoc() {
        return idNguoiDoc;
    }

    public void setIdNguoiDoc(long idNguoiDoc) {
        this.idNguoiDoc = idNguoiDoc;
    }

    public LocalDate getNgayTraThatSu() {
        return ngayTraThatSu;
    }

    public void setNgayTraThatSu(LocalDate ngayTraThatSu) {
        this.ngayTraThatSu = ngayTraThatSu;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public NguoiDocDTO getNguoiDocDTO() {
        return nguoiDocDTO;
    }

    public void setNguoiDocDTO(NguoiDocDTO nguoiDocDTO) {
        this.nguoiDocDTO = nguoiDocDTO;
    }
}
