package com.aforo255.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.entity.Account;
import com.aforo255.service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private IAccountService service;

	@GetMapping("/listar")
	public List<Account> listar() {
		return service.findAll();
	}

	@GetMapping("/ver/{id}")
	public Account detalle(@PathVariable Integer id) {

		Account account = service.findById(id);
		return account;
	}
}
