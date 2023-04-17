package com.aforo255.listener;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.aforo255.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Component
public class ConsumerListener {
	@Autowired
	private TransactionEvents _transactionEvents;
	private Logger log = LoggerFactory.getLogger(ConsumerListener.class);
	@KafkaListener(topics = "#{'${message.topic.name.transaction-events}'}", groupId = "#{'${spring.kafka.consumer.group-id.transaction-events}'}", concurrency = "2")
	public void OnMessage(@Payload String message) throws JsonProcessingException {
		log.info("*************** MICROSERVICE HISTORICAL *******************");
		log.info("ConsumerRecord : {}",message);
		
		_transactionEvents.processTransactionEvent(message);
	}
	
}
