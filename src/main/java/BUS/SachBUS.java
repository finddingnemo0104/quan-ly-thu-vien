/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.NhaXuatBanDAO;
import DAO.SachDAO;
import DAO.TacGiaDAO;
import DTO.LoaiSachDTO;
import DTO.SachDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SachBUS {
    private ArrayList<SachDTO> listSach;
    private SachDAO sachDAO = new SachDAO();
    private TacGiaDAO tacGiaDAO;
    private NhaXuatBanDAO nhaXuatBanDAO;
    
    public SachBUS()
    {
        sachDAO = new SachDAO();
        tacGiaDAO = new TacGiaDAO();
        nhaXuatBanDAO = new NhaXuatBanDAO();
        listSach = new ArrayList<>();
    }
    
    public ArrayList<SachDTO> getListSach(){
        return listSach;
    }
    
    public void findAll(){
        listSach = sachDAO.findAll();
        listSach.forEach((sach) -> {
            sach.setTacGia(tacGiaDAO.findOne(sach.getIdTacGia()));
            sach.setNhaXuatBan(nhaXuatBanDAO.findOne(sach.getIdNhaXuatBan()));
        });
    }
    
    public SachDTO findone(int id){
        return sachDAO.findone(id);
    }
    
    public boolean insertone(SachDTO sach){
        return sachDAO.insertone(sach);
    }
    
    public boolean update (SachDTO sach){
        return sachDAO.update(sach);
    }
    
    public boolean delete(int id){
        return sachDAO.delete(id);
    }
    
    public void findMany (int id, String timTenSach, int timLoaiSach){
        listSach = sachDAO.findMany(id, timTenSach, timLoaiSach);
        listSach.forEach((sach) -> {
            sach.setTacGia(tacGiaDAO.findOne(sach.getIdTacGia()));
            sach.setNhaXuatBan(nhaXuatBanDAO.findOne(sach.getIdNhaXuatBan()));
        });
    }

    public ArrayList<LoaiSachDTO> findAllLoaiSach() {
        return sachDAO.findAllLoaiSach();
    }

    public int countSachByIdTacGia(int idTacGia) {
        return sachDAO.countSachByIdTacGia(idTacGia);
    }

    public int countSachByIdNhaXuatBan(int idNhaXuatBan) {
        return sachDAO.countSachByIdNhaXuatBan(idNhaXuatBan);
    }

    public int countSachByIdLoaiSach(int idLoaiSach) {
        return sachDAO.countSachByIdLoaiSach(idLoaiSach);
    }
}
