package com.example.query_test.service;

import com.example.query_test.entity.Department;
import com.example.query_test.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo repo;

    public List<Department> getAllDepartment() {
        return repo.findAll();
    }

    public Department getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("ERR_404, ID not found."));
    }
}
