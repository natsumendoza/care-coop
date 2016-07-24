package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.LoanTypeEntity;

public interface LoanTypeServiceInterface {

	public List<LoanTypeEntity> getAllLoanTypes();
	public LoanTypeEntity addLoanType(LoanTypeEntity loanTypeEntity);
	
}
