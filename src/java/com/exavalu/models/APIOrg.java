/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.APIOrgService;
import com.exavalu.services.APIService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Preyangsee
 */
public class APIOrg extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    
    private String nameOfOrganisation;
    private String nameOfPresident;
    private String numberOfMembers;
    private String phoneNumber;
    private String address;
    private String validTill;
    private String registrationNumber;
    private String id;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
    
    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    /**
     * @return the nameOfOrganisation
     */
    public String getNameOfOrganisation() {
        return nameOfOrganisation;
    }

    /**
     * @param nameOfOrganisation the nameOfOrganisation to set
     */
    public void setNameOfOrganisation(String nameOfOrganisation) {
        this.nameOfOrganisation = nameOfOrganisation;
    }

    /**
     * @return the nameOfPresident
     */
    public String getNameOfPresident() {
        return nameOfPresident;
    }

    /**
     * @param nameOfPresident the nameOfPresident to set
     */
    public void setNameOfPresident(String nameOfPresident) {
        this.nameOfPresident = nameOfPresident;
    }

    /**
     * @return the numberOfMembers
     */
    public String getNumberOfMembers() {
        return numberOfMembers;
    }

    /**
     * @param numberOfMembers the numberOfMembers to set
     */
    public void setNumberOfMembers(String numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the validTill
     */
    public String getValidTill() {
        return validTill;
    }

    /**
     * @param validTill the validTill to set
     */
    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    public String getOrgData() throws ParseException, freemarker.core.ParseException, JSONException{
        String result = "FAILURE";
        APIOrg apiOrg = APIOrgService.consumeOrgFromAPI(this.registrationNumber);
        //APIUser apiUser = new APIUser();
        //boolean res = APIService.insertDataInDB(apiUsers);
        //if(!apiUsers.isEmpty()){
            System.out.println("Iam +"+ apiOrg.getId());
            System.out.println("Iam +"+ apiOrg.getRegistrationNumber());
            System.out.println("Iam +"+ apiOrg.getValidTill());
            
            //String successMsg = "Entered API Data into Database!";
            sessionMap.put("APIOrg", apiOrg);
            result = "SUCCESS";
           // getSessionMap().put("APIUser", apiUser);
         
        
        return result;
    }
  
}
