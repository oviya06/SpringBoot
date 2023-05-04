package com.example.musics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.musics.entity.Music;
import com.example.musics.service.MusicService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
public class MusicController {
	
	@Autowired
	MusicService musSer;
	
	
	//(1) getall
	//localhost:8080/getallDetails
	@Tag(name="Get",description="get details")
	@GetMapping("/getallDetails")
	public List<Music> getallDetails()
	{
		return musSer.getallDetails();
	}
	
	//(2)post
	//localhost:8080/postMusic
//	{ 
//	    "id":101,
//	    "email": "gokul@gmail.com",
//        "password": "go.cool",
//        "nickname": "gokul",
//        "dyear": 2002,
//        "dmonth": "Feburary",
//        "ddate": 22,
//        "gender": "Male",
//        "age": 21, 
//	    "music":
//	        [ 
//	            { 
//	            "id": 1,
//	            "likablemusic": "Tamil",
//                "likableartist": "Yuvan Shankar Raja"
//	            }, 
//	            { 
//	            "id": 2,
//	            "likablemusic": "Marathi",
//                "likableartist": "A. R. Rahman"
//	            },
//                { 
//	            "id": 3,
//	            "likablemusic": "kannada",
//                "likableartist": "G. V. Prakash"
//	            }
//	        ]
//	}
	@Tag(name="Post",description="post details")
	@PostMapping(value="/postMusic")
	public Music postMusic(@RequestBody Music m)
	{
		return musSer.postMusic(m);
	}

	//(4)delete
	//localhost:8080/deleteMusic/52
	@Tag(name="Delete",description="delete details")
	@DeleteMapping("/deleteMusic/{iid}")
	public void deleteMusic(@PathVariable("iid") int id)
	{
		musSer.deleteMusic(id);
	}
	
	//(5)Sorting - ASC
	//localhost:8080/sortMusicAsc/age
	@Tag(name="Get",description="sort-ASC details")
	@GetMapping("/sortMusicAsc/{feild}")
	public List<Music> sortMusicAsc(@PathVariable String feild)
	{
		return musSer.sortMusicAsc(feild);
	}
	
	//(6)Sorting - DESC
	//localhost:8080/sortMusicDesc/nickname
	@Tag(name="Get",description="sort-DESC details")
	@GetMapping("/sortMusicDesc/{feild}")
	public List<Music> sortMusicDesc(@PathVariable String feild)
	{
		return musSer.sortMusicDesc(feild);
		
	}
	
	//(7)Pagination -> list
	//localhost:8080/listMusic/0/2
	@Tag(name="Get",description="pagination(list) details")
	@GetMapping("/listMusic/{offset}/{pageSize}")
	public List<Music> listMusic(@PathVariable int offset,@PathVariable int pageSize )
	{
		return musSer.listMusic(offset,pageSize);
	}
	
	//(8)Pagination -> page-(content,pageable)
	//localhost:8080/pagingMusic/0/2
	@Tag(name="Get",description="pagination(page) details")
	@GetMapping("/pagingMusic/{offset}/{pageSize}")
	public Page<Music> pagingMusic(@PathVariable int offset,@PathVariable int pageSize )
	{
		return musSer.pagingMusic(offset,pageSize);
	}
	
	//(9)Pagination & sorting-Asc
	//localhost:8080/sortListMusicAsc/0/2/id
	@Tag(name="Get",description="pagination & sort(ASC) details")
	@GetMapping("/sortListMusicAsc/{offset}/{pageSize}/{field}")
	public List<Music> sortListMusicAsc(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable String field)
	{
		return musSer.sortListMusicAsc(offset,pageSize,field);
	}
	
	//(10)Pagination & sorting-Desc
	//localhost:8080/sortListMusicDesc/0/2/id
	@Tag(name="Get",description="pagination & sort(DESC) details")
	@GetMapping("/sortListMusicDesc/{offset}/{pageSize}/{field}")
	public List<Music> sortListMusicDesc(@PathVariable int offset,@PathVariable int pageSize ,@PathVariable String field)
	{
		return musSer.sortListMusicDesc(offset,pageSize,field);
	}
	
	//(11) name StartWith
	//localhost:8080/fetchMusicByNickPrefix?prefix=o
	@Tag(name="Get",description="Startwith")
	@GetMapping("/fetchMusicByNickPrefix")
	public List<Music> fetchMusicByNickPrefix(@RequestParam String prefix)
	{
		return musSer.fetchMusicByNickPrefix(prefix);
	}

	//(12) name EndingWith
	//localhost:8080/fetchMusicByNickSuffix?suffix=a
	@Tag(name="Get",description="Endwith")
	@GetMapping("/fetchMusicByNickSuffix")
	public List<Music> fetchMusicByNickSuffix(@RequestParam String suffix)
	{
		return musSer.fetchMusicByNickSuffix(suffix);
	}

	//(13) search with department
	//localhost:8080/fetchMusicByGender?gender=female
	@Tag(name="Get",description="Searchwith department")
	@GetMapping("/fetchMusicByGender")
	public List<Music> fetchMusicByGender(@RequestParam String gender)
	{
		return musSer.fetchMusicByGender(gender);
	}
	
	//(14) positional parameter
	//localhost:8080/getPositional/ovs@gmail.com/Ovs
	@Tag(name="Get",description="positional parameter")
	@GetMapping("/getPositional/{email}/{nickname}")
	public List<Music> getPositional(@PathVariable String email,@PathVariable String nickname)
	{
		return musSer.getPositional(email,nickname);
	}
	
	//(15) login - emailid & password
	@Tag(name="Post",description="checklogin")
	@PostMapping("/checkLogin")
	public String validateUser(@RequestBody Music u)
	{
	System.out.println(u.getEmail());
		return musSer.validateUser(u.getEmail(),u.getPassword());
	}

	
	//(16) named parameter
	//localhost:8080/getNamedParameter/gokul
	@Tag(name="Get",description="named Parameter")
	@GetMapping("/getNamedParameter/{name}")
	public List<Music> getNamedParameter(@PathVariable String name){
		return musSer.getNamedParameter(name);
	}

	
	//(17) DML delete query
	//localhost:8080/deleteByNickname/kumar
	@Tag(name="Delete",description="DML delete query")
	@DeleteMapping("/deleteByNickname/{name}")
	public String deleteByNickname(@PathVariable String name)
	{
		int result = musSer.deleteByNickname(name);
		if(result>0)
			return "Student record deleted";
		else
			return "Problem occured while deleting";
	}

	//(18) DML update query
	//localhost:8080/updateByName/ece/ajay
	@Tag(name="Put",description="DML update query")
	@PutMapping("/updateByEmail/{pass}/{email}")
	public String updateByEmail(@PathVariable String pass,@PathVariable String email)
	{
		int result = musSer.updateByEmail(pass,email);
		if(result>0)
			return "updated";
		else
			return "not updated";
	}
	
//	//(19)nativeQuery
//	//localhost:8080/nativeQuery
//	@GetMapping("/nativeQuery")
//	public List<Music> nativeQuery()
//	{
//		return musSer.nativeQuery();
//	}
}
