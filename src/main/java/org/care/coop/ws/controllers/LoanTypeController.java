package org.care.coop.ws.controllers;

import java.util.List;

import org.care.coop.ws.entities.LoanTypeEntity;
import org.care.coop.ws.services.LoanTypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanTypeController {

	@Autowired
	private LoanTypeServiceInterface loanTypeServiceInterface;
	
	@RequestMapping(value="/care-coop/get-all-loan-types/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LoanTypeEntity>> getAllLoanTypes() {
		
		List<LoanTypeEntity> loanTypeList = loanTypeServiceInterface.getAllLoanTypes();
		
		return new ResponseEntity<List<LoanTypeEntity>>(loanTypeList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/create-loan-type/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoanTypeEntity> createLoanType(@RequestBody LoanTypeEntity loanTypeEntity) {
		
		LoanTypeEntity createdLoanType = loanTypeServiceInterface.addLoanType(loanTypeEntity);
		
		return new ResponseEntity<LoanTypeEntity>(createdLoanType, HttpStatus.CREATED);
		
	}
	
}
