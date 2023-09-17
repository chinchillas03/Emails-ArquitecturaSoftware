/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dominio;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Servicio {
    
    private String nombre;
    private List<Cuenta> cuentas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }
    
    public void agregarCuenta(Cuenta elemento) {
        cuentas.add(elemento);
    }
    public Cuenta obtenerCuenta(int indice) {
        return cuentas.get(indice);
    }

    
}
