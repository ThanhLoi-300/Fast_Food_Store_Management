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
public class ReceivedNote {
    private String receivedNoteID;
    private LocalDateTime date;
    private double totalValue;
    private double taxValue;
    private double finalValue;
    private String supplier;
    private String staffId;

    public ReceivedNote() {
        
    }
    
    public ReceivedNote(String receivedNoteID, LocalDateTime date, double totalValue, double taxValue, double finalValue, String supplier, String staffId) {
        this.receivedNoteID = receivedNoteID;
        this.date = date;
        this.totalValue = totalValue;
        this.taxValue = taxValue;
        this.finalValue = finalValue;
        this.supplier = supplier;
        this.staffId = staffId;
    }

    
    
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.date = LocalDateTime.parse(date, formatter);
    }

    public String getReceivedNoteID() {
        return receivedNoteID;
    }

    public void setReceivedNoteID(String receivedNoteID) {
        this.receivedNoteID = receivedNoteID;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(double taxValue) {
        this.taxValue = taxValue;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }


   
}
