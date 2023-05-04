package com.example.musics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.musics.entity.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music,Integer>{
	public List<Music>findByNicknameStartingWith(String prefix);
	public List<Music>findByNicknameEndingWith(String suffix);
	public List<Music>findByGender(String gender);
	
	//login - emailid & password
		Music findByEmail(String email);
	
	//(14)positional parameter
	@Query("select m from Music m where m.email=?1 and m.nickname=?2")
	public List<Music> fetchPositional(String email,String nickname);
	
	//(16)named parameter
	@Query("select s from Music s where s.nickname=:name")
	public List<Music> fetchNamedParameter(String name);

	
	//(17)DML delete query
	@Modifying
	@Query("delete from Music s where s.nickname=?1")
	public int deleteMusicByNickname(String name);
	
	
	//(18)DML update query
	@Modifying
	@Query("update Music s set s.password=?1 where s.email=?2")
	public int updateMusicByEmail(String pass,String email);
	

	
}
