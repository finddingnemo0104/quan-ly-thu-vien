package Helpler;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

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
            Integer.parseInt(textField.getText());
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

    public static void setDateChooserFormat(JDateChooser dateChooser) {
        dateChooser.setDateFormatString("dd/MM/yyyy");
    }
}
