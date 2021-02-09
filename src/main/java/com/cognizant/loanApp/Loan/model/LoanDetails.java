package com.cognizant.loanApp.Loan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
@Table(name = "loan_details")
public class LoanDetails {

	@Id
	@Column(name="LOANNUMBER")
	private int loanNumber;

	@Column(name="LOANAMOUNT")
	private double loanAmount;

	@Column(name="LOANTERM")
	private int loanTerm;

	@Column(name="LOANTYPE")
	private String loanType;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="FIRSTNAME")
	private String firstName;

	@Column(name="LASTNAME")
	private String lastName;

}
//first_name,last_name,loan_number,address,loan_amount,loan_type,loan_term