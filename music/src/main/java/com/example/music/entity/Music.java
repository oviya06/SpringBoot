package com.example.music.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Music {
	@Id
	@GeneratedValue
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
	private String likablemusic1;
	private String likablemusic2;
	private String likablemusic3;
	private String likableartist1;
	private String likableartist2;
	private String likableartist3;
	public int getId() {
		return id;
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
	public String getLikablemusic1() {
		return likablemusic1;
	}
	public void setLikablemusic1(String likablemusic1) {
		this.likablemusic1 = likablemusic1;
	}
	public String getLikablemusic2() {
		return likablemusic2;
	}
	public void setLikablemusic2(String likablemusic2) {
		this.likablemusic2 = likablemusic2;
	}
	public String getLikablemusic3() {
		return likablemusic3;
	}
	public void setLikablemusic3(String likablemusic3) {
		this.likablemusic3 = likablemusic3;
	}
	public String getLikableartist1() {
		return likableartist1;
	}
	public void setLikableartist1(String likableartist1) {
		this.likableartist1 = likableartist1;
	}
	public String getLikableartist2() {
		return likableartist2;
	}
	public void setLikableartist2(String likableartist2) {
		this.likableartist2 = likableartist2;
	}
	public String getLikableartist3() {
		return likableartist3;
	}
	public void setLikableartist3(String likableartist3) {
		this.likableartist3 = likableartist3;
	}
	
	

}
