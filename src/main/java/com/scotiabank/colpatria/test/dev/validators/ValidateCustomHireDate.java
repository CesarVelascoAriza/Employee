package com.scotiabank.colpatria.test.dev.validators;

import java.util.Calendar;
import java.util.Date;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidateCustomHireDate implements ConstraintValidator<IsValidHireDate, Date> {

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		Date fechaEleccion = Calendar.getInstance().getTime();
		return value != null && value.getTime() >= fechaEleccion.getTime();
	}

}
