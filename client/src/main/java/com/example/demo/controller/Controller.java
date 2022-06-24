package com.example.demo.controller;

import com.example.demo.api.CallIPI;
import com.example.demo.dto.FormInput;
import com.example.demo.dto.Result;
import com.example.demo.entity.Student;
import com.example.demo.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/client")
public class Controller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CallIPI callIPI;

    @Autowired
    HttpSession session;

    @GetMapping("/view")
    public String login(Model model){
        FormInput formInput = new FormInput();
        model.addAttribute("formInput", formInput);
        System.out.println("done");
        String name = "Bùi Minh Công";
        model.addAttribute("name", name);
        return "view";
    }



    @GetMapping("/viewsemester")
    public String viewPoint(@RequestParam("key") String text, Model model){
        System.out.println(text);
        String year = "";
        String semester = "";
        FormInput formInput = new FormInput();
        String s = text.trim();
        List<Transcript> list = new ArrayList<>();
        String token = "123ABC";
        String studentCode = "B18DCCN056";
        String name = "Bùi Minh Công";
        if (s.contains("-")) {
            String[] arr = s.split("-");
            if (arr.length == 3) {
                year = arr[0].trim() + "-" + arr[1].trim();
                semester = arr[2].trim();

                formInput.setStudentCode(studentCode);
                formInput.setToken(token);
                formInput.setSemester(semester);
                formInput.setYear(year);
                System.out.println(formInput.toString());
                list = callIPI.getTranScriptBySemesterAndYear(formInput);

                if(list.size()>0){
                    model.addAttribute("semester", "Kỳ "+semester);
                    model.addAttribute("gpa", list.get(0).getFourPointAvg());
                    model.addAttribute("year", year);
                    model.addAttribute("list", list);


                }else {
                    model.addAttribute("sai", "Nhập sai!");
                    model.addAttribute("list", list);
                }

            }
            else {
                model.addAttribute("sai", "Nhập sai!");
                model.addAttribute("list", list);
            }

        } else {
            model.addAttribute("sai", "Nhập sai!");
            model.addAttribute("list", list);
        }
       model.addAttribute("name", name);
        return "view";
    }

}
