package com.example.demo.dto;

public class FormInput {
    private String studentCode;
    private String token;
    private String semester;
    private String year;

    public FormInput(String studentCode, String token, String semester, String year) {
        this.studentCode = studentCode;
        this.token = token;
        this.semester = semester;
        this.year = year;
    }

    public FormInput() {
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "FormInput{" +
                "studentCode='" + studentCode + '\'' +
                ", token='" + token + '\'' +
                ", semester='" + semester + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
