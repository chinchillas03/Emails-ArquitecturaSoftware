/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dto;

/**
 *
 * @author Usuario
 */
public class CuentaDTO {
    
    private String nombre;
    private String direccion;
    private String contrasena;

    public CuentaDTO() {
    }

    public CuentaDTO(String nombre, String direccion, String contrasena) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
