package com.example.crud_springboot.controller;

import com.example.crud_springboot.model.Employee;
import com.example.crud_springboot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> findAllEmployees() {
        List<Employee> employees = employeeService.findAll();

        // Mempersiapkan format response untuk setiap employee
        List<Map<String, Object>> responseList = employees.stream().map(employee -> {
            Map<String, Object> response = new HashMap<>();
            response.put("nama", employee.getNamaKaryawan());
            response.put("tanggal_lahir", employee.getTanggalLahir().toString());
            response.put("alamat", employee.getAlamat());
            response.put("email", employee.getEmail());

            List<Map<String, Object>> keluargaList = employee.getKeluarga().stream().map(familyMember -> {
                Map<String, Object> familyMap = new HashMap<>();
                familyMap.put("hubungan", familyMember.getHubunganKeluarga());
                familyMap.put("nama", familyMember.getNamaAnggotaKeluarga());
                familyMap.put("tanggal_lahir", familyMember.getTanggalLahirAnggotaKeluarga().toString());
                return familyMap;
            }).collect(Collectors.toList());

            response.put("keluarga", keluargaList);
            return response;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(responseList);
    }
}
