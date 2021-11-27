package com.saib.capstone.controllers;


import java.util.Date;
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
import com.saib.capstone.services.TransactionService;
import com.saib.util.Results;


@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	public String getname () {
		return "name : mohammed";
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<ApiSuccessPayload> getAllTransaction()
	{
		List<Transaction> list=transactionService.getAllTransaction();
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/transactions/{transaction_id}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByTransactionID(@PathVariable long transaction_id)
	{
		Transaction transaction = transactionService.getTransactionByTransactionID(transaction_id);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(transaction, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<ApiSuccessPayload> MakeTransaction(@RequestBody Transaction transaction)
	{
		ResponseEntity<ApiSuccessPayload> response=null;
		System.out.println(transaction);
		String result=transactionService.addTransaction(transaction);
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSuccessPayload payload=ApiSuccessPayload.build(result, "transaction was made", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	

	@GetMapping("/usertransactions/{User}")
	public ResponseEntity<ApiSuccessPayload> getUserTransactionByTransactionID(@PathVariable String User)
	{

		List<Transaction> list = transactionService.getUserTransactionByTransactionID(User);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}
	
	@GetMapping("/transactionsDate/{date}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByDate(@PathVariable Date date)
	{

		List<Transaction> list = transactionService.getTransactionByDate(date);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Accounts Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}
	
	
	


}
