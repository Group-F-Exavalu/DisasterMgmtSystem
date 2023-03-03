/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.AdminService;
import com.exavalu.services.DonateService;
import com.exavalu.services.LoginService;
import com.exavalu.services.SignupService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.log4j.Logger;

public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @param args the command line arguments
     */
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public static com.opensymphony.xwork2.util.logging.Logger getLOG() {
        return LOG;
    }

    public static void setLOG(com.opensymphony.xwork2.util.logging.Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    private String firstName;
    private String lastName;
    private String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    private String password, gender, phoneNumber, address, country, state, district, aadharNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public ApplicationMap getMap() {
        return map;
    }

    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

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

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean successUser = LoginService.getInstance().doLoginUser(this.emailAddress, this.password);
        boolean successOrg = LoginService.getInstance().doLoginOrganisation(this.emailAddress, this.password);
        boolean successAdmin = LoginService.getInstance().doLoginAdmin(this.emailAddress, this.password);

        User user = LoginService.getUser(emailAddress);
        System.out.println("User Phone :" + user.getPhoneNumber());
        Organisation organisation = LoginService.getOrganisation(emailAddress);
        ArrayList eventList = DonateService.getInstance().getApprovedEvents();
        ArrayList moneyList = DonateService.getInstance().getMoney();
        ArrayList essentialList = DonateService.getInstance().getEssentials();
        ArrayList volunteerList = AdminService.getInstance().getAllVolunteers();
        ArrayList userList = LoginService.getAllUser();

        if (successUser) {
            System.out.println("returning Success from doLoginUser method");
            sessionMap.put("Loggedin", this);
            sessionMap.put("LoggedinStatus", "user");
            sessionMap.put("User", user);
            sessionMap.put("EventList", eventList);
            sessionMap.put("UserList", userList);
            result = "USER";
        } else if (successOrg) {
            System.out.println("returning Success from doLoginOrganization method");
            sessionMap.put("Loggedin", this);
            sessionMap.put("LoggedinStatus", "org");
            sessionMap.put("Organisation", organisation);
            sessionMap.put("EventList", eventList);
            result = "ORG";
        } else if (successAdmin) {
            System.out.println("returning Success from doLoginAdmin method");
            sessionMap.put("Loggedin", this);
            String revenue = AdminService.getTotalDonation();
            String totalUsers = AdminService.getTotalUsers();
            String totalOrgs = AdminService.getTotalOrganisations();
            String totalVolunteers = AdminService.getTotalVolunteers();
            Admin admin = AdminService.getAdminDetails(emailAddress);
            sessionMap.put("LoggedinStatus", "admin");

            sessionMap.put("MoneyList", moneyList);
            sessionMap.put("EssentialList", essentialList);
            sessionMap.put("VolunteerList", volunteerList);
            sessionMap.put("Revenue", revenue);
            sessionMap.put("TotalUsers", totalUsers);
            sessionMap.put("TotalOrgs", totalOrgs);
            sessionMap.put("TotalVolunteers", totalVolunteers);
            sessionMap.put("Admin", admin);

            result = "ADMIN";
        } else {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now() + "--Wrong email ID or password");
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    public String doSignUp() throws Exception {

        String result = "FAILURE";
        boolean success1 = SignupService.getInstance().doCheckUser(this.emailAddress);
        
        System.out.println("email address baba:  "+emailAddress);
        if (!success1) {           
            boolean success = SignupService.getInstance().doSignupUser(this);
            
            
            if (success) {
                sessionMap.put("SuccessSignUp", "Successfully Registered");
                System.out.println("Returning from success");
                result = "SUCCESS";
            } else {
                Logger log = Logger.getLogger(LoginService.class.getName());
                log.error(LocalDateTime.now() + "--Email Id already exists");
                sessionMap.put("FailSignUp", "Email address Already Exists");
                System.out.println("Returning from failure");
            }
            
        } else if(success1) {
           result = "FAILURE"; 
        }
        System.out.println(sessionMap);
        return result;

    }

    public String doPreSignUp() throws Exception {
        sessionMap.clear();
        String result = "SUCCESS";
        //check all data and submit
        ArrayList countryList = LoginService.getInstance().getAllCountries();
        System.err.println("country list: " + countryList);
        ArrayList stateList = null;
        ArrayList distList = null;
        sessionMap.put("CountryList", countryList);
        System.out.println("countries are" + this.country);
        System.out.println("States are" + this.state);

        if (this.country != null) {
            stateList = LoginService.getInstance().getAllStates(this.country);
            System.err.println("Country is: " + this.country);
            sessionMap.put("StateList", stateList);
            sessionMap.put("User", this);
            result = "STATELIST";
        }
        if (this.state != null) {
            distList = LoginService.getInstance().getAllDistricts(this.state);
            sessionMap.put("DistList", distList);
            sessionMap.put("User", this);
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

    public String doLogout() {
        String result = "SUCCESS";
        sessionMap.clear();
        return result;
    }

//    public String apiCall() throws Exception {
//        String result = "SUCCESS";
//        ArrayList userList = ApiService.getInstance().getAllData();
//        boolean success = LoginService.getInstance().doSignUpAll(userList);
//
//        if (success) {
//            result = "SUCCESS";
//            sessionMap.put("SuccessSignUp", "Successfully Registered");
//
//        } else {
//            sessionMap.put("FailSignUp", "Email All Ready Exsists");
//        }
//        System.out.println(sessionMap);
//        return result;
//
//    }
    /**
     * @return the aadharNumber
     */
    public String getAadharNumber() {
        return aadharNumber;
    }

    /**
     * @param aadharNumber the aadharNumber to set
     */
    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String doSave() throws Exception {
        String res = "FAILURE";
        boolean result = LoginService.updateUser(this);
        User user = LoginService.getUser(emailAddress);

        if (result) {
            sessionMap.put("User", user);
            res = "SUCCESS";
        } else {
//           sessionMap.put("UserList", userList);
        }
        return res;
    }
}
