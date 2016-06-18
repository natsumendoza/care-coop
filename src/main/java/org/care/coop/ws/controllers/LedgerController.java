package org.care.coop.ws.controllers;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;
import org.care.coop.ws.services.LedgerServiceInterface;
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
public class LedgerController {

	@Autowired
	private LedgerServiceInterface ledgerServiceInterface;
	
	@RequestMapping(value="/care-coop/get-all-ledger", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LedgerEntity>> getAllLedger() {
		
		List<LedgerEntity> ledgerList = ledgerServiceInterface.getAllLedger();
		
		return new ResponseEntity<List<LedgerEntity>>(ledgerList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-ledger-by-clientno/{clientNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LedgerEntity>> getLedgerByClientNo(@PathVariable Long clientNo) {
		
		List<LedgerEntity> ledgerList = ledgerServiceInterface.getLedgerByClientNo(clientNo);
		
		return new ResponseEntity<List<LedgerEntity>>(ledgerList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-ledger-by-clientno-and-accountno/{clientNo}/{accountNo}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LedgerEntity>> getLedgerByClientNoAndAccountNo(@PathVariable Long clientNo, @PathVariable Long accountNo) {
		
		List<LedgerEntity> ledgerList = ledgerServiceInterface.getLedgerByClientNoAndAccountNo(clientNo, accountNo);
		
		return new ResponseEntity<List<LedgerEntity>>(ledgerList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-ledger-by-clientno-and-accountno-and-createddate/{clientNo}/{accountNo}/{createdDate}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LedgerEntity>> getLedgerByClientNoAndAccountNoAndCreatedDate(@PathVariable Long clientNo, @PathVariable Long accountNo, @PathVariable Date createdDate) {
		
		List<LedgerEntity> ledgerList = ledgerServiceInterface.getLedgerByCLientNoAndAccountNoAndCreatedDate(clientNo, accountNo, createdDate);
		
		return new ResponseEntity<List<LedgerEntity>>(ledgerList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-ledger-by-clientno-and-accountno-and-month/{clientNo}/{accountNo}/{month}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LedgerEntity>> getLedgerByClientNoAndAccountNoAndMonth(@PathVariable Long clientNo, @PathVariable Long accountNo, @PathVariable int month) {
		
		List<LedgerEntity> ledgerList = ledgerServiceInterface.getLedgerByClientNoAndAccountNoAndMonth(clientNo, accountNo, month);
		
		return new ResponseEntity<List<LedgerEntity>>(ledgerList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/create-ledger", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LedgerEntity> createLedger(@RequestBody LedgerEntity ledgerEntity) {
		
		LedgerEntity createdLedger = ledgerServiceInterface.addLedger(ledgerEntity);
		
		return new ResponseEntity<LedgerEntity>(createdLedger, HttpStatus.CREATED);
		
	}
	
}
