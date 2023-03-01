/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.AdminService;
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
 * @author Ayshik Palit
 */
public class Admin extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private int adminId, formId, status;
    private String adminName, emailAddress, password;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAdminId() {
        return adminId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String editMoneyForm() throws Exception {
        String result = "SUCCESS";
        DonateForm moneyform = AdminService.getMoneybyId(this.formId);
        sessionMap.put("MoneyForm", moneyform);
        return result;
    }

    public String editEssentialsForm() throws Exception {
        String result = "SUCCESS";
        ArrayList essentialsform = AdminService.getEssentialsbyId(this.formId);
        sessionMap.put("EssentialsForm", essentialsform);
        return result;
    }

    public String saveMoneyStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.ApproveDonateMoneyStatus(formId);
        System.out.println(this.formId);
        if (success){
        ArrayList moneyList = AdminService.getAllMoney();
        sessionMap.put("MoneyList", moneyList);
        System.out.println("returning Success from saveMoneyStatus method");
        result = "SUCCESS";
    }
    else {
        System.out.println("returning Failure from saveMoneyStatus method");
    }
    return result;
}
     public String deleteMoneyStatus() throws Exception {
        String result = "FAILURE";
        
        boolean success = AdminService.RejectDonateMoneyStatus(formId);
        System.out.println(this.formId);
        if (success){
        ArrayList moneyList = AdminService.getAllMoney();
        sessionMap.put("MoneyList", moneyList);
        System.out.println("returning Success from deleteMoneyStatus method");
        result = "SUCCESS";
    }
    else {
        System.out.println("returning Failure from deleteMoneyStatus method");
    }
    return result;
}

//    public String doUpdateDonateMoneyStatus() throws Exception {
//        String result = "REJECTED";
//        boolean success = AdminService.UpdateDonateMoneyStatus(this.getFormId(), this.getStatus());
//        if (success) {
//            System.out.println("Returning Success from doUpdateDonateMoneyStatus method");
//            if (Integer.parseInt(this.getStatus()) == 2) {
//                result = "APPROVED";
//            } else if (Integer.parseInt(this.getStatus()) == 4) {
//                result = "REJECTED";
//            }
//        } else {
//            System.out.println("Returning Failure from doUpdateDonateMoneyStatus method");
//        }
//
//        return result;
//    }
//    public String approveDonor() throws Exception {
//        String result = "PENDING";
//        boolean success = AdminService.approveDonor(this.getDonorId(), this.getStatus());
//        if (success) {
//            if (Integer.parseInt(this.getstatus()) == 1) {
//                result = "APPROVED";
//            } else {
//
//            }
//            return result;
//        }
}
