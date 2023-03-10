package com.revise.spboot.entity;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorMessage {

    private HttpStatus status;
    private String message;
    private Date timeStamp;

    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String message, Date timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
