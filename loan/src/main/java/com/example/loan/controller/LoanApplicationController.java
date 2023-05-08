package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.LoanApplication;
import com.example.loan.service.LoanApplicationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class LoanApplicationController {

	@Autowired
	LoanApplicationService appSer;
	
	//(1) getall
		//localhost:8080/getallDetails
		@Tag(name="Get",description="get all LoanApplication")
		@GetMapping("/getLoanDetails")
		public List<LoanApplication> getLoanDetails()
		{
			return appSer.getLoanDetails();
		}
		
		//(2)post
		//localhost:8080/postUserDetails
		@Tag(name="Post",description="post LoanApplication")
		@PostMapping(value="/postLoanDetails")
		public LoanApplication postLoanDetails(@RequestBody LoanApplication m)
		{
			return appSer.postLoanDetails(m);
		}
		
		//(4)put -2
		@Tag(name="Put",description="update by id")
		@PutMapping(value="/putApplication/{rno}")
		public LoanApplication putApplication(@RequestBody LoanApplication s,@PathVariable int loanid)
		{
			return appSer.putApplication(s,loanid);
		}

		//(5)delete
		@Tag(name="Delete",description="Delete by id")
		@DeleteMapping(value="/deleteApplication/{loanid}")
		public void deleteApplication(@PathVariable int loanid)
		{
			appSer.deleteApplication(loanid);
		}
}
