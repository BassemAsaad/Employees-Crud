package com.bassem.employees.service;

import com.bassem.employees.dto.AddEmployeeRequest;
import com.bassem.employees.dto.EmployeeResponse;
import com.bassem.employees.dto.UpdateEmployeeRequest;
import com.bassem.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse save(AddEmployeeRequest request);

    EmployeeResponse update(UpdateEmployeeRequest request);

    List<EmployeeResponse> findAll();

    EmployeeResponse findById(int id);

    void deleteById(int id);
}
