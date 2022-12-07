/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.Bill;
import DTO.statisticalObject;
import java.sql.Connection;
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
    private connectDB cB = new connectDB();
    public ArrayList<Bill> LoadData()
        {
            ArrayList<Bill> bL = new ArrayList<>();
            String sql ="SELECT * FROM bill ORDER BY Date DESC";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
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
    

   
    // code của Thái
    public String countGenerateId() {
        String sql  ="SELECT COUNT(Bill_ID) FROM `bill`";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
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
        try (Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql);){
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
             public ArrayList<Bill> loadDataByDate(String date)
    {
        ArrayList<Bill> bL = new ArrayList<>();
        String sql ="SELECT * FROM bill \n" 
                    +   "WHERE DATE(Date)='"+date+"'"
                    +   "ORDER BY Date DESC";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
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
         
        public double getEarnedValueByDate(String date){
             double value=0;
             String sql ="SELECT SUM(TotalValue) AS value FROM bill  "
                    +   "WHERE DATE(Date) = '"+date+"' ";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()) value = rs.getDouble("value");
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return value;
    }
        public ArrayList<statisticalObject> countCustomerByDay(String date)
        {
            ArrayList<statisticalObject> soL= new ArrayList<>();
            String sql = "SELECT bill.Customer_id,COUNT(bill.Customer_id) AS amount FROM bill,customer "
                          +  "WHERE customer.Customer_id=bill.Customer_id\n" +
                             "AND DATE(Date)='"+date+"' " +
                             "GROUP BY Customer_id";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Customer_id"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
            public ArrayList<statisticalObject> countCustomerByDay(String sdate,String edate)
        {
            ArrayList<statisticalObject> soL= new ArrayList<>();
            String sql = "SELECT bill.Customer_id,COUNT(bill.Customer_id) AS amount FROM bill,customer "
                          +  "WHERE customer.Customer_id=bill.Customer_id\n" +
                             "AND DATE(Date) BETWEEN '"+sdate+"' AND '"+edate+"' " +
                             "GROUP BY Customer_id";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Customer_id"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }   
        public int totalCustomerByDay(String date){
            int value=0;
            String sql="SELECT COUNT(Customer_id) AS amount FROM bill where DATE(Date)='"+date+"'";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
         public int countBillByDay(String date){
            int value=0;
            String sql="SELECT COUNT(Bill_ID) AS amount FROM bill where DATE(Date)='"+date+"'";;
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){                
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
    public double[] SumEarnedValuePerMonth(double[] arr,String year){
        String sql = "SELECT MONTH(Date) as month, SUM(TotalValue) as value FROM `bill` WHERE YEAR(Date)='"+year+"'";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()){
                if(rs.getString("month")!=null)
                arr[rs.getInt("month")-1]=rs.getDouble("value");
            }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return arr;
    }
    public ArrayList<statisticalObject> countCustomerByMonth(String month){    
            ArrayList<statisticalObject> soL= new ArrayList<>();
            String sql = "SELECT bill.Customer_id,COUNT(bill.Customer_id) AS amount FROM bill,customer "
                          +  "WHERE customer.Customer_id=bill.Customer_id\n" +
                             "AND MONTH(Date)='"+month+"' " +
                             "GROUP BY Customer_id";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Customer_id"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }   
    
}