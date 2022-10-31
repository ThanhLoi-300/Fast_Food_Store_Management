package DAO;

import DTO.Category_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Category_DAO extends connectDB{
    
    //Lấy dữ liệu database
    public ArrayList<Category_DTO> load_Data_Category(){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        try {
            //Lệnh truy vấn
            String sql = "SELECT * FROM category";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);// Gán data vừa truy vấn được vào rs
            //Duyệt rs để lấy data
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
        try {
            //Lệnh truy vấn
            String sql = "INSERT INTO category (Category_ID, Category_Name, Business_Status) "
                            + "VALUES ('" + category.getCategory_Id() +"','" + category.getCategory_Name() +"','" + category.getBussiness_Status() +"')";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
                
        } catch (SQLException e) {
            System.err.println("Error at  insert_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean update_Category(Category_DTO category){
        try{
            //Lệnh truy vấn
            String sql = "UPDATE category SET Category_Name = '"+ category.getCategory_Name() +"', Business_Status='"+
                        category.getBussiness_Status() +"' WHERE Category_ID = '"+ category.getCategory_Id()+"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();                
        } catch (SQLException e) {
            System.err.println("Error at  update_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean delete_Category(String id){
        try{
            //Lệnh truy vấn
            String sql = "DELETE FROM category WHERE Category_ID = '"+ id +"'";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();               
        } catch (SQLException e) {
            System.err.println("Error at  delete_Category() method from CategoryDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList<Category_DTO> search_Category( String keyword){
        ArrayList<Category_DTO> list_Category = new ArrayList<Category_DTO>();
        //Check kết nối
        try{
            //Lệnh truy vấn
            String sql = "SELECT * FROM category WHERE Category_Name LIKE '%"+ keyword +"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);// Gán data vừa truy vấn được vào rs
            //Duyệt rs để lấy data
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
        try{
            //Lệnh truy vấn
            String sql = "SELECT * FROM category WHERE Category_Name = '"+ name +"' AND Category_ID NOT IN ('"+ id +"')";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);// Gán data vừa truy vấn được vào rs
            //Duyệt rs để lấy data
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
    
    public String check_Id(String id){
        String category_Id="";
        try{
            //Lệnh truy vấn
            String sql = "SELECT * FROM category WHERE Category_ID = '"+ id +"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);// Gán data vừa truy vấn được vào rs
            //Duyệt rs để lấy data
            while(rs.next()) {
                Category_DTO category = new Category_DTO(rs.getString("Category_ID"), rs.getString("Category_Name"), rs.getString("Business_Status"));
                category_Id = category.getCategory_Id();
            }

        } catch (SQLException e) {
            System.err.println("Error at  check_Name() method from CategoryDAO class!");
            System.err.println(e);
        }
        return category_Id;
    }
    
}
