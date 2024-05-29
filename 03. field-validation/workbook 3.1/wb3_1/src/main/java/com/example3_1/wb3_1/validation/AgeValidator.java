package com.example3_1.wb3_1.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AgeValidator implements ConstraintValidator<Age, Date> {
    private int LEGAL_AGE = 18;

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        
        Calendar legalAgeBirthdayLimit = Calendar.getInstance();
        legalAgeBirthdayLimit.add(Calendar.YEAR, -LEGAL_AGE);
        return value.getTime() < legalAgeBirthdayLimit.getTimeInMillis();

    }
    
}
