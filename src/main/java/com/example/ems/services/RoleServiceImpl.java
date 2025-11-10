package com.example.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems.entities.Role;
import com.example.ems.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	    @Autowired
	    private RoleRepository roleRepository;

	    @Override
	    public Role saveRole(Role role) {
	        return roleRepository.save(role);
	    }

	    @Override
	    public List<Role> getAllRoles() {
	        return roleRepository.findAll();
	    }
}
