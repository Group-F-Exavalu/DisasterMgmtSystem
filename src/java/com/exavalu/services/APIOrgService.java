/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.APIOrg;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Scanner;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This Service is responsible for fetching REST API for Data Validation
 * @author Reetangsee Dutta
 */
public class APIOrgService {

    
    public static APIOrg consumeOrgFromAPI(String registrationNumber) throws ParseException {
        //System.out.println("test"+registrationNumber);
         
        APIOrg apiOrg = new APIOrg();
         try {

		URL url = new URL("https://63f733f1833c7c9c607ebe72.mockapi.io/api/project/orgs?RegistrationNumber="+registrationNumber);
               
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
                else{
                    
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());
                    while(scanner.hasNext()){
                        inline += scanner.nextLine();
                    }
                    scanner.close();
                    JSONParser parse = new JSONParser();
                    JSONArray jsonArray = (JSONArray)parse.parse(inline);
                    //JSONArray jsonArray = data_obj.getJSONArra("languages");
          //           System.out.println("Size of Json List"+jsonArray.size());
                    //for(int i = 0; i < jsonArray.size(); i++){
                        
                        
                    JSONObject obj = (JSONObject) jsonArray.get(0);
                    String id = obj.get("Id").toString();
                    String nameOfPresident = obj.get("NameOfPresident").toString();
                    String nameOfOrganisation = obj.get("NameOfOrganisation").toString();
                    String numberOfMembers = obj.get("NumberOfMembers").toString();
                    String phoneNumber = obj.get("PhoneNumber").toString();
                    String address = obj.get("Address").toString();
                    String rgnNumber = obj.get("RegistrationNumber").toString();
                    String validTill = obj.get("ValidTill").toString();
                        
                    //System.out.println("value" + address);

                    apiOrg.setId(id);
                    apiOrg.setAddress(address);
                    apiOrg.setNameOfOrganisation(nameOfOrganisation);
                    apiOrg.setNameOfPresident(nameOfPresident);
                    apiOrg.setNumberOfMembers(numberOfMembers);
                    apiOrg.setPhoneNumber(phoneNumber);
                    apiOrg.setRegistrationNumber(rgnNumber);
                    apiOrg.setValidTill(validTill);
                    scanner.close();
                    //}
                   
                    //System.out.println("set everything with api org");
                }
                 

	  } catch (MalformedURLException e) {

            Logger log = Logger.getLogger(APIOrgService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + e.getMessage();
                log.error(errorMessage);
            }

	  } catch (IOException e) {

            Logger log = Logger.getLogger(APIOrgService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + e.getMessage();
                log.error(errorMessage);
            }

	  }
          return apiOrg;
	}
    }
    
