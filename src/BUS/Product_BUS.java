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

    // code của Thái
    public ArrayList<Product_DTO> readProductOnBusiness() {
        return productDAO.readProductOnBusiness();
    }

    public boolean insertProduct(Product_DTO product) {
        if (productDAO.insertProduct(product)) {
            return true;
        }
        return false;
    }

    public boolean deleteProduct(String id, String size) {
        if (productDAO.deleteProduct(id, size)) {
            return true;
        }
        return false;
    }

    public boolean updateProduct(Product_DTO product, String size) {
        if (productDAO.updateProduct(product,size)) {
            return true;
        }
        return false;
    }
    
     public boolean update_Status_Of_All_Product(Product_DTO product) {
        if (productDAO.update_Status_Of_All_Product(product)) {
            return true;
        }
        return false;
    }

    public boolean incQuantity(String productID, String size, int quantity) {
        return productDAO.incQuantity(productID, size, quantity);
    }

    public boolean decQuantity(String productID, String size, int quantity) {
        return productDAO.decQuantity(productID, size, quantity);
    }

    //code cua Thai
    public boolean updateProductQuantity(Product_DTO product, int quantity) {
        return productDAO.updateProductQuantity(product, quantity);
    }

    public ArrayList<Product_DTO> searchProduct(String keyword, String filter) {
        return productDAO.searchProduct(keyword, filter);
    }

    //code của Thái
    public ArrayList<Product_DTO> readProductByCategoryName(String categoryName) {
        return productDAO.readProductByCategoryName(categoryName);
    }

    //code của Thái
    public ArrayList<Product_DTO> readProductByName(String categoryName, String productName) {
        return productDAO.readProductByName(categoryName, productName);
    }

    //code của Thái
    public ArrayList<String> readSizeByProductID(Product_DTO product) {
        return productDAO.readSizeByProductID(product);
    }

    // code Thai
    public ArrayList<String> readProductPriceAndQuantity(String productId, String size) {
        return productDAO.readProductPriceAndQuantity(productId, size);
    }

    public boolean productNameExisted(String id, String name) {
        return productDAO.productNameExisted(id, name);
    }

    public boolean productDeletedPreviously(String id, String size) {
        return productDAO.productDeletedPreviously(id, size);
    }

    public boolean restoreProduct(String id, String size, int price, int quantity) {
        return productDAO.restoreProduct(id, size, price, quantity);
    }

    public String autoID() {
        return productDAO.autoID();
    }

    public String getNameById(String id) {
        String name = productDAO.getNameByID(id);
        if (name == null) {
            return "";
        }
        return name;
    }

    public double getUnitPriceByID_Size(String id, String size) {
        double unitPrice = productDAO.getUnitPriceByID_Size(id, size);
        return unitPrice;
    }
}
