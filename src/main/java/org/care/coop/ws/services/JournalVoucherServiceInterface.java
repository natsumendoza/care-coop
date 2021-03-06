package org.care.coop.ws.services;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.JournalVoucherEntity;

public interface JournalVoucherServiceInterface {

	public JournalVoucherEntity createJournalVoucher(JournalVoucherEntity journalVoucherEntity);
	public List<JournalVoucherEntity> getAllJournalVouchers();
	public List<JournalVoucherEntity> getJournalVoucherByMemberCode(Long code);
	public List<JournalVoucherEntity> getJournalVoucherByMemberCodeAndCreatedDate(Long code, Date date);
	
}
