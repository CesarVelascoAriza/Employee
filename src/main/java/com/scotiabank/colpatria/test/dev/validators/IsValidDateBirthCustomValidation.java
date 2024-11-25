package com.scotiabank.colpatria.test.dev.validators;

import java.util.Calendar;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsValidDateBirthCustomValidation implements ConstraintValidator<IsValidDateBirth, Date> {

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		Calendar fechaEleccion = Calendar.getInstance();
		fechaEleccion.add(Calendar.YEAR, -18);
		Date fecha = fechaEleccion.getTime();
		return value != null && value.getTime() < fecha.getTime();
	}

	
}
