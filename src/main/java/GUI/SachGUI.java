/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.*;
import DAO.MyConnection;
import DTO.*;
import Helpler.Helpler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * @author pc
 */
public class SachGUI extends javax.swing.JPanel {

    /**
     * Creates new form SachGUI1
     */
    private DefaultTableModel sachmd;
    private ArrayList<LoaiSachDTO> listLoaiSach;
    private ArrayList<NhaXuatBanDTO> listNhaXuatBan;
    private ArrayList<TacGiaDTO> listTacGia;
    private NhanVienDTO nhanVienDangNhap;
    private BaseUI baseUI;


    public SachGUI(NhanVienDTO nhanVienDangNhap, BaseUI baseUI) {
        initComponents();
        Helpler.centerCell(jTableSach);
        this.nhanVienDangNhap = nhanVienDangNhap;
        this.baseUI = baseUI;


//        loadTrangThai(cbTrangThai);
        loadLoaiSach(dbLS);
        loadNhaXuatBan(dbNXB);
        loadTacGia(dbTacGia);
        setTableItemList();
        SachBUS sachBUS = new SachBUS();
        listLoaiSach = sachBUS.findAllLoaiSach();
    }

    public void loadTrangThai(JComboBox<String> cbTrangThai) {
        cbTrangThai.removeAllItems();
        cbTrangThai.addItem(SachDTO.TrangThaiSach.DANG_NHAP_KHO.toString());
        cbTrangThai.addItem(SachDTO.TrangThaiSach.CO_THE_MUON.toString());
        cbTrangThai.addItem(SachDTO.TrangThaiSach.HET_SACH.toString());
    }

    public void loadLoaiSach(JComboBox<String> cb) {
        cb.removeAllItems();
        LoaiSachBUS loaiSachBUS = new LoaiSachBUS();
        loaiSachBUS.findAll();
        listLoaiSach = loaiSachBUS.getListLoaiSach();
        listLoaiSach.forEach(loaiSachDTO -> {
            cb.addItem(loaiSachDTO.getTenLoai());
        });
    }

    public void loadNhaXuatBan(JComboBox<String> dbNXB) {
        dbNXB.removeAllItems();
        NhaXuatBanBUS nhaXuatBanBUS = new NhaXuatBanBUS();
        nhaXuatBanBUS.findAll();
        listNhaXuatBan = nhaXuatBanBUS.getListNhaXuatBan();
        listNhaXuatBan.forEach(nhaXuatBanDTO -> {
            dbNXB.addItem(nhaXuatBanDTO.getTen());
        });
    }

    public void loadTacGia(JComboBox<String> dbTacGia) {
        dbTacGia.removeAllItems();
        TacGiaBUS tacGiaBUS = new TacGiaBUS();
        tacGiaBUS.findAll();
        listTacGia = tacGiaBUS.getListTacGia();
        listTacGia.forEach(tacGiaDTO -> {
            dbTacGia.addItem(tacGiaDTO.getHoTen());
        });
    }

    public void setTableItemList() {
        SachBUS sachBUS = new SachBUS();
        sachBUS.findAll();
        setTableItemList(sachBUS);
    }

    public void setTableItemList(SachBUS sachBUS) {
        sachmd = (DefaultTableModel) jTableSach.getModel();
        sachmd.setRowCount(0);
        ArrayList<SachDTO> listSach = sachBUS.getListSach();
        listSach.forEach(sachDTO -> {
            LoaiSachDTO loaiSachDTO = new LoaiSachBUS().findOne(sachDTO.getIdLoaiSach());
            sachmd.addRow(new Object[]{
                    sachDTO.getId(),
                    sachDTO.getTenSach(),
                    sachDTO.getGiaSach(),
                    sachDTO.getTacGia().getHoTen(),
                    sachDTO.getNhaXuatBan().getTen(),
                    sachDTO.getSoluong(),
                    loaiSachDTO.getTenLoai(),
                    sachDTO.getTrangThaiSach().toString(),
            });
        });
    }

    public void clearAllTextField() {
        txtTenSach.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        dbLS.setSelectedItem("");
    }

    public boolean isEmptyString(String str) {
        return str.equalsIgnoreCase("");
    }

