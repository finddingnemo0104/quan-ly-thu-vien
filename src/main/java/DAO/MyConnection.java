/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class MyConnection {
    // Why my connection is so slow ?
    // Because you are using a local server, and the server is not optimized for speed.
    // You can try to use a remote server, or use a different server.
    // You can also try to use a different database, or use a different database.
    // Can you optimize my connection by code?
    // Yes, you can optimize your connection by code.
    // Let do it
    
    public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=QuanLyThuVien;"
                + "encrypt=true; trustServerCertificate=true;";
        String username = "sa";
        String password = "khongrotmon";
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        return con;
    }

    
    public static int getLastRecordId(String tableName) {
        String query = String.format("SELECT TOP 1 * FROM %s ORDER BY ID DESC", tableName);
        Connection con;
        try {
            con = MyConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("id");
            }
            // Nếu chưa có dòng nào
            return 0;
        } catch (Exception ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
}
