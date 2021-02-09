package com.cognizant.loanApp.Loan.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ModelTest {

	@Test
	public void gettersetterAuthResponseTest() {
		AuthResponse response = new AuthResponse();
		response.setName("test");
		response.setUid("testuid");
		response.setValid(true);

		assertEquals("test", response.getName());
		assertEquals("testuid", response.getUid());
		assertEquals(true, response.isValid());
	}

	@Test
	public void constructerAuthResponseTest() {
		AuthResponse responseNoArg = new AuthResponse();
		assertNotNull(responseNoArg);
		AuthResponse responseAllArg = new AuthResponse("testuid", "test", true);
		assertNotNull(responseAllArg);
	}
	
	@Test
	public void gettersetterLoanDetailsTest() {
		LoanDetails loanDetails = new LoanDetails();
		loanDetails.setLoanNumber(1);
		loanDetails.setFirstName("Samaira");
		loanDetails.setLastName("baronia");
		loanDetails.setAddress("address");
		loanDetails.setLoanAmount(1234);
		loanDetails.setLoanType("home");
		loanDetails.setLoanTerm(1);
		assertEquals(1, loanDetails.getLoanNumber());
		assertEquals("Samaira", loanDetails.getFirstName());
		assertEquals("baronia", loanDetails.getLastName());
		assertEquals("address", loanDetails.getAddress());
		assertEquals(1234, loanDetails.getLoanAmount(),0);
		assertEquals("home", loanDetails.getLoanType());
		assertEquals(1, loanDetails.getLoanTerm());
		
}
	
	@Test
	public void constructerMutualFundDetailsTest() {
		LoanDetails loanDetails = new LoanDetails();	
		LoanDetails LoanDetailsAllArg = new LoanDetails(1,1234.0, 2, "home", "mandla", "samaira", "baronia");
		assertNotNull(LoanDetailsAllArg);
	}
}