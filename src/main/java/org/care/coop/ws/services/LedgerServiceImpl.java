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
	public List<LedgerEntity> getLedgerByClientNoAndAccountNo(Long clientNo, Long accountNo) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndAccountNo(clientNo, accountNo);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByCLientNoAndAccountNoAndCreatedDate(Long clientNo, Long accountNo,
			Date createdDate) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndAccountNoAndCreatedDate(clientNo, accountNo, createdDate);
		
		return ledgerList;
	}

	@Override
	public List<LedgerEntity> getLedgerByClientNoAndAccountNoAndMonth(Long clientNo, Long accountNo, int month) {

		List<LedgerEntity> ledgerList = ledgerRepository.findByClientNoAndAccountNoAndMonth(clientNo, accountNo, month);
		
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

}
