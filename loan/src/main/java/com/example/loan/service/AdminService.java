package com.example.loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.Admin;
import com.example.loan.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adRep;
	
	//(1)getall
	public List<Admin> getAdminDetails()
	{
		return adRep.findAll();
	}
	
	//(2)post
	public Admin postAdminDetails(Admin m)
	{
		return adRep.save(m);
	}
}
