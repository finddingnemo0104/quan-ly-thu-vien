package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;

public class TaiKhoanBUS {
    public TaiKhoanBUS() {
    }
    public boolean themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        return TaiKhoanDAO.themTaiKhoan(taiKhoanDTO);
    }
    public boolean checkTaiKhoan(int id, String matKhau) {
        return TaiKhoanDAO.checkTaiKhoan(id, matKhau);
    }

    // check otp
    public boolean checkOTP(int id, String otp) {
        if (otp.equals("1234567890")) {
            return true;
        }
        return false;
    }

    // update password
    public boolean updatePassword(int id, String matKhau) {
        return TaiKhoanDAO.updatePassword(id, matKhau);
    }
}
