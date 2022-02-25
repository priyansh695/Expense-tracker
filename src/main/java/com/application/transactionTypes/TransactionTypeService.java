package com.application.transactionTypes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.users.User;

@Service
public class TransactionTypeService {

	@Autowired
	private TransactionTypeRepository transactionTypeRepository;
////
	public List<TransactionType> getAllTransactionType() {

		ArrayList<TransactionType> al= new ArrayList<>();
		transactionTypeRepository.findTransactionTypeByIsDeleted(0).forEach(al::add);
		return al;
	}
//
	public void addTransactionType(TransactionType transactionType) {
		transactionTypeRepository.save(transactionType);
	}
//	
	public List<TransactionType> getAllTransactionTypeByUser(User user,String expenseordeposit) {

		ArrayList<TransactionType> al= new ArrayList<>();
		transactionTypeRepository.findTransactionTypeByTtypeExpenseDepositAndUsersAndIsDeleted(expenseordeposit,user,0).forEach(al::add);
		return al;
	}
	
//	public List<TransactionType> getAllTransactionTypeDeposit() {
//
//		ArrayList<TransactionType> al= new ArrayList<>();
//		transactionTypeRepository.findTransactionTypeByTtypeExpenseDepositAndIsDeleted("Deposit",0).forEach(al::add);
//		return al;
//	}
//	
//	public List<TransactionType> getAllTransactionTypeByUserExpense(User username,String expenseordeposit) {
//
//		ArrayList<TransactionType> al= new ArrayList<>();
//		transactionTypeRepository.findTransactionTypeByTtypeExpenseDepositAndUsersAndIsDeleted(expenseordeposit,username,0).forEach(al::add);
//		
//		System.out.println("In Transaction Service for getAllTransactionTypeByUserExpense");
//		for(TransactionType u:al)
//			System.out.println(u.getTransactionTypeValue());
//		return al;
//	}
//	
//	public List<TransactionType> getAllTransactionTypeByUserDeposit(User username,String expenseordeposit) {
//
//		ArrayList<TransactionType> al= new ArrayList<>();
//		transactionTypeRepository.findTransactionTypeByTtypeExpenseDepositAndUsersAndIsDeleted(expenseordeposit,username,0).forEach(al::add);
//		
//		System.out.println("In Transaction Service for getAllTransactionTypeByUserDeposit");
//		for(TransactionType u:al)
//			System.out.println(u.getTransactionTypeValue());
//		return al;
//	}

	public void deleteTransactionTypeByTransactionTypeValue(String transactionTypeValue) {
		TransactionType tr= transactionTypeRepository.findByTransactionTypeValue(transactionTypeValue);
		tr.setIsDeleted(1);
		transactionTypeRepository.save(tr);		
	}
	
	
}
