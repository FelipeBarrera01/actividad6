package com.aforo255.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aforo255.domain.Transaction;
@Repository
public interface ITransactionDao extends JpaRepository<Transaction, Integer> {

}
