package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.ClientAccountEntity;
import org.care.coop.ws.repositories.ClientAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientAccountServiceImpl implements ClientAccountServiceInterface {

	@Autowired
	private ClientAccountRepository clientAccountRepository;
	
	@Override
	public List<ClientAccountEntity> getClientAccountsByClientNo(Long clientNo) {
		
		List<ClientAccountEntity> clientAccountEntityList = clientAccountRepository.findByClientNo(clientNo);
		
		return clientAccountEntityList;
	}

	@Override
	public List<ClientAccountEntity> getAllClientAccounts() {

		List<ClientAccountEntity> clientAccountEntityList = clientAccountRepository.findAll();
		
		return clientAccountEntityList;
	}

	@Override
	public ClientAccountEntity addClientAccount(ClientAccountEntity clientAccount) {
		
		ClientAccountEntity createdClientAccount = clientAccountRepository.save(clientAccount);
		
		return createdClientAccount;
	}

}
