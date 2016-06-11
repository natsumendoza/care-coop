package org.care.coop.ws.repositories;

import org.care.coop.ws.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	
}
