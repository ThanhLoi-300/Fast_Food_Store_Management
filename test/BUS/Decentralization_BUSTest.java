
package BUS;

import DTO.Decentralization;
import DTO.DecentralizationDetail;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Decentralization_BUSTest {
    
    Decentralization_BUS role = new Decentralization_BUS();
    
    @Test
    public void testRead() {
        ArrayList<Decentralization> expResult = null;
        ArrayList<Decentralization> result = role.read();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testReadAllId() {
        ArrayList<String> expResult = null;
        ArrayList<String> result = role.readAllId();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testCheck_Decentralization_Exist() {
        String name = "manager";
        String id = "DC02";
        String s = "update";
        boolean expResult = false;
        boolean result = role.check_Decentralization_Exist(name, id, s);
        assertEquals(expResult, result);
    }

    @Test
    public void testGet_Decentralize_By_Name() {
        String name = "manager";
        DecentralizationDetail expResult = null;
        DecentralizationDetail result = role.get_Decentralize_By_Name(name);
        assertNotEquals(expResult, result);
    }
    
    @Test
    public void testUpdate() {
        Decentralization dc = new Decentralization();
        dc.setDecentralizeID("DC01");
        dc.setDecentralizeName("manager");
        boolean expResult = true;
        boolean result = role.update(dc);
        assertEquals(expResult, result);
    }
    
}
