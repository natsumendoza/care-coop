package org.care.coop.ws.controllers;

import java.util.List;

import org.care.coop.ws.entities.InterestRateEntity;
import org.care.coop.ws.services.InterestRateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterestRateController {

	@Autowired
	private InterestRateServiceInterface interestRateServiceInterface;
	
	@RequestMapping(value="/care-coop/add-interest-rate", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InterestRateEntity> addInterestRate(@RequestBody InterestRateEntity interestRateEntity) {
		
		InterestRateEntity createdInterestRate = interestRateServiceInterface.addInterestRate(interestRateEntity);
		
		return new ResponseEntity<InterestRateEntity>(createdInterestRate, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/care-coop/get-interest-rate-by-accountType/{accountType}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InterestRateEntity> getInterestRateByAccountType(@PathVariable String accountType) {
		
		InterestRateEntity interestRateEntity = interestRateServiceInterface.getInterestRateByAccountType(accountType);
		
		return new ResponseEntity<InterestRateEntity>(interestRateEntity, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-all-interest-rates/", method=RequestMethod.GET)
	public ResponseEntity<List<InterestRateEntity>> getAllInterestRate() {
		
		List<InterestRateEntity> interestRateList = interestRateServiceInterface.getAllInterestRates();
		
		return new ResponseEntity<List<InterestRateEntity>>(interestRateList, HttpStatus.OK);
		
	}
	
	
	
}
