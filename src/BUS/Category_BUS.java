package BUS;

import DAO.Category_DAO;
import DTO.Category_DTO;
import java.util.ArrayList;

public class Category_BUS {
    
    private Category_DAO category_DAO = new Category_DAO();
    
    public ArrayList<Category_DTO> load_Data_Category(){
        return category_DAO.load_Data_Category();
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
    
    public boolean check_Id(String id){
        if( !category_DAO.check_Id(id).equals(id)) return true;
        return false;
    }

}
