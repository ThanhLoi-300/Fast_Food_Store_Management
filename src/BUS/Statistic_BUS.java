/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BUS;

import DAO.Statistic_DAO;
import DTO.statisticalObject;
import java.util.ArrayList;

/**
 *
 * @author Bum
 */
public class Statistic_BUS {
    private final Statistic_DAO s_DAO = new Statistic_DAO();
    public ArrayList<statisticalObject> countPurchaseTimeByDay(String date)
        {
           return s_DAO.countPurchaseTimeByDay(date);
        }
        public ArrayList<statisticalObject> countSoldProductByDay(String date)
        { 
            return s_DAO.countSoldProductByDay(date);
        }
        public ArrayList<statisticalObject> countReceivedProductByDay(String date)
        {
            return s_DAO.countReceivedProductByDay(date);
        }
        public int getPayValueByDay(String date){
            return s_DAO.getPayValueByDay(date);
        }
        public int getEarnedValueByDay(String date){
           
            return s_DAO.getEarnedValueByDay(date);
        }
        public int countBillByDay(String date,boolean choice){
            return s_DAO.countBillByDay(date, choice);
        }
        public int countCustomerByDay(String date){
            return s_DAO.countCustomerByDay(date);
        }
     public static void main(String[] args) {
        ArrayList<statisticalObject> soL = new ArrayList();
        Statistic_BUS s_BUS = new Statistic_BUS();
        String date = "2022-11-06";
        soL=s_BUS.countPurchaseTimeByDay(date);
        for (statisticalObject soL1 : soL) {
            System.out.println(soL1.getName());
        }
    }
}
   

