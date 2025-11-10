package com.example.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.entities.Department;
import com.example.ems.entities.Employee;
import com.example.ems.entities.Role;
import com.example.ems.repositories.DepartmentRepository;
import com.example.ems.repositories.EmployeeRepository;
import com.example.ems.repositories.RoleRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	 @Autowired
	 private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    
    @Override
	public Employee saveEmployee(Employee employee) {
    	 // Ensure valid department & role exist
        if (employee.getDepartment() != null) {
            Department dept = departmentRepository.findById(employee.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Invalid Department ID"));
            employee.setDepartment(dept);
        }

        if (employee.getRole() != null) {
            Role role = roleRepository.findById(employee.getRole().getId())
                    .orElseThrow(() -> new RuntimeException("Invalid Role ID"));
            employee.setRole(role);
        }

        return employeeRepository.save(employee);
	}

	 


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
	}

	
	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
	    Employee existingEmployee = employeeRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

	    // Update basic fields
	    existingEmployee.setName(updatedEmployee.getName());
	    existingEmployee.setEmail(updatedEmployee.getEmail());
	    existingEmployee.setSalary(updatedEmployee.getSalary());

	    // ✅ Load Department properly if provided
	    if (updatedEmployee.getDepartment() != null && updatedEmployee.getDepartment().getId() != null) {
	        Department dept = departmentRepository.findById(updatedEmployee.getDepartment().getId())
	                .orElseThrow(() -> new RuntimeException("Department not found with ID: " + updatedEmployee.getDepartment().getId()));
	        existingEmployee.setDepartment(dept);
	    }

	    // ✅ Load Role properly if provided
	    if (updatedEmployee.getRole() != null && updatedEmployee.getRole().getId() != null) {
	        Role role = roleRepository.findById(updatedEmployee.getRole().getId())
	                .orElseThrow(() -> new RuntimeException("Role not found with ID: " + updatedEmployee.getRole().getId()));
	        existingEmployee.setRole(role);
	    }

	    return employeeRepository.save(existingEmployee);
	}


	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}


	

}
