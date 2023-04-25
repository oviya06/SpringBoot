package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.Emp;

@Repository
public interface EmpRepository extends JpaRepository<Emp,Integer>{

}
