package com.devAsk.api.exception;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
