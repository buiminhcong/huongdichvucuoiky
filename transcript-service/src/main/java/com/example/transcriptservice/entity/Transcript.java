package com.example.transcriptservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int creditsPass;
    private int creditsAvg;
    private float fourPoint;
    private float fourPointAvg;
    private String pointString;
    private String result;
    private String semester;
    private String year;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

}