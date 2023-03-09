/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.AdminService;
import com.exavalu.services.LoginService;
import com.exavalu.services.VolunteerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Azel Karthak
 */
public class Volunteer extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    
    private String emailAddress,name,messsage,phoneNumber,aadharNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
    private int status;
    
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

   
    
     /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
      public String beVolunteer() throws Exception {

        String result = "FAILURE";
        boolean success = VolunteerService.getInstance().beVolunteerInput(this);

        if (success) {            
            //sessionMap.put("SuccessSignUp", "Successfully Registered");
            System.out.println("Returning from success");
            result = "SUCCESS";
        } else {
           // Logger log = Logger.getLogger(VolunteerService.class.getName());
            //log.error(LocalDateTime.now() + "--Email Id already exists");
           // sessionMap.put("FailSignUp", "Email address Already Exists");
            System.out.println("Returning from failure");
        }
        System.out.println(sessionMap);
        return result;

    }
    public String getAllVolunteers(){
        String result = "FAILURE";
        ArrayList volunteerList = VolunteerService.getInstance().getAllVolunteers();
        if(volunteerList!=null){
            result="SUCCESS";
            sessionMap.put("VolunteerList", volunteerList);
            System.out.println("VolunteerList updated");
        }
        return result;
    }
    public String editVolunteerForm() throws Exception {
        String result = "SUCCESS";
        Volunteer volunteerform = VolunteerService.getVolunteersbyId(this.emailAddress);
        System.out.println("email id : "+this.emailAddress);
        sessionMap.put("VolunteerForm", volunteerform);
        return result;
    }
     public String saveVolunteerStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = VolunteerService.ApproveVolunteerStatus(this.emailAddress);
        System.out.println(this.emailAddress);
        if (success){
        ArrayList volunteerList = VolunteerService.getInstance().getAllVolunteers();
        sessionMap.put("VolunteerList", volunteerList);
        System.out.println("returning Success from saveVolunteerStatus method");
        result = "SUCCESS";
    }
    else {
        System.out.println("returning Failure from saveVolunteerStatus method");
    }
    return result;
}
    
     public String deleteVolunteerStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = VolunteerService.RejectVolunteerStatus(this.emailAddress);
        System.out.println(this.emailAddress);
        if (success){
        ArrayList volunteerList = VolunteerService.getInstance().getAllVolunteers();
        sessionMap.put("VolunteerList", volunteerList);
        System.out.println("returning Success from deleteVolunteerStatus method");
        result = "SUCCESS";
    }
    else {
        System.out.println("returning Failure from deleteVolunteerStatus method");
    }
    return result;
}
}
