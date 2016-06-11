package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.AccountTitleEntity;
import org.care.coop.ws.repositories.AccountTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTitleServiceImpl implements AccountTitleServiceInterface {

	@Autowired
	private AccountTitleRepository accountTitleRepository;
	
	@Override
	public List<AccountTitleEntity> getAllAccountTitles() {
		
		List<AccountTitleEntity> accountTitleList = accountTitleRepository.findAll();
		
		return accountTitleList;
	}

}
