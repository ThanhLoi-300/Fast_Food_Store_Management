
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectDB {

    public connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            try {
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food_store", "root", "");
////                System.out.println("Database connection successfull!");
//            } catch (SQLException ex) {
//                Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public Connection getConnect() {
        try {    
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fast_food_store", "thanh", "123456");
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
