package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.ClientAccountEntity;

public interface ClientAccountServiceInterface {

	public List<ClientAccountEntity> getClientAccountsByClientNo(Long clientNo);
	public List<ClientAccountEntity> getAllClientAccounts();
	public ClientAccountEntity addClientAccount(ClientAccountEntity clientAccount);
	
}
