package com.application.transactionTypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionTypeController {

	@Autowired
	private TransactionTypeService transactionTypeService;
	

	@RequestMapping("/transactionType")
	public List<TransactionType> getAllTransactionType()
	{
		return transactionTypeService.getAllTransactionType();		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/transactionType")
	public void addTransactionType(@RequestBody TransactionType transactionType)
	{
		transactionTypeService.addTransactionType(transactionType);
	}
}
