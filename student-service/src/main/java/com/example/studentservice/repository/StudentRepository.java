package com.example.studentservice.repository;

import com.example.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where student_code = ?", nativeQuery = true)
    Student getStudentByStudentCode(String studentCode);

}
