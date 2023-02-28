/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

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
 *
 * @author Preyangsee
 */
public class DonateForm extends ActionSupport implements ApplicationAware, SessionAware, Serializable{
    
    private String formId;
    private String donorId;
    private String firstName;
    private String lastName;
    private String donorType;
    private String donorName;
    private String essentialName;
    private String eventId;
    private String eventName;
    private String status;
    private String amount;

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
    public String insertMoneyFormUser(){
        String result = "FAILURE";
        donorType = "1";
        boolean res = DonateService.getInstance().insertMoneyForm(this);
        if(res){
            result="SUCCESS";
            System.out.println("Payment Record Added to database");
            sessionMap.put("SuccessDonation","Thank you for supporting us and our cause! We wish to see you soon!");
            sessionMap.put("ErrorDonation","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        return result;
    }
    public String insertMoneyFormOrg(){
        String result = "FAILURE";
        donorType = "2";
        boolean res = DonateService.getInstance().insertMoneyForm(this);
        if(res){
            result="SUCCESS";
            System.out.println("Payment Record Added to database");
            sessionMap.put("SuccessDonation","Thank you for supporting us and our cause! We wish to see you soon!");
            sessionMap.put("ErrorDonation","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        return result;
    }
    public String insertEssentialsFormUser(){
        String result = "FAILURE";
        donorType = "1";
        boolean res = DonateService.getInstance().insertEssentialsForm(this);
        if(res){
            result="SUCCESS";
            System.out.println("Essentials Record Added to database");
            sessionMap.put("SuccessEssentials","Thank you for supporting us and our cause! Our agent will be contacting you soon!");
            sessionMap.put("ErrorEssentials","Thank you for supporting us but there is some error in the payment process! We wish you to try again!");
        }
        return result;
    }
    public String insertEssentialsFormOrg(){
        String result = "FAILURE";
        donorType = "2";
        boolean res = DonateService.getInstance().insertEssentialsForm(this);
        if(res){
            result="SUCCESS";
            System.out.println("Essentials Record Added to database");
            sessionMap.put("SuccessEssentials","Thank you for supporting us and our cause! Our agent will be contacting you soon!");
            sessionMap.put("ErrorEssentials","Thank you for supporting us but there is some error in the process! We wish you to try again!");
        }
        return result;
    }
    public String updateStatusEssentials(){
        String result = "FAILURE";
        boolean res = DonateService.getInstance().setEssentialStatus(status,formId);
        if(res){
            result="SUCCESS";
            System.out.println("Essentials Record Status updated with"+status);
        }
        return result;
    }
    public String updateStatusMoney(){
        String result = "FAILURE";
        boolean res = DonateService.getInstance().setPaymentStatus(status,formId);
        if(res){
            result="SUCCESS";
            System.out.println("Payment Record Status updated with"+status);
        }
        return result;
    }
    public String getEvent(){
        String result = "FAILURE";
        Event event = DonateService.getInstance().getEventById(eventId);
        
        if(event!=null){
            result="SUCCESS";
            sessionMap.put("Event", event);
            System.out.println("Event updated");
        }
        return result;
    }
    public String getAllEvents(){
        String result = "FAILURE";
        ArrayList eventList = DonateService.getInstance().getEvents();
        
        if(eventList!=null){
            result="SUCCESS";
            sessionMap.put("EventList", eventList);
            System.out.println("EventList updated");
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
    
}
