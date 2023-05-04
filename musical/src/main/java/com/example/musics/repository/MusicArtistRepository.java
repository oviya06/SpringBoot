package com.example.musics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musics.entity.MusicArtist;

@Repository
public interface MusicArtistRepository extends JpaRepository<MusicArtist,Integer> {

	
}
