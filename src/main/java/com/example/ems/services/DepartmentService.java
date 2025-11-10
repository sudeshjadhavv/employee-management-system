package com.example.ems.services;

import java.util.List;

import com.example.ems.entities.Department;

public interface DepartmentService {
	
	    Department saveDepartment(Department department);
	    
	    List<Department> getAllDepartments();

}
