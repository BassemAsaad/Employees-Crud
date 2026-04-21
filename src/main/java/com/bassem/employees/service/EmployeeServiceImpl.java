package com.bassem.employees.service;

import com.bassem.employees.dto.AddEmployeeRequest;
import com.bassem.employees.dto.EmployeeResponse;
import com.bassem.employees.dto.UpdateEmployeeRequest;
import com.bassem.employees.exception.EmployeeNotFoundException;
import com.bassem.employees.repos.EmployeeRepository;
import com.bassem.employees.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public EmployeeResponse save(AddEmployeeRequest request) {
        Employee employee = new Employee();

        employee.setId(0);
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setEmail(request.email());

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeResponse.from(savedEmployee);
    }

    @Override
    public EmployeeResponse update(UpdateEmployeeRequest request) {
        validateIdNotNull(request.id());

        Employee employee = getEmployeeById(request.id());

        if (request.firstName() != null) {
            employee.setFirstName(request.firstName());
        }
        if (request.lastName() != null) {
            employee.setLastName(request.lastName());
        }
        if (request.email() != null) {
            employee.setEmail(request.email());
        }

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeResponse.from(updatedEmployee);
    }

    private static void validateIdNotNull(Integer id) {
        if (id == null){
            throw new EmployeeNotFoundException("Employee id cannot be null");
        }
    }

    @Override
    public EmployeeResponse findById(int id) {
        validateIdNotNull(id);

         Employee employee = getEmployeeById(id);
         return EmployeeResponse.from(employee);
    }

    @Override
    public List<EmployeeResponse> findAll() {
        List<Employee> employees = employeeRepository.findAllByOrderByIdAsc();
        return employees.stream()
                .map(EmployeeResponse::from)
                .toList();
    }

    @Override
    public void deleteById(int id) {
        validateIdNotNull(id);

        getEmployeeById(id);

        employeeRepository.deleteById(id);
    }

    private Employee getEmployeeById(int id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() ->  new EmployeeNotFoundException("Employee not found with id: " + id));
    }

}






