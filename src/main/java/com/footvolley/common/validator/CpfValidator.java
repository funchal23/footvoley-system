package com.footvolley.common.validator;

import com.footvolley.common.validator.constraints.CPF;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CpfValidator implements ConstraintValidator<CPF, String> {
    @Override
    public void initialize(CPF constraintAnnotation) {
    }

    @Override
    public boolean isValid(String data, ConstraintValidatorContext constraintValidatorContext) {
        var cpf = data.replaceAll("\\D+", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        String regex = "^(\\d)\\1{2}\\.(\\d)\\2{2}\\.(\\d)\\3{2}-(\\d)\\4{2}$";
        return Pattern.matches(regex, cpf);
    }
}
