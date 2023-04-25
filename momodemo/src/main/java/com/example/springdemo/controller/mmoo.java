package com.example.springdemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mmoo {
	   
  @GetMapping("/we")
 public String wel(@RequestParam String username,@RequestParam String password)
 {
	if (username.equals("Ovs")&&password.equals("Root@123"))
	{
		return "Login Successfully";
	}
	else
	{
		return "Login failed , plz check ur username & password";
	}
 }
}
 