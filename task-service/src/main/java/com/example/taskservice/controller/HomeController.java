package com.example.taskservice.controller;

import com.example.taskservice.api.CallIPI;

import com.example.taskservice.dto.FormInput;
import com.example.taskservice.dto.Response;
import com.example.taskservice.dto.Token;
import com.example.taskservice.entity.Student;
import com.example.taskservice.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/task")
public class HomeController {

    @Autowired
    CallIPI callIPI;

    @PostMapping("")
    public List<Transcript> getTranscript(@RequestBody FormInput formInput) {
//@RequestHeader(name = "Authorization") String token1
        System.out.println(formInput.getToken());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", formInput.getToken());
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        List<Transcript> list = new ArrayList<>();
        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange("https://dev-r9ns-whp.us.auth0.com/api/v2/branding",
                    HttpMethod.GET, entity, String.class);
            System.out.println("Xac thuc token thanh cong!");


            Student student = callIPI.getStudentByCode(formInput.getStudentCode());
            if (student != null) {
                list = callIPI.getTranScriptBySemesterAndYear(formInput.getStudentCode(), formInput.getSemester(), formInput.getYear());
                if (list.size() > 0) {
                    System.out.println("Da xem diem thanh cong");
                    String send = callIPI.notify(student.getName(), student.getPhone(),String.valueOf(list.get(0).getFourPointAvg())  );
                    System.out.println(send);
                }
            } else {
                System.out.println("Student null");
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("That bai!");
        }
        return list;
    }


}
