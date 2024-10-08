/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.apimail;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class JavaMailAPI {

    public void envarMail(String servicio, String protocolo, String cuenta, String contrasena, String destino, String asunto, String contenido) {
        try {
            Properties props = new Properties();
            if ("Gmail".equals(servicio)) {
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");            
            props.setProperty("mail.smtp.port", "587"); 
            props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            props.setProperty("mail.smtp.user", cuenta);
        } else if ("Outlook".equals(servicio)) {
            if ("SMTP".equals(protocolo)) {
                props.put("mail.smtp.host", "smtp-mail.outlook.com");
                props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.starttls.enable", "true");            
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
                props.setProperty("mail.smtp.user", cuenta);
            } else if ("IMAP".equals(protocolo)) {
                props.setProperty("mail.imap.host", "imap-mail.outlook.com"); 
                props.setProperty("mail.imap.port", "993"); 
                props.setProperty("mail.imap.ssl.enable", "true");
            } else if ("POP3".equals(protocolo)) {
                props.setProperty("mail.pop3.host", "pop3.live.com"); 
                props.setProperty("mail.pop3.port", "995");
                props.setProperty("mail.pop3.ssl.enable", "true");
            }
        } else if ("Yahoo".equals(servicio)) {
            if ("SMTP".equals(protocolo)) {
                props.setProperty("mail.smtp.auth", "true");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.host", "smtp.mail.yahoo.com"); 
                props.setProperty("mail.smtp.port", "587"); 
            } else if ("POP3".equals(protocolo)) {
                props.setProperty("mail.pop3.host", "pop.mail.yahoo.com"); 
                props.setProperty("mail.pop3.port", "995"); 
                props.setProperty("mail.pop3.ssl.enable", "true");
            }
        }

            Session session;
            session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(cuenta, contrasena);
                }
            });

            Message mensaje = prepararMensaje(session, cuenta, destino, asunto, contenido);
            try {
                Transport.send(mensaje);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            System.out.println("Mensaje enviado a " + destino);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido una excepción:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static Message prepararMensaje(Session session, String user, String recepient, String asunto, String contenido) {
        Message mensaje = new MimeMessage(session);
        try {
            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return mensaje;
    }

}
