package com.saib.capstone.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.capstone.models.Account;
import com.saib.capstone.models.Transaction;
import com.saib.capstone.repository.AccountRepository;
import com.saib.util.Results;

import io.sentry.Sentry;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccountWithPage(Integer pageNo, Integer pageSize)
	{
		Pageable paging = PageRequest.of(pageNo, pageSize) ;
		Page<Account> pageResult = accountRepository.findAll(paging);
		
		if(pageResult.hasContent()) {
			return pageResult.getContent();

		}
		else {
			return new ArrayList<Account>();

		}
	
		
	}
	
	public Account getAccountByAccountNumber(long accountNumber)
	{
		Optional<Account> optional=accountRepository.findById(accountNumber);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account with Account Number:"+accountNumber+"doesn't exist");
		}
		
	}
	
	
	public String addAccount(Account account)
	{
		String result="";
		Account storedAccount=accountRepository.save(account);
		if(storedAccount!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not created");
		}
		
		return result;
	}
	
	public String updateAccount(Account account, long accountNumber)
	{
		String result="";
		
		account.setAccountNumber(accountNumber);
		Account updatedAccount=accountRepository.save(account);
		
		if(updatedAccount!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
		
	}
	
	public String deleteAccount(long accountNumber)
	{
		String result="";
		try {
		accountRepository.deleteById(accountNumber);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			Sentry.captureException(e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}

	public List<Account> getAccountsByStatus(String status) {
		// TODO Auto-generated method stub
		
		List<Account> list=accountRepository.findByStatus(status);
		return list;
	
	}
	
	public List<Account> getAccountsByType(String type) {
		// TODO Auto-generated method stub
		
		List<Account> list = accountRepository.findAccountByaccountType(type);
		return list;
	
	}

	public List<Account> getAccountByGender(String gender) {
		// TODO Auto-generated method stub
		List<Account> list = accountRepository.findByGender(gender);
		return list;
	}
	
	public List<Account> getAllAccount()
	{
		List<Account> list=accountRepository.findAll();
		return list;
	
		
	}
	
	

}