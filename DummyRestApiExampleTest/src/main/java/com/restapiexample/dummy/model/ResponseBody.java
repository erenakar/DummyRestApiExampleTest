package com.restapiexample.dummy.model;

public class ResponseBody {

    private int id;
    private String status;
    private Employee data;
    private String message;

    public String getStatus() {
        return status;
    }

    public ResponseBody setStatus(String status) {
        this.status = status;
        return this;
    }

    public Employee getData() {
        return data;
    }

    public ResponseBody setData(Employee data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
}
