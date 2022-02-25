package com.application.transactionTypes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.application.transactions.Transaction;
import com.application.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class TransactionType {

	@Id
	private String transactionTypeValue;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int transactionTypeId;

	private String ttypeExpenseDeposit;

	@JsonIgnore
	@ManyToMany
//	(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_transactionType", joinColumns = @JoinColumn(name = "transactionTypeValue"), inverseJoinColumns = @JoinColumn(name = "user_username"))
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@OneToMany
	private List<Transaction> transaction;

	private int isDeleted = 0;

	public TransactionType() {
	}

	public TransactionType(String transactionTypeValue, int transactionTypeId, String ttypeExpenseOrDeposit,
			ArrayList<User> users, int isDeleted) {
		this.transactionTypeValue = transactionTypeValue;
		this.transactionTypeId = transactionTypeId;
		this.ttypeExpenseDeposit = ttypeExpenseOrDeposit;
		this.isDeleted = isDeleted;
	}
	
	public TransactionType(String transactionTypeValue, String ttypeExpenseOrDeposit,
			ArrayList<User> users, int isDeleted) {
		this.transactionTypeValue = transactionTypeValue;
		this.ttypeExpenseDeposit = ttypeExpenseOrDeposit;
		this.isDeleted = isDeleted;
	}

	public TransactionType(String transactionTypeValue) {
		this.transactionTypeValue = transactionTypeValue;
	}

	public String getTransactionTypeValue() {
		return transactionTypeValue;
	}

	public void setTransactionTypeValue(String transactionTypeValue) {
		this.transactionTypeValue = transactionTypeValue;
	}

	public int getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}

	public String getTtypeExpenseDeposit() {
		return ttypeExpenseDeposit;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public void setTtypeExpenseDeposit(String ttypeExpenseDeposit) {
		this.ttypeExpenseDeposit = ttypeExpenseDeposit;
	}

}
