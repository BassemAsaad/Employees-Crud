package com.bassem.employees.exception;

public record EmployeeErrorResponse(
        int status,
        String message,
        long timeStamp
) {
    public EmployeeErrorResponse(int status, String message) {
        this(status, message, System.currentTimeMillis());
    }
}
