/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exavalu.models;

import com.exavalu.services.DonateService;
import com.exavalu.services.LoginService;
import com.exavalu.services.SignupService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * This class holds the functionality regarding the Organization Entity and its interaction with the application
 * @author Azel Karthak
 */
public class Organisation extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    private int organisationId;
    private String organisationName; 
    private String regnNumber;
    private String country;
    private String countryName;
    private String stateName;
    private String districtName;
    private String state; 
    private String district;
    private String emailAddress;
    
    /**
     *
     * @return
     */
    public int getOrganisationId() {
        return organisationId;
    }

    /**
     *
     * @param organisationId
     */
    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    /**
     *
     * @return
     */
    public String getOrganisationName() {
        return organisationName;
    }

    /**
     *
     * @param organisationName
     */
    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    /**
     *
     * @return
     */
    public String getRegnNumber() {
        return regnNumber;
    }

    /**
     *
     * @param regnNumber
     */
    public void setRegnNumber(String regnNumber) {
        this.regnNumber = regnNumber;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getDistrict() {
        return district;
    }

    /**
     *
     * @param district
     */
    public void setDistrict(String district) {
        this.district = district;
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
   private String password; 
                                 
     
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    /**
     *
     * @param application
     */
    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    /**
     *
     * @param session
     */
    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    /**
     *
     * @return
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

    /**
     * @return the vehicleNumber
     * @throws java.lang.Exception
     */
    
    public String doSignUpOrg() throws Exception {

        String result = "FAILURE";
        boolean success = SignupService.getInstance().doSignupOrg(this);

        if (success) {            
            sessionMap.put("SuccessSignUp", "Successfully Registered");
            //System.out.println("Returning from success");
            result = "SUCCESS";
        } else {
            Logger log = Logger.getLogger(LoginService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: --Email Id already exists";
                log.error(errorMessage);
            }
            sessionMap.put("FailSignUp", "Email address Already Exists");
            //System.out.println("Returning from failure");
            String errorMsg ="You are Already Registered with us. Please try to Login";
            getSessionMap().put("ErrorMsg", errorMsg);
        }
        //System.out.println(sessionMap);
        return result;

    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String doPreSignUp() throws Exception {
        sessionMap.clear();
        String result = "SUCCESS";
        //check all data and submit
        ArrayList countryList = LoginService.getInstance().getAllCountries();
        //System.err.println("country list: "+countryList);
        ArrayList stateList = null;
        ArrayList distList = null;
        sessionMap.put("CountryList", countryList);
//        System.out.println("countries are" + this.country);
//        System.out.println("States are" + this.state);

        if (this.country != null) {
            stateList = LoginService.getInstance().getAllStates(this.country);
            //System.err.println("Country is: "+this.country);
            sessionMap.put("StateList", stateList);
            sessionMap.put("Organisation", this);
            result = "STATELIST";
        }
        if (this.state != null) {
            distList = LoginService.getInstance().getAllDistricts(this.state);
            sessionMap.put("DistList", distList);
            sessionMap.put("Organisation", this);
            result = "DISTLIST";
        }

//        if (this.firstName != null && this.firstName.length() > 0 && this.lastName != null && this.lastName.length() > 0 && this.emailAddess != null && this.emailAddess.length() > 0 && this.password != null && this.password.length() > 0 && this.stateCode != null && this.stateCode.length() > 0 && this.countryCode != null && this.countryCode.length() > 0 && this.distCode != null && this.distCode.length() > 0 && this.phoneNumber != null && this.phoneNumber.length() > 0 && this.addressLine1 != null && this.addressLine1.length() > 0 && this.addressLine2 != null && this.addressLine2.length() > 0) {
//            result = this.doSignUp();
//
//            System.out.println(sessionMap);
//
//        }

        return result;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        String result = "FAILURE";

        ArrayList orgStatusMoneyList = DonateService.getInstance().getOrgStatusMoneyList(organisationId);
        ArrayList orgStatusEssentialList = DonateService.getInstance().getOrgStatusEssentialList(organisationId);
        //System.out.println(this.organisationId);
        sessionMap.put("MoneyOrgStatus",orgStatusMoneyList);
        sessionMap.put("EssentialOrgStatus",orgStatusEssentialList);
        result = "SUCCESS";
        return result;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}