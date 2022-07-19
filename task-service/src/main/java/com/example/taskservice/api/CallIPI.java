package com.example.taskservice.api;


import com.example.taskservice.dto.Response;
import com.example.taskservice.dto.Token;
import com.example.taskservice.entity.Student;
import com.example.taskservice.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CallIPI {

    @Autowired
    RestTemplate restTemplate;

    // http://localhost:9000/ or http://gateway-service/*

    public String notify(String name,String phone, String gpa) {
        String noti = restTemplate.getForObject("http://notify-service/notify/sendSMS?name={name}&phone={phone}&gpa={gpa}",
                 String.class, name, phone, gpa);
        return noti;
    }

    public Student getStudentByCode(String code){
        Student s = restTemplate.getForObject("http://student-service"+ "/student/{code}",
                Student.class, code);
        return s;
    }


    public List<Transcript> getTranScriptBySemesterAndYear(String student_code,
                                                          String semester,
                                                         String year){
            List<Transcript> list = Arrays.asList(restTemplate.getForObject("http://transcript-service/transcript/get?student_code={student_code}&semester={semester}&year={year}", Transcript[].class, student_code, semester, year));
        return list;
    }




}
