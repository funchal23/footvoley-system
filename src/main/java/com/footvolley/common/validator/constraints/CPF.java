package com.footvolley.common.validator.constraints;

import com.footvolley.common.validator.CpfValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF {
    String message() default "CPF invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
