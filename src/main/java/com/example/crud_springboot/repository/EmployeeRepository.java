package com.example.crud_springboot.repository;

import com.example.crud_springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT '*' FROM Employee")
    List<Employee> getAllData();
}
