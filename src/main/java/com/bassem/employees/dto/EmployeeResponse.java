package com.bassem.employees.dto;

import com.bassem.employees.entity.Employee;

public record EmployeeResponse(
        int id,
        String firstName,
        String lastName,
        String email
) {
    public static EmployeeResponse from(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
