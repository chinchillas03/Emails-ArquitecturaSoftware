/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.implementaciones;

import com.itson.apimail.JavaMailAPI;
import com.itson.interfaces.ManejadorEmails;
import com.itson.utils.ValidadorEmails;
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
public class ImplementacionFachada implements ManejadorEmails{
    
    ValidadorEmails validador = new ValidadorEmails();  
    
    public void enviarEmail(String servicio, String protocolo, String cuenta, String contrasena, String destino, String asunto, String contenido) {       
        if (validador.esVacio(servicio) == false) {       
            JOptionPane.showMessageDialog(null, "Servicio incorrecto",
                    "El el servicio del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);     
        }
        if (validador.esVacio(protocolo) == false) {       
            JOptionPane.showMessageDialog(null, "Protocolo incorrecto",
                    "El el protocolo del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);     
        }
        if (validador.validarCorreo(cuenta) == false) {       
            JOptionPane.showMessageDialog(null, "Cuenta incorrecta",
                    "El formato de cuenta es incorrecto", JOptionPane.INFORMATION_MESSAGE);
        }
        if (validador.validarCorreo(destino) == false) {       
            JOptionPane.showMessageDialog(null, "Destinatario incorrecto",
                    "El formato de correo es incorrecto", JOptionPane.INFORMATION_MESSAGE);
        }
        if (validador.esVacio(asunto) == false) {       
            JOptionPane.showMessageDialog(null, "Asunto incorrecto",
                    "El el asunto del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);     
        }
        if (validador.esVacio(contenido) == false) {       
            JOptionPane.showMessageDialog(null, "Cuerpo de correo incorrecto",
                    "El cuerpo del correo esta vacio", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if (validador.validarCorreo(destino) == false || validador.esVacio(asunto) == false || validador.esVacio(contenido) == false) {
            return;
        }
        
        JavaMailAPI api = new JavaMailAPI();
        api.envarMail(servicio, protocolo, cuenta, contrasena, destino, asunto, contenido);
    } 
    
    public void cambiarConfiguracion() {
        
    }
    
}
