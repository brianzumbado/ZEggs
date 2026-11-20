package com.zeggs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Utilidades para el manejo de contraseñas
 */
public class PasswordUtil {
    
    /**
     * Genera un hash SHA-256 de la contraseña
     * @param password La contraseña en texto plano
     * @return La contraseña hasheada en base64
     */
    public static String hashPassword(String password) {
        if (password == null) {
            return null;
        }
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }
    
    /**
     * Verifica si una contraseña coincide con un hash
     * @param password La contraseña en texto plano
     * @param hashedPassword El hash de la contraseña
     * @return true si coinciden, false en caso contrario
     */
    public static boolean verifyPassword(String password, String hashedPassword) {
        if (password == null || hashedPassword == null) {
            return false;
        }
        
        String hashedInput = hashPassword(password);
        return hashedInput.equals(hashedPassword);
    }
}