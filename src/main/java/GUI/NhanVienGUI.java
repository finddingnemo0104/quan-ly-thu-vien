/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DAO.MyConnection;
import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import Helpler.Helpler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author pc
 */
public class NhanVienGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienGUI
     */

    private DefaultTableModel nhanvienModel;
    private NhanVienDTO nhanVienDangNhap;

    public NhanVienGUI(NhanVienDTO nhanVienDangNhap) {
        initComponents();
        Helpler.centerCell(jTableNhanVien);
        this.nhanVienDangNhap = nhanVienDangNhap;
        setTableItemList();
    }

    public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public void setTableItemList() {
        NhanVienBUS nhanvienBUS = new NhanVienBUS();
        nhanvienBUS.findALl();
        setTableItemList(nhanvienBUS);
    }

    public void setTableItemList(NhanVienBUS nhanvienBUS) {
        nhanvienModel = (DefaultTableModel) jTableNhanVien.getModel();
        nhanvienModel.setRowCount(0);
        ArrayList<NhanVienDTO> listNhanVien = nhanvienBUS.getListNhanVien();
        listNhanVien.forEach(ele -> {
            nhanvienModel.addRow(new Object[]{
                    ele.getID_NV(),
                    ele.getHoTen_NV(),
                    ele.getngaysinh_NV().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    ele.getDiaChi_NV(),
                    ele.getCCCD(),
                    ele.getVaiTroName(),
                    ele.getMatKhau(),
                    ele.getTinhTrangLamViec().toString()
            });
        });
    }

    public void clearAllTextField() {
        // Them
        jTxtHoten.setText("");
        jTxtNgaySinh.setDate(null);
        jTxtDiachi.setText("");
        jTxtCmnd.setText("");
        // Sua
        jTxtHotenSua.setText("");
        jTxtNgaysinhSua.setDate(null);
        jTxtDiachiSua.setText("");
        jTxtCmndSua.setText("");
        // Tim Kiem
        jTxtIDTimKiem.setText("");
        jTxtHotenTimKiem.setText("");
    }

    public boolean checkTextField(String option) {
        String hoten = jTxtHoten.getText();
        Date ngaysinh = jTxtNgaySinh.getDate();
        String diachi = jTxtDiachi.getText();
        String cmnd = jTxtCmnd.getText();

        if (option.equals("Sua")) {
            hoten = jTxtHotenSua.getText();
            ngaysinh = jTxtNgaysinhSua.getDate();
            diachi = jTxtDiachiSua.getText();
            cmnd = jTxtCmndSua.getText();
        }

        if (hoten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên");
            return false;
        }
        // Họ tên <= 256 ký tự
        if (hoten.length() > 256) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên nhỏ hơn 256 ký tự");
            return false;
        }

        // Kiểm tra ngày sinh
        if (ngaysinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh");
            return false;
        }

        // Ngày sinh > 18 tuổi và < 100 tuổi
        if (!Helpler.isOlderThan18(ngaysinh)) {
            JOptionPane.showMessageDialog(this, "Nhân viên phải trên 18 tuổi");
            return false;
        }
        if (!Helpler.isYoungerThan100(ngaysinh)) {
            JOptionPane.showMessageDialog(this, "Nhân viên phải dưới 100 tuổi");
            return false;
        }

        if (diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
            return false;
        }
        // Địa chỉ <= 256 ký tự
        if (diachi.length() > 256) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ nhỏ hơn 256 ký tự");
            return false;
        }

        // Kiểm tra cmnd
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập CMND");
            return false;
        }
        // Kiểm tra cmnd chỉ chứa số
        if (!cmnd.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập chữ số trong cmnd");
            return false;
        }

        // Kiểm tra cmnd có đúng 12 số
        if (cmnd.length() != 12) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng 12 số trong cmnd");
            return false;
        }
        return true;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDialogThem = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtDiachi = new javax.swing.JTextField();
        jTxtHoten = new javax.swing.JTextField();
        jTxtCmnd = new javax.swing.JTextField();
        jBtnXacNhanThem = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jTxtMatKhau = new javax.swing.JTextField();
        cbTinhTrangLamViec = new javax.swing.JComboBox<>();
        jTxtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cbVaiTroLamViec = new javax.swing.JComboBox<>();
        JDialogSua = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTxtDiachiSua = new javax.swing.JTextField();
        jTxtHotenSua = new javax.swing.JTextField();
        jTxtCmndSua = new javax.swing.JTextField();
        jBtnXacNhanSua = new javax.swing.JButton();
        cbVaiTroLamViecSua = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jTxtMatKhauSua = new javax.swing.JTextField();
        jTxtNgaysinhSua = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        cbTinhTrangLamViecSua = new javax.swing.JComboBox<>();
        JDialogTimKiem = new javax.swing.JDialog();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTxtIDTimKiem = new javax.swing.JTextField();
        jTxtHotenTimKiem = new javax.swing.JTextField();
        jBtnXacNhanTimKiem = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        cbTinhTrangLamViecTimKiem = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cbVaiTroTimKiem = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jBtnThem = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jBtnSua = new javax.swing.JButton();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jBtnTimkiem = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jBtnHuyTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        JDialogThem.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        JDialogThem.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel3.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("THÊM NHÂN VIÊN");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel7.setText("CCCD:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel8.setText("Vai trò");

        jTxtDiachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDiachiActionPerformed(evt);
            }
        });

        jTxtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenActionPerformed(evt);
            }
        });

        jTxtCmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCmndActionPerformed(evt);
            }
        });

        jBtnXacNhanThem.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanThem.setText("THÊM");
        jBtnXacNhanThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanThemActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel16.setText("Mật khẩu");

        jTxtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMatKhauActionPerformed(evt);
            }
        });

        jTxtNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel10.setText("Tình Trạng làm việc");

        javax.swing.GroupLayout JDialogThemLayout = new javax.swing.GroupLayout(JDialogThem.getContentPane());
        JDialogThem.getContentPane().setLayout(JDialogThemLayout);
        JDialogThemLayout.setHorizontalGroup(
            JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogThemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JDialogThemLayout.createSequentialGroup()
                        .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbTinhTrangLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTxtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbVaiTroLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBtnXacNhanThem)))))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        JDialogThemLayout.setVerticalGroup(
            JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTxtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTxtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbVaiTroLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTxtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTinhTrangLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtnXacNhanThem)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        JDialogSua.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel9.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("SỬA NHÂN VIÊN");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel11.setText("Họ và tên:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Ngày sinh:");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel13.setText("Địa chỉ:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Số CCCD:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Vai Trò");

        jTxtHotenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenSuaActionPerformed(evt);
            }
        });

        jBtnXacNhanSua.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanSua.setText("Sửa");
        jBtnXacNhanSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanSuaActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel17.setText("Mật khẩu");

        jTxtMatKhauSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtMatKhauSuaActionPerformed(evt);
            }
        });

        jTxtNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel18.setText("Tình Trạng làm việc");

        javax.swing.GroupLayout JDialogSuaLayout = new javax.swing.GroupLayout(JDialogSua.getContentPane());
        JDialogSua.getContentPane().setLayout(JDialogSuaLayout);
        JDialogSuaLayout.setHorizontalGroup(
            JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogSuaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addContainerGap())
                    .addGroup(JDialogSuaLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 271, Short.MAX_VALUE))
                    .addGroup(JDialogSuaLayout.createSequentialGroup()
                        .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel15)
                            .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JDialogSuaLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jBtnXacNhanSua)
                                .addGap(0, 267, Short.MAX_VALUE))
                            .addGroup(JDialogSuaLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtMatKhauSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTinhTrangLamViecSua, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDiachiSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtCmndSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtNgaysinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtHotenSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbVaiTroLamViecSua, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        JDialogSuaLayout.setVerticalGroup(
            JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogSuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTxtHotenSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jTxtNgaysinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTxtDiachiSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTxtCmndSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbVaiTroLamViecSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtMatKhauSua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(JDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTinhTrangLamViecSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnXacNhanSua)
                .addGap(15, 15, 15))
        );

        JDialogTimKiem.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel23.setFont(new java.awt.Font("Tiffany-u-Heavy", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 51, 0));
        jLabel23.setText("TÌM KIẾM NHÂN VIÊN");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel24.setText("ID Nhân Viên:");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel25.setText("Họ và tên:");

        jTxtHotenTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtHotenTimKiemActionPerformed(evt);
            }
        });

        jBtnXacNhanTimKiem.setBackground(new java.awt.Color(102, 255, 51));
        jBtnXacNhanTimKiem.setText("Tìm kiếm");
        jBtnXacNhanTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnXacNhanTimKiemActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel26.setText("Tình trạng làm việc");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel27.setText("Vai trò");

        javax.swing.GroupLayout JDialogTimKiemLayout = new javax.swing.GroupLayout(JDialogTimKiem.getContentPane());
        JDialogTimKiem.getContentPane().setLayout(JDialogTimKiemLayout);
        JDialogTimKiemLayout.setHorizontalGroup(
            JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                        .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtIDTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtHotenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTinhTrangLamViecTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbVaiTroTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(164, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnXacNhanTimKiem)
                .addGap(60, 60, 60))
        );
        JDialogTimKiemLayout.setVerticalGroup(
            JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTxtIDTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTxtHotenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(cbTinhTrangLamViecTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbVaiTroTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119)
                .addComponent(jBtnXacNhanTimKiem)
                .addContainerGap())
        );

        jBtnThem.setText("THÊM");
        jBtnThem.setPreferredSize(new java.awt.Dimension(80, 23));
        jBtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnThemActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnThem);
        jPanel1.add(filler5);

        jBtnSua.setText("SỬA");
        jBtnSua.setPreferredSize(new java.awt.Dimension(80, 23));
        jBtnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnSua);
        jPanel1.add(filler6);

        jBtnTimkiem.setText("TÌM KIẾM");
        jBtnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTimkiemActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnTimkiem);
        jPanel1.add(filler8);

        jBtnHuyTimKiem.setText("TẢI LẠI");
        jBtnHuyTimKiem.setPreferredSize(new java.awt.Dimension(80, 23));
        jBtnHuyTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHuyTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnHuyTimKiem);

        jTableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Ngày sinh", "Địa chỉ", "CCCD", "Chức vụ", "Mật khẩu", "Tình trạng làm việc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNhanVien);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("NHÂN VIÊN");
        jPanel2.add(jLabel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnHuyTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHuyTimKiemActionPerformed
        setTableItemList();
    }//GEN-LAST:event_jBtnHuyTimKiemActionPerformed

    private void jBtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnThemActionPerformed
        // TODO add your handling code here:
        clearAllTextField();

        // Load combo vai tro
        cbVaiTroLamViec.removeAllItems();
        cbVaiTroLamViec.addItem(NhanVienDTO.VaiTro.NHAN_VIEN.name());
        if (this.nhanVienDangNhap.getVaiTro() == NhanVienDTO.VaiTro.QUAN_LY.ordinal()) {
            cbVaiTroLamViec.addItem(NhanVienDTO.VaiTro.QUAN_LY.name());
        }

        // load combo tinh trang
        cbTinhTrangLamViec.removeAllItems();
        cbTinhTrangLamViec.addItem(NhanVienDTO.TinhTrangLamViec.DANG_LAM.toString());
        cbTinhTrangLamViec.addItem(NhanVienDTO.TinhTrangLamViec.NGHI_VIEC.toString());

        JDialogThem.setVisible(true);
        JDialogThem.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnThemActionPerformed

    private void jBtnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTimkiemActionPerformed
        clearAllTextField();
        JDialogTimKiem.setVisible(true);

        // load combo tinh trang
        cbTinhTrangLamViecTimKiem.removeAllItems();
        cbTinhTrangLamViecTimKiem.addItem("Tất cả");
        cbTinhTrangLamViecTimKiem.addItem(NhanVienDTO.TinhTrangLamViec.DANG_LAM.toString());
        cbTinhTrangLamViecTimKiem.addItem(NhanVienDTO.TinhTrangLamViec.NGHI_VIEC.toString());

        // load combo vai tro
        cbVaiTroTimKiem.removeAllItems();
        cbVaiTroTimKiem.addItem("Tất cả");
        cbVaiTroTimKiem.addItem(NhanVienDTO.VaiTro.NHAN_VIEN.toString());
        if (this.nhanVienDangNhap.getVaiTro() == NhanVienDTO.VaiTro.QUAN_LY.ordinal()) {
            cbVaiTroTimKiem.addItem(NhanVienDTO.VaiTro.QUAN_LY.toString());
        }

        JDialogTimKiem.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnTimkiemActionPerformed

    private void jBtnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSuaActionPerformed
        clearAllTextField();
        int selectedRow = jTableNhanVien.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        int id = (int) jTableNhanVien.getValueAt(selectedRow, 0);
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVienDTO nhanVienDTO = nhanVienBUS.findOne(id);
        jTxtHotenSua.setText(nhanVienDTO.getHoTen_NV());
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            jTxtNgaysinhSua.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(nhanVienDTO.getngaysinh_NV().format(fmr)));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        jTxtDiachiSua.setText(nhanVienDTO.getDiaChi_NV());
        jTxtCmndSua.setText(nhanVienDTO.getCCCD());
        jTxtMatKhauSua.setText(nhanVienDTO.getMatKhau());

        // load vai tro
        cbVaiTroLamViecSua.removeAllItems();
        cbVaiTroLamViecSua.addItem(NhanVienDTO.VaiTro.NHAN_VIEN.name());
        if (this.nhanVienDangNhap.getVaiTro() == NhanVienDTO.VaiTro.QUAN_LY.ordinal()) {
            cbVaiTroLamViecSua.addItem(NhanVienDTO.VaiTro.QUAN_LY.name());
        }
        cbVaiTroLamViecSua.setSelectedItem(NhanVienDTO.VaiTro.values()[nhanVienDTO.getVaiTro()].name());

        // load combo tinh trang
        cbTinhTrangLamViecSua.removeAllItems();
        cbTinhTrangLamViecSua.addItem(NhanVienDTO.TinhTrangLamViec.DANG_LAM.toString());
        cbTinhTrangLamViecSua.addItem(NhanVienDTO.TinhTrangLamViec.NGHI_VIEC.toString());
        cbTinhTrangLamViecSua.setSelectedItem(nhanVienDTO.getTinhTrangLamViec().toString());


        JDialogSua.setVisible(true);
        JDialogSua.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBtnSuaActionPerformed

    private void jTxtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenActionPerformed

    private void jBtnXacNhanThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanThemActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("them")) {
            return;
        }
        int id = MyConnection.getLastRecordId(NhanVienDAO.TABLE_NAME) + 1;
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaysinh = convertToLocalDateViaMilisecond(jTxtNgaySinh.getDate());
        String diachi = jTxtDiachi.getText();
        String hoten = jTxtHoten.getText();
        String cmnd = jTxtCmnd.getText();
        String vaiTroName = (String) cbVaiTroLamViec.getSelectedItem();
        int vaiTro = NhanVienDTO.VaiTro.valueOf(vaiTroName).ordinal();
        String matKhau = jTxtMatKhau.getText();
        String tinhTrangLamViecName = (String) cbTinhTrangLamViec.getSelectedItem();
        int tinhTrangLamViec = NhanVienDTO.TinhTrangLamViec.fromString(tinhTrangLamViecName).ordinal();

        // chekc if cmnd is existed
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        nhanVienBUS.findALl();
        for (NhanVienDTO nhanVienDTO : nhanVienBUS.getListNhanVien()) {
            if (nhanVienDTO.getCCCD().equals(cmnd)) {
                JOptionPane.showMessageDialog(JDialogThem, "Trùng số CCCD");
                return;
            }
        }

        NhanVienDTO nhanvienDTO = new NhanVienDTO(id, hoten, ngaysinh, diachi, cmnd, vaiTro, matKhau, tinhTrangLamViec);
        NhanVienBUS nhanvienBUS = new NhanVienBUS();
        TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
        boolean result = nhanvienBUS.ThemNhanVien(nhanvienDTO);
        if (!result) {
            JOptionPane.showMessageDialog(JDialogThem, "Trùng ID nhân viên");
            return;
        }
        taiKhoanBUS.themTaiKhoan(new TaiKhoanDTO(nhanvienDTO.getID_NV(), "123456"));
        setTableItemList();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        clearAllTextField();
        JDialogThem.setVisible(false);
    }//GEN-LAST:event_jBtnXacNhanThemActionPerformed

    private void jTxtHotenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenSuaActionPerformed

    private void jBtnXacNhanSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanSuaActionPerformed
        if (!checkTextField("Sua")) {
            return;
        }
        int id = (int) jTableNhanVien.getValueAt(jTableNhanVien.getSelectedRow(), 0);
        String hoTen = jTxtHotenSua.getText();
        DateTimeFormatter fmr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaysinh = convertToLocalDateViaMilisecond(jTxtNgaysinhSua.getDate());
        String diaChi = jTxtDiachiSua.getText();
        String cmnd = jTxtCmndSua.getText();
        String vaiTroName = (String) cbVaiTroLamViecSua.getSelectedItem();
        int vaiTro = NhanVienDTO.VaiTro.valueOf(vaiTroName).ordinal();
        String matKhau = jTxtMatKhauSua.getText();
        String tinhTrangLamViecName = (String) cbTinhTrangLamViecSua.getSelectedItem();
        int tinhTrangLamViec = NhanVienDTO.TinhTrangLamViec.fromString(tinhTrangLamViecName).ordinal();
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        NhanVienDTO nhanVienDTO = nhanVienBUS.findOne(id);
        // Nếu vai trò đang là quản lý và sửa thành nhân viên thì kiểm tra xem còn bao nhiêu quản lý
        // Nếu còn 1 quản lý thì không cho sửa
        if (vaiTro == NhanVienDTO.VaiTro.NHAN_VIEN.ordinal() && nhanVienDTO.getVaiTro() == NhanVienDTO.VaiTro.QUAN_LY.ordinal()) {
            if (nhanVienBUS.countQuanLy() == 1) {
                JOptionPane.showMessageDialog(JDialogSua, "Không thể sửa vì chỉ còn 1 quản lý");
                return;
            }
        }

        NhanVienDTO newNhanVien = new NhanVienDTO(id, hoTen, ngaysinh, diaChi, cmnd, vaiTro, matKhau, tinhTrangLamViec);
        nhanVienBUS.updateOne(newNhanVien);
        setTableItemList();
        JDialogSua.setVisible(false);
        JOptionPane.showMessageDialog(this, "Sửa thành công");
    }//GEN-LAST:event_jBtnXacNhanSuaActionPerformed

    private void jTxtHotenTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtHotenTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtHotenTimKiemActionPerformed

    private void jBtnXacNhanTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnXacNhanTimKiemActionPerformed
        try {
            boolean itNhat1DieuKien = false;
            int id, tinhTrang, vaiTro;
            String hoTen = "";

            if (!jTxtIDTimKiem.getText().isEmpty()) {
                // id <= 256 để tránh trường hợp nhập số quá lớn
                if (jTxtIDTimKiem.getText().length() > 256) {
                    JOptionPane.showMessageDialog(JDialogTimKiem, "ID không được quá 256 ký tự");
                    return;
                }

                id = Integer.parseInt(jTxtIDTimKiem.getText());
                itNhat1DieuKien = true;
            } else {
                id = -1;
            }
            if (!jTxtHotenTimKiem.getText().isEmpty()) {
                hoTen = jTxtHotenTimKiem.getText();

                if (hoTen.length() > 256) {
                    JOptionPane.showMessageDialog(JDialogTimKiem, "Họ tên không được quá 256 ký tự");
                    return;
                }

                itNhat1DieuKien = true;
            }

            String tinhTrangLamViecTimKiemName = (String) cbTinhTrangLamViecTimKiem.getSelectedItem();
            if (!tinhTrangLamViecTimKiemName.equalsIgnoreCase("Tất cả")) {
                tinhTrang = NhanVienDTO.TinhTrangLamViec.fromString(tinhTrangLamViecTimKiemName).ordinal();
                itNhat1DieuKien = true;
            } else {
                tinhTrang = -1;
           }

            String vaiTroString = (String) cbVaiTroTimKiem.getSelectedItem();
            if (!vaiTroString.equalsIgnoreCase("Tất cả")) {
                vaiTro = NhanVienDTO.VaiTro.fromString(vaiTroString).ordinal();
                itNhat1DieuKien = true;
            } else {
                vaiTro = -1;
            }

            if (!itNhat1DieuKien) {
                return;
            }
            NhanVienBUS nhanVienBUS = new NhanVienBUS();
            nhanVienBUS.findMany(id, hoTen, tinhTrang, vaiTro);
            setTableItemList(nhanVienBUS);
            JDialogTimKiem.setVisible(false);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(JDialogTimKiem, "id và tình trạng chỉ được nhập chữ số");
        }

    }//GEN-LAST:event_jBtnXacNhanTimKiemActionPerformed

    private void jTxtDiachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDiachiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtDiachiActionPerformed

    private void jTxtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMatKhauActionPerformed

    private void jTxtMatKhauSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtMatKhauSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtMatKhauSuaActionPerformed

    private void jTxtCmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCmndActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog JDialogSua;
    private javax.swing.JDialog JDialogThem;
    private javax.swing.JDialog JDialogTimKiem;
    private javax.swing.JComboBox<String> cbTinhTrangLamViec;
    private javax.swing.JComboBox<String> cbTinhTrangLamViecSua;
    private javax.swing.JComboBox<String> cbTinhTrangLamViecTimKiem;
    private javax.swing.JComboBox<String> cbVaiTroLamViec;
    private javax.swing.JComboBox<String> cbVaiTroLamViecSua;
    private javax.swing.JComboBox<String> cbVaiTroTimKiem;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JButton jBtnHuyTimKiem;
    private javax.swing.JButton jBtnSua;
    private javax.swing.JButton jBtnThem;
    private javax.swing.JButton jBtnTimkiem;
    private javax.swing.JButton jBtnXacNhanSua;
    private javax.swing.JButton jBtnXacNhanThem;
    private javax.swing.JButton jBtnXacNhanTimKiem;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNhanVien;
    private javax.swing.JTextField jTxtCmnd;
    private javax.swing.JTextField jTxtCmndSua;
    private javax.swing.JTextField jTxtDiachi;
    private javax.swing.JTextField jTxtDiachiSua;
    private javax.swing.JTextField jTxtHoten;
    private javax.swing.JTextField jTxtHotenSua;
    private javax.swing.JTextField jTxtHotenTimKiem;
    private javax.swing.JTextField jTxtIDTimKiem;
    private javax.swing.JTextField jTxtMatKhau;
    private javax.swing.JTextField jTxtMatKhauSua;
    private com.toedter.calendar.JDateChooser jTxtNgaySinh;
    private com.toedter.calendar.JDateChooser jTxtNgaysinhSua;
    // End of variables declaration//GEN-END:variables
}
