/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.AdminService;
import com.exavalu.services.DonateService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * This class holds all the functionality of the Admin entity
 * @author Ayshik Palit,Debjit Das,Reetangsee Dutta
 */
public class Admin extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int adminId;
    private int formId;
    private int status;
    private int eventId;

    /**
     *
     * @return
     */
    public int getEventId() {
        return eventId;
    }

    /**
     *
     * @param eventId
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    private String adminName;
    private String emailAddress;
    private String password;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    /**
     *
     * @param application
     */
    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    /**
     *
     * @param session
     */
    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    /**
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     *
     * @return
     */
    public int getFormId() {
        return formId;
    }

    /**
     *
     * @param formId
     */
    public void setFormId(int formId) {
        this.formId = formId;
    }

    /**
     *
     * @param adminId
     */
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    /**
     *
     * @return
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     *
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     *
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     *
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String editMoneyForm() throws Exception {
        String result = "SUCCESS";
        DonateForm moneyform = AdminService.getMoneybyId(this.formId);
        if(moneyform.getDonorType().equals("1")){
            String aadharNumber = AdminService.getGovtNumber(moneyform.getDonorId(),moneyform.getDonorType());
            User user = AdminService.getDonorUser(moneyform.getDonorId());
            sessionMap.put("Aadhar", aadharNumber);
            sessionMap.put("RegnNumber", null);
            sessionMap.put("User", user);
            sessionMap.put("Org",null);
            sessionMap.put("GmailUser", null);
            //System.out.println("Aadhar"+aadharNumber);
        }
        else if(moneyform.getDonorType().equals("2")){
            String regnNumber = AdminService.getGovtNumber(moneyform.getDonorId(),moneyform.getDonorType());
            Organisation org = AdminService.getDonorOrg(moneyform.getDonorId());
            sessionMap.put("Aadhar", null);
            sessionMap.put("RegnNumber", regnNumber);
            sessionMap.put("Org",org);
            sessionMap.put("User", null);
            sessionMap.put("GmailUser", null);
            //System.out.println("RegnNumber"+regnNumber);
        }
        else if(moneyform.getDonorType().equals("3")){
            GmailUser gmailUser = AdminService.getGmailDonor(moneyform.getDonorId());
            sessionMap.put("Aadhar", null);
            sessionMap.put("RegnNumber", null);
            sessionMap.put("GmailUser", gmailUser);
            sessionMap.put("Org",null);
            sessionMap.put("User", null);
            //System.out.println("GmailUser"+gmailUser.getFamily_name());
            
        }
        sessionMap.put("MoneyForm", moneyform);
        
        
        return result;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public String getAllUsers() throws IOException, SQLException{
        String result = "FAILURE";
        ArrayList userList = AdminService.getAllUsers();
        sessionMap.put("UserList", userList);
        result="SUCCESS";
        return result;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public String getAllOrgs() throws IOException, SQLException{
        String result = "FAILURE";
        ArrayList orgList = AdminService.getAllOrgs();
        sessionMap.put("OrgList", orgList);
        result="SUCCESS";
        return result;
    }

    /**
     *
     * @return
     * @throws IOException
     * @throws SQLException
     */
    public String getAllGmailUsers() throws IOException, SQLException{
        String result = "FAILURE";
        ArrayList guserList=AdminService.getAllGmailUsers();
        sessionMap.put("GUserList", guserList);
        result="SUCCESS";
        return result;
    }        

    /**
     *
     * @return
     * @throws Exception
     */
    public String saveMoneyStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.ApproveDonateMoneyStatus(formId);
        //System.out.println(this.formId);
        if (success){
        ArrayList moneyList = AdminService.getAllMoney();
        sessionMap.put("MoneyList", moneyList);
        //System.out.println("returning Success from saveMoneyStatus method");
        result = "SUCCESS";
    }
//    else {
//        //System.out.println("returning Failure from saveMoneyStatus method");
//    }
    return result;
}

    /**
     *
     * @return
     * @throws Exception
     */
    public String deleteMoneyStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.RejectDonateMoneyStatus(formId);
        //System.out.println(this.formId);
        if (success){
        ArrayList moneyList = AdminService.getAllMoney();
        sessionMap.put("MoneyList", moneyList);
        //System.out.println("returning Success from deleteMoneyStatus method");
        result = "SUCCESS";
    }
