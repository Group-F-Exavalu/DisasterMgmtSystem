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
 * This class serves as the connection between the JAVA Environment and DataBase for Donate entity Interaction
 * @author Reetangsee Dutta
 */
//@SuppressWarnings("PMD")
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
    public ArrayList<DonateForm> getMoney(){
        ArrayList eventList = new ArrayList();
        String sql = "SELECT * FROM donatemoney d, events e where d.eventId=e.eventId;";
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setTransactionId(rs.getString("transactionId"));
                
                eventList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getMoney");
        }
//        System.err.println("Total rows:"+eventList.size());
        return eventList;
    }
    public ArrayList<DonateForm> getUserStatusMoneyList(int userId){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donatemoney d, events e, users u where d.eventId=e.eventId and d.donorId=u.userId and d.donorType=1 and u.userId=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,userId);
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setTransactionId(rs.getString("transactionId"));
                donateform.setFirstName(rs.getString("firstName"));
                donateform.setLastName(rs.getString("lastName"));
                
                statusList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getUserStatusMoneyList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getUserStatusEssentialList(int userId){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donateessentials d, events e, users u where d.eventId=e.eventId and d.donorId=u.userId and d.donorType=1 and u.userId=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,userId);
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
                donateform.setEventName(rs.getString("eventTopic"));

                donateform.setFirstName(rs.getString("firstName"));
                donateform.setLastName(rs.getString("lastName"));
                
                statusList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getUserStatusEssentialList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getOrgStatusMoneyList(int organisationId){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donatemoney d, events e, organisations o where d.eventId=e.eventId and d.donorId=o.organisationId and d.donorType=2 and o.organisationId=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,organisationId);
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setTransactionId(rs.getString("transactionId"));
                donateform.setDonorName(rs.getString("organisationName"));
                
                statusList.add(donateform);
            }
            ps.close();
            rs.close();
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getOrgStatusMoneyList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getOrgStatusEssentialList(int organisationId){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donateessentials d, events e, organisations o where d.eventId=e.eventId and d.donorId=o.organisationId and d.donorType=2 and o.organisationId=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,organisationId);
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setDonorName(rs.getString("organisationName"));
                
                statusList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getOrgStatusEssentialList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getGUserStatusMoneyList(String email){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donatemoney d, events e, gmailusers g where d.eventId=e.eventId and d.donorId=g.id and d.donorType=3 and g.emailAddress=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setTransactionId(rs.getString("transactionId"));
                donateform.setFirstName(rs.getString("firstName"));
                donateform.setLastName(rs.getString("lastName"));
                
                statusList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getGUserStatusMoneyList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getGUserStatusEssentialList(String email){
        ArrayList statusList = new ArrayList();
        String sql = "SELECT * FROM donateessentials d, events e, gmailusers g where d.eventId=e.eventId and d.donorId=g.id and d.donorType=3 and g.emailAddress=?;";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
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
                donateform.setEventName(rs.getString("eventTopic"));
                donateform.setFirstName(rs.getString("firstName"));
                donateform.setLastName(rs.getString("lastName"));
                
                statusList.add(donateform);
            }
            
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getGUserStatusEssentialList");
        }
//        System.err.println("Total rows:"+statusList.size());
        return statusList;
    }
    public ArrayList<DonateForm> getEssentials(){
        ArrayList eventList = new ArrayList();
        String sql = "Select * from donateessentials d, events e where d.eventId=e.eventId;";
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
                donateform.setEventName(rs.getString("eventTopic"));
                eventList.add(donateform);
            }
            ps.close();
            rs.close();
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getEssentials");
        }
//        System.err.println("Total rows:"+eventList.size());
        return eventList;
    }
    public ArrayList<Event> getEvents(){
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
                event.setUserId(rs.getString("userId"));
                event.setStatus(rs.getString("status"));
                
                eventList.add(event);
            }
            ps.close();
            rs.close();
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getEvents");
        }
//        System.err.println("Total rows:"+eventList.size());
        return eventList;
    }
    public ArrayList<Event> getApprovedEvents(){
        ArrayList eventList = new ArrayList();
        String sql = "Select * from events where status=1";
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
            ps.close();
            rs.close();
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getApprovedEvents");
        }
//        System.err.println("Total rows:"+eventList.size());
        return eventList;
    }
    public Event getEventById(int eventId){
        Event event = new Event();
        String sql = "Select * from events where eventId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, eventId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            { 
                event.setEventId(rs.getString("eventId"));
                event.setEventTopic(rs.getString("eventTopic"));
                event.setEventDetails(rs.getString("eventDetails"));
                event.setUserId(rs.getString("userId"));
                event.setUserId(rs.getString("supportType"));
                event.setStatus(rs.getString("status"));
                
            }
//            System.err.println("EVENT present");
            ps.close();
            rs.close();
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getEventById");
        }
        
        return event;
    }
    public String getEventTopicById(String eventId){
        String eventTopic = null;
        String sql = "Select * from events where eventId=?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, eventId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            { 
                eventTopic=rs.getString("eventTopic");
                
            }
//            System.err.println("EVENT present"+ eventTopic);
            ps.close();
            rs.close();   
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : getEventTopicById");
        }
        
        return eventTopic;
    }
    public boolean setEventStatus(int eventId){
        boolean result = false;
        String sql = "UPDATE events SET status = ? WHERE eventId =?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setInt(2,eventId);
//            System.out.println("Event ID:  "+eventId);
            
            int row = ps.executeUpdate();

                if (row == 1) {
                    result = true;
                }
                
               
            
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : setEventStatus");
        }
        return result;
    }
    public boolean rejectEventStatus(int eventId){
        boolean result = false;
        String sql = "UPDATE events SET status = ? WHERE eventId =?";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,-1);
            ps.setInt(2,eventId);
            
            int row = ps.executeUpdate();

                if (row == 1) {
                    result = true;
                }
                ps.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : rejectEventStatus");
        }
        return result;
    }
    public boolean insertMoneyForm(DonateForm donateForm){
        
        boolean result = false;
        String sql = "INSERT INTO donatemoney(donorId,donorType,amount,eventId,status,transactionId)"+"VALUES(? ,? ,? ,? ,?,?)";
        try {

            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
                preparedStatement.setString(1, donateForm.getDonorId());
                preparedStatement.setString(2, donateForm.getDonorType());
                preparedStatement.setString(3, donateForm.getAmount());
                preparedStatement.setString(4, donateForm.getEventId());
                preparedStatement.setInt(5, 0);
                preparedStatement.setString(6, donateForm.getTransactionId());
                
//                System.out.println(preparedStatement);
                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }
                preparedStatement.close();

        } catch (SQLException ex) {
	     Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : insertMoneyForm");
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
                
//                System.out.println(preparedStatement);
                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }
                   preparedStatement.close();

        } catch (SQLException ex) {
	     Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : insertEssentialsForm");
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
                   ps.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : setPaymentStatus");
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
                   ps.close();
        }
        catch (SQLException ex) {
            Logger log = Logger.getLogger(DonateService.class.getName());
            log.error(LocalDateTime.now()+ "Error Message: " + ex.getMessage()+" Class : DonateService, Method : setEssentialStatus");
        }
        return result;
    }
}
