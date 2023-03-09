/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Admin;
import com.exavalu.models.DonateForm;
import com.exavalu.models.GmailUser;
import com.exavalu.models.Organisation;
import com.exavalu.models.User;
import com.exavalu.models.Volunteer;
import com.exavalu.utils.JDBCConnectionManager;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Debjit Das,Ayshik Palit
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
        String sql = "SELECT sum(amount) FROM donatemoney WHERE status=1";
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
    public static String getTotalUserDonation(){
        String total = "";
        String sql = "SELECT sum(amount) FROM donatemoney WHERE donorType=1 AND status=1;";
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
    public static String getTotalOrgDonation(){
        String total = "";
        String sql = "SELECT sum(amount) FROM donatemoney WHERE donorType=2 AND status=1;";
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
                donateform.setTransactionId(rs.getString("transactionId"));
                
            } 
            System.out.println("donate type" + donateform.getDonorType());
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
                donateform.setTransactionId(rs.getString("transactionId"));
                
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

    public static String getGovtNumber(String donorId, String donorType) {
        String result=null;
        if(donorType.equals("1")){
            String sql = "SELECT * FROM users where userId=?;";
            try {

            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, donorId);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                result = rs.getString("aadharNumber");
            }            
            
        } catch (SQLException ex) {
           
        }
          System.out.println("Aadhar Number fetched :" + result);
          return result;
        }
        else{
            String sql = "SELECT * FROM organisations where organisationId=?;";
            try {

            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, donorId);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                result = rs.getString("regnNumber");
            }            
            
        } catch (SQLException ex) {
           
        }
          System.out.println("Registration Number fetched :" + result);
          return result;
        }
    }
    public static User getDonorUser(String donorId) {
        User user = new User();
        
        String sql = "SELECT * FROM users where userId=?;";
        try {

            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, donorId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setAadharNumber(rs.getString("aadharNumber"));
                
            }

        } catch (SQLException ex) {

        }
        System.out.println("User fetched :" + user.getFirstName());
        return user;
     
    }
        
        public static Organisation getDonorOrg(String donorId) {
            Organisation org = new Organisation();
            String sql = "SELECT * FROM organisations where organisationId=?;";
            try {

            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, donorId);

            ResultSet rs = preparedStatement.executeQuery();
            

            while(rs.next())
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
          System.out.println("Organisation fetched :" + org.getOrganisationName());
          return org;
        }

    public static GmailUser getGmailDonor(String donorId) {
        GmailUser gmailUser = new GmailUser();
        String sql = "SELECT * FROM gmailusers where id=?;";
        try {

            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, donorId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                gmailUser.setEmail(rs.getString("emailAddress"));
                gmailUser.setFirstName(rs.getString("firstName"));
                gmailUser.setLastName(rs.getString("lastName"));
//                user.setPhoneNumber(rs.getString("phoneNumber"));
//                user.setGender(rs.getString("gender"));
//                user.setAddress(rs.getString("address"));
//                user.setAadharNumber(rs.getString("aadharNumber"));
                
            }

        } catch (SQLException ex) {

        }
        System.out.println("User fetched :" + gmailUser.getFirstName());
        return gmailUser;
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
      public static ArrayList getAllUsers() throws IOException, SQLException {
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
                user.setAadharNumber(rs.getString("aadharNumber"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setGender(rs.getString("gender"));
                user.setCountry(rs.getString("country"));
                user.setDate(rs.getString("date"));
                
                userList.add(user);
            }
        } catch (SQLException ex) {
    
        }
        return userList;
    }
      public static ArrayList getAllOrgs() throws IOException, SQLException {
        ArrayList orgList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT * FROM organisations";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Organisation org = new Organisation();
                org.setEmailAddress(rs.getString("emailAddress"));
                org.setOrganisationName(rs.getString("organisationName"));
                org.setOrganisationId(rs.getInt("organisationId"));
                org.setRegnNumber(rs.getString("regnNumber"));
                org.setCountry(rs.getString("country"));
                org.setState(rs.getString("state"));
                orgList.add(org);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orgList;
    }
      public static ArrayList getAllGmailUsers() throws IOException, SQLException {
        ArrayList userList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "SELECT * FROM gmailusers";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                GmailUser user = new GmailUser();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("emailAddress"));
                userList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return userList;
    }
      public static ArrayList getAllDates(){
        ArrayList dateList = new ArrayList();
        String sql = "SELECT DISTINCT date FROM users";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                
                Date date=rs.getDate("date");
                
                dateList.add(date);
            }
            System.out.println(dateList);

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return dateList;
    }
      
      public static ArrayList getAllDatesCount(){
        ArrayList dateCountList = new ArrayList();
        String sql = "SELECT COUNT(*) FROM users GROUP BY date";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                int count=rs.getInt("COUNT(*)");
                
                dateCountList.add(count);
            }            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return dateCountList;
    }
    
}
