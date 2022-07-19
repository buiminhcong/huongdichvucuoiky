package com.example.verificationservice;

public class Response {
    private String statusCode;
    private String error;
    private String message;


    public Response(String statusCode, String error, String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;

    }

    public Response() {
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
