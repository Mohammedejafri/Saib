package com.saib.capstone.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saib.capstone.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	List<Transaction> findTransactionByFromAccountName(String user );
	List<Transaction> findTransactionByToAccountName(String user);
	List<Transaction> findTransactionByDate(LocalDate date);
	List<Transaction> findTransactionByOtherBank(String bankName);
	List<Transaction> findTransactionByTransactionTypeAndDate(String type, LocalDate date);

}
