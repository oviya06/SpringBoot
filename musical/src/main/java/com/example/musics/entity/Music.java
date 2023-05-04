package com.example.musics.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Music {
	@Id
	private int id;
	@Column(unique=true)
	private String email;
	private String password;
	@Column(unique=true)
	private String nickname;
	@Column(length=4)
	private int dyear;
	private String dmonth;
	@Column(length=2)
	private int ddate;
	private String gender;
	@Column(length=2)
	private int age;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="music_id")
	private List<MusicArtist> music;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<MusicArtist> getMusic() {
		return music;
	}
	public void setMusic(List<MusicArtist> music) {
		this.music = music;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getDyear() {
		return dyear;
	}
	public void setDyear(int dyear) {
		this.dyear = dyear;
	}
	public String getDmonth() {
		return dmonth;
	}
	public void setDmonth(String dmonth) {
		this.dmonth = dmonth;
	}
	public int getDdate() {
		return ddate;
	}
	public void setDdate(int ddate) {
		this.ddate = ddate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	

}
