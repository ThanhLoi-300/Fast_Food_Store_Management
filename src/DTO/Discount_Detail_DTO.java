
package DTO;

public class Discount_Detail_DTO {
    String discount_Id, product_Id;

    public Discount_Detail_DTO(String discount_Id, String product_Id) {
        this.discount_Id = discount_Id;
        this.product_Id = product_Id;
    }

    public String getDiscount_Id() {
        return discount_Id;
    }

    public void setDiscount_Id(String discount_Id) {
        this.discount_Id = discount_Id;
    }

    public String getProduct_Id() {
        return product_Id;
    }

    public void setProduct_Id(String product_Id) {
        this.product_Id = product_Id;
    }
    
}
