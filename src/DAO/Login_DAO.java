/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class Login_DAO extends connectDB{
    
    public Account login(String username, String password) {
        String sql = "SELECT * FROM `account` WHERE `UserName`=? AND `Password`=?";
        Account acc = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                acc = new Account();
                acc.setAccountId(rs.getString(1));
                acc.setUsername(rs.getString(2));
                acc.setPassword(rs.getString(3));
                acc.setUserType(rs.getString(4));
                acc.setStaffId(rs.getString(5));
                return acc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
    
    public String getStaffName(String username, String password) {
        String sql = "SELECT `Full_Name` FROM account JOIN staff ON account.Staff_id = staff.Staff_id WHERE account.UserName =? AND account.Password=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                return rs.getNString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}

