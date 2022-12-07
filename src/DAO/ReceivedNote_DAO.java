/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
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
public class ReceivedNote_DAO {
    private connectDB cB = new connectDB();
    public ArrayList<ReceivedNote> loadData() {
        ArrayList<ReceivedNote> rnList = new ArrayList<>();
        String sql = "SELECT * FROM received_note\n"
                    + "ORDER BY Date DESC ";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while (rs.next()) {
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
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rnList;
    }

    public ArrayList<ReceivedNote> loadDataByDate(String Date) {
        ArrayList<ReceivedNote> rnList = new ArrayList<>();
        String sql = "SELECT * FROM received_note\n"
                    + "WHERE DATE(Date)='" + Date + "'"
                    + "ORDER BY Date DESC ";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while (rs.next()) {
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
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return rnList;
    }

    public double getPaidValueByDate(String date) {
        double value = 0;
        String sql = "SELECT SUM(Final_Value) AS value FROM received_note "
                    + "WHERE DATE(Date) = '" + date + "' ";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if (rs.next()) {
                value = rs.getDouble("value");
            }
        } catch (SQLException e) {Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return value;
    }
    public int countRNByDay(String date) {
        int value = 0;
        String sql = "SELECT COUNT(Received_Note_ID) AS amount FROM received_note where DATE(Date)='" + date + "'";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){            
            if (rs.next()) {
                value = rs.getInt("amount");
            }
        } catch (SQLException e) {
            Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return value;
    }
    //Phat
    public boolean insert(ReceivedNote receiveNote) {
        String sql = "INSERT INTO received_note(Received_Note_ID, Date, Total_Value, Tax_Value, Final_Value, Supplier, Staff_ID)"
                    + "VALUES ('"+receiveNote.getReceivedNoteID()+"','"+receiveNote.getDate()+"',"+receiveNote.getTotalValue()+","+receiveNote.getTaxValue()+","+receiveNote.getFinalValue()+",'"+receiveNote.getSupplier()+"','"+receiveNote.getStaffId()+"')";
        try (Connection conn = cB.getConnect();PreparedStatement pst = conn.prepareStatement(sql);){
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("An error has occured at insert method in ReceivedNote_DAO class");
            System.out.println(e);
        }
        return true;
    }
    
    public String autoID() {
        String id = "RN";
        int counter = 1;
        String sql = "SELECT COUNT(Received_Note_ID) FROM received_note";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){           
            while (rs.next()) {
                counter += rs.getInt("COUNT(Received_Note_ID)");
            }
        } catch (SQLException ex) {
            System.out.println("Error occured at autoID from ReceivedNote_DAO class");
            System.out.println(ex);
        }
        return id + counter;
    }
    public double[] SumPaidValuePerMonth(double[] arr,String year){
    String sql = "SELECT MONTH(Date) as month, SUM(Final_Value) as value FROM `received_note` WHERE YEAR(Date)='"+year+"'";
    try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
        while(rs.next()){
            if(rs.getString("month")!=null)
            arr[rs.getInt("month")-1]=rs.getDouble("value");
        }
    }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
    return arr;
    }
}
