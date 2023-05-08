package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.User;
import com.example.loan.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
@CrossOrigin("*")
@RestController

public class UserController {

	@Autowired
	UserService userSer;
	
	//(1) getall
	//localhost:8080/getUserDetails
	@Tag(name="Get",description="get details")
	@GetMapping("/getUserDetails")
	public List<User> getUserDetails()
	{
		return userSer.getUserDetails();
	}
	
	//(2)post
	//localhost:8080/postUserDetails
	@Tag(name="Post",description="get details")
	@PostMapping(value="/postUserDetails")
	public User postUserDetails(@RequestBody User m)
	{
		return userSer.postUserDetails(m);
	}
	
	//(4)put -2
	@Tag(name="Put",description="update by id")
	@PutMapping(value="/putUser/{rno}")
	public User putUser(@RequestBody User s,@PathVariable int rno)
	{
		return userSer.putUser(s,rno);
	}

	//(5)delete
	@Tag(name="Delete",description="Delete by id")
	@DeleteMapping(value="/deleteUser/{rno}")
	public void deleteUser(@PathVariable("rno") int regno)
	{
		userSer.deleteUser(regno);
	}
	
	//(17) DML delete query
	@Tag(name="Delete",description="delete details")
	@DeleteMapping("/deleteByEmail/{email}")
	public String deleteByEmail(@PathVariable String email)
	{
		int result = userSer.deleteByEmail(email);
		if(result>0)
			return "record deleted";
		else
			return "Problem occured while deleting";
	}

	//(18) DML update query
	@Tag(name="Put",description="set details")
	@PutMapping("/updateByEmail/{pass}/{name}/{phoneno}/{role}/{email}")
	public String updateByEmail(@PathVariable String pass,@PathVariable String name,@PathVariable String phoneno,@PathVariable String role,@PathVariable String email)
	{
		int result = userSer.updateByEmail(pass,name,phoneno,role,email);
		if(result>0)
			return "updated";
		else
			return "not updated";
	}

}
