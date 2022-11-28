/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DecentralizationDetail_DAO;
import DTO.DecentralizationDetail;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DecentralizationDetail_BUS {
    
    private DecentralizationDetail_DAO decentralizeDetailDAO;
    
    public DecentralizationDetail_BUS() {
        decentralizeDetailDAO = new DecentralizationDetail_DAO();
    }
    
    public DecentralizationDetail readById(String id){
        return decentralizeDetailDAO.readById(id);
    }
    
    public String getNameById(String id){
        return decentralizeDetailDAO.getNameById(id);
    }
    
    public boolean update(DecentralizationDetail dcdt){
        if(decentralizeDetailDAO.update(dcdt)) return true;
        else return false;
    }
    
    public boolean create(DecentralizationDetail dcdt){
        if(decentralizeDetailDAO.create(dcdt)) return true;
        else return false;
    }
    
    public boolean delete(String id) {
        if(decentralizeDetailDAO.delete(id)) return true;
        return false;
    }
}
