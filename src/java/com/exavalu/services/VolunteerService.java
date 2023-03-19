/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Volunteer;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This class serves as the connection between the JAVA Environment and DataBase
 * for Volunteer entity Interaction
 *
 * @author Azel Karthak
 */
@SuppressWarnings({"PMD.MethodNamingConventions","PMD.LooseCoupling","PMD.SingletonClassReturningNewInstance"})
public class VolunteerService {

    public static VolunteerService userService = null;

    public static VolunteerService getInstance() {
        if (userService == null) {
            return new VolunteerService();
        } else {
            return userService;
        }
    }

    public boolean beVolunteerInput(Volunteer user) {

        boolean result = false;
        try (Connection con = JDBCConnectionManager.getConnection()) {

            String sql = "INSERT INTO volunteer(emailAddress,volunteerName,message,phoneNumber,aadharNumber)" + "VALUES(? ,? ,?,?,?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getEmailAddress());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getMesssage());
                preparedStatement.setString(4, user.getPhoneNumber());
                preparedStatement.setString(5, user.getAadharNumber());

                int row = preparedStatement.executeUpdate();

                if (row == 1) {
                    result = true;
                }
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(VolunteerService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }
        return result;
    }

    public ArrayList<Volunteer> getAllVolunteers() {
        ArrayList volunteerList = new ArrayList();
        String sql = "SELECT * FROM volunteer;";
        try (Connection con = JDBCConnectionManager.getConnection()) {

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        Volunteer volunteer = new Volunteer();

                        volunteer.setPhoneNumber(rs.getString("phoneNumber"));
                        volunteer.setAadharNumber(rs.getString("aadharNumber"));
                        volunteer.setEmailAddress(rs.getString("emailAddress"));
                        volunteer.setName(rs.getString("volunteerName"));
                        volunteer.setMesssage(rs.getString("message"));
                        volunteer.setStatus(rs.getInt("status"));
                        volunteerList.add(volunteer);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(VolunteerService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }
        //System.err.println("Total rows:"+volunteerList.size());
        return volunteerList;
    }

    public static Volunteer getVolunteersbyId(String emailAddress) {
        Volunteer volunteer = new Volunteer();
        String sql = "Select * from volunteer where emailAddress=?";
        try (Connection con = JDBCConnectionManager.getConnection()) {

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, emailAddress);
                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {

                        volunteer.setEmailAddress(rs.getString("emailAddress"));
                        volunteer.setName(rs.getString("volunteerName"));
                        volunteer.setMesssage(rs.getString("message"));
                        volunteer.setPhoneNumber(rs.getString("phoneNumber"));
                        volunteer.setAadharNumber(rs.getString("aadharNumber"));
                        volunteer.setStatus(rs.getInt("status"));

                    }
                }
            }

        } catch (SQLException ex) {
            Logger log = Logger.getLogger(VolunteerService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
//            Logger log = Logger.getLogger(VolunteerService.class.getName());
//            log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());
        }

        return volunteer;
    }

    public static boolean ApproveVolunteerStatus(String emailAddress) {
        boolean result = false;
        try (Connection con = JDBCConnectionManager.getConnection()) {

            String sql = "UPDATE volunteer SET status = ? WHERE emailAddress = ?;";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, emailAddress);

                int row = preparedStatement.executeUpdate();
                if (row == 1) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
//           Logger log = Logger.getLogger(VolunteerService.class.getName());
//            log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());
            Logger log = Logger.getLogger(VolunteerService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
        }

        return result;
    }

    public static boolean RejectVolunteerStatus(String emailAddress) {
        boolean result = false;
        try (Connection con = JDBCConnectionManager.getConnection()) {

            String sql = "UPDATE volunteer SET status = ? WHERE emailAddress = ?;";

            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setInt(1, -1);
                preparedStatement.setString(2, emailAddress);

                int row = preparedStatement.executeUpdate();
                if (row == 1) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            Logger log = Logger.getLogger(VolunteerService.class.getName());
            if (log.isEnabledFor(Level.ERROR)) {
                String errorMessage = LocalDateTime.now() + " Error Code: " + ex.getErrorCode() + " Error Message: " + ex.getMessage();
                log.error(errorMessage);
            }
//           Logger log = Logger.getLogger(VolunteerService.class.getName());
//            log.error(LocalDateTime.now()+ " Error Code: " + ex.getErrorCode()+ " Error Message: " + ex.getMessage());
        }

        return result;
    }
}
