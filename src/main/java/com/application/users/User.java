package com.application.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.application.transactionTypes.TransactionType;
import com.application.transactions.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	public User() {
	}

	@Id
	private String username;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userid;
	private String userpassword;
	private String usergroup;
	private String useremail;
	protected LocalDateTime userCreationDate;
	private int isDeleted = 0;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Transaction> transactionlist;

	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private List<TransactionType> transactionTypelist;


	public ArrayList<Transaction> getTransactionlist() {
		return (ArrayList<Transaction>) transactionlist;
	}

	public void setTransactionlist(ArrayList<Transaction> transactionlist) {
		this.transactionlist = transactionlist;
	}

	public int getUserid() {
		return userid;
	}

	public List<TransactionType> getTransactionTypelist() {
		return transactionTypelist;
	}

	public void setTransactionTypelist(List<TransactionType> transactionTypelist) {
		this.transactionTypelist = transactionTypelist;
	}

	public void setTransactionlist(List<Transaction> transactionlist) {
		this.transactionlist = transactionlist;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public LocalDateTime getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(LocalDateTime userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public User(int userid, String username, String userpassword, String usergroup, String useremail, int isDeleted, LocalDateTime userCreationDate) {
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.usergroup = usergroup;
		this.useremail = useremail;
		this.userCreationDate = userCreationDate;
		this.isDeleted = isDeleted;
	}

	public User(String username) {
		this.username = username;
	}

	public User(int userid) {
		this.userid = userid;
	}

}
