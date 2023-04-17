package com.aforo255.service;

import java.util.List;
import java.util.Map;

import com.aforo255.domain.Transaction;

public interface ITransactionService {
	 Transaction save (Transaction transaction);

	 List<Transaction> findAll();
}
