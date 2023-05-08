package com.example.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.LoanApplication;
import com.example.loan.repository.LoanApplicationRepository;
@Service
public class LoanApplicationService {
	
	@Autowired
	LoanApplicationRepository appRep;
	
	//(1)getall
		public List<LoanApplication> getLoanDetails()
		{
			return appRep.findAll();
		}
		
		//(2)post
		public LoanApplication postLoanDetails(LoanApplication m)
		{
			return appRep.save(m);
		}

		//(4)put -2
		public LoanApplication putApplication(LoanApplication s,int loanid) {
			Optional<LoanApplication> optional = appRep.findById(loanid);
			LoanApplication obj = null;
			if(optional.isPresent())
			{
				obj=optional.get();
				appRep.save(s);
			}
			return obj;
		}

		//(5)delete
		public void deleteApplication(int loanid)
		{
			 appRep.deleteById(loanid);
		}
}
