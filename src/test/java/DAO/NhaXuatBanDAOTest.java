package DAO;

import DTO.NhaXuatBanDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class NhaXuatBanDAOTest {
    
    public NhaXuatBanDAOTest() {
    }

    @Test
    @DisplayName("Không thêm được nhà xuất bản khi tên trống")
    public void testInsertWithEmptyName() {
        NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(0, "", "Địa chỉ", "123456789", "nha@xuatban.com");
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        assertFalse(nhaXuatBanDAO.insertOne(nhaXuatBan));  // Kỳ vọng không thể thêm vì tên trống
    }

    @Test
    @DisplayName("Không thêm được nhà xuất bản khi tên chỉ chứa khoảng trắng")
    public void testInsertWithWhitespaceName() {
        NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(0, "    ", "Địa chỉ", "987654321", "nha2@xuatban.com");
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        assertFalse(nhaXuatBanDAO.insertOne(nhaXuatBan));  // Kỳ vọng không thể thêm vì tên chỉ chứa khoảng trắng 
        // FAIL
    }

    @Test
    @DisplayName("Không thêm được nhà xuất bản khi tên chứa ký tự đặc biệt")
    public void testInsertWithSpecialCharacterName() {
        NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(0, "Nhà Xuất Bản @!", "Địa chỉ", "123456789", "nha3@xuatban.com");
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        assertFalse(nhaXuatBanDAO.insertOne(nhaXuatBan));  // Kỳ vọng không thể thêm vì tên có ký tự đặc biệt
        // FAIL
    }

    @Test
    @DisplayName("Không thêm được nhà xuất bản khi tên chỉ chứa số")
    public void testInsertWithNumericName() {
        NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(0, "12345", "Địa chỉ", "123456789", "nha4@xuatban.com");
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        assertFalse(nhaXuatBanDAO.insertOne(nhaXuatBan));  // Kỳ vọng không thể thêm vì tên chỉ chứa số
        // FAIL
    }

    @Test
    @DisplayName("Không thêm được nhà xuất bản khi tên đã tồn tại")
    public void testInsertWithExistingName() {
        NhaXuatBanDTO nhaXuatBan1 = new NhaXuatBanDTO(0, "NXB ABC", "Địa chỉ 1", "123456789", "nha1@xuatban.com");
        NhaXuatBanDTO nhaXuatBan2 = new NhaXuatBanDTO(0, "NXB ABC", "Địa chỉ 2", "987654321", "nha2@xuatban.com");
        
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        nhaXuatBanDAO.insertOne(nhaXuatBan1);  // Thêm thành công
        assertFalse(nhaXuatBanDAO.insertOne(nhaXuatBan2));  // Kỳ vọng không thể thêm vì tên đã tồn tại
        // FAIL
    }

    @Test
    @DisplayName("Xóa nhà xuất bản thành công")
    public void testDeletePublisher() {
        NhaXuatBanDTO nhaXuatBan = new NhaXuatBanDTO(0, "NXB XYZ", "Địa chỉ XYZ", "123456789", "nha3@xuatban.com");
        NhaXuatBanDAO nhaXuatBanDAO = new NhaXuatBanDAO();
        nhaXuatBanDAO.insertOne(nhaXuatBan);  // Thêm trước khi xóa
        assertTrue(nhaXuatBanDAO.deleteOne(0));  // Kỳ vọng xóa thành công
    }
}
