package com.example.verifyservice.service;

import com.example.verifyservice.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student getStudentByCodeAndPassword(String code);

    String sendOTP(String code, String gpa);



}
