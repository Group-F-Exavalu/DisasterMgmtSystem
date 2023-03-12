/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This class access the value of authentication credentials for Gmail Credentials
 * @author Raktim Ghosal
 */
public class AuthUtility {
    
    public static AuthUtility authUtility = null;
    
    public String getPropertyValue(String param) {

        String value = null;

        //input = getClass().getResourceAsStream("settings.properties"); // Property file path in classpath
        try {

            String path = AuthUtility.class.getClassLoader().getResource("GmailLog.properties").getPath();

            BufferedReader input = new BufferedReader(new FileReader(path));

            Properties prop = new Properties();

            prop.load(input);

            value = prop.getProperty(param);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return value;
    }

    private AuthUtility() {
        // Private constructor
    }

    public static AuthUtility getInstanceOfAuthUtility() {
        if (authUtility == null) {
            authUtility = new AuthUtility();
        }
        return authUtility;
    }
    
}
