package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.Admin;
import com.example.loan.service.AdminService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class AdminController {

	@Autowired
	AdminService adSer;
	
	        //(1) getall
			@Tag(name="Get",description="get all Admin")
			@GetMapping("/getAdminDetails")
			public List<Admin> getAdminDetails()
			{
				return adSer.getAdminDetails();
			}
			
			//(2)post
			@Tag(name="Post",description="post Admin")
			@PostMapping(value="/postAdminDetails")
			public Admin postAdminDetails(@RequestBody Admin m)
			{
				return adSer.postAdminDetails(m);
			}

}
