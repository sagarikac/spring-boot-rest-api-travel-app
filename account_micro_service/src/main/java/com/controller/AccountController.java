package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Account;
import com.service.AccountService;
@RestController
@RequestMapping("account")	// http://localhost:9898/account/*
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(value = "create",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@PutMapping(value = "withdraw",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String withdraw(@RequestBody Account account) {
		return accountService.withdraw(account);
	}
	
	@PutMapping(value = "deposit",consumes =MediaType.APPLICATION_JSON_VALUE)
	public String deposit(@RequestBody Account account) {
		return accountService.deposit(account);
	}

	@GetMapping(value = "findBalanceByAccno/{accno}")
	public String findBalanceUsingAccno(@PathVariable("accno") int accno) {
		return accountService.findBalance(accno);
	}
	
	@GetMapping(value = "findBalanceByEmailId/{emailid}")
	public String findBalanceUsingEmailId(@PathVariable("emailid") String emailid) {
		return accountService.findBalanceUsingEmailId(emailid);
	}
}