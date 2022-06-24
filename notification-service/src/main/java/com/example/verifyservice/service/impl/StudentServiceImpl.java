package com.example.verifyservice.service.impl;

import com.example.verifyservice.config.TwilioConfig;
import com.example.verifyservice.dto.Response;
import com.example.verifyservice.entity.OtpStatus;
import com.example.verifyservice.entity.Student;
import com.example.verifyservice.repository.StudentRepository;
import com.example.verifyservice.service.StudentService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {

//    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;   // 1 minutes

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TwilioConfig twilioConfig;


    @Override
    public Student getStudentByCodeAndPassword(String code) {

        Optional<Student> op = Optional.ofNullable(studentRepository.getStudentByCodeAndPassword(code));
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public String sendOTP(String code, String gpa) {
        Response response = null;
        Student s = getStudentByCodeAndPassword(code);


        try {
            PhoneNumber to = new PhoneNumber(s.getPhone());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());

            String otpMessage = "Chào "+s.getName()+  "GPA hiện tại của bạn là: " + gpa
                    + "##";
            Message message = Message.creator(to, from, otpMessage).create();

            return "true";

        } catch (Exception e) {
            return "false";
        }
    }

}



