package com.example.springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
