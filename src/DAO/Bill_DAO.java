/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bum
 */
public class Bill_DAO extends connectDB{

    public ArrayList<Bill> LoadData()
        {
            ArrayList<Bill> bL = new ArrayList<>();
            try{
                String sql ="SELECT * FROM bill ORDER BY Date DESC";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    Bill b = new Bill();
                    b.setBill_ID(rs.getString("Bill_ID"));
                    b.setDate(rs.getString("Date"));
                    b.setTotalValue(rs.getInt("TotalValue"));
                    b.setReceivedMoney(rs.getDouble("ReceivedMoney"));
                    b.setExcessMoney(rs.getDouble("ExcessMoney"));
                    b.setStaffID(rs.getString("Staff_id"));
                    b.setCustomerID(rs.getString("Customer_id"));
                    bL.add(b);
                }
            } catch(SQLException e){
                Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
            }
            return bL;
        }
    

    public ArrayList<Bill> searchByDate(String date)
    {
        ArrayList<Bill> bL = new ArrayList<>();
        try{
            String sql ="SELECT * FROM bill \n" 
                    +   "WHERE DATE(Date)='"+date+"'"
                    +   "ORDER BY Date DESC";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Bill b = new Bill();
                b.setBill_ID(rs.getString("Bill_ID"));
                b.setDate(rs.getString("Date"));
                b.setTotalValue(rs.getInt("TotalValue"));
                b.setReceivedMoney(rs.getDouble("ReceivedMoney"));
                b.setExcessMoney(rs.getDouble("ExcessMoney"));
                b.setStaffID(rs.getString("Staff_id"));
                b.setCustomerID(rs.getString("Customer_id"));
                bL.add(b);
        }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return bL;
    }
   
    // code của Thái
    public String countGenerateId() {
        String sql  ="SELECT COUNT(Bill_ID) FROM `bill`";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bill_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    // code của Thái
    public Boolean insert(Bill bill) {
        int rowAffected  = 0;
        String sql = "INSERT INTO `bill`(`Bill_ID`, `Date`, `TotalValue`, `ReceivedMoney`, `ExcessMoney`, `Staff_id`, `Customer_id`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, bill.getBill_ID());
            pstm.setString(2, bill.getDate());
            pstm.setDouble(3, bill.getTotalValue());
            pstm.setDouble(4, bill.getReceivedMoney());
            pstm.setDouble(5, bill.getExcessMoney());
            pstm.setString(6, bill.getStaffID());
            pstm.setString(7, bill.getCustomerID());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Bill_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
}