package com.cognizant.loanApp.Loan.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.loanApp.Loan.exception.LoanNotFoundException;
import com.cognizant.loanApp.Loan.model.LoanDetails;
import com.cognizant.loanApp.Loan.repository.LoanRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class LoanServiceImpl implements LoanService{

	
	@Autowired
	LoanRepository loanRepository;
	
	@Override
	@Transactional
	public List<LoanDetails> findAllLoans()
	{
		return this.loanRepository.findAll();
	}
	
	@Override
	public LoanDetails getLoansById(int loanNumber)
	{
		return loanRepository.findById(loanNumber).get();
	}
	
	@Override
	public List<LoanDetails> delete(int loanNumber)
	{
		loanRepository.deleteById(loanNumber);
		return this.loanRepository.findAll();
	}
	
	@Override
    public LoanDetails createLoan(LoanDetails loanDetails) {
         loanRepository.save(loanDetails);
         return loanDetails;
    }
	
    @Override
    public LoanDetails updateLoan(LoanDetails loanDetails) {
        Optional < LoanDetails > loans = this.loanRepository.findById(loanDetails.getLoanNumber());

        	LoanDetails loanUpdate = loans.get();
        	loanUpdate.setLoanAmount(loanDetails.getLoanAmount());
        	loanUpdate.setLoanTerm(loanDetails.getLoanTerm());
        	loanUpdate.setLoanType(loanDetails.getLoanType());
        	//loanUpdate.setLoanType(loanDetails.getLoanType());
            
            loanRepository.save(loanUpdate);
            return loanUpdate;
       
    }



	
	
	
	
}

