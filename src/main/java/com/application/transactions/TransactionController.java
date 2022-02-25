package com.application.transactions;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.users.User;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionservice;


	@RequestMapping("/transaction")
	public List<Transaction> getTransactions() {
		ArrayList<Transaction> tr = (ArrayList<Transaction>) transactionservice.getAllTransactionByIsDeleted();
		return tr;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/transaction")
	public String addTransaction(@RequestBody Transaction transaction) {
		transactionservice.addTransaction(transaction);
		return "Successfully added";
	}

	@RequestMapping("/transaction/{id}")
	public Transaction getTransactionbyID(@PathVariable("id") int id) {
		return transactionservice.getTransactionByID(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/transaction/{id}")
	public void updateTransactionByID(@PathVariable("id") int id, @RequestBody Transaction transaction) {
		transactionservice.updateTransactionByID(id, transaction);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/transaction/{id}")
	public void deleteTransactionByID(@PathVariable("id") int id) {
		transactionservice.deleteTransactionByID(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/{username}/transaction")
	public String addTransactionbyUser(@PathVariable("username") String username, @RequestBody Transaction transaction) {
		transactionservice.addTransaction(transaction);
		return "Transaction successfully added";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{username}/transaction")
	public List<Transaction> getTransactionsByUser(@PathVariable("username") String username) {
		User user=new User(username);
		return transactionservice.getTransactionsByUser(user);
	}
}
