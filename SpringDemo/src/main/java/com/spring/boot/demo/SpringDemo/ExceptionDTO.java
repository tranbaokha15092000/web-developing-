package com.spring.boot.demo.SpringDemo;

import java.util.Date;

public class ExceptionDTO {
    private Date timestamp;
    private String status;
    private String message;

    public ExceptionDTO(Date timestamp, String status, String message){
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
