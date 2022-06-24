package com.example.verifyservice.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private String studentCode;
    private String password;
    private String one_time_password;

}
