package org.care.coop.ws.controllers;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.JournalVoucherEntity;
import org.care.coop.ws.services.JournalVoucherServiceInterface;
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
public class JournalVoucherController {

	@Autowired
	private JournalVoucherServiceInterface journalVoucherServiceInterface;
	
	@RequestMapping(value="/care-coop/create-journal-voucher", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JournalVoucherEntity> createJournalVoucher(@RequestBody JournalVoucherEntity journalVoucherEntity) {
		System.out.println(journalVoucherEntity);
		JournalVoucherEntity createdJournalVoucher = journalVoucherServiceInterface.createJournalVoucher(journalVoucherEntity);
		
		return new ResponseEntity<JournalVoucherEntity>(createdJournalVoucher, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/care-coop/get-all-journal-vouchers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<JournalVoucherEntity>> getAllJournalVouchers() {
		
		List<JournalVoucherEntity> journalVoucherList = journalVoucherServiceInterface.getAllJournalVouchers();
		
		return new ResponseEntity<List<JournalVoucherEntity>>(journalVoucherList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-journal-voucher-by-member-code/{code}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JournalVoucherEntity> getJournalVoucherByMemberCode(@PathVariable Long code) {
		
		JournalVoucherEntity journalVoucher = journalVoucherServiceInterface.getJournalVoucherByMemberCode(code);
		
		return new ResponseEntity<JournalVoucherEntity>(journalVoucher, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/get-journal-voucher-by-member-code-and-created-date/{code}/{date}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JournalVoucherEntity> getJournalVoucherByMemberCodeAndCreatedDate(@PathVariable Long code, @PathVariable Date date) {
		
		JournalVoucherEntity journalVoucher = journalVoucherServiceInterface.getJournalVoucherByMemberCodeAndCreatedDate(code, date);
		
		return new ResponseEntity<JournalVoucherEntity>(journalVoucher, HttpStatus.OK);
		
	}
	
}
