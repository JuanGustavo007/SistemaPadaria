package com.padoca.padaria.dto.dtoerros;

import java.time.Instant;

public class CustomErroId {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;

    public CustomErroId(Instant timestamp, Integer status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
