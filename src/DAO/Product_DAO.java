/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Product_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DLCH
 */
public class Product_DAO extends connectDB {

    public ArrayList<Product_DTO> loadDataProduct() {
        ArrayList<Product_DTO> listProduct = new ArrayList<Product_DTO>();
        try {
            String sql = "SELECT * FROM product WHERE IsDeleted <> 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product_DTO product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getBoolean("IsDeleted"), rs.getBoolean("BusinessStatus"));
                listProduct.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error occured at loadDataProduct method from Product_DAO class.");
            System.out.println(e);
        }
        return listProduct;
    }

    public boolean insertProduct(Product_DTO product) {
        try {
            String sql = "INSERT INTO product (Product_ID, Size, Product_Name, Quantity, UnitPrice, Category_ID, Image, IsDeleted, BusinessStatus)"
                    + "VALUES ('" + product.getProductID() + "','" + product.getSize() + "','" + product.getProductName() + "'," + product.getQuantity() + "," + product.getPrice() + ",'" + product.getCategoryID() + "','" + product.getImage() + "'," + 0 + "," + 1 + ")";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error occured at insertProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean deleteProduct(String id, String size) {
        try {
            String sql = "UPDATE product SET IsDeleted = 1 WHERE Product_ID = '" + id + "' AND Size = '" + size + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error occured at deleteProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean updateProduct(Product_DTO product) {
        try {
            String sql = "UPDATE product SET Size = '" + product.getSize() + "', Product_Name = '" + product.getProductName() + "', Quantity = " + product.getQuantity() + ", UnitPrice = " + product.getPrice() + ", Category_ID = '" + product.getCategoryID() + "', Image = '" + product.getImage() + "'" + ",BusinessStatus = " + product.isBusinessStatus()
                    + " WHERE Product_ID = '" + product.getProductID() + "'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error occured at updateProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }

    public ArrayList<Product_DTO> searchProduct(String keyword, String filter) {
        ArrayList<Product_DTO> listProduct = new ArrayList<Product_DTO>();
        try {
            String searchField = "";

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
                case "CategoryID":
                    searchField = "Category_ID";
                    break;
                default:
                    searchField = "Category_Name";
                    break;
            }

            String sql = "SELECT * FROM product WHERE " + searchField + " LIKE '%" + keyword + "%' AND IsDeleted = 0";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Product_DTO product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getBoolean("IsDeleted"), rs.getBoolean("BusinessStatus"));
                listProduct.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error occured at searchProduct from Product_DAO class");
            System.out.println(e);
        }
        return listProduct;
    }

    public Boolean productNameExisted(String id, String name) {
        Boolean isExisted = false;
        try {
            String sql = "SELECT * FROM product WHERE Product_Name = '" + name + "' AND Product_ID NOT IN ('" + id + "') AND IsDeleted <> 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (name.equalsIgnoreCase(rs.getString("Product_Name"))) {
                    isExisted = true;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occured at productNameExisted from Product_DAO class");
            System.out.println(e);
        }
        return isExisted;
    }
    
    public boolean productDeletedPreviously(String id, String size) {
        boolean isDeleted = false;
        try {
            String sql = "SELECT * FROM product WHERE Product_ID = '"+id+"' AND Size = '"+size+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                if (rs.getBoolean("IsDeleted")) {
                    return true;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Error occured at productDeletedPreviously from Product_DAO class");
            System.out.println(e);
        }
        return isDeleted;
    }
    
    public boolean restoreProduct(String id, String size, int price, int quantity) {
        try {
            String sql = "UPDATE product SET IsDeleted = 0, UnitPrice = "+price+" , Quantity = "+quantity+" WHERE Product_ID = '"+id+"' AND Size = '"+size+"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error occured at restoreProduct from Product_DAO class");
            System.out.println(e);
            return false;
        }
        return true;
    }

    public String autoID() {
        String id = "P0";
        int counter = 1;
        try {
            String sql = "SELECT COUNT(DISTINCT Product_ID) FROM product";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                counter += rs.getInt("COUNT(DISTINCT Product_ID)");
            }

        } catch (SQLException ex) {
            System.out.println("Error occured at autoID from Product_DAO class");
            System.out.println(ex);
        }
        return id + counter;
    }
}
