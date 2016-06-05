package org.care.coop.ws.repositories;

import org.care.coop.ws.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	
	
}
