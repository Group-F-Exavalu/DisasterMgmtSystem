/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Country;
import com.exavalu.models.Districts;
import com.exavalu.models.GmailUser;
import com.exavalu.models.Organisation;
import com.exavalu.models.States;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {
    
    public static LoginService loginService = null;
    
    private LoginService(){}
    
    public static LoginService getInstance()
    {
        if(loginService==null)
        {
            return new LoginService();
        }
        else
        {
            return loginService;
        }
    }
    
    public boolean doLoginUser(String emailAddress, String password)
    {
        boolean success = false;
        
        String sql = "SELECT * FROM users where emailAddress=? and password=?;";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, password);
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
        }
        
        
        return success;
    }
    public boolean doLoginOrganisation(String emailAddress, String password)
    {
        boolean success = false;
        
        String sql = "SELECT * FROM organisations where emailAddress=? and password=?;";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, password);
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
        }
        
        
        return success;
    }
    public boolean doLoginAdmin(String emailAddress,String password)
    {
        boolean success = false;
        
        String sql = "SELECT * FROM admins where emailAddress=? and password=?;";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, password);
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
        }
        
        
        return success;
    }
//    public boolean doSignup(User user){
//        
//        boolean result = false;
//        Connection con = JDBCConnectionManager.getConnection();
//        try{
//            
//            
//            String sql = "INSERT INTO users(emailAddress, password, firstName,lastName,status,addressLine1,addressLine2,countryCode,stateCode,districtCode)" + "VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, user.getEmailAddress());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFirstName());
//            preparedStatement.setString(4, user.getLastName());
//            preparedStatement.setInt(5,1);
//            preparedStatement.setString(6, user.getAddressLine1());
//            preparedStatement.setString(7, user.getAddressLine2());
//            preparedStatement.setString(8, user.getCountryCode());
//            preparedStatement.setString(9, user.getStateCode());
//            preparedStatement.setString(10, user.getDistrictCode());
//            
//            int row = preparedStatement.executeUpdate();
//            
//            if(row==1){
//                result = true;
//            }
//        }catch(SQLException ex){
//            Logger log = Logger.getLogger(LoginService.class.getName());
//            log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());
//
//        }
//        return result;
//    }
    public ArrayList getAllCountries()
    {
        ArrayList countryList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "Select * from countries";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println("prep statement:" +preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Country country = new Country();
                country.setCountry(rs.getString("country"));
                country.setCountryName(rs.getString("countryName"));
                
                
                
                countryList.add(country);

            }

            System.err.println("Number of countries = "+countryList.size());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return countryList;
    }
    public ArrayList getAllStates(String countryCode)
    {
        ArrayList stateList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM states where country=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, countryCode);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                States state = new States();
                
                state.setState(rs.getString("state"));
                state.setStateName(rs.getString("stateName"));
                
                stateList.add(state);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Number of states = "+stateList.size());
        return stateList;
    }
//    
    public static User getUser(String emailAddress) {
        User user= new User();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "Select * from users where emailAddress=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emailAddress);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setAddress(rs.getString("address"));
                user.setCountry(rs.getString("country"));
                user.setDistrict(rs.getString("district"));
                user.setGender(rs.getString("gender"));
                user.setAadharNumber(rs.getString("aadharNumber"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                
                System.out.println("User Phone :" +rs.getString("phoneNumber"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
        public static Organisation getOrganisation(String emailAddress) {
        Organisation org = new Organisation();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "Select * from organisations where emailAddress=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emailAddress);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {

                org.setOrganisationId(rs.getInt("organisationId"));
                org.setOrganisationName(rs.getString("organisationName"));
                org.setRegnNumber(rs.getString("regnNumber"));
                org.setCountry(rs.getString("country"));
                org.setDistrict(rs.getString("district"));
                org.setState(rs.getString("state"));
                
            }
            
        } catch (SQLException ex) {

        }

        return org;
    }

    public ArrayList getAllDistricts(String stateCode) {
        
        ArrayList districtList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "SELECT * FROM districts where state=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, stateCode);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Districts district = new Districts();
                
                district.setDistrict(rs.getString("district"));
                district.setDistrictName(rs.getString("districtName"));
                
                districtList.add(district);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Number of districts = "+districtList.size());
        return districtList;
    }
    public boolean doGmailLoginUser(String id, String email)
    {
        boolean success = false;
        
        String sql = "SELECT * FROM gmailusers where emailAddress=? and id=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, id);
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
        }
        
        
        return success;
    }
    public boolean insertGmailUser(GmailUser gmailUser){
        boolean result = false;
        String sql = "INSERT INTO gmailusers(id,firstName,lastName,emailAddress,imageUrl)"
                + "VALUES(? ,? ,?, ?, ? )";
        Connection con = JDBCConnectionManager.getConnection();
        try{
            
            //String sql = "INSERT INTO users(emailAddress, password, firstName,lastName,gender,phoneNumber,address,govtProof,govtId,country,state,district)" + "VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, gmailUser.getSub());
            preparedStatement.setString(2, gmailUser.getGiven_name());
            preparedStatement.setString(3, gmailUser.getFamily_name());
            preparedStatement.setString(4, gmailUser.getEmail());
            preparedStatement.setString(5,gmailUser.getPicture());
            
            int row = preparedStatement.executeUpdate();
            
            if(row==1){
                result = true;
            }
        }catch(SQLException ex){
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());

        }
        return result;
    }
    public static GmailUser getGmailUser(String id) {
        GmailUser guser = new GmailUser();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "Select * from gmailusers where id=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next())
            {   
                guser.setSub(rs.getString("id"));
                guser.setEmail(rs.getString("emailAddress"));
                guser.setGiven_name(rs.getString("firstName"));
                guser.setFamily_name(rs.getString("lastName"));
                guser.setPicture(rs.getString("imageUrl"));             
                
//                System.out.println("User Phone :" +rs.getString("phoneNumber"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return guser;
    }

}
