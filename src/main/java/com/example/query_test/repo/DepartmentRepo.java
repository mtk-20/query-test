package com.example.query_test.repo;

import com.example.query_test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d INNER JOIN Employee e ON e.deptId=d.id")
    List<Department> findDeptNameByDeptId(Long id);
}
