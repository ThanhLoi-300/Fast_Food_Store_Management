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
    private ArrayList<BillDetail> billDetail;
    private int totalAmount;
    private double totalValue;
    private double receivedMoney;
    private double excessMoney;
    private String staffName;
    private String CustomerName;

    public Bill() {
    }

    public Bill(String bill_ID, LocalDateTime date, ArrayList<BillDetail> billDetail, int totalAmount, double totalValue, double receivedMoney, double excessMoney, String staffName, String CustomerName) {
        this.bill_ID = bill_ID;
        this.date = date;
        this.billDetail = billDetail;
        this.totalAmount = totalAmount;
        this.totalValue = totalValue;
        this.receivedMoney = receivedMoney;
        this.excessMoney = excessMoney;
        this.staffName = staffName;
        this.CustomerName = CustomerName;
    }

    

    public String getBill_ID() {
        return bill_ID;
    }

    public void setBill_ID(String bill_ID) {
        this.bill_ID = bill_ID;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return date.format(formatter);
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = LocalDateTime.parse(date, formatter);
    }

    public ArrayList<BillDetail> getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(ArrayList<BillDetail> billDetail) {
        this.billDetail = billDetail;
    }
    
}
