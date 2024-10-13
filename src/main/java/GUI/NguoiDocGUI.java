/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.NguoiDocBUS;
import BUS.PhieuMuonBUS;
import DTO.NguoiDocDTO;
import DTO.PhieuMuonDTO;
import Helpler.Helpler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author pc
 */
public class NguoiDocGUI extends javax.swing.JPanel {

    /**
     * Creates new form NguoiDocGUI
     */
    private DefaultTableModel nguoiDocModel;

    public NguoiDocGUI() {
        initComponents();

        Helpler.centerCell(jTableNguoiDoc);
        setTableItemList();
    }

    public void setTableItemList() {
        nguoiDocModel = (DefaultTableModel) jTableNguoiDoc.getModel();
        nguoiDocModel.setRowCount(0);
        NguoiDocBUS nguoiDocBus = new NguoiDocBUS();
        nguoiDocBus.findAll();
        setTableItemList(nguoiDocBus);
    }

    public void setTableItemList(NguoiDocBUS nguoiDocBUS) {
        nguoiDocModel = (DefaultTableModel) jTableNguoiDoc.getModel();
        nguoiDocModel.setRowCount(0);
        ArrayList<NguoiDocDTO> listNguoiDoc = nguoiDocBUS.getListNguoiDoc();
        listNguoiDoc.forEach(ele -> {
            nguoiDocModel.addRow(new Object[]{
                ele.getId(),
                ele.getHoTen(),
                ele.getSdt(),
                ele.getNgaySinh().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                ele.getDiaChi(),
                ele.getCCCD(),
                ele.getHanSuDung().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                ele.getSoLuongMuonChoPhep(),
                ele.getTrangThaiViPham().toString()
            });
        });
    }

    public void clearAllTextField() {
        txtHoTen.setText("");
        txtNgaySinh.setDate(null);
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
    }

    public boolean isEmptyString(String str) {
        return str.equalsIgnoreCase("");
    }

    public boolean checkTextField(String option) {
        String id = txtIdThem.getText();
        String sdt = txtSDT.getText();
        Date ngaySinh = txtNgaySinh.getDate();
        String diaChi = txtDiaChi.getText();
        String hoTen = txtHoTen.getText();
        String cmnd = txtCMND.getText();
        if (option.equalsIgnoreCase("Sua")) {
            sdt = txtSDT1.getText();
            ngaySinh = txtNgaySinh1.getDate();
            diaChi = txtDiaChi1.getText();
            hoTen = txtHoTen1.getText();
            cmnd = txtCMND1.getText();
        }
        // Kiểm tra id
        if (isEmptyString(id)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ID");
            return false;
        }
        if (!id.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "ID chỉ được nhập số");
            return false;
        }
        if (id.length() != 10) {
            JOptionPane.showMessageDialog(this, "ID phải 10 chữ số");
            return false;
        }

        // Kiểm tra họ tên
        if (isEmptyString(hoTen)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập họ tên");
            return false;
        }

