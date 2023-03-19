/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.APIUser;

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
 *
 * @author Azel Karthak
 */
public class APIService {

    public static APIService loginService = null;

    private APIService() {
    }

    public static APIService getInstance() {
        if (loginService == null) {
            return new APIService();
        } else {
            return loginService;
        }
    }

    public static APIUser consumeAadharFromAPI(String aadharNumber) throws ParseException, org.json.simple.parser.ParseException {

        APIUser apiUser = new APIUser();
        try {

            URL url = new URL("https://retoolapi.dev/EFub8v/data?aadharNumber=" + aadharNumber);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            } else {

                String inline = "";
                try (Scanner scanner = new Scanner(url.openStream())) {
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }

                    JSONParser parse = new JSONParser();
                    JSONArray jsonArray = (JSONArray) parse.parse(inline);
                    //JSONArray jsonArray = data_obj.getJSONArra("languages");
//                     System.out.println("Size of Json List"+jsonArray.size());
                    //for(int i = 0; i < jsonArray.size(); i++){

                    JSONObject obj = (JSONObject) jsonArray.get(0);
                    String id = obj.get("id").toString();
                    String city = obj.get("city").toString();
                    String name = obj.get("name").toString();
                    String gender = obj.get("gender").toString();
                    String voterId = obj.get("voterId").toString();
                    String dateOfBirth = obj.get("dateOfBirth").toString();
                    aadharNumber = obj.get("aadharNumber").toString();
                    String drivingLicence = obj.get("drivingLicence").toString();

//                        System.out.println("value"+voterId);
                    apiUser.setId(id);
                    apiUser.setCity(city);
                    apiUser.setName(name);
                    apiUser.setGender(gender);
                    apiUser.setVoterId(voterId);
                    apiUser.setDateOfBirth(dateOfBirth);
                    apiUser.setAadharNumber(aadharNumber);
                    apiUser.setDrivingLicence(drivingLicence);

                    //}
                }
            }

        } catch (MalformedURLException e) {

            Logger log = Logger.getLogger(APIService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + e.getMessage();
                log.error(errorMessage);
            }

        } catch (IOException e) {

            Logger log = Logger.getLogger(APIService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + e.getMessage();
                log.error(errorMessage);
            }

        }
        return apiUser;
    }

}
