/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BillDetail_DAO;
import DTO.BillDetail;
import DTO.statisticalObject;
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
    public ArrayList<statisticalObject> countSoldProductByDay(String date){
        return bd_DAO.countSoldProductByDay(date);
    }
    public ArrayList<statisticalObject> countSoldProductByDay(String sdate,String edate){
        return bd_DAO.countSoldProductByDay(sdate,edate);
    }
    public int totalSoldProductByDay(String Date){
        return bd_DAO.totalSoldProductByDay(Date);
    }
    public ArrayList<statisticalObject> CountSoldProductByMonth(String month){
        return bd_DAO.CountSoldProductByMonth(month);
    }
}
