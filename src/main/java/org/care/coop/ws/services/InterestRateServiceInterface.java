package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.InterestRateEntity;

public interface InterestRateServiceInterface {

	public InterestRateEntity addInterestRate(InterestRateEntity interestRateEntity);
	public InterestRateEntity getInterestRateByAccountType(String accountType);
	public List<InterestRateEntity> getAllInterestRates();
	
}
