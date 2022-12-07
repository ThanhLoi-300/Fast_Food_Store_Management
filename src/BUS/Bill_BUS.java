/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.Bill_DAO;
import DTO.Bill;
import DTO.statisticalObject;
import java.util.ArrayList;
import java.util.Arrays;

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
    public double getEarnedValueByDate(String date){
        return b_DAO.getEarnedValueByDate(date);
    }
    public int totalCustomerByDay(String date){
        return b_DAO.totalCustomerByDay(date);
    }
    public int countBillByDay(String date){
        return b_DAO.countBillByDay(date);
    }
    public ArrayList<statisticalObject> countCustomerByDay(String date){
        return b_DAO.countCustomerByDay(date);
    }
    public ArrayList<statisticalObject> countCustomerByDay(String sdate,String edate){
        return b_DAO.countCustomerByDay(sdate,edate);
    }
    public double[] SumEarnedValuePerMonth(String year){
        double[] arr = new double[12];
        Arrays.fill(arr, 0);
        arr=b_DAO.SumEarnedValuePerMonth(arr, year);
        return arr;
    }
    public ArrayList<statisticalObject> countCustomerByMonth(String month){
        return b_DAO.countCustomerByMonth(month);
    }
}
