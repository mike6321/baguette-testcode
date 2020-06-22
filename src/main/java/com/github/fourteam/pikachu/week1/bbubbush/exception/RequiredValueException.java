package com.github.fourteam.pikachu.week1.bbubbush.exception;

import java.io.IOException;

public class

RequiredValueException extends RuntimeException {
    public RequiredValueException (String errorMsg) {
        super(errorMsg);
    }


    public RequiredValueException (String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
    }
}
