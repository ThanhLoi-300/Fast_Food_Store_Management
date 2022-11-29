/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Decentralization;
import DTO.DecentralizationDetail;
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
 * @author ADMIN
 */
public class Decentralization_DAO {
    
    connectDB cn = new connectDB();
    
    public Decentralization_DAO() {}
    
    public ArrayList<Decentralization> read() {
        ArrayList<Decentralization> decentralize_list = new ArrayList<Decentralization>();
        String sql = "SELECT * FROM `decentralization`";
        try (Connection conn = cn.getConnect(); Statement stm = conn.createStatement();){
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                Decentralization dc = new Decentralization();
                dc.setDecentralizeID(rs.getString(1));
                dc.setDecentralizeName(rs.getNString(2));
                decentralize_list.add(dc);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Decentralization_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decentralize_list;
    }
    
    public ArrayList<String> readAllId() {
        ArrayList<String> idList = new ArrayList<String>();
        String sql = "SELECT `decentralize_id` FROM `decentralization`";
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                idList.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idList;
    }
    
    public boolean create(Decentralization dc) {
        int rowAffected = 0;
        String sql = "INSERT INTO `decentralization`(`decentralize_id`, `decentralize_name`) VALUES (?,?)";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, dc.getDecentralizeID());
            pstm.setString(2, dc.getDecentralizeName());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public boolean delete(String id) {
        int rowAffected = 0;
        String sql = "DELETE FROM `decentralization` WHERE `decentralize_id` = ?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, id);
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public boolean update(Decentralization dc) {
        int rowAffected = 0;
        String sql = "UPDATE `decentralization` SET `decentralize_name`=? WHERE `decentralize_id`=?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, dc.getDecentralizeName());
            pstm.setString(2, dc.getDecentralizeID());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public boolean check_Decentralization_Exist(String name,String id, String s){
        String sql = "";
        if(s.equals("create"))
            sql = "SELECT * FROM `decentralization` WHERE decentralize_name = '"+name+"'";
        else sql = "SELECT * FROM `decentralization` WHERE decentralize_name = '"+name+"' AND decentralize_id NOT IN ('"+id+"')";
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) return false;
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public DecentralizationDetail get_Decentralize_By_Name(String name){
        DecentralizationDetail dcdt = null;
        String sql = "SELECT decentralization_detail.* FROM decentralization,decentralization_detail WHERE decentralization.decentralize_name = '"+name+"' AND decentralization_detail.decentralize_id = decentralization.decentralize_id";
        try(Connection conn = cn.getConnect(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                dcdt = new DecentralizationDetail();
                dcdt.setDecentralizeID(rs.getString(1));
                dcdt.setIsSale(rs.getInt(2));
                dcdt.setIsRecept(rs.getInt(3));
                dcdt.setIsProduct(rs.getInt(4));
                dcdt.setIsCategory(rs.getInt(5));
                dcdt.setIsBill(rs.getInt(6));
                dcdt.setIsDiscount(rs.getInt(7));
                dcdt.setIsCustomer(rs.getInt(8));
                dcdt.setIsStaff(rs.getInt(9));
                dcdt.setIsAccount(rs.getInt(10));
                dcdt.setIsDecentralize(rs.getInt(11));
            }      
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dcdt;
    }
}
