/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Product_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DLCH
 */
public class Product_DAO extends connectDB {
    
    public ArrayList<Product_DTO> loadDataProduct() {
        ArrayList<Product_DTO> listProduct = new ArrayList<Product_DTO>();
        try {
            String sql = "SELECT * FROM product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Product_DTO product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getString("BusinessStatus"));
                listProduct.add(product);
            }
        }
        catch (Exception e) {
            System.out.println("Error occured at loadDataProduct method from Product_DAO class.");
            System.out.println(e);
        }
        return listProduct;
    }
    
    public boolean insertProduct (Product_DTO product) {
        try {
            String sql = "INSERT INTO product (Product_ID, Size, Product_Name, Quantity, UnitPrice, Category_ID, Image, BusinessStatus)" +
                    "VALUES ('"+product.getProductID()+"','"+product.getSize()+"','"+product.getProductName()+"',"+product.getQuantity()+","+product.getPrice()+",'"+product.getCategoryID()+"','"+product.getImage()+"','"+product.getBusinessStatus()+"')";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error occured at insertProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean deleteProduct (String id) {
        try {
            String sql = "DELETE FROM product WHERE Product_ID = '" + id + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error occured at deleteProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean updateProduct (Product_DTO product) {
        try {
            String sql = "UPDATE product SET Size = '"+product.getSize()+"', Product_Name = '"+product.getProductName()+"', Quantity = "+product.getQuantity()+", UnitPrice = "+product.getPrice()+", Category_ID = '"+product.getCategoryID()+"', Image = '"+product.getImage()+"', BusinessStatus = '"+product.getBusinessStatus()+
                    "' WHERE Product_ID = '"+product.getProductID()+"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error occured at updateProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList<Product_DTO> searchProduct (String keyword, String filter) {
        ArrayList<Product_DTO> listProduct = new ArrayList<Product_DTO>();
        try {
            String searchField="";
            
            switch (filter) {
                case "ProductID":
                    searchField = "Product_ID";
                    break;
                case "SizeID":
                    searchField = "Size";
                    break;
                case "ProductName":
                    searchField = "Product_Name";
                    break;
                case "BusinessStatus":
                    searchField = "BusinessStatus";
                    break;
                case "CategoryID":
                    searchField = "Category_ID";
                    break;
                default:
                    searchField = "Category_Name";
                    break;
            }
            
            String sql = "SELECT * FROM product WHERE " + searchField + " LIKE '%" + keyword + "%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Product_DTO product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getString("BusinessStatus"));
                listProduct.add(product);
            }
        }
        catch (Exception e) {
            System.out.println("Error occured at searchProduct from Product_DAO class");
            System.out.println(e);
        }
        return listProduct;
    }
    
    public Boolean productNameExisted (String id, String name) {
        Boolean isExisted = false;
        try {
            String sql = "SELECT * FROM product WHERE Product_Name = '"+name+"' AND Product_ID NOT IN ('"+id+"')";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                if (name.equalsIgnoreCase(rs.getString("Product_Name"))) {
                    isExisted = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error occured at checkName from Product_DAO class");
            System.out.println(e);
        }
        return isExisted;
    }
}
