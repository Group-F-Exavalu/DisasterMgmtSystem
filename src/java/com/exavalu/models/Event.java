/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DonateService;
import com.exavalu.services.SupportService;

/**
 *
 * @author Preyangsee
 */
public class Event {
    
    private String eventId;
    private String eventTopic;
    private String eventDetails;
    private String status;

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
     * @return the eventDetails
     */
    public String getEventDetails() {
        return eventDetails;
    }

    /**
     * @param eventDetails the eventDetails to set
     */
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
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
    public String insertEventUser(){
        String result = "FAILURE";
        
        boolean res = SupportService.getInstance().insertEvents(this);
        if(res){
            result="SUCCESS";
            System.out.println("Events submitted");
        }
        return result;
    }
    public String insertEventOrg(){
        String result = "FAILURE";
        boolean res = SupportService.getInstance().insertEvents(this);
        if(res){
            result="SUCCESS";
            System.out.println("Events submitted");
        }
        return result;
    }
}
