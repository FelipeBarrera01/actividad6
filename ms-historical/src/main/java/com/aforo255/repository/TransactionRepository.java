package com.aforo255.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.aforo255.entity.Transaction;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query("Select t from Transaction t where t.accountId = ?1")
	public Iterable<Transaction> findByAccountId(Integer accountId);
}
