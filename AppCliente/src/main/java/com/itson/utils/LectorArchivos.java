/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.utils;

import com.google.gson.Gson;
import com.itson.dominio.Cuenta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import com.google.gson.reflect.TypeToken;
import com.itson.dto.ConfiguracionServiciosDTO;
import com.itson.dto.ProtocoloDTO;
import com.itson.dto.ServicioDTO;
import java.lang.reflect.Type;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class LectorArchivos {
    
    private List<ServicioDTO> nombresServicios;
    
    public void leerArchivo() {
        Gson gson = new Gson();
        
        String json = "";
        
        try {
            BufferedReader bufer = new BufferedReader(new FileReader("config.json"));
            
            String linea = "";
            while ((linea = bufer.readLine()) != null) {                
                json += linea;
            }
            bufer.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfiguracionServiciosDTO servicios = gson.fromJson(json, ConfiguracionServiciosDTO.class);
                
        nombresServicios = servicios.getServicios();

        System.out.println("------Nombres servidores-------");
        for (ServicioDTO nombresServicio : nombresServicios) {          
            System.out.println(nombresServicio.getNombre());
        }
        System.out.println("-------------------------------");
    }

    public List<ServicioDTO> getNombresServicios() {
        return nombresServicios;
    }

    public void setNombresServicios(List<ServicioDTO> nombresServicios) {
        this.nombresServicios = nombresServicios;
    }
 
}
