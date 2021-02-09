package com.cognizant.loanApp.Loan.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.loanApp.Loan.model.LoanDetails;
import com.cognizant.loanApp.Loan.repository.LoanRepository;
import com.cognizant.loanApp.Loan.service.LoanServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {

	@InjectMocks
	LoanServiceImpl service;

	@Mock
	LoanRepository repo;

	@Mock
	LoanDetails loanDetails;

	@Test
	public void findALl() {
		List<LoanDetails> loanDetails = new ArrayList<LoanDetails>();
		when(repo.findAll()).thenReturn(loanDetails);
		service.findAllLoans();
		verify(repo).findAll();
	}
//	@Test
//	public void findById() {
//		int loanNumber = 1;
//		//Optional<LoanDetails> loanDetails = Optional.empty();
//		when(repo.findById(loanNumber)).thenReturn(new LoanDetails(1,"Samaira","baronia","address",1234,"home",1));
//		service.getLoansById(loanNumber);
//		verify(repo).findById(loanNumber);
//		}

	@Test
	public void delete() {
		int loanNumber = 1;
		List<LoanDetails> loanDetails = new ArrayList<LoanDetails>();
		// repo.deleteById(loanNumber);
		service.delete(loanNumber);
		verify(repo).deleteById(loanNumber);
	}

	@Test
	public void create() {
		int loanNumber = 1;
		LoanDetails loanDetails = null;
		when(repo.save(loanDetails)).thenReturn(loanDetails);
		service.createLoan(loanDetails);
		verify(repo).save(loanDetails);
	}
//	@Test
//	public void update() {
//		LoanDetails l = new LoanDetails();
//		int loanNumber = 1;
//		when(repo.save(l)).thenReturn(loanDetails);
//		loanDetails.setLoanAmount(1234);
//		loanDetails.setLoanType("home");
//		loanDetails.setLoanTerm(1);
//		service.updateLoan4(l);
//		verify(repo).save(l);
//		}

}
