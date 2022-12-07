/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.ReceivedNoteDetail_DAO;
import DTO.ReceivedNoteDetail;
import DTO.statisticalObject;
import java.util.ArrayList;

/**
 *
 * @author Bum
 */
public class ReceivedNoteDetail_BUS {

    private ReceivedNoteDetail_DAO rn_DAO = new ReceivedNoteDetail_DAO();

    public ArrayList<ReceivedNoteDetail> load_Data(String id) {
        return rn_DAO.LoadDetail(id);
    }

    public ArrayList<statisticalObject> countReceivedProductByDay(String date) {
        return rn_DAO.countReceivedProductByDay(date);
    }
    public ArrayList<statisticalObject> countReceivedProductByDay(String sdate,String edate) {
        return rn_DAO.countReceivedProductByDay(sdate,edate);
    }

    public int totalReceivedProductByDay(String Date) {
        return rn_DAO.totalReceivedProductByDay(Date);
    }

    //Phat
    public boolean insert(ReceivedNoteDetail rnd) {
        return rn_DAO.insert(rnd);
    }
     public ArrayList<statisticalObject> CountReceivedProductByMonth(String month){
         return rn_DAO.CountReceivedProductByMonth(month);
     }
    
}
