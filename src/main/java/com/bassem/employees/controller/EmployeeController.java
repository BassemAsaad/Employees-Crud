package com.bassem.employees.controller;

import com.bassem.employees.dto.AddEmployeeRequest;
import com.bassem.employees.dto.EmployeeResponse;
import com.bassem.employees.dto.UpdateEmployeeRequest;
import com.bassem.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody AddEmployeeRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.save(request));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(employeeService.findById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping
        public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody UpdateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(request));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);

        return ResponseEntity.noContent().build();
    }
}