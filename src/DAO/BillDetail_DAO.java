/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.BillDetail;
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
        String sql="SELECT Product_Name,product.UnitPrice,bill_detail.* FROM product, bill_detail,bill  " +
"                    WHERE product.Product_ID=bill_detail.Product_id " +
"                    AND product.Size=bill_detail.Size " +
"                    AND bill.Bill_id = bill_detail.Bill_id  " +
"                    AND bill.Bill_id = '"+ id +"'";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            BillDetail bd = new BillDetail();
            bd.setProductName(rs.getString("Product_Name"));
            bd.setSize(rs.getString("Size"));
            bd.setUnitPrice(rs.getInt("UnitPrice"));
            bd.setAmount(rs.getInt("Quantity"));
            bd.setTotalValue(rs.getInt("TotalValue"));
            bdL.add(bd);
            }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return bdL;
    }
    
    public boolean Insert(ArrayList<BillDetail> bd,String id)
    {
        for (BillDetail bd1 : bd) {
            try{
                String sql ="INSERT INTO `received_note_detail` (`Received_Note_ID`, `Product_ID`, `Size`, `Quantity`, `Price`)"
                        + " VALUES ('"+id+"', '"+bd1.getProductId()+"', '"+bd1.getSize()+"', '"+bd1.getAmount()+"', '"+bd1.getTotalValue()+"')";
                Statement stm = conn.createStatement();
                stm.executeUpdate(sql);
            }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
            return false;}
        }
        return true;
    }
    
    
}
