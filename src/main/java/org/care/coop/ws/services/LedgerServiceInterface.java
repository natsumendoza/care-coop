package org.care.coop.ws.services;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;

public interface LedgerServiceInterface {

	public List<LedgerEntity> getAllLedger();
	public List<LedgerEntity> getLedgerByClientNoAndMonth(Long clientNo, int month);
	public List<LedgerEntity> getLedgerByClientNo(Long clientNo);
	public List<LedgerEntity> getLedgerByClientNoAndLoanType(Long clientNo, String loanType);
	public List<LedgerEntity> getLedgerByCLientNoAndLoanTypeAndCreatedDate(Long clientNo, String loanType, Date createdDate);
	public List<LedgerEntity> getLedgerByClientNoAndLoanTypeAndMonth(Long clientNo, String loanType, int month);
	public LedgerEntity addLedger(LedgerEntity ledgerEntity);
	
}
