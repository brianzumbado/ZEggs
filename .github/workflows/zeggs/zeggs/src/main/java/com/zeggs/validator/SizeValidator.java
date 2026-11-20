package com.zeggs.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validador personalizado para @Size
 */
public class SizeValidator implements ConstraintValidator<Size, String> {
    
    private int min;
    private int max;
    
    @Override
    public void initialize(Size constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null values are considered valid
        }
        
        int length = value.length();
        return length >= min && length <= max;
    }
}