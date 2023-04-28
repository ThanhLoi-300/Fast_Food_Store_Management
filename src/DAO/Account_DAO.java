/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Account_DAO extends connectDB {

    private connectDB cB = new connectDB();

    //Lấy dữ liệu từ database
    public ArrayList<Account> loadDataAccount() {
        ArrayList<Account> listAccount = new ArrayList<Account>();
        String sql = "SELECT * FROM account WHERE IsDeleted<>1";
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                Account account = new Account(rs.getString("Account_ID"), rs.getString("UserName"), rs.getString("Password"), rs.getString("decentralize_id"), rs.getString("Staff_ID"), rs.getBoolean("IsDeleted"));
                listAccount.add(account);
            }
        } catch (Exception e) {
            System.out.println("Error occured at loadDataAccount method from Account_DAO class.");
            System.out.println(e);
        }
        return listAccount;
    }

    public boolean insertAccount(Account acc) {
        String sql = "INSERT INTO account (Account_ID, UserName, Password, decentralize_id, Staff_ID, IsDeleted) VALUES (?,?,?,?,?,?)";
        try (Connection conn = cB.getConnect(); PreparedStatement pst = conn.prepareStatement(sql);) {
            pst.setString(1, acc.getAccountId());
            pst.setString(2, acc.getUsername());
            pst.setString(3, acc.getPassword());
            pst.setString(4, acc.getDecetralizeId());
            pst.setString(5, acc.getStaffId());
            pst.setInt(6, 0);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Account_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean updateAccount(Account acc) {

        String sql = "UPDATE `account` SET `UserName`=?, `Password`=?,`decentralize_id`=?, `Staff_ID`=? WHERE `Account_ID`=?";

        try (Connection conn = cB.getConnect(); PreparedStatement pst = conn.prepareStatement(sql);) {
            pst.setString(1, acc.getUsername());
            pst.setString(2, acc.getPassword());
            pst.setString(3, acc.getDecetralizeId());
            pst.setString(4, acc.getStaffId());
            pst.setString(5, acc.getAccountId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Account_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean deleteAccount(String id) {

        String sql = "UPDATE `account` SET `IsDeleted` = '1' WHERE Account_ID=?";
        try (Connection conn = cB.getConnect(); PreparedStatement pst = conn.prepareStatement(sql);) {
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Account_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public ArrayList<Account> searchAccount(String keyword, String filter) {
        ArrayList<Account> listAccount = new ArrayList<Account>();
        try {
            String searchField = "";

            switch (filter) {
                case "Mã tài khoản":
                    searchField = "Account_ID";
                    break;
                case "Tên tài khoản":
                    searchField = "UserName";
                    break;
                case "Mật khẩu":
                    searchField = "Password";
                    break;
                case "Loại":
                    searchField = "decentralize_id";
                    break;
                case "Mã nhân viên":
                    searchField = "Staff_ID";
                    break;
            }
            String sql = "SELECT * FROM account WHERE " + searchField + " LIKE '%" + keyword + "%'";
            try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
                while (rs.next()) {
                    Account acc = new Account(rs.getString("Account_ID"), rs.getString("UserName"),
                            rs.getString("Password"), rs.getString("decentralize_id"), rs.getString("Staff_ID"), rs.getBoolean("IsDeleted"));
                    listAccount.add(acc);

                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println("Error occured at searchAccount from Account_DAO class");
            System.out.println(e);
        }
        return listAccount;
    }

    public boolean accountNameExisted(String id, String name) {
        boolean isExisted = false;
        String sql = "SELECT * FROM account WHERE UserName = '" + name
                + "' AND Account_ID NOT IN ('" + id + "') AND IsDeleted <> 1";
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while (rs.next()) {
                if (name.equalsIgnoreCase(rs.getString("UserName"))) {
                    isExisted = true;
                    break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error accured at accountNameExisted from Account_DAO class");
            System.out.println(e);
        }
        return isExisted;
    }

    public String autoID() {
        String id = "AC0";
        int counter = 1;
        String sql = "SELECT COUNT(DISTINCT Account_ID) FROM account";
        try (Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {

            while (rs.next()) {
                counter += rs.getInt("COUNT(DISTINCT Account_ID)");
            }
        } catch (SQLException e) {
            System.out.println("Error occured at autoID from Account_DAO class");
            System.out.println(e);
        }
        return id + counter;
    }
}
