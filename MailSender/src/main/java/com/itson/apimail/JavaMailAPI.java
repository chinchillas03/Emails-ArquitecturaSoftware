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
            Properties propiedad = new Properties();
            propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            propiedad.put("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");
            propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            propiedad.setProperty("mail.smtp.user", cuenta);

            Session session;
            session = Session.getInstance(propiedad, new Authenticator() {
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
