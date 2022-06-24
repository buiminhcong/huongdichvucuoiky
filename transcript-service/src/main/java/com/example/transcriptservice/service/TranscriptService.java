package com.example.transcriptservice.service;

import com.example.transcriptservice.entity.Transcript;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TranscriptService {

    List<Transcript> getAllListTranScript(String studentCode);

    List<Transcript> getTranScriptBySemesterAndYear(String studentCode, String semester, String year);

}
