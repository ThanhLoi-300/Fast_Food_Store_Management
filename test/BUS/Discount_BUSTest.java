
package BUS;

import DTO.Discount_DTO;
import DTO.Discount_Detail_DTO;
import DTO.Product_DTO;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Discount_BUSTest {
    
    Discount_BUS discount_Bus = new Discount_BUS();

    @Test
    public void testGet_All_Discount() {
        int expResult = 0;
        int result = discount_Bus.get_All_Discount();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testCheck_Name_int() {
        int percent = 10;
        boolean expResult = true;
        boolean result = discount_Bus.check_Name(percent);
        assertEquals(expResult, result);
    }

    @Test
    public void testLoad_Discount() {
        String search = "10";
        String cbb = "Tất cả";
        int expResult = 0;
        ArrayList<Discount_DTO> result = discount_Bus.load_Discount(search, cbb);
        assertNotEquals(expResult, result);
    }

    @Test
    public void testAuto_Update_Discount() {
        String id = "KM0";
        int status = 1;
        boolean expResult = true;
        boolean result = discount_Bus.Auto_Update_Discount(id, status);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheck_Discount_Percent() {
        String id = "P01";
        int expResult = 10;
        int result = discount_Bus.check_Discount_Percent(id);
        assertEquals(expResult, result);
    }
    
}
