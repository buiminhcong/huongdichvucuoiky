package com.example.verificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@RestController
@RequestMapping("/verify")
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    String token1 = "123ABC";
    String token2 = "234ABC";

    @PostMapping("")
    public String checkVerify(@RequestBody Token token) {
        if (token.getToken().equals("123ABC")) {
            return "true";
        } else if (token.getToken().equals("234ABC")) {
            return "true";
        } else {
            return "false";
        }
    }

    @GetMapping("/ok")
    public String hihi(@RequestHeader(name = "Authorization") String token) {
        System.out.println(token);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", token);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        try {
            restTemplate. exchange("https://dev-c92wp7x3.us.auth0.com/api/v2/branding",
                    HttpMethod.GET, entity, String.class);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "sai";
        }
    }


}
