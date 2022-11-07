/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author DLCH
 */
public class Product_DTO {
    String  productID, size, productName, categoryID, image;
    int quantity;
    double price;
    boolean isDeleted, businessStatus;

    public Product_DTO(String productID, String size, String productName, String categoryID, double price, int quantity, String image, boolean isDeleted, boolean businessStatus) {
        this.productID = productID;
        this.size = size;
        this.productName = productName;
        this.categoryID = categoryID;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.isDeleted = isDeleted;
        this.businessStatus = businessStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }
    
    public String getBusinessStatus() {
        if (isBusinessStatus()) return "On";
        else return "Off";
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(boolean businessStatus) {
        this.businessStatus = businessStatus;
    }
    
    
}
