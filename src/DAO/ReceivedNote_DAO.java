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
            String sql ="SELECT *,staff.Full_Name FROM received_note,staff "
                    + "WHERE received_note.staff_ID=staff.staff_id";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                ReceivedNote rn = new ReceivedNote();
                rn.setId(rs.getString("Received_Note_ID"));
                rn.setDate(rs.getString("Date"));
                ReceivedNoteDetail_DAO rndList = new ReceivedNoteDetail_DAO();
                rn.setDetail(rndList.LoadDetail(rn.getId()));
                rn.setTotalValue(rs.getInt("Total_Value"));
                rn.setSupplier(rs.getString("Supplier"));
                rn.setStaffName(rs.getString("Full_Name"));
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
            String sql ="SELECT received_note.*,staff.Full_Name FROM received_note,staff "
                    + "WHERE received_note.staff_ID=staff.staff_id "
                    + "AND DATE(date)='"+date+"' "
                    + "ORDER BY received_note.Date DESC";
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                ReceivedNote rn = new ReceivedNote();
                rn.setId(rs.getString("Received_Note_ID"));
                rn.setDate(rs.getString("Date"));
                ReceivedNoteDetail_DAO rndList = new ReceivedNoteDetail_DAO();
                rn.setDetail(rndList.LoadDetail(rn.getId()));
                rn.setTotalValue(rs.getInt("Total_Value"));
                rn.setSupplier(rs.getString("Supplier"));
                rn.setStaffName(rs.getString("Full_Name"));
                rnList.add(rn);
            }
        } catch(SQLException e){
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rnList;
    }
}
