package com.example.taskservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {


    private int id;
    private String studentCode;
    private String name;
    private String phone;
    private String email;
    private String one_time_password;
    private String token;
    private long otpRequestedTime;

}
