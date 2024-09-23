package BUS;

import DAO.CTPhieuMuonDAO;
import DAO.SachDAO;
import DTO.CTPhieuMuonDTO;
import DTO.SachDTO;

import java.util.ArrayList;
import java.util.Map;

public class CTPhieuMuonBUS {
    private SachDAO sachDAO;

    public CTPhieuMuonBUS() {
        sachDAO = new SachDAO();
    }


    public boolean insertOne(CTPhieuMuonDTO ctPhieuMuonDTO)  {
        try {
            CTPhieuMuonDAO.insertOne(ctPhieuMuonDTO);
            // Cap nhat so luong sach
            int idSach = ctPhieuMuonDTO.getIdSach();
            SachDTO sachDTO = sachDAO.findone(idSach);
            sachDTO.setSoluong(sachDTO.getSoluong() - ctPhieuMuonDTO.getSoLuong());
            if (sachDTO.getSoluong() == 0) {
                sachDTO.setTrangthai(SachDTO.TrangThaiSach.HET_SACH.ordinal());
            }

            sachDAO.update(sachDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<CTPhieuMuonDTO> findAll()  {
        try {
            return CTPhieuMuonDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CTPhieuMuonDTO> findMany(int idPhieuMuon)  {
        try {
            return CTPhieuMuonDAO.findMany(idPhieuMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<CTPhieuMuonDTO, SachDTO> findManyJoinSach(int idPhieuMuon) {
        try {
            return CTPhieuMuonDAO.findManyJoinSach(idPhieuMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public CTPhieuMuonDTO findOne(int idSach, int idPhieuMuon)  {
        try {
            return CTPhieuMuonDAO.findOne(idSach, idPhieuMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateOne(CTPhieuMuonDTO ctPhieuMuonDTO)  {
        try {
            return CTPhieuMuonDAO.updateOne(ctPhieuMuonDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteOne(int idSach, int idPhieuMuon)  {
        try {
            return CTPhieuMuonDAO.deleteOne(idSach, idPhieuMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int deleteMany(int idPhieuMuon) {
        try {
            return CTPhieuMuonDAO.deleteMany(idPhieuMuon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
