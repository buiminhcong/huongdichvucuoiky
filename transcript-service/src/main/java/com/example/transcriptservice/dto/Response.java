package com.example.transcriptservice.dto;


import lombok.Data;


@Data
public class Response {

    private OtpStatus status;
    private String message;
    private long timeCreate;

    public Response() {
    }

    public Response(OtpStatus status, String message, long timeCreate) {
        this.status = status;
        this.message = message;
        this.timeCreate = timeCreate;
    }
}
