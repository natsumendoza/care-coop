package org.care.coop.ws.repositories;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepository extends JpaRepository<LedgerEntity, Long> {

	public List<LedgerEntity> findByClientNo(Long clientNo);
	public List<LedgerEntity> findByClientNoAndAccountNo(Long clientNo, Long accountNo);
	public List<LedgerEntity> findByClientNoAndAccountNoAndCreatedDate(Long clientNo, Long accountNo, Date createdDate);
	public List<LedgerEntity> findByClientNoAndAccountNoAndMonth(Long clientNo, Long accountNo, int month);
	
}
