package com.zeggs.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validador personalizado para @NotBlank
 */
public class NotBlankValidator implements ConstraintValidator<NotBlank, String> {
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return !value.trim().isEmpty();
    }
}