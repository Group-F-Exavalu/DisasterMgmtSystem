/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.SupportService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Preyangsee
 */
public class Event extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String eventId;
    private String userId;
    private String eventTopic;
    private String eventDetails;
    private String status;

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

    public String insertEventUser() {
        String result = "FAILURE";

        boolean res = SupportService.getInstance().insertEvents(this);
        if (res) {
            result = "SUCCESS";
            System.out.println("Events submitted");
        }
        return result;
    }

    public String insertEventOrg() {
        String result = "FAILURE";
        boolean res = SupportService.getInstance().insertEvents(this);
        if (res) {
            result = "SUCCESS";
            System.out.println("Events submitted");
        }
        return result;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
