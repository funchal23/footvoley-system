package com.footvolley.common.exception;

import static com.footvolley.common.exception.ContantsError.CPF_FINDING;

public class CpfFindingException extends RuntimeException{
    public CpfFindingException() {
        super(CPF_FINDING);
    }
}
