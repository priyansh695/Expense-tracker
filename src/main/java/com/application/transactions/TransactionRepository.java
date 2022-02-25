package com.application.transactions;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.application.users.User;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
//
	public Optional<Transaction> findTransactionByIsDeleted(int isDeleted);
	//public Transaction saveTransactionById(int id,Transaction t);
	public Transaction findById(int id);
//
	public Iterable<Transaction> findTransactionByIsDeletedAndUser(int isDeleted, User username);
////
	public List<Transaction> findTransactionByUser(User user);

}
