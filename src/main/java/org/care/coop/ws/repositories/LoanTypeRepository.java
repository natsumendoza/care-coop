package org.care.coop.ws.repositories;

import org.care.coop.ws.entities.LoanTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanTypeRepository extends JpaRepository<LoanTypeEntity, Long> {
	
}
