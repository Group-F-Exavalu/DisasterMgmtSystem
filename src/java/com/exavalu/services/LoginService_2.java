/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService_2 {
    
    public static LoginService_2 loginService = null;
    
    private LoginService_2(){}
    
    public static LoginService_2 getInstance()
    {
        if(loginService==null)
        {
            return new LoginService_2();
        }
        else
        {
            return loginService;
        }
    }
    
    public boolean doLogin(Employee emp)
    {
        boolean success = false;
        
        String sql = "Select * from employees where email=? and password=?";
        
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emp.getEmail());
            ps.setString(2, emp.getPassword());
            
            System.out.println("LoginService :: "+ps);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next())
            {
                success = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        return success;
    }
    
}
