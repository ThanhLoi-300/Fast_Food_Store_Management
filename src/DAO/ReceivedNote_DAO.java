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
    public boolean insert(ReceivedNote rn,ReceivedNoteDetail rnd)
    {
        try{
            String id=rn.getId();
            String sql="INSERT INTO `received_note` (`Received_Note_ID`, `Date`, `Total_Value`, `Supplier`) "
                        + "VALUES ('"+id+"', '"+rn.getDate()+"', '"+rn.getTotalValue()+"', '"+rn.getSupplier()+"')";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            sql="UPDATE received_note,staff SET received_note.Staff_ID=staff.Staff_id  " +
                "WHERE staff.Full_Name='"+rn.getStaffName()+"' AND received_note.Received_Note_ID='"+id+"'";
            stm.executeUpdate(sql);
            ReceivedNoteDetail_DAO rndList = new ReceivedNoteDetail_DAO();
            rndList.Insert(rnd, id);
        }catch(SQLException e){ Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
                                return false;}        
        return true;
    }
    
}
