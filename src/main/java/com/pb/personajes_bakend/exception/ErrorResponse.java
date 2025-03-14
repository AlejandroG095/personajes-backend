package com.pb.personajes_bakend.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Setter
@Getter
public class ErrorResponse {

    // Getters y Setters
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private Map<String, String> validationErrors;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(int status, String message, Map<String, String> validationErrors) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.validationErrors = validationErrors;
    }

}
