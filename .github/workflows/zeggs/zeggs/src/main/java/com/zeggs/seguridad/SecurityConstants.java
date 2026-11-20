package com.zeggs.seguridad;

/**
 * Constantes de seguridad para la aplicación ZEggs
 */
public class SecurityConstants {
    
    /**
     * Tamaño mínimo de contraseña
     */
    public static final int MIN_PASSWORD_LENGTH = 8;
    
    /**
     * Tamaño máximo de contraseña
     */
    public static final int MAX_PASSWORD_LENGTH = 100;
    
    /**
     * Número máximo de intentos de inicio de sesión fallidos antes de bloqueo
     */
    public static final int MAX_LOGIN_ATTEMPTS = 5;
    
    /**
     * Tiempo de bloqueo en minutos por exceso de intentos fallidos
     */
    public static final int LOCKOUT_MINUTES = 30;
}