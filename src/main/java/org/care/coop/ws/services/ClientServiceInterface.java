package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.ClientEntity;

public interface ClientServiceInterface {

	public ClientEntity createClient(ClientEntity clientEntity);
	public ClientEntity getClientByCode(int code);
	public List<ClientEntity> getAllClients();
	
}
