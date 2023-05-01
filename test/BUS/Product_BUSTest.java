
package BUS;

import DTO.Product_DTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;

public class Product_BUSTest {
    
    Product_BUS product_Bus = new Product_BUS();

    @Test
    public void testLoadDataProduct() {
        ArrayList<Product_DTO> result = product_Bus.loadDataProduct();
        assertNotEquals(0, result.size());
    }

    @Test
    public void testIncQuantity() {
        String productID = "P01";
        String size = "5oz";
        int quantity = 1;
        boolean expResult = true;
        boolean result = product_Bus.incQuantity(productID, size, quantity);
        assertEquals(expResult, result);
    }

    @Test
    public void testDecQuantity() {
        String productID = "P01";
        String size = "4oz";
        int quantity = 1;
        boolean expResult = true;
        boolean result = product_Bus.decQuantity(productID, size, quantity);
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchProduct() {
        String keyword = "cơm";
        String filter = "ProductName";
        int expResult = 0;
        ArrayList<Product_DTO> result = product_Bus.searchProduct(keyword, filter);
        assertNotEquals(expResult, result.size());
    }

    @Test
    public void testReadProductByCategoryName() {
        String categoryName = "Thịt gà";
        int expResult = 0;
        ArrayList<Product_DTO> result = product_Bus.readProductByCategoryName(categoryName);
        assertNotEquals(expResult, result.size());
    }


    @Test
    public void testProductNameExisted() {
        String id = "P03";
        String name = "Cơm gà";
        boolean expResult = false;
        boolean result = product_Bus.productNameExisted(id, name);
        assertEquals(expResult, result);
    }

    @Test
    public void testAutoID() {
        String expResult = "P06";
        String result = product_Bus.autoID();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNameById() {
        String id = "P02";
        String expResult = "Gà nướng muối ớt";
        String result = product_Bus.getNameById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUnitPriceByID_Size() {
        String id = "P02";
        String size = "1 con";
        double expResult = 130000.0;
        double result = product_Bus.getUnitPriceByID_Size(id, size);
        assertEquals(expResult, result, 0.0);
    }
}
