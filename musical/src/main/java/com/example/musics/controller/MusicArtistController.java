package com.example.musics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.example.musics.service.MusicArtistService;

@RestController
public class MusicArtistController {

	@Autowired
	MusicArtistService logMusSer;
	
	
}
