package com.barberpro.dsc.dto;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ApiErrorDTO {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ApiErrorDTO(Instant timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}