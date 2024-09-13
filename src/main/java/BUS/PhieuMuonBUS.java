package BUS;

import DAO.PhieuMuonDAO;
import DTO.PhieuMuonDTO;

import java.util.ArrayList;

public class PhieuMuonBUS {
    public boolean insertOne(PhieuMuonDTO phieuMuonDTO) {
        try {
            return PhieuMuonDAO.insertOne(phieuMuonDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<PhieuMuonDTO> findAll() {
        try {
            return PhieuMuonDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PhieuMuonDTO findOne(int id) {
        try {
            return PhieuMuonDAO.findOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOne(PhieuMuonDTO phieuMuonDTO) {
        try {
            return PhieuMuonDAO.updateOne(phieuMuonDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int id) {
        try {
            return PhieuMuonDAO.deleteOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<PhieuMuonDTO> findByIdSach(int idSach) {
        try {
            return PhieuMuonDAO.findByIdSach(idSach);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PhieuMuonDTO> findMany(int id, int idNguoiDoc, int idNhanVien, java.util.Date ngayMuonFrom, java.util.Date ngayMuonTo, java.util.Date ngayTraFrom, java.util.Date ngayTraTo) {
        try {
            return PhieuMuonDAO.findMany(id, idNguoiDoc, idNhanVien, ngayMuonFrom, ngayMuonTo, ngayTraFrom, ngayTraTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
