package DAO;

import DTO.Bill;
import DTO.BillDetail;
import DTO.Category_DTO;
import DTO.Product_DTO;
import DTO.ReceivedNote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Category_DAO{
    private connectDB cB = new connectDB();

    public ArrayList<Category_DTO> load_Data_Category(){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        String sql = "SELECT * FROM category where IsDeleted = 0";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                list_Category.add(category);
            }

        } catch (SQLException e) {
            System.err.println("Error at  load_Data_Category() method from CategoryDAO class!");
            System.err.println(e);
        }
        return list_Category;
    }
    
    //code của Thái
    public ArrayList<Category_DTO> load_Data_CategoryOnBusiness(){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        String sql = "SELECT * FROM `category` WHERE Business_Status = 'On' AND IsDeleted = 0";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                list_Category.add(category);
            }

        } catch (SQLException e) {
            System.err.println("Error at  load_Data_Category() method from CategoryDAO class!");
            System.err.println(e);
        }
        return list_Category;
    }
    
    public boolean insert_Category(Category_DTO category){
        String sql = "INSERT INTO category (Category_ID, Category_Name, Business_Status,IsDeleted) "
                   + "VALUES ('" + category.getCategory_Id() +"','" + category.getCategory_Name() +"','" + category.getBussiness_Status() +"',0)";
        try (Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  insert_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean update_Category(Category_DTO category){
        String sql = "UPDATE category SET Category_Name = '"+ category.getCategory_Name() +"', Business_Status='"+
                        category.getBussiness_Status() +"' WHERE Category_ID = '"+ category.getCategory_Id()+"'";
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();                
        } catch (SQLException e) {
            System.err.println("Error at  update_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean delete_Category(String id){
        String sql = "UPDATE category SET IsDeleted = 1 WHERE Category_ID = '"+ id +"'";
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList<Category_DTO> search_Category( String keyword){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        String sql = "SELECT * FROM category WHERE Category_Name LIKE '%"+ keyword +"%'AND IsDeleted = 0";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                list_Category.add(category);
            }

        } catch (SQLException e) {
            System.err.println("Error at  load_Data_Category() method from CategoryDAO class!");
            System.err.println(e);
        }
        return list_Category;
    }
    
    public String check_Name(String id, String name){
        String category_name="";
        String sql = "SELECT * FROM category WHERE Category_Name = '"+ name +"' AND Category_ID NOT IN ('"+ id +"') AND IsDeleted = 0";
        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                category_name = category.getCategory_Name();
            }

        } catch (SQLException e) {
            System.err.println("Error at  check_Name() method from CategoryDAO class!");
            System.err.println(e);
        }
        return category_name;
    }
    
    public ArrayList<Category_DTO> get_All_Category(){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        String sql = "SELECT * FROM category";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                list_Category.add(category);
            }

        } catch (SQLException e) {
            System.err.println("Error at  load_Data_Category() method from CategoryDAO class!");
            System.err.println(e);
        }
        return list_Category;
    }
    
    public Bill get_Bill_From_Id(String id){
        String sql = "SELECT * FROM bill WHERE Bill_ID = '"+ id +"'";
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()){
                Bill b = new Bill();
                b.setBill_ID(rs.getString("Bill_ID"));
                b.setDate(rs.getString("Date"));
                b.setTotalValue(rs.getInt("TotalValue"));
                b.setReceivedMoney(rs.getDouble("ReceivedMoney"));
                b.setExcessMoney(rs.getDouble("ExcessMoney"));
                b.setStaffID(rs.getString("Staff_id"));
                b.setCustomerID(rs.getString("Customer_id"));
                return b;
            }

        } catch (SQLException e) {
            System.err.println("Error at  get_Bill_From_Id() method from CategoryDAO class!");
            System.err.println(e);
        }
        return null;
    }
    
    public String get_Staff_Name_From_Id(String id){
        String sql = "SELECT * FROM staff WHERE Staff_id  = '"+ id +"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()){
                return rs.getString("Full_Name");
            }

        } catch (SQLException e) {
            System.err.println("Error at  get_Bill_From_Id() method from CategoryDAO class!");
            System.err.println(e);
        }
        return null;
    }
    
    public String get_Customer_Name_From_Id(String id){
        String sql = "SELECT * FROM customer WHERE Customer_id   = '"+ id +"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()){
                return rs.getString("Customer_name");
            }

        } catch (SQLException e) {
            System.err.println("Error at  get_Bill_From_Id() method from CategoryDAO class!");
            System.err.println(e);
        }
        return null;
    }
    
    public Product_DTO get_Product_In_Detail_Bill(String id, String size){
        String sql = "SELECT * FROM product WHERE Product_ID = '"+ id +"' AND Size = '"+ size +"' AND IsDeleted <> 1";

        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()){
              return new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getBoolean("IsDeleted"), rs.getBoolean("BusinessStatus"));  
            }

        } catch (SQLException e) {
            System.err.println("Error at  get_Bill_From_Id() method from CategoryDAO class!");
            System.err.println(e);
        }
        return null;
    }
    
    public int count_Product_Belong_Category( String id){
        String sql = "SELECT COUNT(Category_ID) as count FROM product WHERE IsDeleted <> 1 AND Category_ID ='"+id+"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()){
               return rs.getInt("count");
            }

        } catch (SQLException e) {
            System.err.println("Error at  get_Bill_From_Id() method from CategoryDAO class!");
            System.err.println(e);
        }
        return 0;
    }
    
    public boolean delete_Product_From_Category(String id){
        String sql = "UPDATE product SET IsDeleted = 1 WHERE Category_ID = '"+ id +"'";
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Product_From_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    public boolean update_Status_Category_And_Product(String id, int status){
        String sql = "";
        if(status == 1)
            sql = "UPDATE product SET BusinessStatus = 1 WHERE Category_ID = '"+ id +"'";
        else sql = "UPDATE product SET BusinessStatus = 0 WHERE Category_ID = '"+ id +"'";
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Product_From_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList<Bill> search_Bill(String start, String end){
             String sql = "";
             if(start.equals(end))
                sql = "SELECT * FROM bill WHERE DATE(Date) = '"+start+"'";
             else sql = "SELECT * FROM bill WHERE DATE(Date) >= '"+start+"' AND DATE(Date) <= '"+end+"'";
             ArrayList<Bill> bL = new ArrayList<>();
             try(Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);){
                 while(rs.next()){
                     Bill b = new Bill();
                        b.setBill_ID(rs.getString("Bill_ID"));
                        b.setDate(rs.getString("Date"));
                        b.setTotalValue(rs.getInt("TotalValue"));
                        b.setReceivedMoney(rs.getDouble("ReceivedMoney"));
                        b.setExcessMoney(rs.getDouble("ExcessMoney"));
                        b.setStaffID(rs.getString("Staff_id"));
                        b.setCustomerID(rs.getString("Customer_id"));
                        bL.add(b);
                 }
             } catch (SQLException ex) {
                Logger.getLogger(Category_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return bL; 
         }
         
         public ArrayList<ReceivedNote> search_ReceivedNote(String start, String end){
             String sql = "";
             if(start.equals(end))
                sql = "SELECT * FROM received_note WHERE DATE(Date) = '"+start+"'";
             else sql = "SELECT * FROM received_note WHERE DATE(Date) >= '"+start+"' AND DATE(Date) <= '"+end+"'";
             ArrayList<ReceivedNote> rnList = new ArrayList<>();
             try(Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);){
                 while(rs.next()){
                     ReceivedNote rn = new ReceivedNote();
                    rn.setReceivedNoteID(rs.getString("Received_Note_ID"));
                    rn.setDate(rs.getString("Date"));
                    rn.setTotalValue(rs.getDouble("Total_Value"));
                    rn.setTaxValue(rs.getDouble("Tax_Value"));
                    rn.setFinalValue(rs.getDouble("Final_Value"));
                    rn.setSupplier(rs.getString("Supplier"));
                    rn.setStaffId(rs.getString("Staff_ID"));
                    rnList.add(rn);
                 }
             } catch (SQLException ex) {
                Logger.getLogger(Category_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return rnList; 
         }
         
         public ReceivedNote get_RN_From_Id(String id){
             String sql = "SELECT * FROM received_note WHERE Received_Note_ID = '"+id+"'";
             ReceivedNote rn = null;
             try(Connection conn = cB.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);){
                 while(rs.next()){
                    rn = new ReceivedNote();
                    rn.setReceivedNoteID(rs.getString("Received_Note_ID"));
                    rn.setDate(rs.getString("Date"));
                    rn.setTotalValue(rs.getDouble("Total_Value"));
                    rn.setTaxValue(rs.getDouble("Tax_Value"));
                    rn.setFinalValue(rs.getDouble("Final_Value"));
                    rn.setSupplier(rs.getString("Supplier"));
                    rn.setStaffId(rs.getString("Staff_ID"));
                 }
             } catch (SQLException ex) {
                Logger.getLogger(Category_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
             return rn; 
         }
}