    public boolean checkTextField(String option) {
        String ts = txtTenSach.getText();
        String g = txtGia.getText();
        String sl = txtSoLuong.getText();
        if (option.equalsIgnoreCase("Sua")) {
            ts = txtTSSua.getText();
            g = txtGSua.getText();
            sl = txtSLSua.getText();
        }
        // Kiểm tra trường tên sách
        if (isEmptyString(ts)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sách");
            return false;
        }
        // tên sách ko được vượt quá 256 ký tự
        if (ts.length() > 256) {
            JOptionPane.showMessageDialog(this, "Tên sách không được vượt quá 100 ký tự");
            return false;
        }

        // Kiểm tra trường giá
        if (isEmptyString(g)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá");
            return false;
        }
        if (!g.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Giá chỉ được nhập số");
            return false;
        }
        // giá <= 256 ký tự
        if (g.length() > 9) {
            JOptionPane.showMessageDialog(this, "Giá sách không được vượt quá 100,000,000");
            return false;
        }

        int giaSach = Integer.parseInt(g);
        // giaSach > 0 và < 1 000 000 000
        if (giaSach <= 0 || giaSach >= 1000000000) {
            JOptionPane.showMessageDialog(this, "Giá sách phải lớn hơn 0 và không được vượt quá 100,000,000");
            return false;
        }

        // Kiểm tra trường số lượng
        if (isEmptyString(sl)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
            return false;
        }
        if (!sl.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Số lượng chỉ được nhập số");
            return false;
        }
        if (sl.length() > 7) {
            JOptionPane.showMessageDialog(this, "Số lượng sách tối đa là 1,000,000");
            return false;
        }

        int soLuong = Integer.parseInt(sl);
        // soLuong > 0 và < 1000000
        if (soLuong <= 0 || soLuong >= 1000000) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 và nhỏ hơn 1,000,000");
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

        jDialogTimKiem = new javax.swing.JDialog();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTS2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnXacNhanTIm = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtID2 = new javax.swing.JTextField();
        cbLoaiSachTimKiem = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtGiaSachFrom = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtGiaSachTo = new javax.swing.JTextField();
        jDialogSua = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTSSua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGSua = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSLSua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnXacNhanSua = new javax.swing.JButton();
        txtLSSua = new javax.swing.JComboBox<>();
        txtIDSua = new javax.swing.JTextField();
        cbTacGiaSua = new javax.swing.JComboBox<>();
        cbNXBSua = new javax.swing.JComboBox<>();
        txtTTSua = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenSach = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dbLS = new javax.swing.JComboBox<>();
        dbNXB = new javax.swing.JComboBox<>();
        dbTacGia = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTK = new javax.swing.JButton();
        btnHuyTK = new javax.swing.JButton();
        btnThemTacGiaMoi = new javax.swing.JButton();
        btnThemNXBMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSach = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        jDialogTimKiem.setLocationByPlatform(true);
        jDialogTimKiem.setMinimumSize(new java.awt.Dimension(600, 300));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Tìm Kiếm Sách");

        jLabel20.setText("Tên Sách");

        jLabel21.setText("Loại Sách");

        btnXacNhanTIm.setText("Tìm Kiếm");
        btnXacNhanTIm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanTImActionPerformed(evt);
            }
        });

        jLabel22.setText("ID");

        cbLoaiSachTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiSachTimKiemActionPerformed(evt);
            }
        });

        jLabel23.setText("Giá sách khoảng từ");

        txtGiaSachFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaSachFromActionPerformed(evt);
            }
        });

        jLabel24.setText("Đến");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel24.setInheritsPopupMenu(false);

        txtGiaSachTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaSachToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogTimKiemLayout = new javax.swing.GroupLayout(jDialogTimKiem.getContentPane());
        jDialogTimKiem.getContentPane().setLayout(jDialogTimKiemLayout);
        jDialogTimKiemLayout.setHorizontalGroup(
                jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel19)
                                                        .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                                                                .addGap(55, 55, 55)
                                                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                                                                                .addComponent(txtGiaSachFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel24)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(txtGiaSachTo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(cbLoaiSachTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogTimKiemLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtTS2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtID2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(35, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogTimKiemLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnXacNhanTIm, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(153, 153, 153))))
        );
        jDialogTimKiemLayout.setVerticalGroup(
                jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialogTimKiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(txtTS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(cbLoaiSachTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jDialogTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(txtGiaSachFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel24)
                                        .addComponent(txtGiaSachTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(btnXacNhanTIm)
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        jDialogSua.setMinimumSize(new java.awt.Dimension(400, 600));

        jLabel10.setText("ID");

        jLabel11.setText("Tên Sách");

        jLabel12.setText("Giá");

        jLabel13.setText("Tác giá");

        jLabel14.setText("NXB");

        jLabel15.setText("Số lượng");

        jLabel16.setText("Loại sách");

        jLabel17.setText("Trạng thái");

        btnXacNhanSua.setText("Sửa");
        btnXacNhanSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanSuaActionPerformed(evt);
            }
        });

        txtIDSua.setEnabled(false);
        txtIDSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSuaActionPerformed(evt);
            }
        });

        txtTTSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTTSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogSuaLayout = new javax.swing.GroupLayout(jDialogSua.getContentPane());
        jDialogSua.getContentPane().setLayout(jDialogSuaLayout);
        jDialogSuaLayout.setHorizontalGroup(
                jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialogSuaLayout.createSequentialGroup()
                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtTSSua, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                                        .addComponent(txtIDSua)))
                                        .addGroup(jDialogSuaLayout.createSequentialGroup()
                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel15)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jDialogSuaLayout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(txtGSua, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtSLSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtLSSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbTacGiaSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbNXBSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jDialogSuaLayout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialogSuaLayout.createSequentialGroup()
                                                                .addComponent(btnXacNhanSua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(103, 103, 103))
                                                        .addComponent(txtTTSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jDialogSuaLayout.setVerticalGroup(
                jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jDialogSuaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(txtIDSua))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(txtTSSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(txtGSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(cbTacGiaSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(cbNXBSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(txtSLSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(txtLSSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jDialogSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(txtTTSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addComponent(btnXacNhanSua)
                                .addContainerGap(11, Short.MAX_VALUE))
        );

        setPreferredSize(new java.awt.Dimension(1080, 670));

        jLabel2.setText("Tên Sách:");

        txtTenSach.setMinimumSize(new java.awt.Dimension(60, 20));
        txtTenSach.setPreferredSize(new java.awt.Dimension(60, 25));
        txtTenSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSachActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá:");

        txtGia.setPreferredSize(new java.awt.Dimension(60, 25));
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        jLabel4.setText("Số lượng:");

        txtSoLuong.setPreferredSize(new java.awt.Dimension(60, 25));
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel6.setText("Tác Giả:");

        jLabel7.setText("NXB:");

        jLabel8.setText("Thể loại:");

        dbLS.setPreferredSize(new java.awt.Dimension(60, 25));
        dbLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbLSActionPerformed(evt);
            }
        });

        dbNXB.setMinimumSize(new java.awt.Dimension(64, 22));
        dbNXB.setPreferredSize(new java.awt.Dimension(60, 25));
        dbNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbNXBActionPerformed(evt);
            }
        });

        dbTacGia.setMinimumSize(new java.awt.Dimension(60, 25));
        dbTacGia.setPreferredSize(new java.awt.Dimension(60, 25));
        dbTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbTacGiaActionPerformed(evt);
            }
        });

        btnThem.setText("THÊM");
        btnThem.setPreferredSize(new java.awt.Dimension(80, 23));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);

        btnSua.setText("SỬA");
        btnSua.setPreferredSize(new java.awt.Dimension(80, 23));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua);

        btnXoa.setText("XOÁ");
        btnXoa.setPreferredSize(new java.awt.Dimension(80, 23));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        btnTK.setText("TÌM KIẾM");
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });
        jPanel1.add(btnTK);

        btnHuyTK.setText("TẢI LẠI");
        btnHuyTK.setPreferredSize(new java.awt.Dimension(80, 23));
        btnHuyTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTKActionPerformed(evt);
            }
        });
        jPanel1.add(btnHuyTK);

        btnThemTacGiaMoi.setText("Thêm tác giả mới");
        btnThemTacGiaMoi.setPreferredSize(new java.awt.Dimension(80, 23));
        btnThemTacGiaMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTacGiaMoiActionPerformed(evt);
            }
        });

        btnThemNXBMoi.setText("Thêm NXB mới");
        btnThemNXBMoi.setPreferredSize(new java.awt.Dimension(80, 23));
        btnThemNXBMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNXBMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(dbLS, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(141, 141, 141)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnThemNXBMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(dbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnThemTacGiaMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(151, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(dbLS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(dbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThemTacGiaMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(dbNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnThemNXBMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        dbLS.getAccessibleContext().setAccessibleDescription("");

        jTableSach.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String[]{
                        "ID", "Tên Sách", "Giá", "Tác Giả", "NXB", "Số lượng", "Loại Sách", "Trạng thái"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSach);
        if (jTableSach.getColumnModel().getColumnCount() > 0) {
            jTableSach.getColumnModel().getColumn(0).setMinWidth(50);
            jTableSach.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableSach.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableSach.getColumnModel().getColumn(1).setMinWidth(120);
            jTableSach.getColumnModel().getColumn(1).setPreferredWidth(120);
            jTableSach.getColumnModel().getColumn(1).setMaxWidth(120);
            jTableSach.getColumnModel().getColumn(2).setMinWidth(120);
            jTableSach.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTableSach.getColumnModel().getColumn(2).setMaxWidth(120);
            jTableSach.getColumnModel().getColumn(3).setMinWidth(120);
            jTableSach.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTableSach.getColumnModel().getColumn(3).setMaxWidth(120);
            jTableSach.getColumnModel().getColumn(4).setMinWidth(120);
            jTableSach.getColumnModel().getColumn(4).setPreferredWidth(120);
            jTableSach.getColumnModel().getColumn(4).setMaxWidth(120);
            jTableSach.getColumnModel().getColumn(5).setMinWidth(60);
            jTableSach.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTableSach.getColumnModel().getColumn(5).setMaxWidth(60);
            jTableSach.getColumnModel().getColumn(6).setMinWidth(120);
            jTableSach.getColumnModel().getColumn(6).setPreferredWidth(120);
            jTableSach.getColumnModel().getColumn(6).setMaxWidth(120);
        }

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel18.setText("SÁCH");
        jPanel4.add(jLabel18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSachActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:
        cbLoaiSachTimKiem.removeAllItems();
        cbLoaiSachTimKiem.addItem("Tất cả");
        LoaiSachBUS loaiSachBUS = new LoaiSachBUS();
        loaiSachBUS.findAll();
        listLoaiSach = loaiSachBUS.getListLoaiSach();
        listLoaiSach.forEach(loaiSachDTO -> {
            cbLoaiSachTimKiem.addItem(loaiSachDTO.getTenLoai());
        });
        jDialogTimKiem.setVisible(true);
        jDialogTimKiem.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTKActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("them")) {
            return;
        }
        int id = MyConnection.getLastRecordId("SACH") + 1;
        String tenSach = txtTenSach.getText();
        Integer giaSach = Integer.valueOf(txtGia.getText());

        int tacGiaId = 0;
        for (int i = 0; i < listTacGia.size(); i++) {
            if (listTacGia.get(i).getHoTen().equalsIgnoreCase(String.valueOf(dbTacGia.getSelectedItem()))) {
                tacGiaId = listTacGia.get(i).getIdTacGia();
            }
        }
        int nhaXuatBanId = 0;
        for (int i = 0; i < listNhaXuatBan.size(); i++) {
            if (listNhaXuatBan.get(i).getTen().equalsIgnoreCase(String.valueOf(dbNXB.getSelectedItem()))) {
                nhaXuatBanId = listNhaXuatBan.get(i).getId();
            }
        }
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        // Số lượng sách được thêm phải < 99 và > 0
        if (soLuong <= 0 || soLuong >= 100) {
            JOptionPane.showMessageDialog(this, "Số lượng sách phải lớn hơn 0 và nhỏ hơn 100");
            return;
        }
//        int tt = SachDTO.TrangThaiSach.valueOf(cbTrangThai.getSelectedItem().toString()).ordinal();
        int k = 0;
        int loaiSachId = 0;
        for (int i = 0; i < listLoaiSach.size(); i++) {
            if (listLoaiSach.get(i).getTenLoai().equalsIgnoreCase(String.valueOf(dbLS.getSelectedItem()))) {
                loaiSachId = listLoaiSach.get(i).getIdLoaiSach();
            }
        }
        SachDTO sachDTO = new SachDTO(id, tenSach, giaSach, soLuong, SachDTO.TrangThaiSach.DANG_NHAP_KHO.ordinal(), tacGiaId, nhaXuatBanId, loaiSachId);
        SachBUS sachBUS = new SachBUS();
        sachBUS.insertone(sachDTO);
        setTableItemList();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
        clearAllTextField();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
            return;
        }

        Object obj = jTableSach.getValueAt(selectedRow, 0);
        int id = Integer.parseInt(obj.toString());
        SachDTO sachDTO = new SachBUS().findone(id);

        // Chỉ xoá đc nếu thuộc đang nhập kho hoặc hết sách
        if (
                !(sachDTO.getTrangthai() == SachDTO.TrangThaiSach.DANG_NHAP_KHO.ordinal() ||
                        sachDTO.getTrangthai() == SachDTO.TrangThaiSach.HET_SACH.ordinal())
        ) {
            JOptionPane.showMessageDialog(this, "Chỉ có thể xoá sách đang ở trạng thái đang nhập kho hoặc hết sách");
            return;
        }


        PhieuMuonBUS phieuMuonBUS = new PhieuMuonBUS();
        ArrayList<PhieuMuonDTO> phieuMuonDTOArrayList = phieuMuonBUS.findByIdSach(id);

        // list is not empty
        if (!phieuMuonDTOArrayList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không thể xóa sách này vì sách này đang được mượn");
            return;
        }

        if (sachDTO.getSoluong() > 0) {
            JOptionPane.showMessageDialog(this, "Không thể xóa sách này vì số lượng trong kho > 0");
            return;
        }

        if (!Helpler.showConfirmDialog(this,
                String.format("Bạn có chắc chắn muốn xoá sách '%s' không?", sachDTO.getTenSach()), "Xoá sách")) {
            return;
        }

        SachBUS sbus = new SachBUS();
        if (sbus.delete(id)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
        setTableItemList();
        clearAllTextField();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableSach.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa");
            return;
        }

        loadLoaiSach(txtLSSua);

        int idSach = (int) jTableSach.getValueAt(selectedRow, 0);
        SachBUS sachBUS = new SachBUS();
        SachDTO sachDTO = sachBUS.findone(idSach);

        // Nếu ko phải là quản lý
        if (nhanVienDangNhap.getVaiTro() == NhanVienDTO.VaiTro.NHAN_VIEN.ordinal()) {
            if (sachDTO.getTrangthai() == SachDTO.TrangThaiSach.DANG_NHAP_KHO.ordinal()) {
                txtTTSua.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Chỉ có thể sửa sách đang ở trạng thái đang nhập kho");
                return;
            }
        }

        // Nếu là quản lý
        if (nhanVienDangNhap.getVaiTro() == NhanVienDTO.VaiTro.QUAN_LY.ordinal()) {
            // chi co the sua neu o trang thai dang nhap kho va het sach
            if (
                    sachDTO.getTrangthai() == SachDTO.TrangThaiSach.DANG_NHAP_KHO.ordinal()
                    || sachDTO.getTrangthai() == SachDTO.TrangThaiSach.HET_SACH.ordinal()
            ) {
                txtTSSua.setEnabled(true);
                txtGSua.setEnabled(true);
                txtSLSua.setEnabled(true);
                cbTacGiaSua.setEnabled(true);
                cbNXBSua.setEnabled(true);
                txtLSSua.setEnabled(true);
            } else {
                txtTSSua.setEnabled(false);
                txtGSua.setEnabled(false);
                txtSLSua.setEnabled(false);
                cbTacGiaSua.setEnabled(false);
                cbNXBSua.setEnabled(false);
                txtLSSua.setEnabled(false);
            }
        }


        txtIDSua.setText(String.valueOf(sachDTO.getId()));
        txtTSSua.setText(sachDTO.getTenSach());
        txtGSua.setText(String.valueOf((int) sachDTO.getGiaSach()));
        txtSLSua.setText(String.valueOf(sachDTO.getSoluong()));
        loadTrangThai(txtTTSua);
        LoaiSachDTO loaiSachDTO = new LoaiSachBUS().findOne(sachDTO.getIdLoaiSach());
        NhaXuatBanDTO nhaXuatBanDTO = new NhaXuatBanBUS().findOne(sachDTO.getIdNhaXuatBan());
        TacGiaDTO tacGiaDTO = new TacGiaBUS().findOne(sachDTO.getIdTacGia());
        loadTacGia(cbTacGiaSua);
        loadNhaXuatBan(cbNXBSua);
        txtLSSua.setSelectedItem(loaiSachDTO.getTenLoai());
        cbNXBSua.setSelectedItem(nhaXuatBanDTO.getTen());
        cbTacGiaSua.setSelectedItem(tacGiaDTO.getHoTen());
        txtTTSua.setSelectedItem(SachDTO.TrangThaiSach.values()[sachDTO.getTrangthai()].toString());
        jDialogSua.setVisible(true);
        jDialogSua.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHuyTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTKActionPerformed
        // TODO add your handling code here:
        loadLoaiSach(dbLS);
        loadNhaXuatBan(dbNXB);
        loadTacGia(dbTacGia);
        setTableItemList();
    }//GEN-LAST:event_btnHuyTKActionPerformed

    private void btnXacNhanSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanSuaActionPerformed
        // TODO add your handling code here:
        if (!checkTextField("Sua")) {
            return;
        }
        // Get value in text field
        int id = Integer.parseInt(txtIDSua.getText());
        String ts = txtTSSua.getText();
        Integer g = Integer.valueOf(txtGSua.getText());
        int tg = 0;
        for (int i = 0; i < listTacGia.size(); i++) {
            if (listTacGia.get(i).getHoTen().equalsIgnoreCase(String.valueOf(cbTacGiaSua.getSelectedItem()))) {
                tg = listTacGia.get(i).getIdTacGia();
            }
        }
        int nxb = 0;
        for (int i = 0; i < listNhaXuatBan.size(); i++) {
            if (listNhaXuatBan.get(i).getTen().equalsIgnoreCase(String.valueOf(cbNXBSua.getSelectedItem()))) {
                nxb = listNhaXuatBan.get(i).getId();
            }
        }
        int sl = Integer.parseInt(txtSLSua.getText());
        int tt = SachDTO.TrangThaiSach.fromString(String.valueOf(txtTTSua.getSelectedItem())).ordinal();
        int k = 0;
        int ls = 0;
        for (int i = 0; i < listLoaiSach.size(); i++) {
            if (listLoaiSach.get(i).getTenLoai().equalsIgnoreCase(String.valueOf(txtLSSua.getSelectedItem()))) {
                ls = listLoaiSach.get(i).getIdLoaiSach();
            }
        }
        SachBUS sachBUS = new SachBUS();
        //Get a record with id
        SachDTO sachDTO = sachBUS.findone(id);
        //Change the record columns value
        sachDTO.setTenSach(ts);
        sachDTO.setGiaSach(g);
        sachDTO.setIdTacGia(tg);
        sachDTO.setIdNhaXuatBan(nxb);
        sachDTO.setSoluong(sl);
        sachDTO.setIdLoaiSach(ls);
        sachDTO.setTrangthai(tt);

        if (sachDTO.getTrangThaiSach() == SachDTO.TrangThaiSach.HET_SACH) {
            sachDTO.setSoluong(0);
        }

        if (sachDTO.getSoluong() == 0) {
            sachDTO.setTrangthai(SachDTO.TrangThaiSach.HET_SACH.ordinal());
        }

        //Update record to database
        if (sachBUS.update(sachDTO)) {
            setTableItemList();
            jDialogSua.setVisible(false);
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            clearAllTextField();
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
            return;
        }


    }//GEN-LAST:event_btnXacNhanSuaActionPerformed

    private void txtIDSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSuaActionPerformed

    private void dbLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbLSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbLSActionPerformed

    private void dbNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbNXBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbNXBActionPerformed

    private void dbTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbTacGiaActionPerformed

    private void cbLoaiSachTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiSachTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiSachTimKiemActionPerformed

    private void btnXacNhanTImActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanTImActionPerformed
        // TODO add your handling code here:
        try {
            boolean itNhat1DieuKien = false;
            int id;
            String tensach = "";
            int loaisach = -1;
            int giaTienFrom, giaTienTo;
            if (!txtID2.getText().isEmpty()) {
                // id <= 256 ký tự
                if (txtID2.getText().length() > 256) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "id không được quá 256 ký tự");
                    return;
                }

                id = Integer.parseInt(txtID2.getText());
                itNhat1DieuKien = true;
            } else {
                id = -1;
            }
            if (!txtTS2.getText().isEmpty()) {
                if (txtTS2.getText().length() > 256) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Tên sách không được quá 256 ký tự");
                    return;
                }

                tensach = txtTS2.getText();
                itNhat1DieuKien = true;
            }
            if (!cbLoaiSachTimKiem.getSelectedItem().toString().equalsIgnoreCase("Tất cả")) {
                for (int i = 0; i < listLoaiSach.size(); i++) {
                    if (listLoaiSach.get(i).getTenLoai().equalsIgnoreCase(String.valueOf(cbLoaiSachTimKiem.getSelectedItem()))) {
                        loaisach = listLoaiSach.get(i).getIdLoaiSach();
                    }
                }
                itNhat1DieuKien = true;
            }

            if (txtGiaSachFrom.getText().isEmpty()) {
                giaTienFrom = -1;
            } else {
                // Giá tiền <= 10 ký tự
                if (txtGiaSachFrom.getText().length() > 10) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách không được quá 100,000,000 VND");
                    return;
                }


                try {
                    giaTienFrom = Integer.parseInt(txtGiaSachFrom.getText());
                    if (giaTienFrom < 0 || giaTienFrom > 100000000) {
                        JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách không được < 0 và > 100,000,000 VNĐ");
                        return;
                    }
                } catch (NumberFormatException ignored) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách chỉ được nhập chữ số");
                    return;
                }

                itNhat1DieuKien = true;
            }

            if (txtGiaSachTo.getText().isEmpty()) {
                giaTienTo = -1;
            } else {
                if (txtGiaSachTo.getText().length() > 9) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách không được vượt quá 100,000,000 VNĐ");
                    return;
                }
                try {
                    giaTienTo = Integer.parseInt(txtGiaSachTo.getText());
                    if (giaTienTo < 0 || giaTienTo > 100000000) {
                        JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách không được < 0 và > 100,000,000 VNĐ");
                        return;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách chỉ được nhập chữ số");
                    return;
                }

                itNhat1DieuKien = true;
            }

            // Check gia sach
            if (giaTienFrom != -1 && giaTienTo != -1) {
                if (giaTienFrom >= giaTienTo) {
                    JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách không hợp lệ");
                    return;
                }
            }

            if (!itNhat1DieuKien) {
                return;
            }
            SachBUS sachBUS = new SachBUS();
            sachBUS.findMany(id, tensach, loaisach, giaTienFrom, giaTienTo);
            setTableItemList(sachBUS);
            jDialogTimKiem.setVisible(false);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(jDialogTimKiem, "Giá sách chỉ được nhập chữ số");
        }
    }//GEN-LAST:event_btnXacNhanTImActionPerformed

    private void txtTTSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTTSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTTSuaActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtGiaSachFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaSachFromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaSachFromActionPerformed

    private void txtGiaSachToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaSachToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaSachToActionPerformed

    private void btnThemTacGiaMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTacGiaMoiActionPerformed
        baseUI.setCard("tacGiaGUI", "Tác giả");
    }//GEN-LAST:event_btnThemTacGiaMoiActionPerformed

    private void btnThemNXBMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNXBMoiActionPerformed
        baseUI.setCard("nhaXuatBanGUI", "Nhà xuất bản");
    }//GEN-LAST:event_btnThemNXBMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyTK;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemNXBMoi;
    private javax.swing.JButton btnThemTacGiaMoi;
    private javax.swing.JButton btnXacNhanSua;
    private javax.swing.JButton btnXacNhanTIm;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiSachTimKiem;
    private javax.swing.JComboBox<String> cbNXBSua;
    private javax.swing.JComboBox<String> cbTacGiaSua;
    private javax.swing.JComboBox<String> dbLS;
    private javax.swing.JComboBox<String> dbNXB;
    private javax.swing.JComboBox<String> dbTacGia;
    private javax.swing.JDialog jDialogSua;
    private javax.swing.JDialog jDialogTimKiem;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSach;
    private javax.swing.JTextField txtGSua;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaSachFrom;
    private javax.swing.JTextField txtGiaSachTo;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtIDSua;
    private javax.swing.JComboBox<String> txtLSSua;
    private javax.swing.JTextField txtSLSua;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTS2;
    private javax.swing.JTextField txtTSSua;
    private javax.swing.JComboBox<String> txtTTSua;
    private javax.swing.JTextField txtTenSach;
    // End of variables declaration//GEN-END:variables
}
