/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DTO;

/**
 *
 * @author Bum
 */
public class ReceivedNoteDetail {
    private String receivedNoteID;
    private String productId;
    private String size;
    private int quantity;
    private double unitPrice;
    private double price;

    public ReceivedNoteDetail() {
    }

    public ReceivedNoteDetail(String receivedNoteID, String productId, String size, int quantity, double unitPrice, double price) {
        this.receivedNoteID = receivedNoteID;
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.price = price;
    }

    public String getReceivedNoteID() {
        return receivedNoteID;
    }

    public void setReceivedNoteID(String receivedNoteID) {
        this.receivedNoteID = receivedNoteID;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



   
}
