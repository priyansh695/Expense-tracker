package com.application.transactions;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.application.transactionTypes.TransactionType;
import com.application.users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int transactionID;

	protected String expenseDeposit;
	@ManyToOne
//	@JoinColumn(name = "username", referencedColumnName = "username")
	protected TransactionType transactionType;

	protected float transactionAmount;
	
//	@Temporal(TemporalType.TIMESTAMP)
	protected String transactionDate;
	protected LocalDateTime transactionDateTimeStamp;
	
	@Lob
	protected String transactionDescription;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	@Basic(optional = false)
	protected User user;

	// @ManyToOne
	protected String transactionInUserGroup;
	protected int isDeleted = 0;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public String getExpenseDeposit() {
		return expenseDeposit;
	}

	public void setExpenseOrDeposit(String expenseDeposit) {
		this.expenseDeposit = expenseDeposit;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTransactionInUserGroup() {
		return transactionInUserGroup;
	}

	public void setTransactionInUserGroup(String transactionInUserGroup) {
		this.transactionInUserGroup = transactionInUserGroup;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Transaction() {
		super();
	}

	public LocalDateTime getTransactionDateTimeStamp() {
		return transactionDateTimeStamp;
	}

	public void setTransactionDateTimeStamp(LocalDateTime transactionDateTimeStamp) {
		this.transactionDateTimeStamp = transactionDateTimeStamp;
	}

	public void setExpenseDeposit(String expenseDeposit) {
		this.expenseDeposit = expenseDeposit;
	}

	public Transaction(int transactionID, String expenseDeposit, TransactionType transactionType,
			float transactionAmount, String transactionDate, LocalDateTime transactionDateTimeStamp,
			String transactionDescription, User user, String transactionInUserGroup, int isDeleted) {
		super();
		this.transactionID = transactionID;
		this.expenseDeposit = expenseDeposit;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionDateTimeStamp = transactionDateTimeStamp;
		this.transactionDescription = transactionDescription;
		this.user = user;
		this.transactionInUserGroup = transactionInUserGroup;
		this.isDeleted = isDeleted;
	}
	

}
