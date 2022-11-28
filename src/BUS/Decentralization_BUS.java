/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.Decentralization_DAO;
import DTO.Decentralization;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Decentralization_BUS {
    
    private Decentralization_DAO decentralizeDAO;
    
    public Decentralization_BUS() {
        decentralizeDAO = new Decentralization_DAO();
    }
    
    public ArrayList<Decentralization> read(){
        return decentralizeDAO.read();
    }
    
    public ArrayList<String> readAllId(){
        return decentralizeDAO.readAllId();
    }
    
    public boolean create(Decentralization dc){
        if(decentralizeDAO.create(dc)) return true;
        else return false;
    }
    
    public boolean delete(String id){
        if(decentralizeDAO.delete(id)) return true;
        else return false;
    }
    
    public boolean update(Decentralization dc){
        if(decentralizeDAO.update(dc)) return true;
        else return false;
    }
}
