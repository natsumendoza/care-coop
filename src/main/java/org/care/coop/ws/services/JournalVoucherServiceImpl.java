package org.care.coop.ws.services;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.JournalVoucherEntity;
import org.care.coop.ws.repositories.JournalVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalVoucherServiceImpl implements JournalVoucherServiceInterface {

	@Autowired
	private JournalVoucherRepository journalVoucherRepository;
	
	@Override
	public JournalVoucherEntity createJournalVoucher(JournalVoucherEntity journalVoucherEntity) {
		
		JournalVoucherEntity createdJournalVoucher = journalVoucherRepository.save(journalVoucherEntity);
		
		return createdJournalVoucher;
	}

	@Override
	public List<JournalVoucherEntity> getAllJournalVouchers() {
		
		List<JournalVoucherEntity> journalVoucherList = journalVoucherRepository.findAll();
		
		return journalVoucherList;
	}


	@Override
	public List<JournalVoucherEntity> getJournalVoucherByMemberCode(Long code) {
		List<JournalVoucherEntity> journalVoucherList = journalVoucherRepository.findByClientNo(code);
		
		return journalVoucherList;
	}

	@Override
	public List<JournalVoucherEntity> getJournalVoucherByMemberCodeAndCreatedDate(Long code, Date date) {

		List<JournalVoucherEntity> journalVoucherList = journalVoucherRepository.findByClientNoAndCreatedDate(code, date);
		
		return journalVoucherList;
		
	}

}
