package com.example.verifyservice.dto;

import com.example.verifyservice.entity.OtpStatus;
import lombok.Data;


@Data
public class Response {

    private String studentCode;
    private String gpa;

    public Response() {
    }

    public Response(String studentCode, String gpa) {
        this.studentCode = studentCode;
        this.gpa = gpa;
    }
}
