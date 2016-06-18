package org.care.coop.ws.services;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;

public interface LedgerServiceInterface {

	public List<LedgerEntity> getAllLedger();
	public List<LedgerEntity> getLedgerByClientNo(Long clientNo);
	public List<LedgerEntity> getLedgerByClientNoAndAccountNo(Long clientNo, Long accountNo);
	public List<LedgerEntity> getLedgerByCLientNoAndAccountNoAndCreatedDate(Long clientNo, Long accountNo, Date createdDate);
	public List<LedgerEntity> getLedgerByClientNoAndAccountNoAndMonth(Long clientNo, Long accountNo, int month);
	public LedgerEntity addLedger(LedgerEntity ledgerEntity);
	
}
