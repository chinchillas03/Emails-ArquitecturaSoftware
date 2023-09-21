/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dto;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class ConfiguracionServiciosDTO {
    
    private List<ServicioDTO> servicios;

    public ConfiguracionServiciosDTO() {
    }

    public ConfiguracionServiciosDTO(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }
    
}
