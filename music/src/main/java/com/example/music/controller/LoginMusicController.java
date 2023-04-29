package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.entity.LoginMusic;
import com.example.music.service.LoginMusicService;

@RestController
public class LoginMusicController {

	@Autowired
	LoginMusicService logMusSer;
	
	//(1) getall
	//localhost:8080/getAllDetails
	@GetMapping("/getAllDetails")
	public List<LoginMusic> getAllDetails()
	{
		return logMusSer.getAllDetails();
	}
	
	//(2)post
	//localhost:8080/postLogMusic
	@PostMapping(value="/postLogMusic")
	public LoginMusic postLogMusic(@RequestBody LoginMusic lm)
	{
		return logMusSer.postLogMusic(lm);
	}
	
	//(3) login - emailid & password
	@PostMapping("/validatingUser")
	public String validatingUser(@RequestBody LoginMusic u)
	{
		System.out.println(u.getEmail());
		return logMusSer.validatingUser(u.getEmail(),u.getPassword());
	}
}
