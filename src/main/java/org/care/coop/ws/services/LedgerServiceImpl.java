package org.care.coop.ws.services;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;
import org.care.coop.ws.repositories.LedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LedgerServiceImpl implements LedgerServiceInterface {

	@Autowired
	private LedgerRepository ledgerRepository;
	
	@Override
	public List<LedgerEntity> getAllLedger() {
		
		List<LedgerEntity> ledgerList = ledgerRepository.findAll();
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNo(Long clientNo) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNo(clientNo);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNoAndLoanType(Long clientNo, String loanType) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndLoanType(clientNo, loanType);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByCLientNoAndLoanTypeAndCreatedDate(Long clientNo, String loanType,
			Date createdDate) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndLoanTypeAndCreatedDate(clientNo, loanType, createdDate);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNoAndLoanTypeAndMonth(Long clientNo, String loanType, int month) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndLoanTypeAndMonth(clientNo, loanType, month);
		
		return ledgerList;
	}

	@Override
	public LedgerEntity addLedger(LedgerEntity ledgerEntity) {
		
		LedgerEntity createdLedger = ledgerRepository.save(ledgerEntity);
		
		return createdLedger;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNoAndMonth(Long clientNo, int month) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndMonth(clientNo, month);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNoAndLoanTypeAndTransactionType(Long clientNo, String loanType,
			String transactionType) {
		
		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndLoanTypeAndTransactionType(clientNo, loanType, transactionType);
		
		return ledgerList;
	}

}
