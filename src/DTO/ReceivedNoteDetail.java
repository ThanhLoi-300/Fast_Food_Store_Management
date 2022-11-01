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
    private String productId;
    private String productName;
    private String size;
    private int quantity;
    private int price;

    public ReceivedNoteDetail() {
    }

    public ReceivedNoteDetail(String productId, String productName, String size, int quantity, int price) {
        this.productId = productId;
        this.productName=productName;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ReceivedNoteDetail{" + "productId=" + productId + ", productName=" + productName + ", size=" + size + ", quantity=" + quantity + ", price=" + price + '}';
    }
    

   
}
