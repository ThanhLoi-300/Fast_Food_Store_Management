package BUS;

import DAO.Discount_DAO;
import DTO.Discount_DTO;
import DTO.Discount_Detail_DTO;
import DTO.Product_DTO;
import java.util.ArrayList;

public class Discount_BUS {
    Discount_DAO discount_DAO = new Discount_DAO();
    
    public boolean insert_Discount(Discount_DTO discount_DTO){
        return discount_DAO.insert_Discount(discount_DTO);
    }
    
    public int get_All_Discount(){
        return discount_DAO.get_All_Discount().size();
    }
    
    public boolean check_Name( int percent ){
        if( !discount_DAO.check_Name_Discount(percent)) return true;
        return false;
    }
    
    public ArrayList<Discount_DTO> load_Discount(String search, String cbb){
        return discount_DAO.load_Discount(search, cbb);
    }
    
    public boolean delete_Discount(String id){
        if(discount_DAO.delete_Discount(id)) return true;
        return false;
    }
    
    public boolean check_Name(int percent, String id){
        if(!discount_DAO.check_Name(percent, id)) return true;
        return false;
    }
    
    public boolean update_Discount(Discount_DTO discount){
        return discount_DAO.update_Discount(discount);
    }
    
    public boolean inser_Detail_Discount(String discount_Id, String product_Id){
        return discount_DAO.insert_Detail_Discount(discount_Id, product_Id);
    }
    
    public boolean delete_Detail_Discount(String discount_Id){
        return discount_DAO.delete_Detail_Discount(discount_Id);
    }
    
    public ArrayList<Discount_Detail_DTO> load_Detail_Discount( String discount_Id){
        return discount_DAO.load_Detail_Discount(discount_Id);
    }
    
    public Product_DTO get_Product_By_Id( String id){
        return discount_DAO.get_Product_By_Id(id);
    }
    
    public Discount_DTO get_Discount_By_Id( String id){
        return discount_DAO.get_Discount_By_Id(id);
    }
    
    public boolean check_Discount_Id(String id){
        if(discount_DAO.check_Discount_Id(id).size() == 0) return true;
        else return false;
    }
    
    public ArrayList<Product_DTO> load_Product_Remaining(String search, String cbb){
        return discount_DAO.load_Product_Remaining(search,cbb);
    }
    
    public int check_Product_Discount(String id){
        return discount_DAO.check_Product_Discount(id);
    }
    
    public ArrayList<Discount_DTO> get_Discount(){
        return discount_DAO.get_Discount();
    }
    
    public boolean Auto_Update_Discount(String id, int status){
        if(discount_DAO.Auto_Update_Discount(id,status)) return true;
        return false;
    }
    
    public int check_Discount_Percent( String id){
        return discount_DAO.check_Discount_Percent(id);
    }
}
