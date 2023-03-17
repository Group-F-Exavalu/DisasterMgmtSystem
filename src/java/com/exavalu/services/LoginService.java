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
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class serves as the connection between the JAVA Environment and DataBase for Login in to the system
 * @author Reetangsee Dutta
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
        String enPassword = LoginService.getMd5(password);
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, enPassword);
            
//            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
        }
        
        
        return success;
    }
    public boolean doLoginOrganisation(String emailAddress, String password)
    {
        boolean success = false;
        
        String sql = "SELECT * FROM organisations where emailAddress=? and password=?;";
        String enPassword = LoginService.getMd5(password);
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ps.setString(2, enPassword);
            
//            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
               ps.close();
               rs.close();    
        } 
               
        catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
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
            
//            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
               ps.close();
               rs.close();
            
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
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
    public ArrayList<Country> getAllCountries()
    {
        ArrayList countryList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
            String sql = "Select * from countries";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            System.out.println("prep statement:" +preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while(rs.next())
            {
                Country country = new Country();
                country.setCountry(rs.getString("country"));
                country.setCountryName(rs.getString("countryName"));
                
                
                
                countryList.add(country);

            }

//            System.err.println("Number of countries = "+countryList.size());
               preparedStatement.close();
               rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }
        
        return countryList;
    }
    public ArrayList<States> getAllStates(String countryCode)
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
             preparedStatement.close();
               rs.close();
            


        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }
//        System.err.println("Number of states = "+stateList.size());
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
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setAddress(rs.getString("address"));
                user.setCountry(rs.getString("country"));
                user.setDistrict(rs.getString("district"));
                user.setGender(rs.getString("gender"));
                user.setAadharNumber(rs.getString("aadharNumber"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                
                Blob imageBlob = rs.getBlob("image");
                if (imageBlob != null) {
                    byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
                    String imageString = Base64.getEncoder().encodeToString(imageBytes);
                    user.setImageData(imageString);
                }
                
                //System.out.println("User Phone :" +rs.getString("phoneNumber"));
            }
             preparedStatement.close();
               rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
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
             preparedStatement.close();
               rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }

        return org;
    }

    public ArrayList<Districts> getAllDistricts(String stateCode) {
        
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
             preparedStatement.close();
               rs.close();


        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }
//        System.err.println("Number of districts = "+districtList.size());
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
            
//            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
               ps.close();
               rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Code: " + ex.getErrorCode() +"Error Message: " + ex.getMessage());
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
            preparedStatement.close();
              
        }catch(SQLException ex){
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());

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
             preparedStatement.close();
             rs.close();
             
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }

        return guser;
    }
    
    
    public static ArrayList<User> getAllUser() throws IOException, SQLException {
        ArrayList userList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setAddress(rs.getString("address"));
                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setGender(rs.getString("gender"));
                user.setCountry(rs.getString("country"));
                
                userList.add(user);
            }
              preparedStatement.close();
             rs.close();
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
            //log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage());
        }
        return userList;
    }
    
    public static boolean updateUser(User user) throws IOException, SQLException {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection(); {
            String sql = "UPDATE users SET firstName = ? , lastName = ? , emailAddress = ?, phoneNumber = ? , address = ?, gender = ?, image = ? WHERE userId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            FileInputStream inputStream = new FileInputStream(user.getImage());
            
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmailAddress());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getGender());
            
            preparedStatement.setBinaryStream(7, inputStream);
            
            preparedStatement.setInt(8, user.getUserId());
            int row = preparedStatement.executeUpdate();
            if(row==1)
            {
                result = true;
            }
              preparedStatement.close();
            
        }
        return result;
    }    
    
    public static boolean updateUserWithoutImage(User user) throws IOException, SQLException {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection(); {
            String sql = "UPDATE users SET firstName = ? , lastName = ? , emailAddress = ?, phoneNumber = ? , address = ?, gender = ? WHERE userId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
                     
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmailAddress());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getGender());
            
            
            preparedStatement.setInt(7, user.getUserId());
            int row = preparedStatement.executeUpdate();
            if(row==1)
            {
                result = true;
            }
              preparedStatement.close();
            
        }
        
        return result;
    }    
    public static String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
   
}
