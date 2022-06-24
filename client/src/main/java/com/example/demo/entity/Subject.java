package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {


    private int id;
    private String name;
    private String credits;

    private Semester semester;

    private Year year;

}
