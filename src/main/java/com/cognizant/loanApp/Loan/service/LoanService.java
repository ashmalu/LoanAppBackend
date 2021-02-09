package com.cognizant.loanApp.Loan.service;

import java.util.List;

import com.cognizant.loanApp.Loan.model.LoanDetails;

public interface LoanService{
	List<LoanDetails> findAllLoans();
	LoanDetails getLoansById(int loanNumber);
	List<LoanDetails> delete(int loanNumber);

	LoanDetails updateLoan(LoanDetails loanDetails);
	LoanDetails createLoan(LoanDetails loanDetails);

}
