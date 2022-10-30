
package DTO;

public class Category_DTO {

    String category_Id, category_Name, bussiness_Status;
    
    public Category_DTO(String category_Id, String category_Name, String bussiness_Status) {
        this.category_Id = category_Id;
        this.category_Name = category_Name;
        this.bussiness_Status = bussiness_Status;
    }

    public String getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(String category_Id) {
        this.category_Id = category_Id;
    }

    public String getCategory_Name() {
        return category_Name;
    }

    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    public String getBussiness_Status() {
        return bussiness_Status;
    }

    public void setBussiness_Status(String bussiness_Status) {
        this.bussiness_Status = bussiness_Status;
    } 
}
