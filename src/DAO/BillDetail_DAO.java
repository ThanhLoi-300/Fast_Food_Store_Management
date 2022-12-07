/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.BillDetail;
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
public class BillDetail_DAO {
    private connectDB cB = new connectDB();
    public ArrayList<BillDetail> LoadDetail(String id){
        ArrayList<BillDetail> bdL = new ArrayList<>();
        String sql="SELECT * FROM bill_detail  " +
"                   WHERE Bill_id = '"+ id +"'";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
        while(rs.next()){
            BillDetail bd = new BillDetail();
            bd.setBillId(rs.getString("Bill_id"));
            bd.setProductId(rs.getString("Product_id"));
            bd.setSize(rs.getString("Size"));
            bd.setQuantity(rs.getInt("Quantity"));
            bd.setTotalValue(rs.getInt("TotalValue"));
            bd.setPercent(rs.getInt("percent"));
            bdL.add(bd);
            }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return bdL;
    }
    
    public Boolean insert(BillDetail bd) {
        int rowAffected  = 0;
        String sql = "INSERT INTO `bill_detail`(`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`, `percent`) VALUES (?,?,?,?,?,?)";
        try (Connection conn = cB.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);){
            pstm.setString(1, bd.getBillId());
            pstm.setString(2, bd.getProductId());
            pstm.setString(3, bd.getSize());
            pstm.setInt(4, bd.getQuantity());
            pstm.setDouble(5, bd.getTotalValue());
            pstm.setInt(6, bd.getPercent());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetail_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    public ArrayList<statisticalObject> countSoldProductByDay(String date)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            String sql="SELECT product_id,Size, SUM(Quantity) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(Date) = '"+date+"'\n" +
                            "GROUP BY Product_id,Size";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){ 
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
        public ArrayList<statisticalObject> countSoldProductByDay(String sdate,String eDate)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            String sql="SELECT product_id,Size, SUM(Quantity) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(Date) BETWEEN '"+sdate+"' AND '"+eDate+"' \n" +
                            "GROUP BY Product_id,Size";
            try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){ 
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
    public int totalSoldProductByDay(String Date){
        int n=0;
        String sql="SELECT product_id,Size, SUM(Quantity) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(Date) = '"+Date+"'";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()) n = rs.getInt("amount");
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return n;
    }
    public ArrayList<statisticalObject> CountSoldProductByMonth(String month){
        ArrayList<statisticalObject> soL = new ArrayList<>();
        String sql="SELECT Product_id,Size, SUM(Quantity) AS amount FROM bill_detail,bill \n" +
                    "WHERE bill.Bill_ID = bill_detail.Bill_id\n" +
                    "AND MONTH(bill.Date) = '"+month+"' \n" +
                    "GROUP BY Product_id,Size";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setDescription(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return soL;
    }
}
