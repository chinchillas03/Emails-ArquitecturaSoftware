/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.interfaces;

/**
 *
 * @author Usuario
 */
public interface ManejadorEmails {
    
    void enviarEmail(String servicio, String protocolo, String cuenta, String contrasena, String destino, String asunto, String contenido);
    void cambiarConfiguracion();
    
}
