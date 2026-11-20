package com.zeggs.util;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.regex.Pattern;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

/**
 * Utilidades para validación de datos
 */
public class ValidationUtil {
    
    /**
     * Expresión regular para validar nombres de usuario (solo letras, números y guiones bajos)
     */
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]+$");
    
    /**
     * Valida que un nombre de usuario sea válido
     * @param username El nombre de usuario a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean isValidUsername(String username) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        
        return USERNAME_PATTERN.matcher(username).matches() && 
               username.length() >= 3 && username.length() <= 50;
    }
    
    /**
     * Valida que una contraseña sea segura
     * @param password La contraseña a validar
     * @return true si es segura, false en caso contrario
     */
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        // Requiere al menos una letra mayúscula, una minúscula y un número
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
    
    /**
     * Normaliza un nombre de usuario (elimina espacios y convierte a minúsculas)
     * @param username El nombre de usuario a normalizar
     * @return El nombre de usuario normalizado
     */
    public static String normalizeUsername(String username) {
        if (username == null) {
            return null;
        }
        return username.trim().toLowerCase();
    }
    
    /**
     * Valida un objeto utilizando Bean Validation
     * @param <T> Tipo del objeto a validar
     * @param object Objeto a validar
     * @return Conjunto de violaciones de validación
     */
    public static <T> Set<ConstraintViolation<T>> validate(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(object);
    }
}