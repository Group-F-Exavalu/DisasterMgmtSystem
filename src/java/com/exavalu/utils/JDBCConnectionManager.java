package com.exavalu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *  This class establishes connection between the JAVA Environment and DataBase
 * @author Raktim Ghosal
 */
public class JDBCConnectionManager {

    public static JDBCConnectionManager connectionManager = null;
    

    public static Connection getConnection() {
        Connection connection = null;

        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();

        String user = jdbcUtility.getPropertyValue("user");
        String password = jdbcUtility.getPropertyValue("pass");
        String dbNname = jdbcUtility.getPropertyValue("dbNname");
        String url = jdbcUtility.getPropertyValue("url");
        
        //System.out.println("URL ="+url);

        try {

            if (connection == null) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        url + dbNname, user, password);

            }

        } catch (ClassNotFoundException | SQLException ex) {

            Logger log = Logger.getLogger(JDBCConnectionManager.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now()+ " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }

        return connection;
    }

}
