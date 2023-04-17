package com.aforo255.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aforo255.entity.Account;
import com.aforo255.repository.AccountRepository;



@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	AccountRepository _accountRepo;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return  _accountRepo.findAll();
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return _accountRepo.findById(id).orElse(null);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return _accountRepo.save(account);
	}

}
