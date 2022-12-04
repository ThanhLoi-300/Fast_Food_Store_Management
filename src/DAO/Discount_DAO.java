package DAO;

import DTO.Discount_DTO;
import DTO.Discount_Detail_DTO;
import DTO.Product_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Discount_DAO {
    private connectDB cB = new connectDB();
    
    public boolean insert_Discount(Discount_DTO discount_DTO){
        String sql = "INSERT INTO discount (discount_Id, discount_Percent, start_Time, end_Time, status, isDeleted)"
                + "VALUES( '"+ discount_DTO.getDiscount_Id() +"',"+ discount_DTO.getDiscount_Percent() 
                +",'"+ discount_DTO.getStart_Time() +"','"+ discount_DTO.getEnd_Time() +"',"+ discount_DTO.getStatus() +",0)";
        
        try (Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  insert_Discount() method from DiscountDAO class!");
            System.err.println(e);
            return false;
        }
        
        return true;
    }
    
    public ArrayList<Discount_DTO> get_All_Discount(){
        String sql = "SELECT * FROM discount";
        ArrayList<Discount_DTO> list_Discount = new ArrayList<>();
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Discount_DTO discount = new Discount_DTO(rs.getString("discount_Id"), rs.getInt("discount_Percent"), rs.getInt("status"), rs.getInt("isDeleted"), rs.getString("start_Time"), rs.getString("end_Time"));
                list_Discount.add(discount);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  get_All_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return list_Discount;
    }
    
    public boolean check_Name_Discount( int percent){
        String sql = "SELECT * FROM discount WHERE discount_Percent = '"+ percent +"' AND isDeleted = 0";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            if(rs.next()) return false;      
        } catch (SQLException e) {
            System.err.println("Error at  check_Name_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return true;
    }
    
    public ArrayList<Discount_DTO> load_Discount( String search, String cbb){
        String sql = "";
        if(  search.isEmpty() && cbb.equals("Tất cả") )
            sql = "SELECT * FROM discount WHERE isDeleted = 0";
        else if(!search.isEmpty() && cbb.equals("Tất cả"))
            sql = "SELECT * FROM discount WHERE isDeleted = 0 AND discount_Percent LIKE '%"+search+"%'";
        else{
            if(cbb.equals("Đang áp dụng"))
                sql = "SELECT * FROM discount WHERE isDeleted = 0 AND discount_Percent LIKE '%"+search+"%' AND status = 1";
            else sql = "SELECT * FROM discount WHERE isDeleted = 0 AND discount_Percent LIKE '%"+search+"%' AND status = 0";
        }
            
        ArrayList<Discount_DTO> list_Discount = new ArrayList<>();
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Discount_DTO discount = new Discount_DTO(rs.getString("discount_Id"), rs.getInt("discount_Percent"), rs.getInt("status"), rs.getInt("isDeleted"), rs.getString("start_Time"), rs.getString("end_Time"));
                list_Discount.add(discount);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  load_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return list_Discount;
    }
    
    public boolean delete_Discount(String id){
        String sql = "UPDATE discount SET isDeleted = 1 WHERE discount_Id = '"+ id +"'";
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Discount() method from Discount_DAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean check_Name(int percent, String id){
        String sql = "SELECT discount_Percent FROM discount WHERE isDeleted = 0 AND discount_Percent = '"+ percent +"' AND discount_Id NOT IN ('"+ id +"')";

        try(Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql); ){
            if(rs.next()) return false;

        } catch (SQLException e) {
            System.err.println("Error at  check_Name() method from Discount_DAO class!");
            System.err.println(e);
        }
        return true;
    }
    
    public boolean update_Discount(Discount_DTO discount){
        String sql = "UPDATE discount SET discount_Percent = "+ discount.getDiscount_Percent()+", status = "+ discount.getStatus() +", "
                + "start_Time = '"+ discount.getStart_Time() +"', end_Time = '"+ discount.getEnd_Time() 
                +"' WHERE discount_Id  = '"+discount.getDiscount_Id()+"'";
        
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();                
        } catch (SQLException e) {
            System.err.println("Error at  update_Discount() method from Discount_DAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean insert_Detail_Discount(String discount_Id, String product_Id){
        String sql = "INSERT INTO discount_detail (discount_Id, product_Id)"
                + "VALUES( '"+ discount_Id +"','"+ product_Id +"')";
        
        try (Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  insert_Detail_Discount() method from DiscountDAO class!");
            System.err.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean delete_Detail_Discount(String discount_Id){
        String sql = "DELETE FROM discount_detail WHERE discount_Id = '"+ discount_Id +"'";
        
        try (Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Detail_Discount() method from DiscountDAO class!");
            System.err.println(e);
            return false;
        }
        
        return true;
    }
    
    public ArrayList<Discount_Detail_DTO> load_Detail_Discount( String discount_Id){
        ArrayList<Discount_Detail_DTO> detail_Discount = new ArrayList<>();
        String sql = "SELECT * FROM discount_Detail WHERE discount_Id = '"+ discount_Id +"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Discount_Detail_DTO discount_Detail = new Discount_Detail_DTO(rs.getString("discount_Id"), rs.getString("product_Id"));
                detail_Discount.add(discount_Detail);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  load_Detail_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return detail_Discount;
    }
    
    public Product_DTO get_Product_By_Id( String id){
        Product_DTO product;
        String sql = "SELECT * FROM product WHERE Product_ID = '"+ id +"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getBoolean("IsDeleted"), rs.getBoolean("BusinessStatus"));
                return product;
            }        
        } catch (SQLException e) {
            System.err.println("Error at  get_Product_By_Id() method from DiscountDAO class!");
            System.err.println(e);
        }
        return null;
    }
    
    public Discount_DTO get_Discount_By_Id( String id){
        Discount_DTO discount;
        String sql = "SELECT * FROM discount WHERE discount_Id = '"+ id +"'";
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                discount = new Discount_DTO(rs.getString("discount_Id"), rs.getInt("discount_Percent"), rs.getInt("status"), rs.getInt("isDeleted"), rs.getString("start_Time"), rs.getString("end_Time"));
                return discount;
            }        
        } catch (SQLException e) {
            System.err.println("Error at  get_Discount_By_Id() method from DiscountDAO class!");
            System.err.println(e);
        }
        return null;
    }
    

     
    public ArrayList<Discount_Detail_DTO> check_Discount_Id(String id){
        String sql = "SELECT * FROM discount_detail WHERE discount_Id = '"+ id +"'";
        ArrayList<Discount_Detail_DTO> list_Discount = new ArrayList<>();
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Discount_Detail_DTO discount = new Discount_Detail_DTO(rs.getString("discount_Id"), rs.getString("product_Id"));
                list_Discount.add(discount);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  get_All_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return list_Discount;
     }
    
    public ArrayList<Product_DTO> load_Product_Remaining(String search, String cbb){
        
        String sql = "";
        if(search.isEmpty() && cbb.equals("Tất cả"))
            sql = "SELECT * FROM product WHERE product_Id NOT IN ( SELECT product_Id FROM discount_detail) AND IsDeleted = 0 GROUP BY Product_Name";
        else if(!search.isEmpty() && cbb.equals("Tất cả"))
            sql = "SELECT * FROM product WHERE product_Id NOT IN ( SELECT product_Id FROM discount_detail) AND product.Product_Name LIKE N'%"+search+"%' AND IsDeleted = 0 GROUP BY Product_Name";
        else
            sql = "SELECT * FROM product, category WHERE category.Category_Id = product.Category_ID AND product_Id NOT IN ( SELECT product_Id FROM discount_detail) AND product.Product_Name LIKE N'%"+search+"%' AND category.Category_Name = '"+cbb+"' AND product.IsDeleted = 0 GROUP BY Product_Name";
        ArrayList<Product_DTO> list = new ArrayList<>();
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Product_DTO product = new Product_DTO(rs.getString("Product_ID"), rs.getString("size"), rs.getString("Product_Name"), rs.getString("Category_ID"), rs.getInt("UnitPrice"), rs.getInt("Quantity"), rs.getString("Image"), rs.getBoolean("IsDeleted"), rs.getBoolean("BusinessStatus"));
                list.add(product);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  load_Product_Remaining() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return list;
     }
    
    public int check_Product_Discount(String id){
        String sql = "SELECT dc.discount_Percent FROM discount_detail as dd, discount as dc WHERE dd.discount_Id = dc.discount_Id AND  dd.product_Id = '"+ id +"' AND dc.status = 1 AND isDeleted = 0";
        int result = -1;
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);  ){
            if(rs.next()) 
                result = rs.getInt("dc.discount_Percent");
        } catch (SQLException e) {
            System.err.println("Error at  check_Product_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        return result;
    }
    
    public ArrayList<Discount_DTO> get_Discount(){
        String sql = "SELECT * FROM discount WHERE isDeleted = 0";
        ArrayList<Discount_DTO> list_Discount = new ArrayList<>();
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            while(rs.next()) {
                Discount_DTO discount = new Discount_DTO(rs.getString("discount_Id"), rs.getInt("discount_Percent"), rs.getInt("status"), rs.getInt("isDeleted"), rs.getString("start_Time"), rs.getString("end_Time"));
                list_Discount.add(discount);
            }        
        } catch (SQLException e) {
            System.err.println("Error at  get_All_Discount() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return list_Discount;
    }
    
    public boolean Auto_Update_Discount(String id, int status){
        String sql = "UPDATE discount SET status = '"+ status+"' WHERE discount_Id  = '"+ id +"'";
        
        try(Connection conn = cB.getConnect();PreparedStatement pstm = conn.prepareStatement(sql); ){
            pstm.executeUpdate();                
        } catch (SQLException e) {
            System.err.println("Error at  update_Discount() method from Discount_DAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public int check_Discount_Percent( String id){
        String sql = "SELECT dc.discount_Percent FROM discount_detail as dd, discount as dc WHERE dd.discount_Id = dc.discount_Id  AND  dd.product_Id = '" + id + "' AND dc.status = 1 AND isDeleted = 0";
        int percent = 0;
        
        try (Connection conn = cB.getConnect();Statement stm= conn.createStatement();ResultSet rs = stm.executeQuery(sql);){
            if(rs.next()) percent = rs.getInt("dc.discount_Percent");    
        } catch (SQLException e) {
            System.err.println("Error at  check_Discount_Percent() method from DiscountDAO class!");
            System.err.println(e);
        }
        
        return percent;
    }
    
}
