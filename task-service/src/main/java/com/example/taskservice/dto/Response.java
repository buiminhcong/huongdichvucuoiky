package com.example.taskservice.dto;

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

    @Override
    public String toString() {
        return "Response{" +
                "studentCode='" + studentCode + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }
}
