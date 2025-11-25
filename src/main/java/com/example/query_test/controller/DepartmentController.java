package com.example.query_test.controller;

import com.example.query_test.entity.Department;
import com.example.query_test.entity.Student;
import com.example.query_test.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping
    public ResponseEntity<?> handleSearchAll() {
        List<Department> departments = service.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> handleSearchById(@PathVariable("id") Long id) {
        Department department = service.getById(id);
        return ResponseEntity.ok(department);
    }
}
