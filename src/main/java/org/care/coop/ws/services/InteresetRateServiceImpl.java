package org.care.coop.ws.services;

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

}
