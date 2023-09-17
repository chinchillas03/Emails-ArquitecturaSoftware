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
    
    private String asunto;
    private String contenido;
    private Calendar horaEnvio;

    public String getTitulo() {
        return asunto;
    }

    public void setTitulo(String titulo) {
        this.asunto = titulo;
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
