package com.example.ems.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.ems.entities.*;
import com.example.ems.repositories.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employeeDetails) {
        Employee employee = new Employee();
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setSalary(employeeDetails.getSalary());

        Department dept = departmentRepository.findById(employeeDetails.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        Role role = roleRepository.findById(employeeDetails.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        employee.setDepartment(dept);
        employee.setRole(role);

        return employeeRepository.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return "Employee deleted successfully!";
    }
}
