package com.application.transactionTypes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.application.users.User;

public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer> {
////
	public List<TransactionType> findTransactionTypeByIsDeleted(int id);
	
//	public List<TransactionType> findTransactionTypeByTtypeExpenseDepositAndIsDeleted(String expenseOrDeposit, int i);
//
	public List<TransactionType> findTransactionTypeByTtypeExpenseDepositAndUsersAndIsDeleted(String expenseOrDeposit, User Username,int i);
	
//	public List<TransactionType> findTransactionTypeByUsers(User Username);
	
//	public List<TransactionType> findTransactionTypeByUsersAndTtypeExpenseDeposit(User Username,String expenseordeposit);
//	
	public TransactionType findByTransactionTypeValue(String ransactionTypeValue);
}
