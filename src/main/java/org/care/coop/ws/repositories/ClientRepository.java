package org.care.coop.ws.repositories;

import org.care.coop.ws.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	public ClientEntity findByClientNo(Long clientNo);
	
}
