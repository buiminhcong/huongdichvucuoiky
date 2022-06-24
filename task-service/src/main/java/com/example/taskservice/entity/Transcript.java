package com.example.taskservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transcript {


    private int id;
    private int creditsPass;
    private int creditsAvg;
    private float fourPoint;
    private float fourPointAvg;
    private String pointString;
    private String result;
    private String semester;
    private String year;

    private Student student;

    private Subject subject;

}