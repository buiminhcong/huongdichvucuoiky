package com.example.transcriptservice.api;


import com.example.transcriptservice.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallIPI {

    @Autowired
    RestTemplate restTemplate;

    public Student getStudentByCode(String code){
        Student s = restTemplate.getForObject("http://student-service" + "/student/{code}",
                Student.class, code);
        return s;
    }

}
