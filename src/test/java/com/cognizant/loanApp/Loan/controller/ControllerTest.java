package com.cognizant.loanApp.Loan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cognizant.loanApp.Loan.model.LoanDetails;
import com.cognizant.loanApp.Loan.repository.LoanRepository;
import com.cognizant.loanApp.Loan.service.LoanService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ControllerTest {

	@InjectMocks
	LoanController loanController;

	@Mock
	private LoanService loanService;

	@Mock
	private LoanRepository loanRepo;

	@Mock
	LoanDetails loanDetails;

	List<LoanDetails> loanDetailsList;

	int laonNumber = 1;

	@Test
	public void getAllLoansTest() {
		when(loanRepo.findAll())
				.thenReturn(Stream.of(new LoanDetails(1, 1234.0, 2, "home", "mandla", "samaira", "baronia"))
						.collect(Collectors.toList()));
		assertEquals(0, loanController.retrieveAllLoans().size());
	}

	@Test
	public void getDetailsByLoanNumberTest() {
		int loanNumber = 1;
		when(loanService.getLoansById(loanNumber))
				.thenReturn(new LoanDetails(1, 1234.0, 2, "home", "mandla", "samaira", "baronia"));
		assertNotNull(loanDetails);
		ResponseEntity<?> loanDetails = loanController.getLoansByLoanNumber(loanNumber);
		// assertEquals(200, loanDetails.getStatusCodeValue());
		assertNotNull(loanDetails);
	}

	@Test
	public void createLoansTest() {
		LoanDetails loan = new LoanDetails(1, 8888, 20, "Gold", "Maheshwar", "Ashish", "Malviya");
		when(loanService.createLoan(loan)).thenReturn(loan);
		ResponseEntity<?> loanDetails = loanController.createLoans(loan);
		// assertEquals(200, loanDetails.getStatusCodeValue());
		assertNotNull(loanDetails);
	}

	@Test
	public void updateLoanTest() {
		LoanDetails loan = new LoanDetails(1, 8888, 20, "Gold", "Maheshwar", "Ashish", "Malviya");
		int lNumber = 1;

		when(loanService.updateLoan(loan)).thenReturn(loan);
		ResponseEntity<?> loanDetails = loanController.updateLoans(loan);
		assertNotNull(loanDetails);
	}

	@Test
	public void deleteLoanTest() {
		int loanNumber = 1;
		LoanDetails l = new LoanDetails(1, 8888, 20, "Gold", "Maheshwar", "Ashish", "Malviya");
		when(loanService.delete(1))
				.thenReturn(Stream.of(new LoanDetails(1, 8888, 20, "Gold", "Maheshwar", "Ashish", "Malviya"))
						.collect(Collectors.toList()));
		assertEquals(0, loanController.deleteLoan(loanNumber).size());

	}

}