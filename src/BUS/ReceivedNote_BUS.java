/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.ReceivedNote_DAO;

import DTO.ReceivedNote;
import java.util.ArrayList;

/**
 *
 * @author Bum
 */
public class ReceivedNote_BUS {

    private ReceivedNote_DAO rn_DAO = new ReceivedNote_DAO();
    public ArrayList<ReceivedNote> load_Data(){
        return rn_DAO.loadData();
    }
}
