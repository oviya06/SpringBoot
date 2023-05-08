package com.example.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loan.model.Login;
import com.example.loan.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	//(17)DML delete query
	@Modifying
	@Query("delete from User s where s.email=?1")
	public int deleteUserByEmail(String email);
	
	
	//(18)DML update query
	@Modifying
	@Query("update User s set s.password=?1,s.username=?2,s.mobileNumber=?3,s.userRole=?4 where s.email=?2")
	public int updateUserByEmail(String pass,String name,String phoneno,String role,String email);
	
	//public User checkemail(Login l);
}
