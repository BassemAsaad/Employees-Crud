package com.bassem.employees.controller;


import com.bassem.employees.entity.Employee;
import com.bassem.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeService.findAll());
        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String saveEmployee(Model model){
        model.addAttribute("newEmployee", new Employee());
        return "employees/add-employee";
    }
    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute("newEmployee") Employee employee){
        employeeService.save(employee);
        return "redirect:/api/employees/list";
    }

    @GetMapping("/edit")
    public String editEmployee(@RequestParam("id") int employeeId , Model model){
        model.addAttribute("editEmployee", employeeService.findById(employeeId));

        return "employees/edit-employee";
    }
    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute("editEmployee") Employee employee){
        employeeService.save(employee);
        return "redirect:/api/employees/list";
    }
    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        employeeService.deleteById(id);
        return "redirect:/api/employees/list";
    }

}
