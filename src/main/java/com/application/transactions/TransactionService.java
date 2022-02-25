package com.application.transactions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.users.User;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
//
	public List<Transaction> getAllTransactionByIsDeletedAndUser(User user) {
		ArrayList<Transaction> tr = new ArrayList<Transaction>();
		transactionRepository.findTransactionByIsDeletedAndUser(0,user).forEach(tr::add);
		return tr;
		
	}

	public List<Transaction> getAllTransactionByIsDeleted() {
		ArrayList<Transaction> tr = new ArrayList<Transaction>();
		transactionRepository.findTransactionByIsDeleted(0).ifPresent(tr::add);;
		return tr;
		
	}


	public Transaction getTransactionByID(int id) {
		return transactionRepository.findById(id);
	}

	public void updateTransactionByID(int id, Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void deleteTransactionByID(int id) {
		//transactionRepository.deleteById(id);
		Transaction tr= transactionRepository.findById(id);
		tr.setIsDeleted(1);
		transactionRepository.save(tr);
	}
//
	public void addTransaction(Transaction transaction) {
		transaction.transactionDateTimeStamp = LocalDateTime.now();
		transactionRepository.save(transaction);		
	}
	
	public List<Transaction> getTransactionsByUser(User user) {
		ArrayList<Transaction> al=new ArrayList<Transaction>();
		transactionRepository.findTransactionByUser(user).forEach(al::add);
		return al;
	}

}
