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
        
        Cuenta cuenta = gson.fromJson(json, Cuenta.class);
        
        System.out.println(cuenta.getNombre());
        System.out.println(cuenta.getDireccion());

//        try {
//            BufferedReader buffer = new BufferedReader(new FileReader("config.json"));
//
//            String linea;
//            while ((linea = buffer.readLine()) != null) {
//                json += linea;
//            }
//            buffer.close();
//
//            // Crear un tipo genérico para representar una lista de cuentas
//            Type tipoListaCuentas = new TypeToken<List<Cuenta>>(){}.getType();
//
//            // Leer el archivo JSON y convertirlo en una lista de cuentas
//            List<Cuenta> cuentas = gson.fromJson(json, tipoListaCuentas);
//
//            // Iterar sobre la lista de cuentas e imprimir los detalles
//            for (Cuenta cuenta : cuentas) {
//                System.out.println("Nombre: " + cuenta.getNombre());
//                System.out.println("Dirección de correo: " + cuenta.getDireccion());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(LectorArchivos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
