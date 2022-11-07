/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADMIN
 */
public class Customer {
    private String customerId;
    private String customerName;
    private int customerBirthYear;
    private String phoneNum;
    private int purchaseTimes;

    public Customer() {
    }

    public Customer(String customerId, String customerName, int customerBirthYear, String phoneNum, int purchaseTimes) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthYear = customerBirthYear;
        this.phoneNum = phoneNum;
        this.purchaseTimes = purchaseTimes;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getCustomerBirthYear() {
        return customerBirthYear;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }

    public int getPurchaseTimes() {
        return purchaseTimes;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerBirthYear(int customerBirthYear) {     
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date = LocalDate.parse(customerBirthYear, formatter);
//        this.customerBirthYear = date.format(DateTimeFormatter.ofPattern("yyyy"));
        this.customerBirthYear = customerBirthYear;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPurchaseTimes(int purchaseTimes) {
        this.purchaseTimes = purchaseTimes;
    }
    
}
