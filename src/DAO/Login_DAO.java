/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import DTO.DecentralizationDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class Login_DAO{
    
    connectDB cn = new connectDB();
    
    public Account login(String username, String password) {
        String sql = "SELECT * FROM `account` WHERE `UserName`=? AND `Password`=?";
        Account acc = null;
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                acc = new Account();
                acc.setAccountId(rs.getString(1));
                acc.setUsername(rs.getString(2));
                acc.setPassword(rs.getString(3));
                acc.setDecentralizeId(rs.getString(4));
                acc.setStaffId(rs.getString(5));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
    
    public ArrayList<String> getStaffInfo(String username, String password) {
        ArrayList<String> staffInfo = new ArrayList<String>();
        String sql = "SELECT account.Staff_ID, staff.Full_Name, decentralization.decentralize_name, account.decentralize_id FROM account JOIN staff ON account.Staff_ID = staff.Staff_id"
        + " LEFT JOIN decentralization ON account.decentralize_id = decentralization.decentralize_id WHERE UserName =? AND Password =?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                staffInfo.add(rs.getNString(1));
                staffInfo.add(rs.getNString(2));
                staffInfo.add(rs.getString(3));
                staffInfo.add((rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffInfo;
    }
    
    public DecentralizationDetail getDecentralizationDetail(String decentralize_id) {
        DecentralizationDetail dcdt = new DecentralizationDetail();
        String sql = "SELECT * FROM `decentralization_detail` WHERE decentralize_id =?";
        try(Connection conn = cn.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, decentralize_id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
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
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dcdt;
    }
}

