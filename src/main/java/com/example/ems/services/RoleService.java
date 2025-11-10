package com.example.ems.services;


import java.util.List;

import com.example.ems.entities.Role;

public interface RoleService {
	
    Role saveRole(Role role);
    
    List<Role> getAllRoles();
}

