
package DAO;

import DTO.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer_DAO extends connectDB{

    public Customer_DAO() {
    }
    
    public ArrayList<Customer> read() {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM customer";
            Statement  stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                Customer ct = new Customer();
                ct.setCustomerId(rs.getString(1));
                ct.setCustomerName(rs.getNString(2));
                ct.setCustomerBirthYear(rs.getInt(3)); //or '^.{4}'
                ct.setPurchaseTimes(rs.getInt(4));
                customerList.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    public Boolean create(Customer ct) {
        int rowAffected = 0;
        try {
            String sql = "INSERT INTO `customer`(`Customer_id`, `Customer_name`, `YearOfBirth`, `Purchase_Time`) VALUES (?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ct.getCustomerId());
            pstm.setString(2, ct.getCustomerName());
            pstm.setInt(3, ct.getCustomerBirthYear());
            pstm.setInt(4, ct.getPurchaseTimes());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public Boolean update(Customer ct) {
        int rowAffected = 0;
        String sql = "UPDATE `customer` SET `Customer_name`=?,`YearOfBirth`=?,`Purchase_Time`=? WHERE `Customer_id`=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ct.getCustomerName());
            pstm.setInt(2, ct.getCustomerBirthYear());
            pstm.setInt(3, ct.getPurchaseTimes());
            pstm.setString(4, ct.getCustomerId());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public Boolean delete(String id) {
        int rowAffected = 0;
        String sql = "DELETE FROM `customer` WHERE `Customer_id` = ?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public Customer findById(String id) {
        String sql = "SELECT * FROM `customer` WHERE `Customer_id` = ?";
        Customer ct = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                ct = new Customer();
                ct.setCustomerId(rs.getString(1));
                ct.setCustomerName(rs.getNString(2));
                ct.setCustomerBirthYear(rs.getInt(3));
                ct.setPurchaseTimes(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ct;
    }
    
    public ArrayList<Customer> filter(String filter) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        String sqlGreaterThan = "SELECT * FROM `customer` WHERE `Purchase_Time` >= 5";
        String sqlSmallerThan = "SELECT * FROM `customer` WHERE `Purchase_Time` < 5";
        if(filter.equals("Tích lũy < 5")) {
            try {
                PreparedStatement pstm = conn.prepareStatement(sqlSmallerThan);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()) {
                    Customer ct = new Customer();
                    ct.setCustomerId(rs.getString(1));
                    ct.setCustomerName(rs.getNString(2));
                    ct.setCustomerBirthYear(rs.getInt(3));
                    ct.setPurchaseTimes(rs.getInt(4));
                    customerList.add(ct);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try {
                PreparedStatement pstm = conn.prepareStatement(sqlGreaterThan);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()) {
                    Customer ct = new Customer();
                    ct.setCustomerId(rs.getString(1));
                    ct.setCustomerName(rs.getNString(2));
                    ct.setCustomerBirthYear(rs.getInt(3));
                    ct.setPurchaseTimes(rs.getInt(4));
                    customerList.add(ct);
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return customerList;
    }

}

