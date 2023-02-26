/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Event;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SupportService {
    
    public static SupportService supportService = null;
    public static SupportService getInstance()
    {
        if(supportService==null)
        {
            return new SupportService();
        }
        else
        {
            return supportService;
        }
    }
    
    public boolean insertEvents(Event event){
        
        boolean result = false;
        String sql = "INSERT INTO events(eventTopic,eventDetails)"+"VALUES(? ,?)";
        try {

            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
                preparedStatement.setString(1, event.getEventTopic());
                preparedStatement.setString(2, event.getEventDetails());
                
                System.out.println(preparedStatement);
                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }

        } catch (SQLException ex) {
	     ex.printStackTrace();
            }
        return result;
    }
    
   
}