/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.BillDetail;
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
public class BillDetail_DAO extends connectDB {

    public ArrayList<BillDetail> LoadDetail(String id){
        ArrayList<BillDetail> bdL = new ArrayList<>();
        try{
        String sql="SELECT * FROM bill_detail  " +
"                   WHERE Bill_id = '"+ id +"'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            BillDetail bd = new BillDetail();
            bd.setBillId(rs.getString("Bill_id"));
            bd.setProductId(rs.getString("Product_id"));
            bd.setSize(rs.getString("Size"));
            bd.setQuantity(rs.getInt("Quantity"));
            bd.setTotalValue(rs.getInt("TotalValue"));
            bdL.add(bd);
            }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return bdL;
    }
    
    public Boolean insert(BillDetail bd) {
        int rowAffected  = 0;
        String sql = "INSERT INTO `bill_detail`(`Bill_id`, `Product_id`, `Size`, `Quantity`, `TotalValue`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, bd.getBillId());
            pstm.setString(2, bd.getProductId());
            pstm.setString(3, bd.getSize());
            pstm.setInt(4, bd.getQuantity());
            pstm.setDouble(5, bd.getTotalValue());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDetail_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    public ArrayList<statisticalObject> countSoldProductByDay(String date)
        {
            ArrayList<statisticalObject> soL = new ArrayList<>();
            try{
                String sql="SELECT product_id,Size, SUM(Quantity) AS amount FROM bill_detail,bill \n" +
                            "WHERE Bill.Bill_ID=bill_detail.Bill_id "
                        +   "AND DATE(Date) = '"+date+"'\n" +
                            "GROUP BY Product_id,Size";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                    statisticalObject so = new statisticalObject();
                    so.setId(rs.getString("Product_id"));
                    so.setSize(rs.getString("Size"));
                    so.setValue(rs.getInt("amount"));
                    soL.add(so);
                }
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
            return soL;
        }
    
}
