package com.zeggs.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Anotación personalizada para validar que un campo no esté en blanco
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankValidator.class)
@Documented
public @interface NotBlank {
    
    String message() default "El campo no puede estar en blanco";
    
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
}