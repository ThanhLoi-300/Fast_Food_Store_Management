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
    private String productId;
    private String productName;
    private String Size;
    private int unitPrice;
    private int Amount;
    private double totalValue; 

    public BillDetail() {
    }

    public BillDetail(String productId,String productName, String Size, int Amount, double totalValue) {
        this.productId=productId;
        this.productName = productName;
        this.Size = Size;
        this.Amount = Amount;
        this.totalValue = totalValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
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

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
