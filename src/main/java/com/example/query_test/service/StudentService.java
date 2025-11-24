package com.example.query_test.service;

import com.example.query_test.entity.Student;
import com.example.query_test.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo repo;

    public List<Student> getStudentsByResult(String keyword) {
        return repo.findByResult(keyword);
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Page<Student> getByNameOrSubject(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repo.findByNameOrSubject(keyword, pageable);
    }
}
