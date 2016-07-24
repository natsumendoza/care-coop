package org.care.coop.ws.controllers;

import java.util.List;

import org.care.coop.ws.entities.CollectorEntity;
import org.care.coop.ws.services.CollectorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectorController {

	@Autowired
	private CollectorServiceInterface collectorServiceInterface;
	
	@RequestMapping(value="/care-coop/get-all-collectors/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CollectorEntity>> getAllCollectors() {
		
		List<CollectorEntity> collectorList = collectorServiceInterface.getAllCollectors();
		
		return new ResponseEntity<List<CollectorEntity>>(collectorList, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/care-coop/create-collector/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CollectorEntity> createCollector(@RequestBody CollectorEntity collectorEntity) {
		
		CollectorEntity createdCollector = collectorServiceInterface.addCollector(collectorEntity);
		
		return new ResponseEntity<CollectorEntity>(createdCollector, HttpStatus.CREATED);
		
	}
	
}
