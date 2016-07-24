package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.LoanTypeEntity;
import org.care.coop.ws.repositories.LoanTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanTypeServiceImpl implements LoanTypeServiceInterface {

	@Autowired
	private LoanTypeRepository loanTypeRepository;
	
	@Override
	public List<LoanTypeEntity> getAllLoanTypes() {

		List<LoanTypeEntity> loanTypeEntityList = loanTypeRepository.findAll();
		
		return loanTypeEntityList;
	}

	@Override
	public LoanTypeEntity addLoanType(LoanTypeEntity loanTypeEntity) {

		LoanTypeEntity createdLoanType = loanTypeRepository.save(loanTypeEntity);
		
		return createdLoanType;
	}

}
