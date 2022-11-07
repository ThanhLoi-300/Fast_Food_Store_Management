/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Bum
 */

public class Bill {
    private String bill_ID;
    private LocalDateTime date;
    private double totalValue;
    private double receivedMoney;
    private double excessMoney;
    private String staffID;
    private String CustomerID;

    public Bill() {
    }

    public Bill(String bill_ID, LocalDateTime date, double totalValue, double receivedMoney, double excessMoney, String staffID, String CustomerID) {
        this.bill_ID = bill_ID;
        this.date = date;
        this.totalValue = totalValue;
        this.receivedMoney = receivedMoney;
        this.excessMoney = excessMoney;
        this.staffID = staffID;
        this.CustomerID = CustomerID;
    }

    

    public String getBill_ID() {
        return bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        this.bill_ID = bill_ID;
    }


    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(double receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public double getExcessMoney() {
        return excessMoney;
    }

    public void setExcessMoney(double excessMoney) {
        this.excessMoney = excessMoney;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return date.format(formatter);
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = LocalDateTime.parse(date, formatter);
    }


}
