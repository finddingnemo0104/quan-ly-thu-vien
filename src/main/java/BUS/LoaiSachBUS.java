package BUS;

import DAO.LoaiSachDAO;
import DTO.LoaiSachDTO;

import java.util.ArrayList;

public class LoaiSachBUS {
    private ArrayList<LoaiSachDTO> listLoaiSach;
    private LoaiSachDAO loaiSachDAO;

    public LoaiSachBUS() {
        loaiSachDAO = new LoaiSachDAO();
        listLoaiSach = new ArrayList<>();
    }

    public ArrayList<LoaiSachDTO> getListLoaiSach() {
        return listLoaiSach;
    }

    public void findAll() {
        listLoaiSach = loaiSachDAO.findAll();
    }

    public LoaiSachDTO findOne(int id) {
        return loaiSachDAO.findOne(id);
    }

    // insertOne and deleteOne
    public boolean insertOne(LoaiSachDTO loaiSachDTO) {
        return loaiSachDAO.insertOne(loaiSachDTO);
    }

    public boolean deleteOne(int id) {
        return loaiSachDAO.deleteOne(id);
    }
}
