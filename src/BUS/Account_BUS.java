/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Account_DAO;
import DTO.Account;
import java.util.ArrayList;

/**
 *
 * @author Josie
 */
public class Account_BUS {
    private Account_DAO accountDAO = new Account_DAO();
    
    public ArrayList<Account> loadDataAccount() {
        return accountDAO.loadDataAccount();
    }
    
    public boolean inserAccount(Account account) {
        if(accountDAO.insertAccount(account)) return true;
        return false;
    }
    
    public boolean deleteAccount(String id) {
        if (accountDAO.deleteAccount(id)) return true;
        return false;
    }
    
    public boolean updateAccount(Account account){
        if(accountDAO.updateAccount(account)) return true;
        return false;
    }
    public ArrayList<Account> searchAccount(String keyword, String filter) {
        return accountDAO.searchAccount(keyword, filter);
    }
    
    public boolean accountNameExisted(String id, String name) {
        return accountDAO.accountNameExisted(id, name);
    }
    
    public String autoID() {
        return accountDAO.autoID();
    }
    
}
