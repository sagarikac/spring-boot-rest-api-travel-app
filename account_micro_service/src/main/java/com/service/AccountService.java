
package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		if(accountRepository.existsById(account.getAccno())) {
			return "Account number must be unique";
		}else {
			accountRepository.save(account);
			return "Account created successfully";
		}
	}
	
	public String findBalance(int accno) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return "Your balance is "+acc.getAmount();
		}else {
			return "Account not exists";
		}
	}
	
	public String withdraw(Account account) {		// accno and amount 
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			Account acc = result.get();
			if(acc.getAmount()>=account.getAmount()) {
				acc.setAmount(acc.getAmount()-account.getAmount());
				accountRepository.saveAndFlush(acc);
				return "Withdraw amount successfully";
			}else {
				return "Can't withdrawn no amount present";
			}
		}else {
			return "Account not exists";
		}
	}
	
	public String deposit(Account account) {		// accno and amount 
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			Account acc = result.get();
			acc.setAmount(acc.getAmount()+account.getAmount());
			accountRepository.saveAndFlush(acc);
			return "Deposit amount successfully";
		}else {
			return "Account not exists";
		}
	}
	
	public String findBalanceUsingEmailId(String emailid) {
	System.err.println("Client send request........");
		try {
			return "Your balance is "+accountRepository.findBalanceByEmailId(emailid);
		} catch (Exception e) {
			return "Account not exists with emailid as "+emailid;
		}
	}
}
