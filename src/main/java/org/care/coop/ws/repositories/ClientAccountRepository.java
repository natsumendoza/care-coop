package org.care.coop.ws.repositories;

import java.util.List;

import org.care.coop.ws.entities.ClientAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAccountRepository extends JpaRepository<ClientAccountEntity, Long> {

	public List<ClientAccountEntity> findByClientNo(Long clientNo);
	
}
