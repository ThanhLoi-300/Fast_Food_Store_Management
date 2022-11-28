/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class DecentralizationDetail {
    private String decentralizeID;
    private int isSale;
    private int isRecept;
    private int isProduct;
    private int isCategory;
    private int isBill;
    private int isDiscount;
    private int isCustomer;
    private int isStaff;
    private int isAccount;
    private int isDecentralize;
    
    public DecentralizationDetail(){}

    public DecentralizationDetail(String decentralizeID, int isSale, int isRecept, int isProduct, int isCategory, int isBill, int isDiscount, int isCustomer, int isStaff, int isAccount, int isDecentralize) {
        this.decentralizeID = decentralizeID;
        this.isSale = isSale;
        this.isRecept = isRecept;
        this.isProduct = isProduct;
        this.isCategory = isCategory;
        this.isBill = isBill;
        this.isDiscount = isDiscount;
        this.isCustomer = isCustomer;
        this.isStaff = isStaff;
        this.isAccount = isAccount;
        this.isDecentralize = isDecentralize;
    }

    public String getDecentralizeID() {
        return decentralizeID;
    }

    public int getIsSale() {
        return isSale;
    }

    public int getIsRecept() {
        return isRecept;
    }

    public int getIsProduct() {
        return isProduct;
    }

    public int getIsCategory() {
        return isCategory;
    }

    public int getIsBill() {
        return isBill;
    }

    public int getIsDiscount() {
        return isDiscount;
    }

    public int getIsCustomer() {
        return isCustomer;
    }

    public int getIsStaff() {
        return isStaff;
    }

    public int getIsAccount() {
        return isAccount;
    }

    public void setDecentralizeID(String decentralizeID) {
        this.decentralizeID = decentralizeID;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public void setIsRecept(int isRecept) {
        this.isRecept = isRecept;
    }

    public void setIsProduct(int isProduct) {
        this.isProduct = isProduct;
    }

    public void setIsCategory(int isCategory) {
        this.isCategory = isCategory;
    }

    public void setIsBill(int isBill) {
        this.isBill = isBill;
    }

    public void setIsDiscount(int isDiscount) {
        this.isDiscount = isDiscount;
    }

    public void setIsCustomer(int isCustomer) {
        this.isCustomer = isCustomer;
    }

    public void setIsStaff(int isStaff) {
        this.isStaff = isStaff;
    }

    public void setIsAccount(int isAccount) {
        this.isAccount = isAccount;
    }

    public int getIsDecentralize() {
        return isDecentralize;
    }

    public void setIsDecentralize(int isDecentralize) {
        this.isDecentralize = isDecentralize;
    }

    @Override
    public String toString() {
        return "DecentralizationDetail{" + "decentralizeID=" + decentralizeID + ", isSale=" + isSale + ", isRecept=" + isRecept + ", isProduct=" + isProduct + ", isCategory=" + isCategory + ", isBill=" + isBill + ", isDiscount=" + isDiscount + ", isCustomer=" + isCustomer + ", isStaff=" + isStaff + ", isAccount=" + isAccount + ", isDecentralize=" + isDecentralize + '}';
    }
    
}
