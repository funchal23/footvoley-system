package com.footvolley.common.exception;

import static com.footvolley.common.exception.ContantsError.ATHLETE_NOT_FOUND;

public class AthleteNotFoundException extends RuntimeException{
    public AthleteNotFoundException() {
        super(ATHLETE_NOT_FOUND);
    }
}
