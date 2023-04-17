package com.aforo255.service;

import java.util.List;

import com.aforo255.entity.Account;

public interface IAccountService {

	public List<Account> findAll();
	public Account findById (Integer id ); 
	public Account save (Account account);
	
}
