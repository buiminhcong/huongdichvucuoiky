package com.example.taskservice.controller;

import com.example.taskservice.api.CallIPI;

import com.example.taskservice.dto.FormInput;
import com.example.taskservice.dto.Response;
import com.example.taskservice.dto.Token;
import com.example.taskservice.entity.Student;
import com.example.taskservice.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/task")
public class HomeController {

    @Autowired
    CallIPI callIPI;

    @PostMapping("")
    public List<Transcript> getTranscript(@RequestBody FormInput formInput){
        List<Transcript> list = new ArrayList<>();
        Student student = callIPI.getStudentByCode(formInput.getStudentCode());
        System.out.println(student.toString());

        if(student!=null){
            Token token = new Token();
            token.setToken(student.getToken());
            token.setStudentCode(student.getStudentCode());
            System.out.println(token.toString());
            String checkToken = callIPI.verify(token);
            if(checkToken.equals("true")){
                System.out.println("check = true");

                list = callIPI.getTranScriptBySemesterAndYear(formInput.getStudentCode(), formInput.getSemester(), formInput.getYear() );
                if(list.size()>0){
                    Response response = new Response();
                    response.setStudentCode(student.getStudentCode());
                    response.setGpa(String.valueOf(list.get(0).getFourPointAvg()));
                    String send = callIPI.notify(response );
                }
                System.out.println(list.size());
             }else {
                System.out.println("check token khac true");
            }
        }else {
            System.out.println("Student null");
        }
        return list;
    }


}
