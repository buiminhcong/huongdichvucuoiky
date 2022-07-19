package com.example.transcriptservice.controller;

import com.example.transcriptservice.api.CallIPI;
import com.example.transcriptservice.entity.Transcript;
import com.example.transcriptservice.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transcript")
public class TranscriptController {

    @Autowired
    TranscriptService transcriptService;

    @GetMapping("/get")
    public List<Transcript> getTranScriptBySemesterAndYear(@RequestParam("student_code") String studentCode,
                                                           @RequestParam("semester") String semester,
                                                           @RequestParam("year") String year){

        return transcriptService.getTranScriptBySemesterAndYear(studentCode, semester, year);
    }

}
