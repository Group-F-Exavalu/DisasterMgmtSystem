/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DonateService;
import com.exavalu.services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *  This class stores the functionality for users who are sign in with Gmail feature and its interaction with the application
 * @author Raktim Ghosal
 */
@SuppressWarnings({"PMD.MethodNamingConventions","PMD.FormalParameterNamingConventions"})
public class GmailUser extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String sub;
    private String firstName;
    private String lastName;
    private String given_name;
    private String family_name;
    private String email;
    private String picture;

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
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
     * @return the id
     */
//    public String getId() {
//        return id;
//    }
//
//    /**
//     * @param id the id to set
//     */
//    public void setId(String id) {
//        this.id = id;
//    }
    /**
     * @return the given_name
     */
    public String getGiven_name() {
        return given_name;
    }

    /**
     * @param given_name the given_name to set
     */
    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    /**
     * @return the family_name
     */
    public String getFamily_name() {
        return family_name;
    }

    /**
     * @param family_name the family_name to set
     */
    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String gmailLogin() {
        String result = "FAILURE";
//        boolean success= false;

        boolean success = LoginService.getInstance().doGmailLoginUser(this.sub, this.email);

        GmailUser guser = LoginService.getGmailUser(this.sub);
        ArrayList eventList = DonateService.getInstance().getApprovedEvents();
        
//        GmailUser guser = LoginService.getGmailUser(email);
        if (success) {
            sessionMap.put("Loggedin", this);
            sessionMap.put("LoggedinStatus", "GmailUser");
            sessionMap.put("GmailUser", guser);
            
            sessionMap.put("EventList", eventList);
            
            result = "GMAILUSER";
        } else if (success == false) {
            boolean successInsert = LoginService.getInstance().insertGmailUser(this);
            if (successInsert) {
                sessionMap.put("Loggedin", this);
                sessionMap.put("LoggedinStatus", "user");
                sessionMap.put("GmailUser", guser);
                sessionMap.put("EventList", eventList);
                result = "GMAILUSER";
            }
        }
//        System.out.println(this.sub);
//        System.out.println(this.email);
//        System.out.println(this.family_name);
//        System.out.println(this.given_name);
//        System.out.println(this.picture);
//        System.out.println(this.);
        //System.out.println("the result is: " + result);
        return result;

    }

    /**
     *
     * @return
     */
    public String getStatus() {
        String result = "FAILURE";
        ArrayList gUserStatusMoneyList = DonateService.getInstance().getGUserStatusMoneyList(email);
        ArrayList gUserStatusEssentialList = DonateService.getInstance().getGUserStatusEssentialList(email);
        //System.out.println(this.email);
        sessionMap.put("MoneyStatus",gUserStatusMoneyList);
        sessionMap.put("EssentialStatus",gUserStatusEssentialList);
        result = "SUCCESS";
        return result;
    }
    /**
     * @return the sub
     */
    public String getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(String sub) {
        this.sub = sub;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

}
