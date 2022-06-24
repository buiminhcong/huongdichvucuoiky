package com.example.transcriptservice.service.impl;

import com.example.transcriptservice.api.CallIPI;
import com.example.transcriptservice.entity.Student;
import com.example.transcriptservice.entity.Transcript;
import com.example.transcriptservice.repository.TranscriptRepository;
import com.example.transcriptservice.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TranScriptServiceImpl implements TranscriptService {

    @Autowired
    TranscriptRepository transcriptRepository;


    @Autowired
    CallIPI callIPI;

    @Override
    public List<Transcript> getAllListTranScript(String studentCode) {

        Optional<Student> op = Optional.ofNullable(callIPI.getStudentByCode(studentCode));
        List<Transcript> list = new ArrayList<>();
        if (op.isPresent()) {
            Student s = op.get();
            list = transcriptRepository.getAllTranScriptOfStudent(s.getId());
        }
        return list;
    }

    @Override
    public List<Transcript> getTranScriptBySemesterAndYear(String studentCode, String semester, String year) {

        Optional<Student> optional = Optional.ofNullable(callIPI.getStudentByCode(studentCode));
        List<Transcript> list = new ArrayList<>();
        if (optional.isPresent()) {
            Student s = optional.get();
            list = transcriptRepository.getTranScriptOfStudentBySemesterAndYear(s.getId(), semester, year);
        }
        return list;
    }
}
