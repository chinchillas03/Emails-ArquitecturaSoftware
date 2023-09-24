/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Usuario
 */
public class ImplementacionFachada{

    public void enviarEmail(String servicio, String protocolo, String cuenta, String destino, String asunto, String contenido) {       
        String user = "alvarezchinchillas3@gmail.com";
        String password = "onihrehokyiwfthb";
        System.out.println(servicio);
        Properties propiedad = new Properties();
        
        propiedad.put("mail.smtp.ssl.trust", "smtp.gmail.com");        
        propiedad.put("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedad.setProperty("mail.smtp.user", user);     
        
        Session session;
        session = Session.getInstance(propiedad, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
          
        Message mensaje = prepararMensaje(session, user, destino, asunto, contenido);
        try {
            Transport.send(mensaje);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Mensaje enviado a " + destino);
    }
    
    private static Message prepararMensaje(Session session, String user, String recepient, String asunto, String contenido){
        Message mensaje = new MimeMessage(session);
        try{
            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
        }catch(MessagingException ex){
            ex.printStackTrace();
        }
        return mensaje;
    }
    
    public void cambiarConfiguracion() {
        
    }
    
}
