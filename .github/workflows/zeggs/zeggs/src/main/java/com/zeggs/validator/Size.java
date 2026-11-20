package com.zeggs.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotación personalizada para validar el tamaño de una cadena
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SizeValidator.class)
@Documented
public @interface Size {
    
    String message() default "El tamaño debe estar entre {min} y {max} caracteres";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
    int min() default 0;
    
    int max() default Integer.MAX_VALUE;
}