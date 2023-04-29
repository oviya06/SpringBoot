package com.example.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.entity.Music;
import com.example.music.service.MusicService;

@RestController
public class MusicController {
	
	@Autowired
	MusicService musSer;
	//(1) getall
	//localhost:8080/getallDetails
	@GetMapping("/getallDetails")
	public List<Music> getallDetails()
	{
		return musSer.getallDetails();
	}
	
	//(2)post
	//localhost:8080/postMusic
	@PostMapping(value="/postMusic")
	public Music postMusic(@RequestBody Music m)
	{
		return musSer.postMusic(m);
	}

	//(4)delete
	//localhost:8080/deleteMusic/52
	@DeleteMapping("/deleteMusic/{iid}")
	public void deleteMusic(@PathVariable("iid") int id)
	{
		musSer.deleteMusic(id);
	}
	
	//(5)Sorting - ASC
	//localhost:8080/sortMusicAsc/age
	@GetMapping("/sortMusicAsc/{feild}")
	public List<Music> sortMusicAsc(@PathVariable String feild)
	{
		return musSer.sortMusicAsc(feild);
	}
	
	//(6)Sorting - DESC
	//localhost:8080/sortMusicDesc/nickname
	@GetMapping("/sortMusicDesc/{feild}")
	public List<Music> sortMusicDesc(@PathVariable String feild)
	{
		return musSer.sortMusicDesc(feild);
		
	}
	
	//(7)Pagination -> list
	//localhost:8080/listMusic/0/2
	@GetMapping("/listMusic/{offset}/{pageSize}")
	public List<Music> listMusic(@PathVariable int offset,@PathVariable int pageSize )
	{
		return musSer.listMusic(offset,pageSize);
	}
	
	//(8)Pagination -> page-(content,pageable)
	//localhost:8080/pagingMusic/0/2
	@GetMapping("/pagingMusic/{offset}/{pageSize}")
	public Page<Music> pagingMusic(@PathVariable int offset,@PathVariable int pageSize )
	{
		return musSer.pagingMusic(offset,pageSize);
	}
	
	//(9)Pagination & sorting-Asc
	//localhost:8080/sortListMusicAsc/0/2/id
	@GetMapping("/sortListMusicAsc/{offset}/{pageSize}/{field}")
	public List<Music> sortListMusicAsc(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable String field)
	{
		return musSer.sortListMusicAsc(offset,pageSize,field);
	}
	
	//(10)Pagination & sorting-Desc
	//localhost:8080/sortListMusicDesc/0/2/id
	@GetMapping("/sortListMusicDesc/{offset}/{pageSize}/{field}")
	public List<Music> sortListMusicDesc(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable String field)
	{
		return musSer.sortListMusicDesc(offset,pageSize,field);
	}
	
	//(11) name StartWith
	//localhost:8080/fetchMusicByNickPrefix?prefix=o
	@GetMapping("/fetchMusicByNickPrefix")
	public List<Music> fetchMusicByNickPrefix(@RequestParam String prefix)
	{
		return musSer.fetchMusicByNickPrefix(prefix);
	}

	//(12) name EndingWith
	//localhost:8080/fetchMusicByNickSuffix?suffix=a
	@GetMapping("/fetchMusicByNickSuffix")
	public List<Music> fetchMusicByNickSuffix(@RequestParam String suffix)
	{
		return musSer.fetchMusicByNickSuffix(suffix);
	}

	//(13) search with department
	//localhost:8080/fetchMusicByGender?gender=female
	@GetMapping("/fetchMusicByGender")
	public List<Music> fetchMusicByGender(@RequestParam String gender)
	{
		return musSer.fetchMusicByGender(gender);
	}
	
	//(14) positional parameter
	//localhost:8080/getPositional/ovs@gmail.com/Ovs
	@GetMapping("/getPositional/{email}/{nickname}")
	public List<Music> getPositional(@PathVariable String email,@PathVariable String nickname)
	{
		return musSer.getPositional(email,nickname);
	}
	
	//(15) login - emailid & password
	@PostMapping("/checkLogin")
	public String validateUser(@RequestBody Music u)
	{
	System.out.println(u.getEmail());
		return musSer.validateUser(u.getEmail(),u.getPassword());
	}


}
