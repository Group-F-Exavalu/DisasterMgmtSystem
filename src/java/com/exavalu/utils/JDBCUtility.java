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
 * This class access the value of authentication credentials for DataBase
 * connection
 *
 * @author Raktim Ghosal
 */
public class JDBCUtility {

    public static JDBCUtility jdbcUtility = null;

    // in this class we will have static methods to get the connection params
    public String getPropertyValue(String param) {

        String value = null;

        //input = getClass().getResourceAsStream("settings.properties"); // Property file path in classpath
        try {

            String path = JDBCUtility.class.getClassLoader().getResource("settings.properties").getPath();

            try (BufferedReader input = new BufferedReader(new FileReader(path))) {

                Properties prop = new Properties();

                prop.load(input);

                value = prop.getProperty(param);

            }
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            Logger log = Logger.getLogger(JDBCUtility.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }

        return value;
    }

    private JDBCUtility() {
        // Private constructor
    }

    public static JDBCUtility getInstanceOfJDBCUtility() {
        if (jdbcUtility == null) {
            jdbcUtility = new JDBCUtility();
        }
        return jdbcUtility;
    }

}
