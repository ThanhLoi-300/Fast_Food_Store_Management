/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.Bill;
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
            String sql ="SELECT bill.*,staff.Full_Name,customer.Customer_name FROM bill,customer,staff\n" +
                        "WHERE staff.Staff_id=bill.Staff_id AND customer.Customer_id = bill.Customer_id";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Bill b = new Bill();
                b.setBill_ID(rs.getString("Bill_ID"));
                b.setDate(rs.getString("Date"));
                BillDetail_DAO bd = new BillDetail_DAO();
                b.setBillDetail(bd.LoadDetail(b.getBill_ID()));
                b.setTotalValue(rs.getInt("TotalValue"));
                b.setReceivedMoney(rs.getDouble("ReceivedMoney"));
                b.setExcessMoney(rs.getDouble("ExcessMoney"));
                b.setStaffName(rs.getString("Full_Name"));
                b.setCustomerName(rs.getString("Customer_Name"));
                bL.add(b);
            }
        } catch(SQLException e){
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return bL;
    }
    
    public boolean insert(Bill b)
    {
        try{
            String id=b.getBill_ID();
            String sql="INSERT INTO `received_note` (`Received_Note_ID`, `Date`, `Total_Value`) "
                        + "VALUES ('"+id+"', '"+b.getDate()+"', '"+b.getTotalValue()+"', )";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            sql="UPDATE bill,staff,customer SET bill.Staff_ID=staff.Staff_id AND bill.Customer_id=customer.Customer_id  " +
                "WHERE staff.Full_Name='"+b.getStaffName()+
                "AND customer.Customer_name="+b.getCustomerName()+
                "AND bill.Bill_ID="+id;
            stm.executeUpdate(sql);
            BillDetail_DAO bdL = new BillDetail_DAO();
            bdL.Insert(b.getBillDetail(), id);
        }catch(SQLException e){ Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
                                return false;}        
        return true;
   
}
}