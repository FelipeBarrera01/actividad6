package com.aforo255.producer;

import java.util.List;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import com.aforo255.domain.Transaction;
import com.aforo255.service.ITransactionService;
//import com.aforo255.domain.TransactionRedis;
//import com.aforo255.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class DepositEventProducer {

	String topic="transaction-events";
	private Logger log = LoggerFactory.getLogger(DepositEventProducer.class);
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private ITransactionService _service;
	
	public void sendDepositEvent(Transaction depositEvent)
			throws JsonProcessingException {
		String value = objectMapper.writeValueAsString(depositEvent);
		kafkaTemplate.send(topic, value);

	}

	
}
