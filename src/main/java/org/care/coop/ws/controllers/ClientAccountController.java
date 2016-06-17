package org.care.coop.ws.controllers;

import java.util.List;

import org.care.coop.ws.entities.ClientAccountEntity;
import org.care.coop.ws.services.ClientAccountServiceInterface;
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
public class ClientAccountController {

	@Autowired
	private ClientAccountServiceInterface clientAccountServiceInterface;
	
	@RequestMapping(value="/care-coop/get-by-client-no/{clientNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientAccountEntity>> getClientAccountsByClientNo(@PathVariable Long clientNo) {
	
		List<ClientAccountEntity> clientAccountEntityList = clientAccountServiceInterface.getClientAccountsByClientNo(clientNo);
	
		return new ResponseEntity<List<ClientAccountEntity>>(clientAccountEntityList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/care-coop/get-client-accounts/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientAccountEntity>> getAllClientAccounts() {
		
		List<ClientAccountEntity> clientAccountEntityList = clientAccountServiceInterface.getAllClientAccounts();
		
		return new ResponseEntity<List<ClientAccountEntity>>(clientAccountEntityList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/create-account/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientAccountEntity> addClientAccount(@RequestBody ClientAccountEntity clientAccount) {
		
		ClientAccountEntity createdClientAccount = clientAccountServiceInterface.addClientAccount(clientAccount);
		
		return new ResponseEntity<ClientAccountEntity>(createdClientAccount, HttpStatus.CREATED);
		
	}
	
	
}
