/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dominio;

import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Mensaje {
    
    private String titulo;
    private String contenido;
    private Calendar horaEnvio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
