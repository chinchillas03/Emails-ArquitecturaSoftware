/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.daos;

import com.itson.dominio.Cuenta;
import com.itson.dominio.Protocolo;
import com.itson.dominio.Servicio;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ServicioDAO {
    
    private Servicio serv;
    
    public void cargarServicios(){
        Servicio servicio1 = new Servicio();
        Servicio servicio2 = new Servicio();
        
        servicio1.setNombre("GMAIL");
        servicio2.setNombre("OUTLOOK");
    }
    
    public void cargarProtocolos(){
        Protocolo protocolo1 = new Protocolo("SMTP");
        Protocolo protocolo2 = new Protocolo("IMAP");
        
        List<Protocolo> lista = new LinkedList<>();
        lista.add(protocolo1);
        lista.add(protocolo2);
        
        serv.setProtocolos(lista);
    }
    
    public void cargarCuentas(){
        Cuenta cuenta1 = new Cuenta("", "");
        Cuenta cuenta2 = new Cuenta("", "");
        
        List<Cuenta> lista = new LinkedList<>();
        lista.add(cuenta1);
        lista.add(cuenta1);
        
        serv.setCuentas(lista);
    }
    
}
