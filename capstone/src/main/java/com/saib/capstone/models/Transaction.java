package com.saib.capstone.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "transaction")

public class Transaction {
	
	
	@Id
	@Column(name="transaction_id")
	private long transaction_id;
	
	@Column(name="from_account")
	private int fromAccount;
	
	@Column(name="to_account")
	private int toAccount;
	
	@Column(name="from_account_name")
	private String fromAccountName;
	
	@Column(name="to_account_name")
	private String toAccountName;
	
	@Column(name="same_bank_transaction")
	private boolean sameBankTransaction;
	
	@Column(name="other_bank")
	private String otherBank;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name = "date")
	@ApiModelProperty(example="YYYY-MM-DD")
	private LocalDate date ;
	
	@Column(name="time")
	private LocalDateTime time ;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="status")
	private String status;
	
	

	public Transaction(int transaction_id, int fromAccount, int toAccount, String fromAccountName,
			String toAccountName, boolean sameBankTransaction, String otherBank, double amount, LocalDate date,
			LocalDateTime time, String transactionType, String status) {
		super();
		this.transaction_id = transaction_id;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.fromAccountName = fromAccountName;
		this.toAccountName = toAccountName;
		this.sameBankTransaction = sameBankTransaction;
		this.otherBank = otherBank;
		this.amount = 100.0;
		this.date = date;
		this.time = time;
		this.transactionType = transactionType;
		this.status = status;
	}
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public String getFromAccountName() {
		return fromAccountName;
	}
	public void setFromAccountName(String fromAccountName) {
		this.fromAccountName = fromAccountName;
	}
	public String getToAccountName() {
		return toAccountName;
	}
	public void setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
	}
	public boolean getSameBankTransaction() {
		return sameBankTransaction;
	}
	public void setSameBankTransaction(boolean sameBankTransaction) {
		this.sameBankTransaction = sameBankTransaction;
	}
	public String getOtherBank() {
		return otherBank;
	}
	public void setOtherBank(String otherBank) {
		this.otherBank = otherBank;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount ) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void settransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", from_account=" + fromAccount + ", to_account="
				+ toAccount + ", from_account_name=" + fromAccountName + ", to_account_name=" + toAccountName
				+ ", same_bank_transaction=" + sameBankTransaction + ", other_bank=" + otherBank + ", amount="
				+ amount + ", date=" + date + ", time=" + time + ", transaction_type=" + transactionType + ", status="
				+ status + "]";
	}

	
}
