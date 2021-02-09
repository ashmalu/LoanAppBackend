package com.cognizant.loanApp.Loan.exception;

public class LoanNotFoundException extends RuntimeException {

	public LoanNotFoundException(String message) {
        super(message);
    }
}
