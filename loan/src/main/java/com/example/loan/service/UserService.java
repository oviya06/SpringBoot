package com.example.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.User;
import com.example.loan.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository userRep;
	
	//(1)getall
	public List<User> getUserDetails()
	{
		return userRep.findAll();
	}
	
	//(2)post
	public User postUserDetails(User m)
	{
		return userRep.save(m);
	}
	
	//(4)put -2
	public User putUser(User s,int rno) {
		Optional<User> optional = userRep.findById(rno);
		User obj = null;
		if(optional.isPresent())
		{
			obj=optional.get();
			userRep.save(s);
		}
		return obj;
	}

	//(5)delete
	public void deleteUser(int regno)
	{
		 userRep.deleteById(regno);
	}
	
	//(17) DML delete query
	@Transactional
	public int deleteByEmail(String email){
		return userRep.deleteUserByEmail(email);
	}

	//(18) DML update query
	@Transactional
	public int updateByEmail(String pass,String name,String phoneno,String role,String email){
		return userRep.updateUserByEmail(pass,name,phoneno,role,email);
	}
}
