package com.example.query_test.controller;

import com.example.query_test.entity.Department;
import com.example.query_test.entity.Employee;
import com.example.query_test.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<?> handleSearchAll() {
        List<Employee> employees = service.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> handleSearchById(@PathVariable("id") Long id) {
        Employee employee = service.getById(id);
        return ResponseEntity.ok(employee);
    }
}
