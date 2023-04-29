package com.example.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.music.entity.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>{
	public List<Music>findByNicknameStartingWith(String prefix);
	public List<Music>findByNicknameEndingWith(String suffix);
	public List<Music>findByGender(String gender);
	
	//positional parameter
	@Query("select m from Music m where m.email=?1 and m.nickname=?2")
	public List<Music> fetchPositional(String email,String nickname);
	
	//login - emailid & password
	Music findByEmail(String email);


}
