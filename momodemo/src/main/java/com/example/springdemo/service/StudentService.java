
package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.dao.StudentRepository;
import com.example.springdemo.model.Student;

@Service
public class StudentService {
@Autowired
	StudentRepository studRepository;

public List<Student> getAllStudents()
{
	List<Student> studList=studRepository.findAll();
	return studList;
}
public Student saveStudent(Student s)
{
	return studRepository .save(s);
//	(or)
//	Student obj = studRepository .save(s);
//	return obj;
}

public Student updateStudent(Student r)
{
	return studRepository .save(r);

}

public void deleteStudent(int regno)
{
	 studRepository.deleteById(regno);

}

public Student getIdStudents(int id)
{
	  return studRepository.findById(id).get();

}
}
