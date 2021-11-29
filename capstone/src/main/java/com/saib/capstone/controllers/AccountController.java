package com.saib.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saib.capstone.config.ApiSuccessPayload;
import com.saib.capstone.models.Account;
import com.saib.capstone.models.Transaction;
import com.saib.capstone.services.AccountService;
import com.saib.util.Results;

@RestController
public class AccountController {
	
	/*
	 *  GET - /accounts - Get me all details 
	 *  GET - /accounts/id - Get me details for a single account 
	 *  POST - /accounts - Creating a new account 
	 *  PUT - /accounts/id - Updating an existing account 
	 *  DELETE -/accounts/id - for d
	 *  eleting an account from db
	 *  
	 *  
	 */
	
	@Autowired
	AccountService accountService;
	
	
	@GetMapping("/accounts")
	public ResponseEntity<ApiSuccessPayload> getAllAccounts(int pageNumber , int pageSize)
	{
		List<Account> list=accountService.getAllAccount(pageNumber, pageSize);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/accounts/{accountNumber}")
	public ResponseEntity<ApiSuccessPayload> getAccountbyAccountNumber(@PathVariable long accountNumber)
	{
		Account account=accountService.getAccountByAccountNumber(accountNumber);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(account, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<ApiSuccessPayload> addAccount(@RequestBody Account account)
	{
		ResponseEntity<ApiSuccessPayload> response=null;
		System.out.println(account);
		String result=accountService.addAccount(account);
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSuccessPayload payload=ApiSuccessPayload.build(result, "Account created successfully", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	
	@PutMapping("/accounts/{accountNumber}")
	public ResponseEntity<ApiSuccessPayload> updateAccount(@RequestBody Account account, @PathVariable long accountNumber)
	{
		String result=accountService.updateAccount(account, accountNumber);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/accounts/{accountNumber}")
	public ResponseEntity<ApiSuccessPayload> deleteAccount(@PathVariable long accountNumber)
	{
		String result=accountService.deleteAccount(accountNumber);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/findaccountbytype/{type}")
	public ResponseEntity<ApiSuccessPayload> getAccountsByType(@PathVariable String type)
	{
		List<Account> list = accountService.getAccountsByType(type);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
	}
	
	@GetMapping("/findaccountbystatus/{status}")
	public ResponseEntity<ApiSuccessPayload> getAccountsByStatus(@PathVariable String status)
	{
		List<Account> list = accountService.getAccountsByStatus(status);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
	}
	
	@GetMapping("/AccountByGender/{Gender}")
	public ResponseEntity<ApiSuccessPayload> getAccountByGender(@PathVariable String Gender)
	{

		List<Account> list = accountService.getAccountByGender(Gender);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}
	
	
	

}