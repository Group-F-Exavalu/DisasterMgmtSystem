/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Organisation;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class serves as the connection between the JAVA Environment and DataBase
 * for Signing up into the system
 *
 * @author Raktim Ghosal, Azel Karthak
 */
public class SignupService {

    public static SignupService loginService = null;

    private SignupService() {
    }

    public static SignupService getInstance() {
        if (loginService == null) {
            return new SignupService();
        } else {
            return loginService;
        }
    }

    public boolean doSignupUser(User user) throws FileNotFoundException, IOException {

        boolean result = false;
        try (Connection con = JDBCConnectionManager.getConnection()) {

            String sql = "INSERT INTO users(emailAddress, password, firstName,lastName,gender,phoneNumber,address,aadharNumber,country,state,district,image,date)" + "VALUES(? ,? ,? ,? ,?,? ,? ,? ,?,?,?,?,CURDATE())";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

                try (FileInputStream inputStream = new FileInputStream(user.getImage())) {
                    String encryptPassword = LoginService.getMd5(user.getPassword());
                    preparedStatement.setString(1, user.getEmailAddress());
                    preparedStatement.setString(2, encryptPassword);
                    preparedStatement.setString(3, user.getFirstName());
                    preparedStatement.setString(4, user.getLastName());
                    preparedStatement.setString(5, user.getGender());
                    preparedStatement.setString(6, user.getPhoneNumber());
                    preparedStatement.setString(7, user.getAddress());
                    preparedStatement.setString(8, user.getAadharNumber());
                    preparedStatement.setString(9, user.getCountry());
                    preparedStatement.setString(10, user.getState());
                    preparedStatement.setString(11, user.getDistrict());

                    preparedStatement.setBinaryStream(12, inputStream);

                    //System.out.println("prepared statement do signup"+ preparedStatement);
                    int row = preparedStatement.executeUpdate();

                    if (row == 1) {
                        result = true;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(SignupService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }
        return result;
    }

    public boolean doSignupOrg(Organisation org) {

        boolean result = false;
        try (Connection con = JDBCConnectionManager.getConnection()) {

            String encryptPassword = LoginService.getMd5(org.getPassword());
            String sql = "INSERT INTO organisations(organisationName, regnNumber,country,state,district,emailAddress,password,date)" + "VALUES(? ,? ,? ,? ,? ,? ,?,CURDATE() )";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

                preparedStatement.setString(1, org.getOrganisationName());
                preparedStatement.setString(2, org.getRegnNumber());
                preparedStatement.setString(3, org.getCountry());
                preparedStatement.setString(4, org.getState());
                preparedStatement.setString(5, org.getDistrict());
                preparedStatement.setString(6, org.getEmailAddress());
                preparedStatement.setString(7, encryptPassword);

                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(SignupService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }

        }
        return result;
    }

    public boolean doCheckUser(String email) {
        boolean success = false;

        String sql = "SELECT * FROM users where emailAddress=?";

        try (Connection con = JDBCConnectionManager.getConnection()) {

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, email);

//            System.out.println("LoginService :: "+ps);
                try (ResultSet rs = preparedStatement.executeQuery()) {

                    if (rs.next()) {
                        success = true;
                    }
                }
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(SignupService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }

        return success;
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
