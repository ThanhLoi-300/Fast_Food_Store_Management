/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.ReceivedNote_DAO;

import DTO.ReceivedNote;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Bum
 */
public class ReceivedNote_BUS {

    private ReceivedNote_DAO rn_DAO = new ReceivedNote_DAO();
    public ArrayList<ReceivedNote> load_Data(){
        return rn_DAO.loadData();
    }
    public double getPaidValueByDate(String date){
         return rn_DAO.getPaidValueByDate(date);
     }
    public int countRNByDay(String date){
         return rn_DAO.countRNByDay(date);
     }
    
    //Phat
    public String autoID() {
        return rn_DAO.autoID();
    }
    
    public boolean insert(ReceivedNote rn) {
        return rn_DAO.insert(rn);
    }
    public double[] SumPaidValuePerMonth(String year){
        double[] arr = new double[12];
        Arrays.fill(arr, 0);
        arr=rn_DAO.SumPaidValuePerMonth(arr, year);
        return arr;
    }
}
