package com.ecommerce.library.service.impl;

import com.ecommerce.library.dto.AdminDto;
import com.ecommerce.library.model.Admin;
import com.ecommerce.library.repository.AdminRepository;
import com.ecommerce.library.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AdminServiceImpl {
	 @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    public Admin findByUsername(String username) {
	        return adminRepository.findByUsername(username);
	    }

	    public Admin save(AdminDto adminDto) {
	        Admin admin = new Admin();
	        admin.setFirstName(adminDto.getFirstName());
	        admin.setLastName(adminDto.getLastName());
	        admin.setUsername(adminDto.getUsername());
	        admin.setPassword(adminDto.getPassword());
	        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
	        return adminRepository.save(admin);
	    }
}
