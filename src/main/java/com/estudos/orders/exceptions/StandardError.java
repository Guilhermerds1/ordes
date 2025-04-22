package com.estudos.orders.exceptions;

import java.time.Instant;

public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String massage;
    private String path;

    public StandardError(){}

    public StandardError(Instant timestamp, Integer status, String error, String massage, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.massage = massage;
        this.path = path;
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

    public String getMassage() {
        return massage;
    }

    public String getPath() {
        return path;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
