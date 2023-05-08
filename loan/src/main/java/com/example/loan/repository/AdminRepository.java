package com.example.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loan.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {

}
