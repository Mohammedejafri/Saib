package com.saib.capstone.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saib.capstone.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	List<Transaction> findByFromaccountname(String user );
	List<Transaction> findByToaccountname(String user);
	List<Transaction> findByDate(Date date);

}
