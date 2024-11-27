/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import DTO.CTPhieuMuonDTO;
import DTO.NguoiDocDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Administrator
 */
public class CTPhieuMuonDAOTest {
    
    public CTPhieuMuonDAOTest() {
    }

    @Test
public void testFindOneByIdPhieuMuon() throws Exception {
    // Giả sử idPhieuMuon là 1
    int idPhieuMuon = 1;
    
    // Gọi phương thức findMany
    ArrayList<CTPhieuMuonDTO> result = CTPhieuMuonDAO.findMany(idPhieuMuon);
    
    // Kiểm tra kết quả trả về
    assertNotNull(result);
    assertTrue(result.size() > 0); // Giả sử có ít nhất 1 bản ghi với idPhieuMuon = 1
}


    @Test
public void testFindOneByIdPhieuMuonNotFound() throws Exception {
    // Giả sử idPhieuMuon không tồn tại trong cơ sở dữ liệu
    int idPhieuMuon = 9999;
    
    // Gọi phương thức findMany
    ArrayList<CTPhieuMuonDTO> result = CTPhieuMuonDAO.findMany(idPhieuMuon);
    
    // Kiểm tra kết quả trả về
    assertNotNull(result);
    assertTrue(result.isEmpty()); // Kết quả trả về phải rỗng nếu không tìm thấy
}


@Test
public void testFindOneByIdNguoiDoc() throws Exception {
    long idNguoiDoc = 1;
    // Tạo đối tượng NguoiDocDAO và gọi phương thức findOne
    NguoiDocDAO nguoiDocDAO = new NguoiDocDAO();
    NguoiDocDTO nguoiDocDTO = nguoiDocDAO.findOne(idNguoiDoc);
    assertNotNull(nguoiDocDTO);  // Kiểm tra nếu người đọc tồn tại
    assertEquals(idNguoiDoc, nguoiDocDTO.getId()); // Kiểm tra idNguoiDoc khớp với dữ liệu người đọc
    assertNotNull(nguoiDocDTO.getHoTen()); // Kiểm tra tên người đọc có tồn tại
}



@Test
public void testFindOneByIdNguoiDocNotFound() throws Exception {
    long idNguoiDoc = 9999;
    NguoiDocDAO nguoiDocDAO = new NguoiDocDAO();
    NguoiDocDTO nguoiDocDTO = nguoiDocDAO.findOne(idNguoiDoc);
    assertNull(nguoiDocDTO);  // Kiểm tra nếu không tìm thấy người đọc, phải trả về null
}
    
@Test
public void testFindOneByIdNhanVien() throws Exception {
    int idNhanVien = 1;
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    NhanVienDTO nhanVienDTO = nhanVienDAO.findOne(idNhanVien);
    // Kiểm tra kết quả trả về
    assertNotNull(nhanVienDTO);  // Kiểm tra nếu nhân viên tồn tại
    assertEquals(idNhanVien, nhanVienDTO.getID_NV());  // Kiểm tra idNhanVien khớp với dữ liệu nhân viên
    assertNotNull(nhanVienDTO.getHoTen_NV());  // Kiểm tra tên nhân viên có tồn tại
}

    @Test
public void testFindOneByIdNhanVienNotFound() throws Exception {
    int idNhanVien = 9999;
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    NhanVienDTO nhanVienDTO = nhanVienDAO.findOne(idNhanVien);
    assertNull(nhanVienDTO);  // Kiểm tra nếu không tìm thấy nhân viên, phải trả về null
}
}
