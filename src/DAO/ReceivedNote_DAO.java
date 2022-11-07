/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
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
public class ReceivedNote_DAO extends connectDB{

    public ArrayList<ReceivedNote> loadData(){
        ArrayList<ReceivedNote> rnList = new ArrayList<>();
        try{
            String sql ="SELECT * FROM received_note_detail"
                    +   "ORDER BY received_note.Date DESC ";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                ReceivedNote rn = new ReceivedNote();
                rn.setReceivedNoteID(rs.getString("Received_Note_ID"));
                rn.setDate(rs.getString("Date"));
                rn.setTotalValue(rs.getDouble("Total_Value"));
                rn.setTaxValue(rs.getDouble("Tax_Value"));
                rn.setFinalValue(rs.getDouble("Final_Value"));
                rn.setSupplier(rs.getString("Supplier"));
                rn.setStaffId(rs.getString("Staff_ID"));
                rnList.add(rn);
            }
        } catch(SQLException e){
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rnList;
    }
   
    public ArrayList<ReceivedNote> searchByDate(String date){
        ArrayList<ReceivedNote> rnList = new ArrayList<>();
        try{
            String sql ="SELECT * FROM received_note "  
                    + "WHERE DATE(date)='"+date+"' "
                    + "ORDER BY received_note.Date DESC";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                ReceivedNote rn = new ReceivedNote();
                rn.setReceivedNoteID(rs.getString("Received_Note_ID"));
                rn.setDate(rs.getString("Date"));
                rn.setTotalValue(rs.getDouble("Total_Value"));
                rn.setTaxValue(rs.getDouble("Tax_Value"));
                rn.setFinalValue(rs.getDouble("Final_Value"));
                rn.setStaffId(rs.getString("Staff_ID"));
                rnList.add(rn);
            }
        } catch(SQLException e){
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rnList;
    }
}
