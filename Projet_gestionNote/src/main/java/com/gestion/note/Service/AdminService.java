package com.gestion.note.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.note.Repository.AdminRepository;
import com.gestion.note.entities.Admin;

@Service
public class AdminService {
      
	private final AdminRepository adminRepository;

	@Autowired
	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	
}
