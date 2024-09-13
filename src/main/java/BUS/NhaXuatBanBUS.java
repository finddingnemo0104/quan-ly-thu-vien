package BUS;

import DAO.NguoiDocDAO;
import DAO.NhaXuatBanDAO;
import DTO.NguoiDocDTO;
import DTO.NhaXuatBanDTO;

import java.util.ArrayList;

public class NhaXuatBanBUS {
    private ArrayList<NhaXuatBanDTO> listNhaXuatBan;
    private NhaXuatBanDAO nhaXuatBanDAO;

    public NhaXuatBanBUS() {
        nhaXuatBanDAO = new NhaXuatBanDAO();
        listNhaXuatBan = new ArrayList<>();
    }

    public ArrayList<NhaXuatBanDTO> getListNhaXuatBan() {
        return listNhaXuatBan;
    }

    public void findAll() {
        listNhaXuatBan = nhaXuatBanDAO.findAll();
    }

    public NhaXuatBanDTO findOne(int id) {
        return nhaXuatBanDAO.findOne(id);
    }

    public boolean insertOne(NhaXuatBanDTO nhaXuatBanDTO) {
        return nhaXuatBanDAO.insertOne(nhaXuatBanDTO);
    }

    public boolean deleteOne(int id) {
        return nhaXuatBanDAO.deleteOne(id);
    }
}
