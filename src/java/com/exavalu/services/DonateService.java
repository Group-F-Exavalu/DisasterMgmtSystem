/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.DonateForm;
import com.exavalu.models.Event;
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
 * @author Preyangsee
 */
public class DonateService {
    
    public static DonateService donateService = null;
    public static DonateService getInstance()
    {
        if(donateService==null)
        {
            return new DonateService();
        }
        else
        {
            return donateService;
        }
    }
    public ArrayList getEvents(){
        ArrayList eventList = new ArrayList();
        String sql = "Select * from events";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Event event = new Event();
                
                event.setEventId(rs.getString("eventId"));
                event.setEventTopic(rs.getString("eventTopic"));
                event.setEventDetails(rs.getString("eventDetails"));
                event.setStatus(rs.getString("status"));
                
                eventList.add(event);
            }
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+eventList.size());
        return eventList;
    }
    public Event getEventById(String eventId){
        Event event = new Event();
        String sql = "Select * from events where eventId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, eventId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            { 
                event.setEventId(rs.getString("eventId"));
                event.setEventTopic(rs.getString("eventTopic"));
                event.setEventDetails(rs.getString("eventDetails"));
                event.setStatus(rs.getString("status"));
                
            }
            System.err.println("EVENT present");
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return event;
    }
    public boolean setEventStatus(int value, String eventId){
        boolean result = false;
        String sql = "UPDATE events SET status = ? WHERE eventId =?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,value);
            ps.setString(2,eventId);
            
            int row = ps.executeUpdate();

                if (row == 1) {
                    result = true;
                }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public boolean insertMoneyForm(DonateForm donateForm){
        
        boolean result = false;
        String sql = "INSERT INTO donatemoney(donorId,donorType,amount,eventId,status)"+"VALUES(? ,? ,? ,? ,?)";
        try {

            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
                preparedStatement.setString(1, donateForm.getDonorId());
                preparedStatement.setString(2, donateForm.getDonorType());
                preparedStatement.setString(3, donateForm.getAmount());
                preparedStatement.setString(4, donateForm.getEventId());
                preparedStatement.setInt(5, 0);
                
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
    public boolean insertEssentialsForm(DonateForm donateForm){
        
        boolean result = false;
        String sql = "INSERT INTO donateessentials(donorId,donorType,essentialName,eventId,status)"+"VALUES(? ,? ,? ,? ,?)";
        try {

            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
                preparedStatement.setString(1, donateForm.getDonorId());
                preparedStatement.setString(2, donateForm.getDonorType());
                preparedStatement.setString(3, donateForm.getEssentialName());
                preparedStatement.setString(4, donateForm.getEventId());
                preparedStatement.setInt(5, 0);
                
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
    public boolean setPaymentStatus(String value, String formId){
        boolean result = false;
        String sql = "UPDATE donatemoney SET status = ? WHERE formId =?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,value);
            ps.setString(2,formId);
            
            int row = ps.executeUpdate();

                if (row == 1) {
                    result = true;
                }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public boolean setEssentialStatus(String value, String formId){
        boolean result = false;
        String sql = "UPDATE donateessentials SET status = ? WHERE formId =?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,value);
            ps.setString(2,formId);
            
            int row = ps.executeUpdate();

                if (row == 1) {
                    result = true;
                }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
