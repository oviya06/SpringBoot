package com.example.musics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MusicArtist {
	@Id
	private int id;
	private String likablemusic;
	private String likableartist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLikablemusic() {
		return likablemusic;
	}
	public void setLikablemusic(String likablemusic) {
		this.likablemusic = likablemusic;
	}
	public String getLikableartist() {
		return likableartist;
	}
	public void setLikableartist(String likableartist) {
		this.likableartist = likableartist;
	}
	


}
