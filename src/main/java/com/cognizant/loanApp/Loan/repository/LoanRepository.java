package com.cognizant.loanApp.Loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.loanApp.Loan.model.LoanDetails;

@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Integer>{

}
