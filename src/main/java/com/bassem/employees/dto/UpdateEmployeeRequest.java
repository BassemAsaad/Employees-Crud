package com.bassem.employees.dto;

public record UpdateEmployeeRequest(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
