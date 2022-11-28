/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
public class DecentralizationDetail_DAO {
    
    connectDB cn = new connectDB();
    
    public DecentralizationDetail readById(String id) {
        DecentralizationDetail dcdt = null;
        String sql = "SELECT * FROM `decentralization_detail` WHERE `decentralize_id`=?";
        try (Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);){
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
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
        } 
        catch (SQLException ex) {
            Logger.getLogger(DecentralizationDetail_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dcdt;
    }
    
    public String getNameById(String id) {
        String decentralization_name = "";
        String sql = "SELECT dc.decentralize_name FROM `decentralization_detail` dcdt JOIN `decentralization` dc ON dcdt.decentralize_id=dc.decentralize_id WHERE dcdt.decentralize_id=?";
        try (Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);){
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                decentralization_name = rs.getString(1);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DecentralizationDetail_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decentralization_name;
    }
    
    public boolean update(DecentralizationDetail dcdt) {
        int rowAffected = 0;
        String sql = "UPDATE `decentralization_detail` SET `isSale`=?,`isRecept`=?,`isProduct`=?,`isCategory`=?,`isBill`=?,`isDiscount`=?,`isCustomer`=?,`isStaff`=?,`isAccount`=?, `isDecentralize`=? WHERE `decentralize_id`=?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setInt(1, dcdt.getIsSale());
            pstm.setInt(2, dcdt.getIsRecept());
            pstm.setInt(3, dcdt.getIsProduct());
            pstm.setInt(4, dcdt.getIsCategory());
            pstm.setInt(5, dcdt.getIsBill());
            pstm.setInt(6, dcdt.getIsDiscount());
            pstm.setInt(7, dcdt.getIsCustomer());
            pstm.setInt(8, dcdt.getIsStaff());
            pstm.setInt(9, dcdt.getIsAccount());
            pstm.setInt(10, dcdt.getIsDecentralize());
            pstm.setString(11, dcdt.getDecentralizeID());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public boolean create(DecentralizationDetail dcdt) {
        int rowAffected = 0;
        String sql = "INSERT INTO `decentralization_detail`(`decentralize_id`, `isSale`, `isRecept`, `isProduct`, `isCategory`, `isBill`, `isDiscount`, `isCustomer`, `isStaff`, `isAccount`, `isDecentralize`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, dcdt.getDecentralizeID());
            pstm.setInt(2, dcdt.getIsSale());
            pstm.setInt(3, dcdt.getIsRecept());
            pstm.setInt(4, dcdt.getIsProduct());
            pstm.setInt(5, dcdt.getIsCategory());
            pstm.setInt(6, dcdt.getIsBill());
            pstm.setInt(7, dcdt.getIsDiscount());
            pstm.setInt(8, dcdt.getIsCustomer());
            pstm.setInt(9, dcdt.getIsStaff());
            pstm.setInt(10, dcdt.getIsAccount());
            pstm.setInt(11, dcdt.getIsDecentralize());
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
    
    public boolean delete(String id) {
        int rowAffected = 0;
        String sql = "DELETE FROM `decentralization_detail` WHERE `decentralize_id` = ?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, id);
            rowAffected = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Customer_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected > 0 ? true:false;
    }
}
