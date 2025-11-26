package com.example.query_test.service;

import com.example.query_test.entity.Department;
import com.example.query_test.entity.Employee;
import com.example.query_test.repo.DepartmentRepo;
import com.example.query_test.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo repo;
    private final DepartmentRepo deptRepo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("ERR_404, ID not found."));
    }

    public List<Department> getDeptName(Long id) {
        return deptRepo.findDeptNameByDeptId(id);
    }
}
