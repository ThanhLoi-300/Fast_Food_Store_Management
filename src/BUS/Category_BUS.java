package BUS;

import DAO.Category_DAO;
import DTO.Bill;
import DTO.BillDetail;
import DTO.Category_DTO;
import DTO.Product_DTO;
import DTO.ReceivedNote;
import java.util.ArrayList;

public class Category_BUS {
    
    private Category_DAO category_DAO = new Category_DAO();
    
    public ArrayList<Category_DTO> load_Data_Category(){
        return category_DAO.load_Data_Category();
    }
    
    //code của Thái
    public ArrayList<Category_DTO> load_Data_CategoryObBusiness(){
        return category_DAO.load_Data_CategoryOnBusiness();
    }
    
    public boolean insert_Category( Category_DTO category){
        if(category_DAO.insert_Category(category)) return true;
        return false;
    }
    
    public boolean update_Category( Category_DTO category){
        if(category_DAO.update_Category(category)) return true;
        return false;
    }
    
    public boolean delete_Category( String id){
        if(category_DAO.delete_Category(id)) return true;
        return false;
    }
    
    public ArrayList<Category_DTO> search_Category( String keyword){
        return category_DAO.search_Category(keyword);
    }
    
    public boolean check_Name( String id, String name){
        if( !category_DAO.check_Name(id, name).equals(name)) return true;
        return false;
    }
    
    public int get_All_Category(){
        return category_DAO.get_All_Category().size();
    }
    
    public Bill get_Bill_From_Id(String id){
        return category_DAO.get_Bill_From_Id(id);
    }
    
    public String get_Staff_Name_From_Id(String id){
        return category_DAO.get_Staff_Name_From_Id(id);
    }
    
    public String get_Customer_Name_From_Id(String id){
        return category_DAO.get_Customer_Name_From_Id(id);
    }

    public Product_DTO get_Product_In_Detail_Bill(String id, String size){
        return category_DAO.get_Product_In_Detail_Bill(id,size);
    }
    
    public int count_Product_Belong_Category( String id){
        return category_DAO.count_Product_Belong_Category(id);
    }
    
    public boolean delete_Product_From_Category(String id){
        return category_DAO.delete_Product_From_Category(id);
    }
       
    public boolean update_Status_Category_And_Product(String id, int status){
        return category_DAO.update_Status_Category_And_Product(id,status);
    }

    public ArrayList<Bill> search_Bill(String start, String end){
        return category_DAO.search_Bill(start, end);
    }
    
    public ArrayList<ReceivedNote> search_ReceivedNote(String start, String end){
        return category_DAO.search_ReceivedNote(start, end);
    }
    
    public ReceivedNote get_RN_From_Id(String id){
        return category_DAO.get_RN_From_Id(id);
    }
}
