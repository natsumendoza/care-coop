package org.care.coop.ws.repositories;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.JournalVoucherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalVoucherRepository extends JpaRepository<JournalVoucherEntity, Long> {
	
	public List<JournalVoucherEntity> findByClientNo(Long clientNo);
	public List<JournalVoucherEntity> findByClientNoAndCreatedDate(Long clientNo, Date date);
	
}
