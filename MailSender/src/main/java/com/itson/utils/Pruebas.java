/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.utils;

/**
 *
 * @author Usuario
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String variable = "diego.chinchillas233233@potros.itson.edu.mx";
        ValidadorEmails emails = new ValidadorEmails();
        
        
        if (emails.validarCorreo(variable) == true) {
            System.out.println("Correo bien");
        }else{
            System.out.println("No esta bien");
        }
    }
    
}
