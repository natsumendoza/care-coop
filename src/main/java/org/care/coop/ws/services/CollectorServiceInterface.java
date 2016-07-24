package org.care.coop.ws.services;

import java.util.List;

import org.care.coop.ws.entities.CollectorEntity;

public interface CollectorServiceInterface {

	public List<CollectorEntity> getAllCollectors();
	public CollectorEntity addCollector(CollectorEntity collectorEntity);
	
}
