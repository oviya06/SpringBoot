package com.example.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.Emp;
import com.example.login.repository.EmpRepository;

@Service
public class EmpService {
	@Autowired
	EmpRepository er;
	
	public Emp getEmpId(int id){
		return er.findById(id).get();
	}
	
	public List<Emp> getAll(){
		return er.findAll();
	}

	public Emp postEmp(Emp id) {
		return er.save(id);
	}
	
	public Emp putEmp(Emp id) {
		return er.save(id);
	}
	
	public void deleteEmp(int iid) {
		er.deleteById(iid);
	}
}
