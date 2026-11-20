package com.zeggs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilidades para el manejo de fechas
 */
public class DateUtil {
    
    /**
     * Formato estándar para fechas
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * Formatea una fecha en cadena con el formato estándar
     * @param date La fecha a formatear
     * @return La fecha formateada como cadena
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }
    
    /**
     * Obtiene la fecha actual como cadena
     * @return La fecha actual formateada
     */
    public static String getCurrentDateAsString() {
        return formatDate(new Date());
    }
}