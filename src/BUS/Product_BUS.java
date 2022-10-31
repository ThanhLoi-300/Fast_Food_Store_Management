/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Product_DAO;
import DTO.Product_DTO;
import java.util.ArrayList;

/**
 *
 * @author DLCH
 */
public class Product_BUS {
    private Product_DAO productDAO = new Product_DAO();
    
    public ArrayList<Product_DTO> loadDataProduct() {
        return productDAO.loadDataProduct();
    }
    
    public boolean insertProduct (Product_DTO product) {
        if (productDAO.insertProduct(product)) return true;
        return false;
    }
    
    public boolean deleteProduct (String id) {
        if (productDAO.deleteProduct(id)) return true;
        return false;
    }
    
    public boolean updateProduct (Product_DTO product) {
        if (productDAO.updateProduct(product)) return true;
        return false;
    }
    
    public ArrayList<Product_DTO> searchProduct(String keyword, String filter) {
        return productDAO.searchProduct(keyword, filter);
    }
    
    public boolean productNameExisted (String id, String name) {
        return productDAO.productNameExisted(id, name);
    }
}
