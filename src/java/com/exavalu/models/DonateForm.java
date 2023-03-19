/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.AdminService;
import com.exavalu.services.DonateService;
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
 * This class holds the functionality of the Donation contributed
 * @author Reetangsee Dutta
 */
@SuppressWarnings({"PMD.LiteralsFirstInComparisons","PMD.MethodNamingConventions","PMD.FormalParameterNamingConventions"})
public class DonateForm extends ActionSupport implements ApplicationAware, SessionAware, Serializable{

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
    
    private String formId;
    private String donorId;
    private String firstName;
    private String lastName;
    private String donorType;
    private String donorName;
    private String essentialName;
    private String eventId;
    private String eventName;
    private String eventTopic;
    private String status;
    private String amount;
    private String transactionId;
    private String phoneNumber;
    private String address;
    private String email;
    private String given_name;
    private String family_name;
    
    

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
     * Function to insert Payment details on donation into the database
     * @return SUCCESS only after checking whether the data have been successfully added to database
     */
    public String insertMoneyFormUser(){
        String result = "FAILURE";
        boolean success = false;
        if(donorType.equals("3")){
            success = DonateService.getInstance().insertMoneyForm(this);
            eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
            sessionMap.put("DonateForm", this);
            if (success) {
                result = "SUCCESS";
                //System.out.println("Payment Record Added to database");
                sessionMap.put("SuccessDonation", "Thank you for supporting us and our cause! We wish to see you soon!");
                sessionMap.put("ErrorDonation", "Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        }
        else{
            donorType = "1";
            boolean res = DonateService.getInstance().insertMoneyForm(this);
            eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
            sessionMap.put("DonateForm", this);
            if (res) {
                result = "SUCCESS";
                //System.out.println("Payment Record Added to database");
                sessionMap.put("SuccessDonation", "Thank you for supporting us and our cause! We wish to see you soon!");
                sessionMap.put("ErrorDonation", "Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        }
        
        return result;
    }

    /**
     *
     * @return
     */
    public String insertMoneyFormOrg(){
        String result = "FAILURE";
        donorType = "2";
        boolean res = DonateService.getInstance().insertMoneyForm(this);
        eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
        sessionMap.put("DonateForm", this);
        if(res){
            result="SUCCESS";
            //System.out.println("Payment Record Added to database");
            sessionMap.put("SuccessDonation","Thank you for supporting us and our cause! We wish to see you soon!");
            sessionMap.put("ErrorDonation","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String insertEssentialsFormUser(){
        String result = "FAILURE";
        boolean success = false;
        if(donorType.equals("3")){
            success = DonateService.getInstance().insertEssentialsForm(this);
            eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
            sessionMap.put("DonateForm", this);
            if(success){
            result="SUCCESS";
            //System.out.println("Essentials Record Added to database");
            sessionMap.put("SuccessEssentials","Thank you for supporting us and our cause! Our agent will be contacting you soon!");
            sessionMap.put("ErrorEssentials","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        }
        else{
            donorType = "1";
            boolean res = DonateService.getInstance().insertEssentialsForm(this);
            eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
            sessionMap.put("DonateForm", this);
            if(res){
            result="SUCCESS";
            //System.out.println("Essentials Record Added to database");
            sessionMap.put("SuccessEssentials","Thank you for supporting us and our cause! Our agent will be contacting you soon!");
            sessionMap.put("ErrorEssentials","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        }
        
        return result;
    }

    /**
     *
     * @return
     */
    public String insertEssentialsFormOrg(){
        String result = "FAILURE";
        donorType = "2";
        boolean res = DonateService.getInstance().insertEssentialsForm(this);
        eventTopic = DonateService.getInstance().getEventTopicById(this.eventId);
        sessionMap.put("DonateForm", this);
        if(res){
            result="SUCCESS";
            //System.out.println("Essentials Record Added to database");
            sessionMap.put("SuccessEssentials","Thank you for supporting us and our cause! Our agent will be contacting you soon!");
            sessionMap.put("ErrorEssentials","Thank you for supporting us but there is some error in the process! We wish you to try again!");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String updateStatusEssentials(){
        String result = "FAILURE";
        boolean res = DonateService.getInstance().setEssentialStatus(status,formId);
        if(res){
            result="SUCCESS";
            //System.out.println("Essentials Record Status updated with"+status);
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String updateStatusMoney(){
        String result = "FAILURE";
        boolean res = DonateService.getInstance().setPaymentStatus(status,formId);
        if(res){
            result="SUCCESS";
            //System.out.println("Payment Record Status updated with"+status);
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String getEvent(){
        String result = "FAILURE";
        Event event = DonateService.getInstance().getEventById(Integer.parseInt(eventId));
        
        if(event!=null){
            result="SUCCESS";
            sessionMap.put("Event", event);
            //System.out.println("Event updated");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String getAllEventsTable(){
        String result = "FAILURE";
        ArrayList eventList = DonateService.getInstance().getEvents();
        
        if(eventList!=null){
            result="SUCCESS";
            sessionMap.put("EventList", eventList);
            //System.out.println("EventList updated");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String getAllEvents(){
        String result = "FAILURE";
        ArrayList eventList = DonateService.getInstance().getApprovedEvents();
        
        if(eventList!=null){
            result="SUCCESS";
            sessionMap.put("EventList", eventList);
            //System.out.println("EventList updated");
        }
        return result;
    }

    /**
     *
     * @return
     */
    public String getAllFunds(){
        String result = "FAILURE";
        ArrayList moneyList = DonateService.getInstance().getMoney();
        if(moneyList!=null){
            result="SUCCESS";
            sessionMap.put("MoneyList", moneyList);
            //System.out.println("MoneyList updated");
        }
        return result;
    }
    
    public String getAllVolunteers(){
        String result = "FAILURE";
        ArrayList volunteerList = AdminService.getInstance().getAllVolunteers();
        if(volunteerList!=null){
            result="SUCCESS";
            sessionMap.put("VolunteerList", volunteerList);
            //System.out.println("Volunteer List updated");
        }
        return result;
    }
    

    /**
     *
     * @return
     */
    public String getAllEssentials(){
        String result = "FAILURE";
        ArrayList essentialsList = DonateService.getInstance().getEssentials();
        
        if(essentialsList!=null){
            result="SUCCESS";
            sessionMap.put("EssentialsList", essentialsList);
            //System.out.println("EssentialsList updated");
        }
        return result;
    }
    
    /**
     * @return the formId
     */
    public String getFormId() {
        return formId;
    }

    /**
     * @param formId the formId to set
     */
    public void setFormId(String formId) {
        this.formId = formId;
    }

    /**
     * @return the donorId
     */
    public String getDonorId() {
        return donorId;
    }

    /**
     * @param donorId the donorId to set
     */
    public void setDonorId(String donorId) {
        this.donorId = donorId;
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
     * @return the donorType
     */
    public String getDonorType() {
        return donorType;
    }

    /**
     * @param donorType the donorType to set
     */
    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    /**
     * @return the donorName
     */
    public String getDonorName() {
        return donorName;
    }

    /**
     * @param donorName the donorName to set
     */
    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    /**
     * @return the essentialName
     */
    public String getEssentialName() {
        return essentialName;
    }

    /**
     * @param essentialName the essentialName to set
     */
    public void setEssentialName(String essentialName) {
        this.essentialName = essentialName;
    }

    /**
     * @return the eventId
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * @param eventId the eventId to set
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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
     * @return the eventTopic
     */
    public String getEventTopic() {
        return eventTopic;
    }

    /**
     * @param eventTopic the eventTopic to set
     */
    public void setEventTopic(String eventTopic) {
        this.eventTopic = eventTopic;
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
    
}
