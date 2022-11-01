/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import DTO.ReceivedNote;
import DTO.ReceivedNoteDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bum
 */
public class ReceivedNoteDetail_DAO extends connectDB {
    
    public ArrayList<ReceivedNoteDetail> LoadDetail(String id)
    {
        
        ArrayList<ReceivedNoteDetail> rndList= new ArrayList<>();
        try{
        String sql="SELECT Product_Name,received_note_detail.* FROM product, received_note_detail,received_note "
                    + "WHERE product.Product_ID=received_note_detail.Product_ID "
                    + "AND product.Size=received_note_detail.Size "
                    + "AND received_note.Received_Note_ID = received_note_detail.Received_Note_ID  "
                    + "AND received_note.Received_Note_ID = "+ id;
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            ReceivedNoteDetail rnd = new ReceivedNoteDetail();
            rnd.setProductId(rs.getString("Product_ID"));
            rnd.setProductName(rs.getString("Product_Name"));
            rnd.setSize(rs.getString("Size"));
            rnd.setQuantity(rs.getInt("Quantity"));
            rnd.setPrice(rs.getInt("Price"));
            rndList.add(rnd);
            }
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);}
        return rndList;
    }
    
    public boolean Insert(ReceivedNoteDetail rnd,String id)
    {
        try{
            String sql ="INSERT INTO `received_note_detail` (`Received_Note_ID`, `Product_ID`, `Size`, `Quantity`, `Price`)"
                    + " VALUES ('"+id+"', '"+rnd.getProductId()+"', '"+rnd.getSize()+"', '"+rnd.getQuantity()+"', '"+rnd.getPrice()+"')";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        }catch(SQLException e){Logger.getLogger(connectDB.class.getName()).log(Level.SEVERE, null, e);
                               return false;}
        return true;
    }
    
    public static void main(String[] args) {
        ReceivedNote_DAO a = new ReceivedNote_DAO();
        ArrayList<ReceivedNote> l = new ArrayList<>();
        l=a.loadData();
        ReceivedNote r = null;
        for(int i=0;i<l.size();i++)
            r = l.get(i);
        System.out.println(r.toString());
    }
}
