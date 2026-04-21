package com.bassem.employees.dto;

public record AddEmployeeRequest(
        String firstName,
        String lastName,
        String email
) {
}
