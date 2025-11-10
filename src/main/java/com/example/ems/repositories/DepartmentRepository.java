package com.example.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ems.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Long> {

}