//    else {
//        //System.out.println("returning Failure from deleteMoneyStatus method");
//    }
    return result;
}

    /**
     *
     * @return
     * @throws Exception
     */
    public String editEssentialsForm() throws Exception {
        String result = "SUCCESS";
        DonateForm essentialsform = AdminService.getEssentialsbyId(this.formId);
        //System.out.println("form id : "+this.formId);
        if(essentialsform.getDonorType().equals("1")){
            String aadharNumber = AdminService.getGovtNumber(essentialsform.getDonorId(),essentialsform.getDonorType());
            User user = AdminService.getDonorUser(essentialsform.getDonorId());
            sessionMap.put("Aadhar", aadharNumber);
            sessionMap.put("RegnNumber", null);
            sessionMap.put("User", user);
            sessionMap.put("Org",null);
            sessionMap.put("GmailUser", null);
            //System.out.println("Aadhar"+aadharNumber);
        }
        else if(essentialsform.getDonorType().equals("2")){
            String regnNumber = AdminService.getGovtNumber(essentialsform.getDonorId(),essentialsform.getDonorType());
            Organisation org = AdminService.getDonorOrg(essentialsform.getDonorId());
            sessionMap.put("Aadhar", null);
            sessionMap.put("RegnNumber", regnNumber);
            sessionMap.put("Org",org);
            sessionMap.put("User", null);
            sessionMap.put("GmailUser", null);
            //System.out.println("RegnNumber"+regnNumber);
        }
        else if(essentialsform.getDonorType().equals("3")){
            GmailUser gmailUser = AdminService.getGmailDonor(essentialsform.getDonorId());
            sessionMap.put("Aadhar", null);
            sessionMap.put("RegnNumber", null);
            sessionMap.put("GmailUser", gmailUser);
            sessionMap.put("Org",null);
            sessionMap.put("User", null);
            //System.out.println("GmailUser"+gmailUser.getFamily_name());
        }
        sessionMap.put("EssentialsForm", essentialsform);
        return result;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String saveEssentialStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.ApproveDonateEssentialStatus(formId);
        //System.out.println(this.formId);
        if (success){
        ArrayList essentialList = AdminService.getAllEssential();
        sessionMap.put("EssentialList", essentialList);
        //System.out.println("returning Success from saveEssentialStatus method");
        result = "SUCCESS";
    }
//    else {
//        System.out.println("returning Failure from saveEssentialStatus method");
//    }
    return result;
}

    /**
     *
     * @return
     * @throws Exception
     */
    public String deleteEssentialStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.RejectDonateEssentialStatus(formId);
        //System.out.println(this.formId);
        if (success){
        ArrayList essentialList = AdminService.getAllEssential();
        sessionMap.put("EssentialList", essentialList);
        //System.out.println("returning Success from deleteEssentialStatus method");
        result = "SUCCESS";
    }
    else {
        //System.out.println("returning Failure from deleteEssentialStatus method");
    }
    return result;
}

    /**
     *
     * @return
     * @throws Exception
     */
    public String editEventsForm() throws Exception {
        String result = "SUCCESS";
        Event eventform = DonateService.getInstance().getEventById(this.eventId);
        //System.out.println("event id : "+this.eventId);
        sessionMap.put("EventForm", eventform);
        return result;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String saveEventStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = DonateService.getInstance().setEventStatus(this.eventId);
        //System.out.println(this.eventId);
        if (success){
        ArrayList eventList = DonateService.getInstance().getEvents();
        sessionMap.put("EventList", eventList);
        //System.out.println("returning Success from saveEventStatus method");
        result = "SUCCESS";
    }
//    else {
//        System.out.println("returning Failure from saveEventStatus method");
//    }
    return result;
}

    /**
     *
     * @return
     * @throws Exception
     */
    public String deleteEventStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = DonateService.getInstance().rejectEventStatus(this.eventId);
        //System.out.println(this.eventId);
        if (success){
        ArrayList eventList = DonateService.getInstance().getEvents();
        sessionMap.put("EventList", eventList);
        //System.out.println("returning Success from deleteEventStatus method");
        result = "SUCCESS";
    }
//    else {
//        System.out.println("returning Failure from deleteEventStatus method");
//    }
    return result;
}
     
     

//    public String doUpdateDonateMoneyStatus() throws Exception {
//        String result = "REJECTED";
//        boolean success = AdminService.UpdateDonateMoneyStatus(this.getFormId(), this.getStatus());
//        if (success) {
//            System.out.println("Returning Success from doUpdateDonateMoneyStatus method");
//            if (Integer.parseInt(this.getStatus()) == 2) {
//                result = "APPROVED";
//            } else if (Integer.parseInt(this.getStatus()) == 4) {
//                result = "REJECTED";
//            }
//        } else {
//            System.out.println("Returning Failure from doUpdateDonateMoneyStatus method");
//        }
//
//        return result;
//    }
//    public String approveDonor() throws Exception {
//        String result = "PENDING";
//        boolean success = AdminService.approveDonor(this.getDonorId(), this.getStatus());
//        if (success) {
//            if (Integer.parseInt(this.getstatus()) == 1) {
//                result = "APPROVED";
//            } else {
//
//            }
//            return result;
//        }
}
