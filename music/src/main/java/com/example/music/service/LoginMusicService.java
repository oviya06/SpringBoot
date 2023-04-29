package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.entity.LoginMusic;
import com.example.music.repository.LoginMusicRepository;

@Service
public class LoginMusicService {

	@Autowired
	LoginMusicRepository logMusRep;
	
	
	//(1)getall
	public List<LoginMusic> getAllDetails()
	{
		return logMusRep.findAll();
	}
	
	//(2)post
	public LoginMusic postLogMusic(LoginMusic lm)
	{
		return logMusRep.save(lm);
	}
	
	//(3) login - emailid & password
	public String validatingUser(String email,String password)
	{
		String result="";
		LoginMusic u=logMusRep.findByEmail(email);
		if(u==null)
		{
			result="Invalid user";
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				result="Login success";
			}
			else
			{
				result="Login failed";
			}
		}
		return result;
	}	
			
}
