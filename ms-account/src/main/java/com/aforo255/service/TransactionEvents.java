package com.aforo255.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.entity.Account;
import com.aforo255.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class TransactionEvents {
	@Autowired
	private IAccountService accountService;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	@Autowired
	private ObjectMapper objectMapper ; 
	
	public void processTransactionEvent(String message) throws JsonProcessingException {
		double newAmount= 0 ; 

		Transaction event = objectMapper.readValue(message, Transaction.class);
		var account = accountService.findById(event.getAccountId());
		switch(event.getType()) {
		case "deposito":
			newAmount =  account.getTotalAmount() + event.getAmount();
			break ; 
			
		case "retiro":
			newAmount =  account.getTotalAmount()  - event.getAmount();
			break ; 	
		
		}
		account.setTotalAmount(newAmount);
		log.info("Actulizando N° cuenta ***"+event.getAccountId());
		accountService.save(account);
	}

}
