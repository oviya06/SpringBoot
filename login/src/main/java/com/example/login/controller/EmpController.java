package com.example.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.model.Emp;
import com.example.login.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	EmpService es;
	
	@GetMapping("/getid/{iid}")
	public Emp getEmpId(@PathVariable("iid") int id )
	{
		return es.getEmpId(id);
	}
	
	@GetMapping("/getall")
	public List<Emp> getAll(){
		return es.getAll();
	}
	
	@PostMapping("/post")
	public Emp postEmp(@RequestBody Emp ep)
	{
		return es.postEmp(ep);
	}
	
	@PutMapping("/put")
	public Emp putEmp(@RequestBody Emp epp)
	{
		return es.putEmp(epp);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable("id") int iid){
		es.deleteEmp(iid);
	}
}
