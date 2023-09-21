/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itson.dominio.ConfiguracionCorreo;
import com.itson.dominio.Cuenta;
import com.itson.dominio.Servicio;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class LectorArchivos {
    
    public void leerArchivo(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Leer el archivo JSON y convertirlo en un objeto ConfiguracionCorreo
            ConfiguracionCorreo configuracion = objectMapper.readValue(new File("configuracion.json"), ConfiguracionCorreo.class);

            // Acceder a los servicios de correo y trabajar con ellos
            for (Servicio servicio : configuracion.getServiciosCorreo()) {
                System.out.println("Nombre del servicio: " + servicio.getNombre());

                for (Cuenta cuenta : servicio.getCuentas()) {
                    System.out.println("Usuario: " + cuenta.getDireccion());
                    System.out.println("Contraseña: " + cuenta.getContrasenia());
                }

                System.out.println("Protocolos: " + servicio.getProtocolos());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
