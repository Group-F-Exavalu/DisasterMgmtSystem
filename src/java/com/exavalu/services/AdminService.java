/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Admin;
import com.exavalu.models.DonateForm;
import com.exavalu.models.Event;
import com.exavalu.models.Volunteer;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Ayshik Palit
 */
public class AdminService {
    public static AdminService adminService = null;
    public static AdminService getInstance()
    {
        if(adminService==null)
        {
            return new AdminService();
        }
        else
        {
            return adminService;
        }
    }
    
//    public static boolean updateEventStatus(int eventId, int status) {
//        boolean result = false;
//        try {
//
//            Connection con = JDBCConnectionManager.getConnection();
//
//            String sql = "UPDATE events SET status = ? WHERE (eventId = ?);";
//
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setInt(1, status);
//            preparedStatement.setInt(2, eventId);
//
//            int row = preparedStatement.executeUpdate();
//            if (row == 1) {
//                result = true;
//            }
//
//        } catch (SQLException ex) {
//           
//        }
//
//        return result;
//    }
    public static Admin getAdminDetails(String emailAddress){
        Admin admin = new Admin();
        String sql = "SELECT * FROM admins where emailAddress=? ;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, emailAddress);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                admin.setAdminId(rs.getInt("adminId"));
                admin.setAdminName(rs.getString("adminName"));
                admin.setEmailAddress(rs.getString("emailAddress"));
                admin.setPassword(rs.getString("password"));
                
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return admin;
    }
    public static String getTotalDonation(){
        String total = "";
        String sql = "SELECT sum(amount) FROM donatemoney";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                total=rs.getString("sum(amount)");
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }
    public static String getTotalUsers(){
        String total = "";
        String sql = "SELECT count(*) FROM users;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                total=rs.getString("count(*)");
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }
    public static String getTotalOrganisations(){
        String total = "";
        String sql = "SELECT count(*) FROM organisations;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                total=rs.getString("count(*)");
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }
    public static String getTotalVolunteers(){
        String total = "";
        String sql = "SELECT count(*) FROM volunteer where status=0;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                total=rs.getString("count(*)");
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total;
    }
    public static DonateForm getMoneybyId(int formId){
        DonateForm donateform = new DonateForm();
        String sql = "Select * from donatemoney where formId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, formId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                               
                donateform.setEventId(rs.getString("eventId"));
                donateform.setFormId(rs.getString("formId"));
                donateform.setDonorId(rs.getString("donorId"));
                donateform.setDonorType(rs.getString("donorType"));
                donateform.setAmount(rs.getString("amount"));
                donateform.setStatus(rs.getString("status"));
                
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return donateform;
    }
    
    public static DonateForm getEssentialsbyId(int formId){
        DonateForm donateform = new DonateForm();
        String sql = "Select * from donateessentials where formId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, formId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                
                
                donateform.setEventId(rs.getString("eventId"));
                donateform.setFormId(rs.getString("formId"));
                donateform.setDonorId(rs.getString("donorId"));
                donateform.setDonorType(rs.getString("donorType"));
                donateform.setEssentialName(rs.getString("essentialName"));
                donateform.setStatus(rs.getString("status"));
                
                
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return donateform;
    }
    
     public static ArrayList getAllMoney(){
        ArrayList eventList = new ArrayList();
        String sql = "Select * from donatemoney";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                DonateForm donateform = new DonateForm();
                
                donateform.setEventId(rs.getString("eventId"));
                donateform.setFormId(rs.getString("formId"));
                donateform.setDonorId(rs.getString("donorId"));
                donateform.setDonorType(rs.getString("donorType"));
                donateform.setAmount(rs.getString("amount"));
                donateform.setStatus(rs.getString("status"));
                
                eventList.add(donateform);
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return eventList;
    }
     public static ArrayList getAllEssential(){
        ArrayList eventList = new ArrayList();
        String sql = "Select * from donateessentials";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                DonateForm donateform = new DonateForm();
                
                donateform.setEventId(rs.getString("eventId"));
                donateform.setFormId(rs.getString("formId"));
                donateform.setDonorId(rs.getString("donorId"));
                donateform.setDonorType(rs.getString("donorType"));
                donateform.setEssentialName(rs.getString("essentialName"));
                donateform.setStatus(rs.getString("status"));
                
                eventList.add(donateform);
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return eventList;
    }
    
    public static boolean ApproveDonateMoneyStatus(int formId) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE donatemoney SET status = ? WHERE formId = ?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, formId);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
           
        }

        return result;
    }
    public static boolean ApproveDonateEssentialStatus(int formId) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE donateessentials SET status = ? WHERE formId = ?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, formId);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
           
        }

        return result;
    }
    public static boolean RejectDonateMoneyStatus(int formId) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE donatemoney SET status = ? WHERE formId = ?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, formId);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
           
        }

        return result;
    }
    public static boolean RejectDonateEssentialStatus(int formId) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "UPDATE donateessentials SET status = ? WHERE formId = ?;";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, -1);
            preparedStatement.setInt(2, formId);

            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
           
        }

        return result;
    }
    
     
      public ArrayList getAllVolunteers(){
        ArrayList volunteerList = new ArrayList();
        String sql = "Select * from volunteer";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Volunteer volunteer = new Volunteer();
                
                volunteer.setEmailAddress(rs.getString("emailAddress"));
                volunteer.setName(rs.getString("volunteerName"));
                volunteer.setMesssage(rs.getString("message"));
                volunteer.setPhoneNumber(rs.getString("phoneNumber"));
                volunteer.setAadharNumber(rs.getString("aadharNumber"));
                volunteer.setStatus(rs.getInt("status"));
                
                volunteerList.add(volunteer);
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Volunteer List: "+volunteerList);
        return volunteerList;
        
    }
    
}
