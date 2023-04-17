package com.aforo255.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.aforo255.domain.Transaction;
import com.aforo255.producer.DepositEventProducer;
import com.aforo255.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/deposit")
public class DepositController {
	@Autowired
	private ITransactionService service;
	@Autowired
	DepositEventProducer eventProducer;
	private Logger log = LoggerFactory.getLogger(DepositController.class);
	@PostMapping("/event")
	@Timed(value = "postDepositEvent", histogram = true , percentiles = {0.95,0.99}
	,extraTags = {"app","postDepositEvent"})
	public ResponseEntity<Transaction> postDepositEvent(@RequestBody Transaction transaction) throws JsonProcessingException {
		log.info("antes de transql");
		Transaction transql = service.save(transaction);
		log.info("despues de transql");
		log.info("antes de sendDepositEvent");
		eventProducer.sendDepositEvent(transql);
		log.info("despues de sendDepositEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}	

	@GetMapping("/all")
	public List<Transaction> getAll(){
		return service.findAll();
	}	
	
}
