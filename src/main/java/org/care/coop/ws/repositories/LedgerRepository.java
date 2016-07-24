package org.care.coop.ws.repositories;

import java.util.Date;
import java.util.List;

import org.care.coop.ws.entities.LedgerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerRepository extends JpaRepository<LedgerEntity, Long> {

	public List<LedgerEntity> findByClientNo(Long clientNo);
	public List<LedgerEntity> findByClientNoAndMonth(Long clientNo, int month);
	public List<LedgerEntity> findByClientNoAndLoanType(Long clientNo, String loanType);
	public List<LedgerEntity> findByClientNoAndLoanTypeAndCreatedDate(Long clientNo, String loanType, Date createdDate);
	public List<LedgerEntity> findByClientNoAndLoanTypeAndMonth(Long clientNo, String loanType, int month);
	
}
