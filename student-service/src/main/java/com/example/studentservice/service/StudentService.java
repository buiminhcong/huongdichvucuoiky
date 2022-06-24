package com.example.studentservice.service;

import com.example.studentservice.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student getStudentByStudentCode(String studentCode);

}
