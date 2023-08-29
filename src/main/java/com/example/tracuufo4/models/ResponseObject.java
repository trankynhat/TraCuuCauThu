package com.example.tracuufo4.models;

public class ResponseObject {
    private String status;
    private String massage;
    private Object data;



    public ResponseObject(String status, String massage, Object data) {
        this.status = status;
        this.massage = massage;
        this.data = data;
    }

    public ResponseObject(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
