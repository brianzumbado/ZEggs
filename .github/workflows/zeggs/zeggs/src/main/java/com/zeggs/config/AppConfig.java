package com.zeggs.config;

import java.util.ResourceBundle;

/**
 * Configuración de la aplicación ZEggs
 */
public class AppConfig {
    
    private static final ResourceBundle bundle = ResourceBundle.getBundle("application");
    
    /**
     * Obtiene una propiedad del archivo de configuración
     * @param key La clave de la propiedad
     * @return El valor de la propiedad o null si no existe
     */
    public static String getProperty(String key) {
        try {
            return bundle.getString(key);
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Obtiene una propiedad del archivo de configuración como entero
     * @param key La clave de la propiedad
     * @return El valor de la propiedad como entero o 0 si no existe o no es válido
     */
    public static int getIntProperty(String key) {
        try {
            return Integer.parseInt(getProperty(key));
        } catch (Exception e) {
            return 0;
        }
    }
    
    /**
     * Obtiene una propiedad del archivo de configuración como booleano
     * @param key La clave de la propiedad
     * @return El valor de la propiedad como booleano o false si no existe o no es válido
     */
    public static boolean getBooleanProperty(String key) {
        try {
            return Boolean.parseBoolean(getProperty(key));
        } catch (Exception e) {
            return false;
        }
    }
}