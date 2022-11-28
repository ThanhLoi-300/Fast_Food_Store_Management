/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Login_DAO;
import DTO.Account;
import DTO.DecentralizationDetail;
import java.util.ArrayList;

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
    
    public ArrayList<String> loginGetStaffInfo(String username, String password) {
        ArrayList<String> staffInfo = loginDAO.getStaffInfo(username, password);
        if(!staffInfo.isEmpty()) {
            return staffInfo;
        }
        else return null;
    }
    
    public DecentralizationDetail getDecentralizationDetail(String decentralize_id) {
        return loginDAO.getDecentralizationDetail(decentralize_id);
    }
}

