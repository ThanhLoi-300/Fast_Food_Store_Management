/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.statisticalObject;
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
public class Statistic_DAO extends connectDB {
        public ArrayList<statisticalObject> countPurchaseTimeByDay(String date)
        {
            ArrayList<statisticalObject> soL= new ArrayList<>();
            try{
                String sql = "SELECT customer.Customer_name,COUNT(bill.Customer_id) AS amount FROM bill,customer "
                          +  "WHERE customer.Customer_id=bill.Customer_id\n" +
                             "AND DATE(Date)='"+date+"'" +
                             "GROUP BY customer.Customer_name";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setName(rs.getString("Customer_name"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
        public ArrayList<statisticalObject> countSoldProductByDay(String date)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>(); 
            try{
                String sql="SELECT Product_Name,product.Size, SUM(bill_detail.Quantity) AS amount FROM product, bill_detail,bill\n" +
"                    WHERE product.Product_ID=bill_detail.Product_id\n" +
"                    AND product.Size=bill_detail.Size \n" +
"                    AND bill.Bill_id = bill_detail.Bill_id\n" +
"                    AND DATE(bill.Date)='"+date+"'" +    
"                    GROUP BY bill_detail.Product_id, bill_detail.Size" ;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setName(rs.getString("Product_Name"));
                    so.setSize(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
        public ArrayList<statisticalObject> countReceivedProductByDay(String date)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            try{
                String sql="SELECT Product_Name,product.Size,SUM(received_note_detail.Quantity) as amount FROM product, received_note_detail,received_note "
                    + "WHERE product.Product_ID=received_note_detail.Product_ID "
                    + "AND product.Size=received_note_detail.Size "
                    + "AND received_note.Received_Note_ID = received_note_detail.Received_Note_ID  "
                    + "AND DATE(received_note.Date)='"+date+"'"
                    + "GROUP BY received_note_detail.Product_id,received_note_detail.Size";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setName(rs.getString("Product_Name"));
                    so.setSize(rs.getString("Size"));
                    so.setSize(rs.getString("Size"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
        public int getEarnedValueByDay(String date){
            int value=0;
            try{
                String sql="SELECT SUM(totalValue) AS amount FROM bill where DATE(Date)='"+date+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
        public int getPayValueByDay(String date){
            int value=0;
            try{
                String sql="SELECT SUM(Total_Value) AS amount FROM received_note where DATE(Date)='"+date+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
        public int countBillByDay(String date,boolean choice){
            int value=0;
            String sql;
            try{
                if(choice)
                sql="SELECT COUNT(Bill_ID) AS amount FROM bill where DATE(Date)='"+date+"'";
                else sql="SELECT COUNT(Received_Note_ID) AS amount FROM received_note where DATE(Date)='"+date+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
        public int countCustomerByDay(String date){
            int value=0;
            try{
                String sql="SELECT COUNT(Customer_id) AS amount FROM bill where DATE(Date)='"+date+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()) value = rs.getInt("amount");
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return value;
        }
}
