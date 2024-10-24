package Helpler;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helpler {
    public static void centerCell(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        int numberOfColumn = table.getColumnCount();
        for (int i = 0; i < numberOfColumn; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static boolean checkTextFieldNumber(JTextField textField, String labelName, JDialog jDialog) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jDialog, "Vui lòng nhập " + labelName );
            return false;
        }
        // check is number
        try {
            Long.parseLong(textField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jDialog, labelName + " phải là số");
            return false;
        }
        return true;
    }

    public static boolean checkTextFieldNotEmpty(JTextField textField, String labelName, JDialog jDialog) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jDialog, "Vui lòng nhập " + labelName );
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        // Biểu thức chính quy cho email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,7}$";

        // Khởi tạo Pattern từ biểu thức chính quy
        Pattern pattern = Pattern.compile(emailRegex);

        // Nếu email null thì không hợp lệ
        if (email == null) {
            return false;
        }

        // Khớp email với biểu thức chính quy
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void setDateChooserFormat(JDateChooser dateChooser) {
        dateChooser.setDateFormatString("dd/MM/yyyy");
    }

    public static boolean showConfirmDialog( java.awt.Component parentComponent,
                                             Object message,
                                             String title) {
        int dialogConfirmXoa = JOptionPane.showConfirmDialog(parentComponent,
                message, title, JOptionPane.YES_NO_CANCEL_OPTION);
        // Check if the dialog was closed or NO was selected
        if (dialogConfirmXoa == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    public static boolean isOlderThan18(Date ngaySinh) {
        // Get the current date
        Calendar cal = Calendar.getInstance();

        // Subtract 18 years from the current date
        cal.add(Calendar.YEAR, -18);
        Date date18YearsAgo = cal.getTime();

        // Check if ngaySinh is before the date 18 years ago
        return ngaySinh.before(date18YearsAgo);
    }

    // is younger than 100
    public static boolean isYoungerThan100(Date ngaySinh) {
        // Get the current date
        Calendar cal = Calendar.getInstance();

        // Subtract 100 years from the current date
        cal.add(Calendar.YEAR, -100);
        Date date100YearsAgo = cal.getTime();

        // Check if ngaySinh is after the date 100 years ago
        return ngaySinh.after(date100YearsAgo);
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }
}
