package com.example.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.music.entity.LoginMusic;

@Repository
public interface LoginMusicRepository extends JpaRepository<LoginMusic,Integer> {

	//login - emailid & password
	LoginMusic findByEmail(String email);
}
