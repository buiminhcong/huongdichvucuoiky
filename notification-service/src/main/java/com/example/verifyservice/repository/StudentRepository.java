package com.example.verifyservice.repository;

import com.example.verifyservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select * from student where student_code =? ", nativeQuery = true)
    Student getStudentByCodeAndPassword(String code);

}
