package com.aforo255.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class TransactionEvents {

	@Autowired
	private ITransactionService service;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(String message ) throws  JsonProcessingException {
		Transaction event = objectMapper.readValue(message, Transaction.class);
		log.info("transactionEvent : {}", event.getAccountId());		
		service.save(event);
	}
	
}
