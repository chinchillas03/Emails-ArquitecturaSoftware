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
public class ServicioDTO {
    
    private List<CuentaDTO> cuentas;
    private List<ProtocoloDTO> protocolos;

    public ServicioDTO() {
    }

    public List<ProtocoloDTO> getProtocolos() {
        return protocolos;
    }

    public void setProtocolos(List<ProtocoloDTO> protocolos) {
        this.protocolos = protocolos;
    }

    public ServicioDTO(List<CuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }

    public List<CuentaDTO> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaDTO> cuentas) {
        this.cuentas = cuentas;
    }
    
}
