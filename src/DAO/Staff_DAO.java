/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Staff_DAO {
    connectDB cd = new connectDB();
    
    
    public ArrayList<Staff> readStaffs() {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        String sql = "SELECT * FROM `staff` WHERE `Staff_id` <> 'A00' AND `IsDeleted` <> '1'";
        
        try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while(rs.next()) {
                Staff sf = new Staff();
                sf.setStaffId(rs.getString(1));
                sf.setStaffName(rs.getString(2));
                sf.setStaffBirthYear(rs.getInt(3));
                sf.setGender(rs.getString(4));
                sf.setAddress(rs.getString(5));
                sf.setPhoneNum(rs.getString(6));
                sf.setBaseSalary(rs.getInt(7));
                staffList.add(sf);
                
            }
            
        }
        catch(SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
    }
    
     /*public ArrayList<String> readStaffID(){
        ArrayList<String> staffIdList = new ArrayList<String>();
        String sql = "SELECT `Staff_id` FROM `staff` WHERE `Staff_id` <> 'AA00'";
        try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs =stm.executeQuery(sql);) {
            while(rs.next()) {
                staffIdList.add(rs.getString(1));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffIdList;
    } */
    
    public Boolean createStaff(Staff sf){
        int rowStaff = 0;
        String sql = "INSERT INTO `staff` (`Staff_id`, `Full_Name`, `Year_Of_Birth`, `Gender`, `HomeTown`, `Phone_Num`, `Salary`, `IsDeleted`) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = cd.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, sf.getStaffId());;
            pstm.setString(2, sf.getStaffName());
            pstm.setInt(3, sf.getStaffBirthYear());
            pstm.setString(4, sf.getGender());
            pstm.setString(5, sf.getAddress());
            pstm.setString(6, sf.getPhoneNum());
            pstm.setInt(7, sf.getBaseSalary());
            pstm.setInt(8, 0);
            rowStaff = pstm.executeUpdate();
            
        }
        catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowStaff > 0 ? true : false;
        
    }
    
    public Boolean updateStaff(Staff sf) {
        int rowStaff = 0;
        String sql = "UPDATE `staff` SET `Full_Name` = ?, `Year_Of_Birth` = ?, `Gender` = ?, `HomeTown` = ?, `Phone_Num` = ?, `Salary` = ? WHERE `Staff_id` = ?";
        try (Connection conn = cd.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, sf.getStaffName());
            pstm.setInt(2, sf.getStaffBirthYear());
            pstm.setString(3, sf.getGender());
            pstm.setString(4, sf.getAddress());
            pstm.setString(5, sf.getPhoneNum());
            pstm.setInt(6, sf.getBaseSalary());
            pstm.setString(7, sf.getStaffId());
            
            rowStaff = pstm.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowStaff > 0 ? true : false;
    }
    
    public boolean  deleteStaff(String id) {
        int rowStaff = 0;
        String sql = "UPDATE `staff` SET `IsDeleted` = '1' WHERE `Staff_id` = ?";
        try (Connection conn = cd.getConnect(); PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, id);
            rowStaff = pstm.executeUpdate();     
            }
        
        catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return rowStaff > 0 ? true : false;
    }
    
    public ArrayList<Staff> searchStaff(String wordString, String column) {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
       
        //Lựa chọn 
        try {
            String searchColumn = "";
            switch (column) {
                case "Mã nhân viên":
                    searchColumn = "Staff_id";
                    break;
                case "Tên nhân viên":
                    searchColumn = "Full_Name";
                    break;
                case "Giới tính":
                    searchColumn = "Gender";
                    break;
                
            }
            //Tìm kiếm từ trong cột đã chọn
            String sql = "SELECT * FROM staff WHERE "+ searchColumn +" LIKE '%"+ wordString +"%'";
            try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
                while(rs.next()){
                    Staff sf = new Staff(rs.getString("Staff_id"), rs.getString("Full_Name"), rs.getInt("Year_Of_Birth"), rs.getString("Gender"), rs.getString("HomTown"),  rs.getString("Phone_Num"), rs.getInt("Salary"), rs.getBoolean("IsDeleted"));
                    staffList.add(sf);

                }
            }
            catch(Exception e){
                
            }
        }
        catch (Exception e) {
            System.out.println("Đã xảy ra lỗi tại searchStaff() ở Staff_DAO class");
            System.out.println(e);
        }
        return staffList;
    }
    
     /*public  ArrayList<Staff> readStaffById(String idString) {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        
        String sql = "SELECT * FROM staff WHERE Staff_id LIKE '%"+ idString +"%' AND IsDeleted <> '1'";
        try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while(rs.next()){
                Staff sf = new Staff (rs.getString("Staff_id"), rs.getString("Full_Name"), rs.getInt("Year_Of_Birth"), rs.getString("Gender"), rs.getString("HomTown"),  rs.getString("Phone_Num"), rs.getInt("Salary"), rs.getBoolean("IsDeleted"));
                staffList.add(sf);          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
        
    }
 
    public  ArrayList<Staff> readStaffByName(String nameString) {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        String sql = "SELECT * FROM staff WHERE Full_Name LIKE '%"+ nameString +"%' AND IsDeleted <> '1'";
        try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while(rs.next()){
                Staff sf = new Staff(rs.getString("Staff_id"), rs.getString("Full_Name"), rs.getInt("Year_Of_Birth"), rs.getString("Gender"), rs.getString("HomTown"),  rs.getString("Phone_Num"), rs.getInt("Salary"), rs.getBoolean("IsDeleted"));
                staffList.add(sf);          
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
        
    }
    
    public  ArrayList<Staff> readStaffByGender(String genderString) {
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        String sql = "SELECT * FROM staff WHERE Gender LIKE '%"+ genderString +"%' AND IsDeleted <> '1'";
        try (Connection conn = cd.getConnect(); Statement stm = conn.createStatement(); ResultSet rs = stm.executeQuery(sql);) {
            while(rs.next()){
                Staff sf = new Staff(rs.getString("Staff_id"), rs.getString("Full_Name"), rs.getInt("Year_Of_Birth"), rs.getString("Gender"), rs.getString("HomTown"),  rs.getString("Phone_Num"), rs.getInt("Salary"), rs.getBoolean("IsDeleted"));
                staffList.add(sf);          
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Staff_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staffList;
        
    } */
    
    public boolean phoneExisted(String id, String phone) {
        boolean isExisted = false;
            String sql = "SELECT * FROM staff WHERE Phone_Num = '" + phone + "' AND Staff_id NOT IN ('" + id + "') AND IsDeleted <> 1";
            
            try (Connection conn = cd.getConnect(); Statement stm= conn.createStatement();  ResultSet rs = stm.executeQuery(sql); ) {
                while (rs.next()) {
                    if (phone.equalsIgnoreCase(rs.getString("Phone_Num"))) {
                    isExisted = true;
                    break;
                    }
                }
            }
            catch (SQLException e) {
            System.out.println("Đã xảy ra lỗi tại phoneExisted ở Staff_DAO class");
            System.out.println(e);
        }
        return isExisted;
    }
    

    public String autoStaffId() {
        String id = "AA0";
        int counter = 1;
        String sql = "SELECT COUNT(DISTINCT Staff_id) FROM staff";
        try (Connection conn = cd.getConnect(); Statement stm= conn.createStatement(); ResultSet rs = stm.executeQuery(sql); ){
            while (rs.next()) {
                counter += rs.getInt("COUNT(DISTINCT Staff_id)");
            }
        } 
        catch (Exception e) {
            System.out.println("Đã xảy ra lỗi tại autoStaffId ở Staff_DAO class");
            System.out.println(e);
        }
        return id + counter;
    }

    public String getNameByID(String id){
        String name = null;
        try(Connection conn = cd.getConnect(); Statement stm = conn.createStatement();) {
            String sql= "SELECT Full_Name FROM staff WHERE Staff_id = '"+ id +"' ";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next())
                name = rs.getString("Full_Name");
        }
        catch(SQLException e){
        }
        
        return name;
    }
      
}
    


