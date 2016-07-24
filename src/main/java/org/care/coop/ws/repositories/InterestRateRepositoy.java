package org.care.coop.ws.repositories;

import org.care.coop.ws.entities.InterestRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRateRepositoy extends JpaRepository<InterestRateEntity, Long>{

	public InterestRateEntity findByAccountType(String accountType);
	
}
