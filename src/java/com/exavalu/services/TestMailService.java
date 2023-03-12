/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.utils.AuthUtility;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 *  This service class integrates the sending gmail functionality from the application
 * @author Raktim Ghosal
 */
public class TestMailService {

    public static void send( String to, String subject, String text) {
        
        AuthUtility authUtility = AuthUtility.getInstanceOfAuthUtility();
        //Get properties object    
        final String from= authUtility.getPropertyValue("email");
        final String password = authUtility.getPropertyValue("password");
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");
        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(text);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException ex) {
            Logger log = Logger.getLogger(TestMailService.class.getName());
            log.error(LocalDateTime.now()+ " Error Message: " + ex.getMessage()+" Class : TestMailService, Method : send");
        }         
            System.out.println(from+" "+to+" "+password);
    }
    
}

