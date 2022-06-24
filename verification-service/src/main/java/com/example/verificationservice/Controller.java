package com.example.verificationservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class Controller {

    String token1= "123ABC";
    String token2= "234ABC";

    @PostMapping("")
    public String checkVerify(@RequestBody Token token){
        if(token.getToken().equals("123ABC")){
            return "true";
        }else if(token.getToken().equals("234ABC")){
            return "true";
        }else {
            return "false";
        }
    }

}
