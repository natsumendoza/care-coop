package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.CollectorEntity;
import org.care.coop.ws.repositories.CollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectorServiceImpl implements CollectorServiceInterface {

	@Autowired
	private CollectorRepository collectorRepository;
	
	@Override
	public List<CollectorEntity> getAllCollectors() {
		
		List<CollectorEntity> collectorList = collectorRepository.findAll();
		
		return collectorList;
	}

	@Override
	public CollectorEntity addCollector(CollectorEntity collectorEntity) {

		CollectorEntity createdCollector = collectorRepository.save(collectorEntity);
		
		return createdCollector;
	}

}
