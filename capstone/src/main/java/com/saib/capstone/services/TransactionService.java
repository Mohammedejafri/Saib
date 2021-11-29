package com.saib.capstone.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.saib.capstone.models.Account;
import com.saib.capstone.models.Transaction;
import com.saib.capstone.repository.TransactionRepository;
import com.saib.util.Results;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransaction()
	{
		List<Transaction> list=transactionRepository.findAll();
		return list;
	
		
	}
	
	public Transaction getTransactionByTransactionID(long transaction_id)
	{
		Optional<Transaction> optional=transactionRepository.findById(transaction_id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no transaction found eith this id ::"+transaction_id+"doesn't exist");
		}
		
	}
	
	
	public String addTransaction(Transaction transaction)
	{
		String result="";
		Transaction storedTransaction = transactionRepository.save(transaction);
		if(storedTransaction!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"transaction is not completed ");
		}
		
		return result;
	}
	
	public String updateTransaction(Transaction transaction, int transactionId)
	{
		String result="";
		
		transaction.setTransaction_id(transactionId);
		Transaction updatedTransaction = transactionRepository.save(transaction);
		
		if(updatedTransaction!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
		
	}

	public List<Transaction> getUserTransactionByTransactionID(String User ) {
		
	
			List<Transaction> list = transactionRepository.findTransactionByFromAccountName(User);
			List<Transaction> list1 = transactionRepository.findTransactionByToAccountName(User);

			List<Transaction> list2 = new ArrayList<Transaction>();
			list2.addAll(list);
			list2.addAll(list1);

			return list2;
		
		
	}

	public List<Transaction> getTransactionByDate(String date) {
		List<Transaction> list = transactionRepository.findTransactionByDate(LocalDate.parse(date));	
		return list;
	}

	
	public String deleteTransaction(long transaction_id)
	{
		String result="";
		try {
		transactionRepository.deleteById(transaction_id);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}
	
	

	public String updateTransaction(Transaction transaction, long transaction_id) {
		// TODO Auto-generated method stub

		String result="";
		
		transaction.setTransaction_id(transaction_id);
		Transaction updatedtransaction = transactionRepository.save(transaction);
		
		if(updatedtransaction!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
	}



	public List<Transaction> getTransactionByOtherBank(String bankName) {
		
		List<Transaction> list=transactionRepository.findTransactionByOtherBank(bankName);
		return list;
	
	}

	public List<Transaction> getTransactionByTypeAndDatek(String type, String date) {
		// TODO Auto-generated method stub
		List<Transaction> list=transactionRepository.findTransactionByTransactionTypeAndDate(type , LocalDate.parse(date));
		return list;
	}

	
	


	


}