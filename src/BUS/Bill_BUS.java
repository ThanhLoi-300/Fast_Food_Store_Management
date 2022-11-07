/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.Bill_DAO;
import DTO.Bill;
import java.util.ArrayList;

/**
 *
 * @author Bum
 */
public class Bill_BUS {

    private Bill_DAO b_DAO = new Bill_DAO();
    
    public ArrayList<Bill>LoadData(){
        return b_DAO.LoadData();
    }
    
    public String countGenerateId() {
        return b_DAO.countGenerateId();
    }
    
    public Boolean Insert(Bill b){
        return b_DAO.insert(b);
    }
}
