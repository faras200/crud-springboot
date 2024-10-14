package com.example.crud_springboot.service;

import com.example.crud_springboot.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
