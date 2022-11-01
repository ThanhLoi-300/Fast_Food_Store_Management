/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Login_DAO;
import DTO.Account;

/**
 *
 * @author ADMIN
 */
public class Login_BUS {
    private Login_DAO loginDAO;

    public Login_BUS() {
        loginDAO = new Login_DAO();
    }
    
    public Account userlogin(String username, String password) {
        Account acc = loginDAO.login(username, password);
        if(acc == null) {
            return null;
        }
        return acc;
    } 
    
    public String loginGetStaffName(String username, String password) {
        String staffName = loginDAO.getStaffName(username, password);
        if(!staffName.isEmpty()) {
            return staffName;
        }
        else return "";
    }
}

