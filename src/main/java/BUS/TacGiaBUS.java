package BUS;

import DAO.TacGiaDAO;
import DTO.TacGiaDTO;

import java.util.ArrayList;

public class TacGiaBUS {
    private ArrayList<TacGiaDTO> listTacGia;
    private TacGiaDAO tacGiaDAO;

    public TacGiaBUS() {
        tacGiaDAO = new TacGiaDAO();
        listTacGia = new ArrayList<>();
    }

    public ArrayList<TacGiaDTO> getListTacGia() {
        return listTacGia;
    }

    public void findAll() {
        listTacGia = tacGiaDAO.findAll();
    }

    public TacGiaDTO findOne(int id) {
        return tacGiaDAO.findOne(id);
    }

    public boolean insertOne(TacGiaDTO tacGia) {
        return tacGiaDAO.insertOne(tacGia);
    }

    public boolean updateOne(TacGiaDTO tacGia) {
        return tacGiaDAO.updateOne(tacGia);
    }

    public boolean deleteOne(int id) {
        return tacGiaDAO.deleteOne(id);
    }
}
