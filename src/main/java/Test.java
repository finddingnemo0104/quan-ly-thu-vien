import BUS.*;
import DAO.MyConnection;
import DAO.PhieuMuonDAO;
import DAO.PhieuTraDAO;
import DTO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    int soLuongGenerated = 0;
    int tongSoLuongPhieuMuon = 0;
    int tongSoLuongPhieuTra = 0;
    int soLuongTraDu = 0;
    int soLuongTraThieu = 0;
    int soLuongChuaTra = 0;
    int soLuongTraTreHan = 0;
    public CTPhieuMuonDTO generateRandomCTPhieuMuon(PhieuMuonDTO phieuMuonDTO, ArrayList<SachDTO> allSach) {
        // choose random idSach list
        int indexSach = 1 + (int) (Math.random() * ((allSach.size() - 1 - 1) + 1));
        int idSach = allSach.get(indexSach).getId();
        // choose random soLuong from 1 to 2
        int soLuong = 1 + (int) (Math.random() * ((2 - 1) + 1));

        SachDTO sachDTO = new SachBUS().findone(idSach);
        if (sachDTO == null) {
            System.out.println("Sách không tồn tại");
            return null;
        }

        if (sachDTO.getSoluong() < soLuong) {
            System.out.println("Số lượng sách không đủ");
            return null;
        }
        // check if idSach is already in listCTPhieuMuon
        for (CTPhieuMuonDTO ctPhieuMuonDTO : phieuMuonDTO.getListCTPhieuMuon()) {
            if (ctPhieuMuonDTO.getIdSach() == idSach) {
                System.out.println("Sách đã tồn tại trong phiếu mượn");
                return null;
            }
        }

        System.out.println("idSach: " + idSach + " soLuongHienTai: " + sachDTO.getSoluong() + " soLuongMuon: " + soLuong);

        CTPhieuMuonDTO ctPhieuMuonDTO = new CTPhieuMuonDTO(idSach, phieuMuonDTO.getId_pm(), soLuong);
        return ctPhieuMuonDTO;
    }


    public void insertRandomPhieuMuon(ArrayList<SachDTO> allSach, ArrayList<NhanVienDTO> allNhanVien, ArrayList<NguoiDocDTO> allNguoiDoc) {
        // choose random idNhanVien from 1 to 38

        int indexNhanVien = 1 + (int) (Math.random() * ((allNhanVien.size() - 1 - 1) + 1));
        int idNhanVien = allNhanVien.get(indexNhanVien).getID_NV();
        // choose random idNguoiDoc from 1 to 63

        int indexNguoiDoc = 1 + (int) (Math.random() * ((allNguoiDoc.size() - 1 - 1) + 1));
        long idNguoiDoc = allNguoiDoc.get(indexNguoiDoc).getId();
        // Get NguoiDocDTO by idNguoiDoc
        NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();
        NguoiDocDTO nguoiDocDTO = nguoiDocBUS.findOne(idNguoiDoc);

        PhieuMuonDTO newPhieuMuonDTO = new PhieuMuonDTO();
        newPhieuMuonDTO.setId_pm(MyConnection.getLastRecordId(PhieuMuonDAO.TABLE_NAME) + 1);
        newPhieuMuonDTO.setId_nv(idNhanVien);

        // A random date between 2020-01-01 and 2024-01-01
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 1);
        long randomDays = startDate.toEpochDay() + (long) (Math.random() * (endDate.toEpochDay() - startDate.toEpochDay()));
        newPhieuMuonDTO.setNgay_muon(java.sql.Date.valueOf(LocalDate.ofEpochDay(randomDays)));
        // Ngay tra = Ngay muon + 15 days
        newPhieuMuonDTO.setNgay_Tra(java.sql.Date.valueOf(LocalDate.ofEpochDay(randomDays + 15)));
        newPhieuMuonDTO.setId_ND(idNguoiDoc);
        System.out.println("newPhieuMuonDTO: " + newPhieuMuonDTO.toString());

        // Add from 1-5 random CTPhieuMuon
        int soLuongCTPhieuMuon = 1 + (int) (Math.random() * ((5 - 1) + 1));
        if (nguoiDocDTO.getSoLuongMuonChoPhep() == 0) {
            System.out.println("Số lượng mượn của người đọc đã hết");
            return;
        }

        System.out.println("soLuongCTPhieuMuon: " + soLuongCTPhieuMuon);
        int tongSoLuongMuon = 0;
        for (int i = 0; i < soLuongCTPhieuMuon; i++) {
            CTPhieuMuonDTO ctPhieuMuonDTO = generateRandomCTPhieuMuon(newPhieuMuonDTO, allSach);
            if (ctPhieuMuonDTO == null) {
                continue;
            }
            tongSoLuongMuon += ctPhieuMuonDTO.getSoLuong();

            if (tongSoLuongMuon > nguoiDocDTO.getSoLuongMuonChoPhep()) {
                System.out.println("Số lượng mượn vượt quá số lượng mượn cho phép của người đọc");
                break;
            }
            newPhieuMuonDTO.getListCTPhieuMuon().add(ctPhieuMuonDTO);
        }

        if (newPhieuMuonDTO.getListCTPhieuMuon().size() == 0) {
            System.out.println("Không thể tạo phiếu mượn");
            return;
        }

        // Nếu người đọc quá hạn sử dụng thì không cho mượn
        if (nguoiDocDTO.getHanSuDung().isBefore(LocalDate.now())) {
            System.out.println("Người đọc quá hạn sử dụng vào ngày " + nguoiDocDTO.getHanSuDung() + " không thể mượn sách");
            return;
        }

        // Thêm phiếu mượn
        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        CTPhieuMuonBUS ctPhieuMuonBUS = new CTPhieuMuonBUS();
        phieuMuonBUS.insertOne(newPhieuMuonDTO);
        System.out.println(newPhieuMuonDTO);
        for (CTPhieuMuonDTO ctPhieuMuonDTO : newPhieuMuonDTO.getListCTPhieuMuon()) {
            if (ctPhieuMuonDTO.getSoLuong() > nguoiDocDTO.getSoLuongMuonChoPhep()) {
                System.out.println("Số lượng mượn vượt quá số lượng mượn cho phép của người đọc");
                return;
            }


            // Cap nhat so luong muon cua nguoi doc
            nguoiDocDTO.setSoLuongMuonChoPhep(nguoiDocDTO.getSoLuongMuonChoPhep() - ctPhieuMuonDTO.getSoLuong());
            nguoiDocBUS.updateOne(nguoiDocDTO);
            ctPhieuMuonBUS.insertOne(ctPhieuMuonDTO);
        };
        this.insertRandomPhieuTra(newPhieuMuonDTO);
        tongSoLuongPhieuMuon++;
    }

    // Function to generate random PhieuTra base on PhieuMuon
    public void insertRandomPhieuTra(PhieuMuonDTO phieuMuonDTO) {

        NguoiDocDTO nguoiDocDTOCanThem = new NguoiDocBUS().findOne(phieuMuonDTO.getId_ND());
        int idPhieuTra = MyConnection.getLastRecordId(PhieuTraDAO.TABLE_NAME) + 1;
        // a random date return plus 1 to 30 days from ngayMuon
        LocalDate ngayTra = phieuMuonDTO.getNgay_Tra().toLocalDate();
        LocalDate ngayMuon = phieuMuonDTO.getNgay_muon().toLocalDate();
        long randomDays = ngayMuon.toEpochDay() + (long) (Math.random() * (30 - 1) + 1);
        LocalDate ngayTraThucTe = LocalDate.ofEpochDay(randomDays);
        int soNgayTre = (int) (ngayTraThucTe.toEpochDay() - ngayTra.toEpochDay());
        if (soNgayTre < 0) {
            soNgayTre = 0;
        }
        if (soNgayTre > 0) {
            soLuongTraTreHan++;
        }
        System.out.println("soNgayTre: " + soNgayTre);
        PhieuTraDTO phieuTraDTO = new PhieuTraDTO(idPhieuTra, nguoiDocDTOCanThem.getId(), ngayTraThucTe, 0, phieuMuonDTO.getId_pm());
        // Get phieu muon join sach
        CTPhieuMuonBUS ctPhieuMuonBUS = new CTPhieuMuonBUS();
        Map<CTPhieuMuonDTO, SachDTO> listCTPhieuMuonVaSach = ctPhieuMuonBUS.findManyJoinSach(phieuMuonDTO.getId_pm());

        // tạo 1 xúc xắc 1 hoặc 2 hoặc 3. Nếu là 1 thì trả đủ hoặc 2 thì trả thiếu hoặc 3 là chưa trả
        // tỉ lệ trả đủ là 1 sẽ cao hơn trả thiếu và chưa trả
        int xucXac = 1 + (int) (Math.random() * (5 - 1) + 1);
        if (xucXac == 3 || xucXac == 4) {
            xucXac = 1;
        }
        NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();
        NguoiDocDTO nguoiDocDTO = nguoiDocBUS.findOne(phieuTraDTO.getIdNguoiDoc());

        if (xucXac == 1) {
            // trả đủ
            for (Map.Entry<CTPhieuMuonDTO, SachDTO> entry : listCTPhieuMuonVaSach.entrySet()) {
                CTPhieuMuonDTO ctPhieuMuonDTO = entry.getKey();
                SachDTO sachDTO = entry.getValue();
                int soLuongTra = ctPhieuMuonDTO.getSoLuong();
                // Tính tiền phạt thiếu bao nhiêu sách phạt bằng giá giá sách đó + số lượng trễ, mỗi khi trễ 1 ngày phạt thêm 5% giá sách
                float tienPhat = (ctPhieuMuonDTO.getSoLuong() - soLuongTra) * sachDTO.getGiaSach();
                tienPhat += (float) (sachDTO.getGiaSach() * ctPhieuMuonDTO.getSoLuong() * soNgayTre * 0.05);
                phieuTraDTO.setTienPhat(phieuTraDTO.getTienPhat() + (int) tienPhat);
                CTPhieuTraDTO ctPhieuTraDTO = new CTPhieuTraDTO(sachDTO.getId(), idPhieuTra, soLuongTra, 0);
                phieuTraDTO.getListCTPhieuTra().add(ctPhieuTraDTO);
                System.out.println(ctPhieuTraDTO);
            }
            System.out.println("Trả đủ");
            soLuongTraDu++;
        } else if (xucXac == 2) {
            int soLuongMuonCuaPhieu = 0;
            int soLuongTraCuaPhieuTam = 0;
            // trả thiếu
            for (Map.Entry<CTPhieuMuonDTO, SachDTO> entry : listCTPhieuMuonVaSach.entrySet()) {
                CTPhieuMuonDTO ctPhieuMuonDTO = entry.getKey();
                SachDTO sachDTO = entry.getValue();
                // Random so luong tra from 0 to soLuongMuon
                int soLuongTra = (int) (Math.random() * (ctPhieuMuonDTO.getSoLuong() + 1));
                soLuongMuonCuaPhieu += ctPhieuMuonDTO.getSoLuong();
                soLuongTraCuaPhieuTam += soLuongTra;
                System.out.println("soLuongMuon: " + ctPhieuMuonDTO.getSoLuong());
                System.out.println("soLuongTra: " + soLuongTra);
                // Tính tiền phạt thiếu bao nhiêu sách phạt bằng giá giá sách đó + số lượng trễ, mỗi khi trễ 1 ngày phạt thêm 5% giá sách
                float tienPhat = (ctPhieuMuonDTO.getSoLuong() - soLuongTra) * sachDTO.getGiaSach();
                tienPhat += (float) (sachDTO.getGiaSach() * ctPhieuMuonDTO.getSoLuong() * soNgayTre * 0.05);
                phieuTraDTO.setTienPhat(phieuTraDTO.getTienPhat() + (int) tienPhat);
                CTPhieuTraDTO ctPhieuTraDTO = new CTPhieuTraDTO(sachDTO.getId(), idPhieuTra, soLuongTra, 0);
                phieuTraDTO.getListCTPhieuTra().add(ctPhieuTraDTO);
            }

            // Nếu số lượng mượn của phiếu = số lượng trả của phiếu
            if (soLuongMuonCuaPhieu == soLuongTraCuaPhieuTam) {
                // Giảm só lượng của 1 ct phieu muon bất kỳ 1 đơn vị
                System.out.println("Giảm số lượng của 1 ct phieu muon bất kỳ 1 đơn vị");
                int randomIndex = (int) (Math.random() * ((phieuMuonDTO.getListCTPhieuMuon().size())));
                CTPhieuMuonDTO ctPhieuMuonDTO = phieuMuonDTO.getListCTPhieuMuon().get(randomIndex);
                ctPhieuMuonDTO.setSoLuong(ctPhieuMuonDTO.getSoLuong() - 1);
            }

            System.out.println("Trả thiếu");
            soLuongTraThieu++;
        } else {
            // chưa trả
            System.out.println("Chưa trả");
            nguoiDocDTO.setTrangThaiViPham(NguoiDocDTO.TrangThaiViPham.VI_PHAM);
            soLuongChuaTra++;
            return;
        }
        if (soNgayTre > 0) {
            nguoiDocDTO.setTrangThaiViPham(NguoiDocDTO.TrangThaiViPham.VI_PHAM);
        }

        nguoiDocBUS.updateOne(nguoiDocDTO);

        System.out.println(phieuTraDTO);

        //insert PhieuTra
        PhieuTraBUS phieuTraBUS = new PhieuTraBUS();
        phieuTraBUS.insertOne(phieuTraDTO);
        CTPhieuTraBUS ctPhieuTraBUS = new CTPhieuTraBUS();
        phieuTraDTO.getListCTPhieuTra().forEach(ctPhieuTraDTO -> {
            ctPhieuTraBUS.insertOne(ctPhieuTraDTO);
            // update so luong sach
            SachBUS sachBUS = new SachBUS();
            SachDTO sachDTO = sachBUS.findone(ctPhieuTraDTO.getIdSach());
            sachDTO.setSoluong(sachDTO.getSoluong() + ctPhieuTraDTO.getSoLuong());
            sachBUS.update(sachDTO);

            // cap nhat so luong muon cua nguoi doc
            nguoiDocDTO.setSoLuongMuonChoPhep(nguoiDocDTO.getSoLuongMuonChoPhep() + ctPhieuTraDTO.getSoLuong());
            nguoiDocBUS.updateOne(nguoiDocDTO);
            System.out.println(ctPhieuTraDTO);
        });
        tongSoLuongPhieuTra++;
    }

    public static void changeIdOfAllNguoiDoc() {
        NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();
        nguoiDocBUS.findAll();
        List<NguoiDocDTO> listNguoiDoc = nguoiDocBUS.getListNguoiDoc();
        List<String> listId = new ArrayList<>();
        for (NguoiDocDTO nguoiDocDTO : listNguoiDoc) {
            // a random string with this format
            // 3120410324
            // "31{khoá học}{SỐ random}"
            // Trong đó khoá học là 2 chữ số gồm các khoá học sau: 18, 19, 20, 21, 22, 23, 24
            // Số random là số ngẫu nhiên phải bao gồm 6 chữ số ko được nhỏ hơn 100000
            int khoaHoc = 18 + (int) (Math.random() * ((24 - 18) + 1));
            String randomString = "31" + khoaHoc + (100000 + (int) (Math.random() * ((999999 - 100000) + 1)));
            // kiểm tra xem randomString đã tồn tại trong listId chưa
            while (listId.contains(randomString)) {
                randomString = "31" + khoaHoc + (100000 + (int) (Math.random() * ((999999 - 100000) + 1)));
            }
            listId.add(randomString);
            nguoiDocDTO.setId(Integer.parseInt(randomString));
            System.out.println(nguoiDocDTO.getId());
        }
    }

    public static void main(String[] args) {
        Test test = new Test();

        SachBUS sachBUS = new SachBUS();
        sachBUS.findAll();
        ArrayList<SachDTO> allSach = sachBUS.getListSach();

        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        nhanVienBUS.findALl();
        ArrayList<NhanVienDTO> allNhanVien = nhanVienBUS.getListNhanVien();

        NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();
        nguoiDocBUS.findAll();
        ArrayList<NguoiDocDTO> allNguoiDoc = nguoiDocBUS.getListNguoiDoc();


        test.soLuongGenerated = 150;
        for (int i = 0; i < test.soLuongGenerated; i++) {
            test.insertRandomPhieuMuon(allSach, allNhanVien, allNguoiDoc);
            System.out.println("=====================================");
        }

        // Thống kê
        System.out.println("Số lượng generated: " + test.soLuongGenerated);
        System.out.println("Tổng số lượng phiếu mượn: " + test.tongSoLuongPhieuMuon);
        System.out.println("Tổng số lượng phiếu trả: " + test.tongSoLuongPhieuTra);
        System.out.println("Số lượng trả đủ: " + test.soLuongTraDu);
        System.out.println("Số lượng trả thiếu: " + test.soLuongTraThieu);
        System.out.println("Số lượng chưa trả: " + test.soLuongChuaTra);
        System.out.println("Số lượng trả trễ hạn: " + test.soLuongTraTreHan);

    }
}