        // Kiểm tra số điện thoại
        if (isEmptyString(sdt)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập SDT");
            return false;
        }
        if (!sdt.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "SDT chỉ được nhập số");
            return false;
        }
        // Kiểm tra số điện thoại có đúng 10 hoặc 11 số không
        if (sdt.length() != 10 && sdt.length() != 11) {
            JOptionPane.showMessageDialog(this, "SDT phải có 10 hoặc 11 số");
            return false;
        }

        // Kiểm tra ngày sinh
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày sinh");
            return false;
        }

        if (!Helpler.isOlderThan18(ngaySinh)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải lớn hơn 18 tuổi");
            return false;
        }

        // Kiểm tra địa chỉ
        if (isEmptyString(diaChi)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
            return false;
        }
        // Kiểm tra CMND
        if (isEmptyString(cmnd)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập CCCD");
            return false;
        }
        if (!cmnd.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "CCCD chỉ được nhập số");
            return false;
        }
        // Kiểm tra CMND có đúng 12 số không
        if (cmnd.length() != 12) {
            JOptionPane.showMessageDialog(this, "CCCD phải có 12 số");
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

        jDialogSua = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSDT1 = new javax.swing.JTextField();
        txtNgaySinh1 = new com.toedter.calendar.JDateChooser();
        txtHoTen1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiaChi1 = new javax.swing.JTextField();
        txtCMND1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnXacNhanSua = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jDialogTimKiem = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        txtIdTimKiem = new javax.swing.JTextField();
        btnXacNhanTim = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        ckbQuaHanSuDung = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        rbtnCoViPham = new javax.swing.JRadioButton();
        rbtnKhongViPham = new javax.swing.JRadioButton();
        rbtnBiKhoa = new javax.swing.JRadioButton();
        rbtnTatCa = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        txtHoTenTimKiem = new javax.swing.JTextField();
        buttonGroupTinhTrang = new javax.swing.ButtonGroup();
        jDialogThem = new javax.swing.JDialog();
        txtHoTen = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnXacNhanThem = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtIdThem = new javax.swing.JTextField();
        String desktopDir = System.getProperty("user.home") + "/Desktop";
        jFileChooserExport = new javax.swing.JFileChooser(desktopDir);
        jFileChooserImport = new javax.swing.JFileChooser(desktopDir);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNguoiDoc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btnSua = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btnXoa = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btnTimKiem = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        btnHuyTimKiem = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));

        jDialogSua.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialogSua.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel7.setText("Họ Tên");

        jLabel8.setText("SDT");

        txtNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel9.setText("Ngày sinh");

        jLabel10.setText("Địa chỉ");

        jLabel11.setText("CCCD");

        btnXacNhanSua.setText("Sửa");
        btnXacNhanSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanSuaActionPerformed(evt);
            }
        });
        jPanel3.add(btnXacNhanSua);

        jLabel12.setText("ID");

        txtID.setEnabled(false);

        javax.swing.GroupLayout jDialogSuaLayout = new javax.swing.GroupLayout(jDialogSua.getContentPane());
        jDialogSua.getContentPane().setLayout(jDialogSuaLayout);
        jDialogSuaLayout.setHorizontalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDialogSuaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCMND1)
                            .addComponent(txtDiaChi1)
                            .addComponent(txtNgaySinh1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtSDT1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtHoTen1))
                        .addGap(55, 55, 55))
                    .addGroup(jDialogSuaLayout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jDialogSuaLayout.setVerticalGroup(
            jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogSuaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jDialogTimKiem.setTitle("Tìm kiếm");
        jDialogTimKiem.setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel13.setText("Họ Tên");

        btnXacNhanTim.setText("Tìm");
        btnXacNhanTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanTimActionPerformed(evt);
            }
        });

        jLabel14.setText("Khác");

        ckbQuaHanSuDung.setText("Quá hạn sử dụng");

        jLabel15.setText("Tình trạng");

        buttonGroupTinhTrang.add(rbtnCoViPham);
        rbtnCoViPham.setText("Có vi phạm");

        buttonGroupTinhTrang.add(rbtnKhongViPham);
        rbtnKhongViPham.setText("Không vi phạm");

        buttonGroupTinhTrang.add(rbtnBiKhoa);
        rbtnBiKhoa.setText("Bị khóa");

        buttonGroupTinhTrang.add(rbtnTatCa);
        rbtnTatCa.setText("Tất cả");
        rbtnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTatCaActionPerformed(evt);
            }
        });

        jLabel21.setText("ID");

        javax.swing.GroupLayout jDialogTimKiemLayout = new javax.swing.GroupLayout(jDialogTimKiem.getContentPane());
        jDialogTimKiem.getContentPane().setLayout(jDialogTimKiemLayout);
        jDialogTimKiemLayout.setHorizontalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogTimKiemLayout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                        .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ckbQuaHanSuDung)
                            .addComponent(txtIdTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbtnKhongViPham, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(rbtnCoViPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnBiKhoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnTatCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))))
                .addGap(135, 135, 135))
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnXacNhanTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogTimKiemLayout.setVerticalGroup(
            jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtIdTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHoTenTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ckbQuaHanSuDung))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(1, 1, 1)
                .addComponent(rbtnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnKhongViPham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnCoViPham)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnBiKhoa)
                .addGap(2, 2, 2)
                .addComponent(btnXacNhanTim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDialogThem.setTitle("Thêm người đọc");
        jDialogThem.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel16.setText("Họ Tên");

        jLabel17.setText("SDT");

        txtNgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel18.setText("Ngày sinh");

        jLabel19.setText("Địa chỉ");

        jLabel20.setText("CCCD");

        btnXacNhanThem.setText("Thêm");
        btnXacNhanThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanThemActionPerformed(evt);
            }
        });

        jLabel22.setText("ID");

        javax.swing.GroupLayout jDialogThemLayout = new javax.swing.GroupLayout(jDialogThem.getContentPane());
        jDialogThem.getContentPane().setLayout(jDialogThemLayout);
        jDialogThemLayout.setHorizontalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnXacNhanThem, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(136, 136, 136))
            .addGroup(jDialogThemLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCMND)
                    .addComponent(txtDiaChi)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHoTen)
                    .addComponent(txtIdThem))
                .addContainerGap())
        );
        jDialogThemLayout.setVerticalGroup(
            jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogThemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtIdThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jDialogThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXacNhanThem)
                .addContainerGap())
        );

        setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTableNguoiDoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ tên", "SĐT", "NGày sinh", "Địa chỉ", "CCCD", "Thời hạn thành viên", "Số lượng mượn tối đa", "Trạng thái vi phạm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableNguoiDoc);
        if (jTableNguoiDoc.getColumnModel().getColumnCount() > 0) {
            jTableNguoiDoc.getColumnModel().getColumn(0).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(1).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(2).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(3).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(4).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(5).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(6).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(7).setResizable(false);
            jTableNguoiDoc.getColumnModel().getColumn(8).setResizable(false);
        }
        jTableNguoiDoc.getAccessibleContext().setAccessibleName("");
        jTableNguoiDoc.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("NGƯỜI ĐỌC");
        jPanel1.add(jLabel2);

        btnThem.setText("THÊM");
        btnThem.setPreferredSize(new java.awt.Dimension(80, 23));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel4.add(btnThem);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler5);

        btnSua.setText("SỬA");
        btnSua.setInheritsPopupMenu(true);
        btnSua.setPreferredSize(new java.awt.Dimension(80, 23));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);
        jPanel2.add(filler1);

        btnXoa.setText("XOÁ");
        btnXoa.setPreferredSize(new java.awt.Dimension(80, 23));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);
        jPanel2.add(filler4);

        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btnTimKiem);
        jPanel2.add(filler3);

        btnHuyTimKiem.setText("TẢI LẠI");
        btnHuyTimKiem.setPreferredSize(new java.awt.Dimension(80, 23));
        btnHuyTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimKiemActionPerformed(evt);
            }
        });
        jPanel2.add(btnHuyTimKiem);
        jPanel2.add(filler2);
        jPanel2.add(filler6);
        jPanel2.add(filler7);

        jPanel4.add(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        jDialogThem.setVisible(true);
        jDialogThem.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = jTableNguoiDoc.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }
        JTextField textFields[] = {txtID, txtHoTen1, txtSDT1, null, txtDiaChi1, txtCMND1};
        // Id, Hoten, SDT, diaChi, CMND
        for (int col = 0; col <= 5; col++) {
            Object obj = jTableNguoiDoc.getValueAt(selectedRow, col);
            if (col == 3) {
                try {
                    //NgaySinh
                    txtNgaySinh1.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(obj.toString()));
                    txtNgaySinh1.setDateFormatString("dd/MM/yyyy");
                } catch (ParseException ex) {
                    Logger.getLogger(NguoiDocGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                textFields[col].setText(obj.toString());
            }
        }
        jDialogSua.setVisible(true);
        jDialogSua.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXacNhanSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanSuaActionPerformed
        if (!checkTextField("Sua")) {
            return;
        }
        // Get value in text field
        long id = Long.parseLong(txtID.getText());
        String sdt = txtSDT1.getText();
        LocalDate ngaySinh = convertToLocalDateViaMilisecond(txtNgaySinh1.getDate());
        String diaChi = txtDiaChi1.getText();
        String hoTen = txtHoTen1.getText();
        String cmnd = txtCMND1.getText();
        NguoiDocBUS nguoiDocBus = new NguoiDocBUS();

        //Get a record with id
        NguoiDocDTO nguoiDocDTO = nguoiDocBus.findOne(id);

        // check if sdt already exist
        for (NguoiDocDTO nguoiDoc : nguoiDocBus.getListNguoiDoc()) {
            if (nguoiDoc.getSdt().equals(sdt) && nguoiDoc.getId() != id) {
                JOptionPane.showMessageDialog(this, String.format("SDT %s đã tồn tại", sdt));
                return;
            }
        }

        // check if cmnd already exist
        for (NguoiDocDTO nguoiDoc : nguoiDocBus.getListNguoiDoc()) {
            if (nguoiDoc.getCCCD().equals(cmnd) && nguoiDoc.getId() != id) {
                JOptionPane.showMessageDialog(this, String.format("CCCD %s đã tồn tại", cmnd));
                return;
            }
        }

        //Change the record columns valueNGUOI_DOC_3
        nguoiDocDTO.setHoTen(hoTen);
        nguoiDocDTO.setCCCD(cmnd);
        nguoiDocDTO.setDiaChi(diaChi);
        nguoiDocDTO.setNgaySinh(ngaySinh);
        nguoiDocDTO.setSdt(sdt);
        //Update record to database
        if (nguoiDocBus.updateOne(nguoiDocDTO)) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
        setTableItemList();
        clearAllTextField();
        jDialogSua.setVisible(false);
    }//GEN-LAST:event_btnXacNhanSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int[] selectedRows = jTableNguoiDoc.getSelectedRows();
        if (selectedRows == null || selectedRows.length == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
            return;
        }
        NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();

        if (selectedRows.length == 1) {
            long id = (long) jTableNguoiDoc.getValueAt(selectedRows[0], 0);
            NguoiDocDTO nguoiDocDTO = nguoiDocBUS.findOne(id);

            PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
            ArrayList<PhieuMuonDTO> phieuMuonDTOArrayList = phieuMuonBUS.findByIdNguoiDoc(id);

            // list is not empty
            if (!phieuMuonDTOArrayList.isEmpty()) {
                JOptionPane.showMessageDialog(this, String.format("Không thể xóa người đọc %s vì người đọc này đang có phiếu mượn", nguoiDocDTO.getHoTen()));
                return;
            }

            int dialogResult = JOptionPane.showConfirmDialog(this, String.format("Xác nhận xóa người đọc '%s'", nguoiDocDTO.getHoTen()));
            if (dialogResult == JOptionPane.YES_OPTION) {
                if (nguoiDocBUS.deleteOne(id)) {
                    JOptionPane.showMessageDialog(this, "Xoá thành công");
                    setTableItemList();
                    clearAllTextField();
                } else {
                    JOptionPane.showMessageDialog(this, "Xoá thất bại");
                }
            }
        } else {
//            ArrayList<Integer> arrayId = new ArrayList<>();
//            for (int row : selectedRows) {
//                Object id = jTableNguoiDoc.getValueAt(row, 0);
//                arrayId.add((Integer) id);
//            }
//            int dialogResult = JOptionPane.showConfirmDialog(this, "Xác nhận xóa các người đọc với id = " + arrayId.toString());
//            if (dialogResult == JOptionPane.YES_OPTION) {
//                int count = nguoiDocBUS.deleteMany(arrayId);
//                setTableItemList();
//                JOptionPane.showMessageDialog(this, "Đã xóa " + count + " dòng");
//            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        jDialogTimKiem.setVisible(true);
        jDialogTimKiem.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return "";
    }

    private void btnXacNhanTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanTimActionPerformed
        String hoTenTimKiem = txtHoTenTimKiem.getText();
        boolean quaHanSuDung = ckbQuaHanSuDung.isSelected();
        String trangThaiText = getSelectedButtonText(buttonGroupTinhTrang);
        int trangThai;
        switch (trangThaiText) {
            case "Không vi phạm" ->
                trangThai = 0;
            case "Có vi phạm" ->
                trangThai = 1;
            case "Bị khóa" ->
                trangThai = 2;
            case "Tất cả" ->
                trangThai = -1;
            default ->
                trangThai = -1;
        }
        if (!(!isEmptyString(hoTenTimKiem) || quaHanSuDung || trangThai != -1 || !isEmptyString(txtIdTimKiem.getText()))) {
            JOptionPane.showMessageDialog(jDialogTimKiem, "Vui lòng ít nhất 1 điều kiện");
            return;
        }
        long idTimKiem = -1;
        // Kiểm tra id
        if (!isEmptyString(txtIdTimKiem.getText())) {
            if (!txtIdTimKiem.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "ID chỉ được nhập số");
                return;
            } else {
                idTimKiem = Long.parseLong(txtIdTimKiem.getText());
            }
        }


        NguoiDocBUS ndbus = new NguoiDocBUS();
        ndbus.findMany(idTimKiem, hoTenTimKiem, quaHanSuDung, trangThai);
        setTableItemList(ndbus);
        jDialogTimKiem.setVisible(false);
    }//GEN-LAST:event_btnXacNhanTimActionPerformed

    private void btnHuyTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimKiemActionPerformed
        setTableItemList();
    }//GEN-LAST:event_btnHuyTimKiemActionPerformed

    private void btnXacNhanThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanThemActionPerformed
        if (!checkTextField("them")) {
            return;
        }
        NguoiDocBUS nguoiDocBus = new NguoiDocBUS();

        long id = Long.parseLong(txtIdThem.getText());
        String sdt = txtSDT.getText();
        LocalDate ngaySinh = convertToLocalDateViaMilisecond(txtNgaySinh.getDate());
        String diaChi = txtDiaChi.getText();
        String hoTen = txtHoTen.getText();
        String cmnd = txtCMND.getText();
        LocalDate nextYear = LocalDate.now().plusYears(1);
        LocalDate hanSuDung = nextYear;
        int soLuongMuonChoPhep = 20;
        int trangThaiViPham = 0;
        NguoiDocDTO nguoiDocDTO = new NguoiDocDTO(id, sdt, ngaySinh, diaChi, hoTen, cmnd, hanSuDung, soLuongMuonChoPhep, trangThaiViPham);

        if (nguoiDocBus.findOne(id) != null) {
            JOptionPane.showMessageDialog(this, String.format("ID %s đã tồn tại", id));
            return;
        }

        // check if sdt already exist
        for (NguoiDocDTO nguoiDoc : nguoiDocBus.getListNguoiDoc()) {
            if (nguoiDoc.getSdt().equals(sdt)) {
                JOptionPane.showMessageDialog(this, String.format("Số điện thoại %s đã tồn tại", sdt));
                return;
            }
        }

        // check if cmnd already exist
        for (NguoiDocDTO nguoiDoc : nguoiDocBus.getListNguoiDoc()) {
            if (nguoiDoc.getCCCD().equals(cmnd)) {
                JOptionPane.showMessageDialog(this, String.format("CCCD %s đã tồn tại", cmnd));
                return;
            }
        }

        nguoiDocBus.insertOne(nguoiDocDTO);
        setTableItemList();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        clearAllTextField();
        jDialogThem.setVisible(false);
    }//GEN-LAST:event_btnXacNhanThemActionPerformed

    private void rbtnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTatCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnTatCaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyTimKiem;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXacNhanSua;
    private javax.swing.JButton btnXacNhanThem;
    private javax.swing.JButton btnXacNhanTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroupTinhTrang;
    private javax.swing.JCheckBox ckbQuaHanSuDung;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.JDialog jDialogSua;
    private javax.swing.JDialog jDialogThem;
    private javax.swing.JDialog jDialogTimKiem;
    private javax.swing.JFileChooser jFileChooserExport;
    private javax.swing.JFileChooser jFileChooserImport;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNguoiDoc;
    private javax.swing.JRadioButton rbtnBiKhoa;
    private javax.swing.JRadioButton rbtnCoViPham;
    private javax.swing.JRadioButton rbtnKhongViPham;
    private javax.swing.JRadioButton rbtnTatCa;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtCMND1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHoTen1;
    private javax.swing.JTextField txtHoTenTimKiem;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdThem;
    private javax.swing.JTextField txtIdTimKiem;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private com.toedter.calendar.JDateChooser txtNgaySinh1;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT1;
    // End of variables declaration//GEN-END:variables
}
