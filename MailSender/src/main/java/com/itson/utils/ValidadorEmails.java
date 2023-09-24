/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class ValidadorEmails {
    
    public boolean esVacio(String variable){
        if (variable.isBlank() == true || variable.isEmpty() == true) {
            return false;
        } 
        return true;
    }
    
    public boolean validarCorreo(String correo) {
        String expresionRegular = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
    
}
