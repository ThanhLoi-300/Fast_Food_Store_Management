package DAO;

import DTO.Category_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


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
    
}
