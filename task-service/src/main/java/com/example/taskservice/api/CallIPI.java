package com.example.taskservice.api;


import com.example.taskservice.dto.Response;
import com.example.taskservice.dto.Token;
import com.example.taskservice.entity.Student;
import com.example.taskservice.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CallIPI {

    @Autowired
    RestTemplate restTemplate;

    public String verify(Token token) {
       String checkToken = restTemplate.postForObject("http://verify-service/verify",
               token, String.class);
        return checkToken;
    }
    public String notify(Response response) {
        String noti = restTemplate.postForObject("http://notify-service/notify/send",
                response, String.class);
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
