package com.example.demo.api;


import com.example.demo.dto.FormInput;
import com.example.demo.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CallIPI {



    public List<Transcript> getTranScriptBySemesterAndYear(FormInput formInput){

        RestTemplate restTemplate = new RestTemplate();
        List<Transcript> list = Arrays.asList(restTemplate.postForObject("http://localhost:8888/task" , formInput,  Transcript[].class ));
        return list;
    }




}
