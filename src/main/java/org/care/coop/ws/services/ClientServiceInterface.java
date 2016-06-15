package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.ClientEntity;

public interface ClientServiceInterface {

	public ClientEntity createClient(ClientEntity clientEntity);
	public ClientEntity getClientByClientNo(Long code);
	public List<ClientEntity> getAllClients();
	
}
