package com.example.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
@Id
//@GeneratedValued  can use if it an integer
private int regno;
private String name;
private String department;
private String email;


public int getRegno() {
	return regno;
}
public void setRegno(int regno) {
	this.regno = regno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
