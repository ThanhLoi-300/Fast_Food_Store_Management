/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BillDetail_DAO;
import DTO.BillDetail;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class BillDetail_BUS {
    private BillDetail_DAO bd_DAO = new BillDetail_DAO();
    
    public ArrayList<BillDetail> LoadDetail(String id) {
        return bd_DAO.LoadDetail(id);
    }
    
    public Boolean insert(BillDetail bd) {
        return bd_DAO.insert(bd);
    }
}
