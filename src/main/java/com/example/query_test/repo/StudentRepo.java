package com.example.query_test.repo;

import com.example.query_test.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE LOWER(s.result) = LOWER(:keyword)")
    List<Student> findByResult(String keyword);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) = LOWER(:keyword) or LOWER(s.subject) = LOWER(:keyword) ")
    Page<Student> findByNameOrSubject(@Param("keyword") String keyword, Pageable pageable);
}
