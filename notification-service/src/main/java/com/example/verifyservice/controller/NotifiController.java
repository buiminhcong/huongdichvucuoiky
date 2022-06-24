package com.example.verifyservice.controller;

import com.example.verifyservice.dto.Response;
import com.example.verifyservice.dto.StudentDTO;
import com.example.verifyservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotifiController {

    @Autowired
    StudentService studentService;

    @PostMapping("/send")
    public String sendOPT(@RequestBody Response response) {
        return studentService.sendOTP(response.getStudentCode(), response.getGpa());
    }

}
