package com.example.query_test.controller;

import com.example.query_test.entity.Student;
import com.example.query_test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {

    private final StudentService service;

    @GetMapping("/result")
    public ResponseEntity<List<Student>> handleSearchByResult(@RequestParam String keyword) {
        List<Student> students = service.getStudentsByResult(keyword);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/all")
    public ResponseEntity<?> handleSearchAll() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping
    public ResponseEntity<?> handleSearchByNameOrSubject(@RequestParam String keyword,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Page<Student> students = service.getByNameOrSubject(keyword, page, size);

        Map<String, Object> response = new HashMap<>();
        response.put("students", students.getContent());
        response.put("currentPage", students.getNumber());
        response.put("totalItems", students.getTotalElements());
        response.put("totalPages", students.getTotalPages());

        return ResponseEntity.ok(response);
    }

}
