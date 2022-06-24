package com.example.studentservice.service.impl;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import com.example.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentByStudentCode(String studentCode) {

        Optional<Student> op = Optional.ofNullable(studentRepository.getStudentByStudentCode(studentCode));
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }
}
