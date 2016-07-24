package org.care.coop.ws.services;

import org.care.coop.ws.entities.InterestRateEntity;

public interface InterestRateServiceInterface {

	public InterestRateEntity addInterestRate(InterestRateEntity interestRateEntity);
	public InterestRateEntity getInterestRateByAccountType(String accountType);
	
}
