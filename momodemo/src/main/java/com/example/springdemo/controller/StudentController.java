package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Student;
import com.example.springdemo.service.StudentService;

@RestController
public class StudentController {
@Autowired

	StudentService studService ;

//localhost:8080/fetchStudents
@GetMapping(value="/fetchStudents")
public List<Student> getAllStudents()
{
	List<Student> studList = studService.getAllStudents();
	return studList;
}

//localhost:8080/saveStudent
@PostMapping(value="/saveStudent")
public Student saveStudent(@RequestBody Student s)
{
	return studService.saveStudent(s);
}

//localhost:8080/updateStudent
@PutMapping(value="/updateStudent")
public Student updateStudent(@RequestBody Student s)
{
	return studService.updateStudent(s);
}

//localhost:8080/deleteStudent/102
@DeleteMapping(value="/deleteStudent/{rno}")
public void deleteStudent(@PathVariable("rno") int regno)
{
	studService.deleteStudent(regno);
}

//localhost:8080/fetchIdStudents/103
@GetMapping(value="/fetchIdStudents/{iid}")
public Student getIdStudents(@PathVariable("iid") int id)
{
	return studService.getIdStudents(id);
}
}
