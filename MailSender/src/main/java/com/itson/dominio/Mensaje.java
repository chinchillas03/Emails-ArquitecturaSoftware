/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Mensaje {
    
    private String destinatario;
    private String asunto;
    private String contenido;
    private Calendar horaEnvio;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Calendar getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Calendar horaEnvio) {
        this.horaEnvio = horaEnvio;
    }
    
}
