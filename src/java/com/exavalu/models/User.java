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
import java.io.File;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.log4j.Logger;

/**
 * This class hold all the functionality regarding the USER entity and its interaction with the application
 * @author Debjit Das
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    
    private int userId;

    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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
    public static com.opensymphony.xwork2.util.logging.Logger getLOG() {
        return LOG;
    }

    /**
     *
     * @param LOG
     */
    public static void setLOG(com.opensymphony.xwork2.util.logging.Logger LOG) {
        ActionSupport.LOG = LOG;
    }
    private String firstName;
    private String lastName;
    private String emailAddress, date;

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
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
    private String password, gender, phoneNumber, address, country, state, district, aadharNumber;

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     *
     * @param sessionMap
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     *
     * @return
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     *
     * @param map
     */
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

    private File image; //(create getter setter)
    private String imageData;

    /**
     *
     * @return
     */
    public File getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(File image) {
        this.image = image;
    }

    /**
     *
     * @param imageData
     */
    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    /**
     *
     * @return
     */
    public String getImageData() {
        return imageData;
    }

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
     * @throws Exception
     */
    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean successUser = LoginService.getInstance().doLoginUser(this.emailAddress, this.password);
        boolean successOrg = LoginService.getInstance().doLoginOrganisation(this.emailAddress, this.password);
        boolean successAdmin = LoginService.getInstance().doLoginAdmin(this.emailAddress, this.password);

        User user = LoginService.getUser(emailAddress);
        this.userId=user.getUserId();
//        ArrayList userStatusMoneyList = DonateService.getInstance().getUserStatusMoneyList(user.getUserId());
//        ArrayList userStatusEssentialList = DonateService.getInstance().getUserStatusEssentialList(user.getUserId());
        System.out.println("User Phone :" + user.getPhoneNumber());
        Organisation organisation = LoginService.getOrganisation(emailAddress);
        
        ArrayList eventList = DonateService.getInstance().getApprovedEvents();
        ArrayList moneyList = DonateService.getInstance().getMoney();
        ArrayList essentialList = DonateService.getInstance().getEssentials();
        ArrayList volunteerList = AdminService.getInstance().getAllVolunteers();
        ArrayList userList = LoginService.getAllUser();
        ArrayList dateList = AdminService.getAllDates();
        ArrayList dateCountList = AdminService.getAllDatesCount();
//        ArrayList newDateList = new ArrayList(dateList.size());
//        for(int i=0;i<dateList.size();i++)
//        {
//            newDateList.get(i)=new Date(dateList.get(i));
//            
//        }

        if (successUser) {
            System.out.println("returning Success from doLoginUser method");
            sessionMap.put("Loggedin", this);
            sessionMap.put("LoggedinStatus", "user");
            sessionMap.put("User", user);
//            sessionMap.put("MoneyStatus",userStatusMoneyList);
//            sessionMap.put("EssentialStatus",userStatusEssentialList);
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
            double revenueInt = Double.parseDouble(AdminService.getTotalDonation());
            double userDonation = Double.parseDouble(AdminService.getTotalUserDonation());
            double orgDonation = Double.parseDouble(AdminService.getTotalOrgDonation());
            double userPercent = Math.round((userDonation / revenueInt) * 100);
            double orgPercent = 100 - userPercent;

            System.out.println("revenue Int  " + revenueInt);
            System.out.println("user Donation  " + userDonation);
            System.out.println("org Donation  " + orgDonation);
            System.out.println("User Percentage  " + userPercent);
            System.out.println("Org Percentage  " + orgPercent);
            System.out.println("Date List  " + dateList);
            System.out.println("Date Count List  " + dateCountList);

            String totalUsers = AdminService.getTotalUsers();
            String totalOrgs = AdminService.getTotalOrganisations();
            String totalVolunteers = AdminService.getTotalVolunteers();
            Admin admin = AdminService.getAdminDetails(emailAddress);

            sessionMap.put("LoggedinStatus", "admin");

            sessionMap.put("MoneyList", moneyList);
            sessionMap.put("EssentialList", essentialList);
            sessionMap.put("VolunteerList", volunteerList);
            sessionMap.put("DateList", dateList);
            sessionMap.put("DateCountList", dateCountList);
            sessionMap.put("Revenue", revenue);
            sessionMap.put("UserPercent", userPercent);
            sessionMap.put("OrgPercent", orgPercent);
            sessionMap.put("TotalUsers", totalUsers);
            sessionMap.put("TotalOrgs", totalOrgs);
            sessionMap.put("TotalVolunteers", totalVolunteers);
            sessionMap.put("Admin", admin);

            result = "ADMIN";
        } else {
            Logger log = Logger.getLogger(LoginService.class.getName());
            log.error(LocalDateTime.now() + "--Wrong email ID or password");
            System.out.println("returning Failure from doLogin method");
            String errorMsg ="Either Email Address or Password is Wrong. Please Try Again !!";
            getSessionMap().put("ErrorMsg", errorMsg);
        }

        return result;
    }

    /**
     *
     * @return
     */
    public String getStatus(){
        String result = "FAILURE";
        
        ArrayList userStatusMoneyList = DonateService.getInstance().getUserStatusMoneyList(this.userId);
        ArrayList userStatusEssentialList = DonateService.getInstance().getUserStatusEssentialList(userId);
        System.out.println(this.userId);
        sessionMap.put("MoneyStatus",userStatusMoneyList);
        sessionMap.put("EssentialStatus",userStatusEssentialList);
        result = "SUCCESS";
        return result;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String doSignUp() throws Exception {

        String result = "FAILURE";
        boolean success1 = SignupService.getInstance().doCheckUser(this.emailAddress);

        System.out.println("email address baba:  " + emailAddress);
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

        } else if (success1) {
            result = "FAILURE";

            String errorMsg ="You are Already Registered with us. Please try to Login";
            getSessionMap().put("ErrorMsg", errorMsg);
        }
        System.out.println(sessionMap);
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

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     * @throws Exception
     */
    public String doSave() throws Exception {
        String res = "FAILURE";
//        boolean result = LoginService.updateUser(this);
        boolean result = false;
        if (this.image!=null){
                result = LoginService.updateUser(this);
        }
        else{
            result = LoginService.updateUserWithoutImage(this);
        }      
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
