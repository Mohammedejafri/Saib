package com.saib.capstone.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")

public class Transaction {
	
	
	@Id
	@Column(name="transaction_id")
	private int transaction_id;
	
	@Column(name="from_account")
	private int from_account;
	
	@Column(name="to_account")
	private int to_account;
	
	@Column(name="fromaccountname")
	private String fromaccountname;
	
	@Column(name="toaccountname")
	private String toaccountname;
	
	@Column(name="same_bank_transaction")
	private String same_bank_transaction;
	
	@Column(name="other_bank")
	private String other_bank;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="date")
	private Date date ;
	
	@Column(name="time")
	private LocalDateTime time ;
	
	@Column(name="transaction_type")
	private String transaction_type;
	
	@Column(name="status")
	private String status;
	
	

	public Transaction(int transaction_id, int from_account, int to_account, String fromaccountname,
			String toaccountname, String same_bank_transaction, String other_bank, double amount, Date date,
			LocalDateTime time, String transaction_type, String status) {
		super();
		this.transaction_id = transaction_id;
		this.from_account = from_account;
		this.to_account = to_account;
		this.fromaccountname = fromaccountname;
		this.toaccountname = toaccountname;
		this.same_bank_transaction = same_bank_transaction;
		this.other_bank = other_bank;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.transaction_type = transaction_type;
		this.status = status;
	}
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getFrom_account() {
		return from_account;
	}
	public void setFrom_account(int from_account) {
		this.from_account = from_account;
	}
	public int getTo_account() {
		return to_account;
	}
	public void setTo_account(int to_account) {
		this.to_account = to_account;
	}
	public String getFrom_account_name() {
		return fromaccountname;
	}
	public void setFrom_account_name(String from_account_name) {
		this.fromaccountname = from_account_name;
	}
	public String getTo_account_name() {
		return toaccountname;
	}
	public void setTo_account_name(String to_account_name) {
		this.toaccountname = to_account_name;
	}
	public String getSame_bank_transaction() {
		return same_bank_transaction;
	}
	public void setSame_bank_transaction(String same_bank_transaction) {
		this.same_bank_transaction = same_bank_transaction;
	}
	public String getOther_bank() {
		return other_bank;
	}
	public void setOther_bank(String other_bank) {
		this.other_bank = other_bank;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", from_account=" + from_account + ", to_account="
				+ to_account + ", from_account_name=" + fromaccountname + ", to_account_name=" + toaccountname
				+ ", same_bank_transaction=" + same_bank_transaction + ", other_bank=" + other_bank + ", amount="
				+ amount + ", date=" + date + ", time=" + time + ", transaction_type=" + transaction_type + ", status="
				+ status + "]";
	}

	
}
