package com.example.musics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.musics.entity.Music;
import com.example.musics.repository.MusicRepository;

import jakarta.transaction.Transactional;


@Service
public class MusicService {

	@Autowired
	MusicRepository musRep;
	
	//(1)getall
	public List<Music> getallDetails()
	{
		return musRep.findAll();
	}
	
	//(2)post
	public Music postMusic(Music m)
	{
		return musRep.save(m);
	}
	
	
	//(4)delete
	public void deleteMusic(int id)
	{
		 musRep.deleteById(id);
	}

	//(5)Sorting - ASC
	public List<Music> sortMusicAsc(String feild)
	{
		return musRep.findAll(Sort.by(feild));
	}
	
	//(6)Sorting - DESC
	public List<Music> sortMusicDesc(String feild)
	{
		return musRep.findAll(Sort.by(Direction.DESC,feild));
	}

	//(7)Pagination -> list
	public List<Music> listMusic(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<Music> musData=musRep.findAll(paging);
		List<Music> musList = musData.getContent() ;
		return musList;
	}
	
	//(8)Pagination -> page-(content,pageable)
	public Page<Music> pagingMusic(int offset,int pageSize)
	{
		Pageable paging = PageRequest.of(offset,pageSize);
		Page<Music> musData=musRep.findAll(paging);
		return musData;
	}
	
	//(9)Pagination & sorting-Asc
	public List<Music> sortListMusicAsc(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(field));
		Page<Music> musData=musRep.findAll(paging);
		List<Music> musList = musData.getContent() ;
		return musList;
	}
	
	//(10)Pagination & sorting-Desc
	public List<Music> sortListMusicDesc(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize).withSort(Sort.by(Direction.DESC,field));
		Page<Music> musData=musRep.findAll(paging);
		List<Music> musList = musData.getContent() ;
		return musList;
	}
	
	//(11) name StartWith
	public List<Music> fetchMusicByNickPrefix(String prefix)
	{
		return musRep.findByNicknameStartingWith(prefix);
	}

	//(12) name EndingWith
	public List<Music> fetchMusicByNickSuffix(String suffix)
	{
		return musRep.findByNicknameEndingWith(suffix);
	}

	//(13) search with department
	public List<Music> fetchMusicByGender(String gender)
	{
		return musRep.findByGender(gender);
	}
	
	//(14) positional parameter
	public List<Music> getPositional(String email,String nickname)
	{
		return musRep.fetchPositional(email,nickname);
	}
	
	//(15) login - emailid & password
	public String validateUser(String email,String password)
	{
		String result="";
		Music u=musRep.findByEmail(email);
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

	//(16) named parameter
	public List<Music> getNamedParameter(String name){
		return musRep.fetchNamedParameter(name);
	}
	
	//(17) DML delete query
	@Transactional
	public int deleteByNickname(String name){
		return musRep.deleteMusicByNickname(name);
	}

	//(18) DML update query
	@Transactional
	public int updateByEmail(String pass,String email){
		return musRep.updateMusicByEmail(pass,email);
	}


	
}
