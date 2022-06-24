package com.example.transcriptservice.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private String studentCode;
    private String password;
    private String one_time_password;

    public StudentDTO() {
    }

    public StudentDTO(String studentCode, String password, String one_time_password) {
        this.studentCode = studentCode;
        this.password = password;
        this.one_time_password = one_time_password;
    }
}
