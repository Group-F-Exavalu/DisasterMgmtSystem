/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.models.Volunteer;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.apache.log4j.Logger;

public class VolunteerService {

    public static VolunteerService userService = null;

    public static VolunteerService getInstance() {
        if (userService == null) {
            return new VolunteerService();
        } else {
            return userService;
        }
    }
    
     public boolean beVolunteerInput(Volunteer user){
        
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        try{
            
            
            String sql = "INSERT INTO volunteer(emailAddress,volunteerName,message,phoneNumber,aadharNumber)" + "VALUES(? ,? ,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmailAddress());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getMesssage());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getAadharNumber());
            
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

    
}

