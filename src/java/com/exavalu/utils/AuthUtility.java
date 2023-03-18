/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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
            Logger log = Logger.getLogger(AuthUtility.class.getName());
            // TODO Auto-generated catch block
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + e.getMessage();
                log.error(errorMessage);
            }
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
