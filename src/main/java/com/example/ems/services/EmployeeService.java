package com.example.ems.services;

import java.util.List;

import com.example.ems.entities.Employee;

public interface EmployeeService {
	
    Employee saveEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(Long id);
    
    Employee updateEmployee(Long id, Employee employee);
    
    void deleteEmployee(Long id);
}
