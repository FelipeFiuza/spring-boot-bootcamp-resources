package com.example3_1.wb3_1.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  AgeValidator.class)

public @interface Age {
    
    String message() default "INVALID AGE";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

