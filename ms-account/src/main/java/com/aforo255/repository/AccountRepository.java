package com.aforo255.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.aforo255.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
