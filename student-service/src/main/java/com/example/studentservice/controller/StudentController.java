package com.example.studentservice.controller;

import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{code}")
    public Student getStudentByStudentCode( @PathVariable("code") String code){
        return studentService.getStudentByStudentCode(code);
    }

}
