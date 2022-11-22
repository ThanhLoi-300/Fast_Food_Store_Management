
package DTO;

import java.util.Date;

public class Discount_DTO {
    private String discount_Id;
    private int discount_Percent, status, isDelete;
    String start_Time, end_Time;

    public Discount_DTO(String discount_Id, int discount_Percent, int status, int isDelete, String start_Time, String end_Time) {
        this.discount_Id = discount_Id;
        this.discount_Percent = discount_Percent;
        this.status = status;
        this.isDelete = isDelete;
        this.start_Time = start_Time;
        this.end_Time = end_Time;
    }

    public String getDiscount_Id() {
        return discount_Id;
    }

    public void setDiscount_Id(String discount_Id) {
        this.discount_Id = discount_Id;
    }

    public int getDiscount_Percent() {
        return discount_Percent;
    }

    public void setDiscount_Percent(int discount_Percent) {
        this.discount_Percent = discount_Percent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getStart_Time() {
        return start_Time;
    }

    public void setStart_Time(String start_Time) {
        this.start_Time = start_Time;
    }

    public String getEnd_Time() {
        return end_Time;
    }

    public void setEnd_Time(String end_Time) {
        this.end_Time = end_Time;
    }

    
}
