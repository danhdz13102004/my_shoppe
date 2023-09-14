package com.example.rest_api.handle;

import org.springframework.http.HttpStatus;

public class ErrorRespond {
    private int status;
    private String message;

    private long timeError;

    public ErrorRespond(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeError = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeError() {
        return timeError;
    }

    public void setTimeError(long timeError) {
        this.timeError = timeError;
    }

    @Override
    public String toString() {
        return "ErrorRespond{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeError=" + timeError +
                '}';
    }
}
