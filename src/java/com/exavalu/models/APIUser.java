package com.exavalu.models;


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
 * @author Avijit Chattopadhyay
 */
public class APIUser extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    
    
    private String id,city,name,gender,voterId,dateOfBirth,aadharNumber,drivingLicence;
    private int formId;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

   

  

   

   

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    /**
     * @param stateName the stateName to set
     *
     *
     * /
     **
     * @param districtName the districtName to set
     *
     * /
     **
     * @return the sessionMap
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
     * @return the driverLiscenceNo
     */
    
    /**
     * @return the status
     * @throws org.json.simple.parser.ParseException
     * @throws freemarker.core.ParseException
     * @throws org.json.JSONException
     */
    

  public String getAdharData() throws ParseException, freemarker.core.ParseException, JSONException{
        String result = "FAILURE";
        APIUser apiUsers = APIService.consumeAadharFromAPI(this.aadharNumber);
        //APIUser apiUser = new APIUser();
        //boolean res = APIService.insertDataInDB(apiUsers);
        //if(!apiUsers.isEmpty()){
            System.out.println("Iam"+ apiUsers.getId());
            System.out.println("Iam"+ apiUsers.getAadharNumber());
            System.out.println("Iam"+ apiUsers.getDrivingLicence());
            
            //String successMsg = "Entered API Data into Database!";
            getSessionMap().put("APIUsers", apiUsers);
            result = "SUCCESS";
           // getSessionMap().put("APIUser", apiUser);
         
        
        return result;
    }
  

    
    


}