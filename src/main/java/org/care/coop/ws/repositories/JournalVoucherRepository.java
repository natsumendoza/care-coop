package org.care.coop.ws.repositories;

import java.util.Date;

import org.care.coop.ws.entities.JournalVoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalVoucherRepository extends JpaRepository<JournalVoucherEntity, Long> {
	
	public JournalVoucherEntity findByMemberCode(Long code);
	public JournalVoucherEntity findByMemberCodeAndCreatedDate(Long code, Date date);
	
}
