package org.care.coop.ws.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.care.coop.ws.entities.ClientEntity;
import org.care.coop.ws.services.ClientServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/care-coop/")
public class ClientController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ClientServiceInterface clientServiceInterface;
	
	@RequestMapping(value="/care-coop/createclient", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity clientEntity) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		clientEntity.setBirthday(formatter.parse(formatter.format(clientEntity.getBirthday())));
		
		logger.info(clientEntity.getBirthday().toString());
		ClientEntity createdClientEntity = clientServiceInterface.createClient(clientEntity);
		
		return new ResponseEntity<ClientEntity>(createdClientEntity, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/care-coop/get-client-by-code/{code}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientEntity> getClientByCode(@PathVariable int code) {
		
		ClientEntity clientEntity = clientServiceInterface.getClientByCode(code);
		
		return new ResponseEntity<ClientEntity>(clientEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value="/care-coop/get-clients/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClientEntity>> getClientByCode() {
		
		List<ClientEntity> clientEntityList = clientServiceInterface.getAllClients();
		
		return new ResponseEntity<List<ClientEntity>>(clientEntityList, HttpStatus.OK);
	}
	
}
