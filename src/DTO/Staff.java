/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author LENOVO
 */
public class Staff {
    private String staffId;
    private String staffName;
    private int staffBirthYear;
    private String address;
    private String gender;
    private String phoneNum;
    private int baseSalary;
    private boolean isDeleted;
    
    
    public Staff(){
    }

   
    public Staff(String staffId, String staffName, int staffBirthYear, String address, String gender, String phoneNum, int baseSalary, boolean isDeleted) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffBirthYear = staffBirthYear;
        this.address = address;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.baseSalary = baseSalary;
        this.isDeleted = isDeleted;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getStaffBirthYear() {
        return staffBirthYear;
    }

    public void setStaffBirthYear(int staffBirthYear) {
        this.staffBirthYear = staffBirthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public boolean isDeleted() {
        return isDeleted;
    }

    public void isDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    

    
   
    
    
    
    
    
    
}
