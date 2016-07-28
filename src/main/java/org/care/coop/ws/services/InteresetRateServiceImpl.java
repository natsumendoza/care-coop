package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.InterestRateEntity;
import org.care.coop.ws.repositories.InterestRateRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InteresetRateServiceImpl implements InterestRateServiceInterface {

	@Autowired
	private InterestRateRepositoy interestRateRepository;
	
	@Override
	public InterestRateEntity addInterestRate(InterestRateEntity interestRateEntity) {
		
		InterestRateEntity createdInterestRate = interestRateRepository.save(interestRateEntity);
		
		return createdInterestRate;
	}

	@Override
	public InterestRateEntity getInterestRateByAccountType(String accountType) {
		
		InterestRateEntity interestRateEntity = interestRateRepository.findByAccountType(accountType);
		
		return interestRateEntity;
	}

	@Override
	public List<InterestRateEntity> getAllInterestRates() {
		

		List<InterestRateEntity> interestRateList = interestRateRepository.findAll();
		
		return interestRateList;
	}

}
