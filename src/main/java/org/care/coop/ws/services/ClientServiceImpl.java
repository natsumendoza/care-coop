package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.ClientEntity;
import org.care.coop.ws.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientServiceInterface{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientEntity createClient(ClientEntity clientEntity) {
		
		ClientEntity createdClientEntity = clientRepository.save(clientEntity);
		
		return createdClientEntity;
	}

	@Override
	public ClientEntity getClientByClientNo(Long code) {
		ClientEntity clientEntity = clientRepository.findByClientNo(code);
		return clientEntity;
	}

	@Override
	public List<ClientEntity> getAllClients() {
		List<ClientEntity> clientList = clientRepository.findAll();
		return clientList;
	}

}
