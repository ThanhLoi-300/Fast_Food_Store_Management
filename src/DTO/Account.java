/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class Account {
    private String accountId;
    private String username;
    private String password;
    private String userType;
    private String staffId;
    private boolean isDeleted;

    public Account(String accountId, String username, String password, String userType, String staffId, boolean isDeleted) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.staffId = staffId;
        this.isDeleted = isDeleted;
    }
    
    public Account() {
    }

    public boolean IsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

     
    public String getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    
    
}
