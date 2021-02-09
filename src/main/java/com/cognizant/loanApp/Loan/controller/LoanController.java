package com.cognizant.loanApp.Loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loanApp.Loan.exception.LoanNotFoundException;
import com.cognizant.loanApp.Loan.model.AuthResponse;
import com.cognizant.loanApp.Loan.model.LoanDetails;
import com.cognizant.loanApp.Loan.service.LoanService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*")
//@RequestMapping("/loans")
public class LoanController {
	@Autowired
	private LoanService loanService;

//	@Autowired
//	private AuthClient authclient;

	@GetMapping("/getloan") ///////////////////////////////////// 1
	public List<LoanDetails> retrieveAllLoans() {
		// log.info("inside findAll()");
		return loanService.findAllLoans();
	}

	@GetMapping("/loanByNumber/{loanNumber}")
	public ResponseEntity<?> getLoansByLoanNumber(@PathVariable("loanNumber") int loanNumber) {

		LoanDetails loanDetails = loanService.getLoansById(loanNumber);

		return new ResponseEntity<>(loanDetails, HttpStatus.OK);

	}

	@PostMapping("/create") /////////////////////////////// 2
	public ResponseEntity<LoanDetails> createLoans(@RequestBody LoanDetails loanDetails) {
		// log.info("inside createLoan()");
		LoanDetails loan = loanService.createLoan(loanDetails);
		return new ResponseEntity<LoanDetails>(loan, HttpStatus.CREATED);
	}

//	
//	@PutMapping("/update")
//	public LoanDetails updateLoans(@RequestBody LoanDetails loanDetails)
//	{
//		//log.info("inside updateLoan()");
//		loanService.updateLoan(loanDetails);
//		return loanDetails;
//		
//	}
	@PutMapping("/update")
	public ResponseEntity<LoanDetails> updateLoans(@RequestBody LoanDetails loanDetails) {
		// log.info("inside updateLoan()");
		LoanDetails loan = loanService.updateLoan(loanDetails);
		return new ResponseEntity<LoanDetails>(loan, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{loanNumber}")
	public List<LoanDetails> deleteLoan(@PathVariable("loanNumber") int loanNumber) {
		// log.info("inside delete()");
		loanService.delete(loanNumber);
		return loanService.findAllLoans();

	}

}