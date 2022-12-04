/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author Bum
 */
public class BillDetail {
    private String billId;
    private String productId;
    private String Size;
    private int Quantity;
    private double totalValue; 
    private int percent;

    public BillDetail() {
    }

    public BillDetail(String billId,String productId,String Size, int Quantity, double totalValue, int perrcent) {
        this.billId=billId;
        this.productId=productId;
        this.Size = Size;
        this.Quantity = Quantity;
        this.totalValue = totalValue;
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

}