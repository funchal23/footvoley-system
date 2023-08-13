package com.footvolley.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BaseApiExceptionHandler {

    @ExceptionHandler(CpfFindingException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected String cpfFindingException(final CpfFindingException ex, final HttpServletRequest request) {
        return ex.getMessage();
    }

    @ExceptionHandler(AthleteNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected String athleteNotFoundException(final AthleteNotFoundException ex, final HttpServletRequest request) {
        return ex.getMessage();
    }
}
