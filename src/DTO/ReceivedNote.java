/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bum
 */
public class ReceivedNote {
    private String id;
    private String date;
    private ArrayList<ReceivedNoteDetail> detail;
    private int totalValue;
    private String supplier;
    private String staffName;

    public ReceivedNote() {
        detail = new ArrayList<ReceivedNoteDetail>();
    }

    public ReceivedNote(String id, String date, ArrayList<ReceivedNoteDetail> detail, int totalValue, String supplier, String staffName) {
        this.id = id;
        this.date = date;
        this.detail = detail;
        this.totalValue = totalValue;
        this.supplier = supplier;
        this.staffName = staffName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<ReceivedNoteDetail> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<ReceivedNoteDetail> detail) {
        this.detail = detail;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Override
    public String toString() {
        return "ReceivedNote{" + "id=" + id + ", date=" + date + ", detail=" + detail.toString() + ", totalValue=" + totalValue + ", supplier=" + supplier + ", staffName=" + staffName + '}';
    }
    
   
}
