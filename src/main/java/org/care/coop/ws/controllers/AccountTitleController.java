package org.care.coop.ws.controllers;

import java.util.List;

import org.care.coop.ws.entities.AccountTitleEntity;
import org.care.coop.ws.services.AccountTitleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountTitleController {

	@Autowired
	private AccountTitleServiceInterface accountTitleServiceInterface;
	
	@RequestMapping(value="/care-coop/account-titles", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTitleEntity>> getAllAccountTitles() {
		List<AccountTitleEntity> accountTitleList = accountTitleServiceInterface.getAllAccountTitles();
		
		return new ResponseEntity<List<AccountTitleEntity>>(accountTitleList, HttpStatus.OK);
	}
	
}
