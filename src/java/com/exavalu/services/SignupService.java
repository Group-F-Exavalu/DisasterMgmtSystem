/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Organisation;
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
public class SignupService {
    
    public static SignupService loginService = null;
    
    private SignupService(){}
    
    public static SignupService getInstance()
    {
        if(loginService==null)
        {
            return new SignupService();
        }
        else
        {
            return loginService;
        }
    }
    
    
    public boolean doSignupUser(User user){
        
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        try{
            
            
            String sql = "INSERT INTO users(emailAddress, password, firstName,lastName,gender,phoneNumber,address,govtProof,govtId,country,state,district)" + "VALUES(? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmailAddress());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5,user.getGender());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setInt(8, user.getGovtProof());
            preparedStatement.setString(9, user.getGovtId());
            preparedStatement.setString(10, user.getCountry());
            preparedStatement.setString(11, user.getState());
            preparedStatement.setString(12, user.getDistrict());
            
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
    
    
    public boolean doSignupOrg(Organisation org){
        
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        try{
            
            
            String sql = "INSERT INTO organisations(organisationName, regnNumber,country,state,district,emailAddress,password)" + "VALUES(? ,? ,? ,? ,? ,? ,? )";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, org.getOrganisationName());
            preparedStatement.setString(2, org.getRegnNumber());
            preparedStatement.setString(3, org.getCountry());
            preparedStatement.setString(4, org.getState());
            preparedStatement.setString(5, org.getDistrict());
            preparedStatement.setString(6, org.getEmailAddress());
            preparedStatement.setString(7, org.getPassword());
            
            
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
    
    
    
//    public ArrayList getAllCountries()
//    {
//        ArrayList countryList = new ArrayList();
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
//            String sql = "SELECT * FROM country";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            while(rs.next())
//            {
//                Country country = new Country();
//                country.setCountryName(rs.getString("countryName"));
//                country.setCountryCode(rs.getString("countryCode"));
//                
//                
//                countryList.add(country);
//
//            }
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        System.err.println("Number of countries = "+countryList.size());
//        return countryList;
//    }
//    public ArrayList getAllStates(String countryCode)
//    {
//        ArrayList stateList = new ArrayList();
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
//            String sql = "SELECT * FROM state where countryCode=?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, countryCode);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            while(rs.next())
//            {
//                State state = new State();
//                
//                state.setStateCode(rs.getString("stateCode"));
//                state.setStateName(rs.getString("stateName"));
//                
//                stateList.add(state);
//
//            }
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        System.err.println("Number of states = "+stateList.size());
//        return stateList;
//    }
//      
//   public ArrayList getAllDistricts(String stateCode) {
//        
//        ArrayList districtList = new ArrayList();
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            //String sql = "SELECT employeeId, firstName, lastName, phone, address, gender, age, basicSalary, .employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId carAllowance, departmentName, roleName FROM employeedb.employees, employeedb.departments, employeedb.roles where employees.departmentId = departments.departmentId and employees.roleId = roles.roleId order by employeeId;";
//            String sql = "SELECT * FROM district where stateCode=?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, stateCode);
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//
//            while(rs.next())
//            {
//                District district = new District();
//                
//                district.setDistrictCode(rs.getString("districtCode"));
//                district.setDistrictName(rs.getString("districtName"));
//                
//                districtList.add(district);
//
//            }
//
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        System.err.println("Number of districts = "+districtList.size());
//        return districtList;
//    }
}
