package com.example.transcriptservice.repository;

import com.example.transcriptservice.entity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {

    @Query(value = "SELECT * FROM huong_dich_vu.transcript where student_id = ?", nativeQuery = true)
    List<Transcript> getAllTranScriptOfStudent(int student_id);

    @Query(value = "SELECT * FROM huong_dich_vu.transcript where student_id = ? and semester = ? and year = ?", nativeQuery = true)
    List<Transcript> getTranScriptOfStudentBySemesterAndYear(int student_id, String semester, String year);

}
