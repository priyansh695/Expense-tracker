package com.application.webController;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.application.transactionTypes.TransactionType;
import com.application.transactionTypes.TransactionTypeService;
import com.application.transactions.Transaction;
import com.application.transactions.TransactionService;
import com.application.users.User;
import com.application.users.UserRepository;

@Controller
@SessionAttributes("userAttribute")
//
public class WebController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	TransactionTypeService transactionTypeService;

	@Autowired
	UserRepository userRepository;


	@RequestMapping("/")
	public ModelAndView firstPage() {
		return new ModelAndView("Login");
	}
	
	@RequestMapping("/Home")
	public ModelAndView homePage() {
		return new ModelAndView("Home");
	}
	
	@RequestMapping(value = "/addExpense")
	public ModelAndView addExpenseRedirectReirectExpense(@ModelAttribute("userAttribute") User userAttribute) {

		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUser(userAttribute,"Expense");
		ModelAndView model = new ModelAndView("newExpense");
		model.addObject("transactionTypeModel", transactionType);
		return model;
	}

	@RequestMapping(value = "/addDeposit")
	public ModelAndView addExpenseRedirectRedirectDeposit(@ModelAttribute("userAttribute") User userAttribute) {

		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUser(userAttribute,"Deposit");
		ModelAndView model = new ModelAndView("newDeposit");
		model.addObject("transactionTypeModel", transactionType);
		return model;
	}

	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public ModelAndView addTransaction(@ModelAttribute("userAttribute") User userAttribute,
			@ModelAttribute("expenseModelAttribute") Transaction transaction,
			@RequestParam("transactionTypeList") String transactionTypeValue,
			@RequestParam("expenseOrDeposit") String expenseordeposit) {
		
		System.out.println("Inside Add Transaction Method with values"+expenseordeposit+" transaction Type "+transactionTypeValue+" User"+userAttribute.getUsername());
		transaction.setExpenseOrDeposit(expenseordeposit);
		transaction.setUser(userAttribute);
		transaction.setTransactionType(new TransactionType(transactionTypeValue));
		transactionService.addTransaction(transaction);
		return new ModelAndView("Home");
	}
	
	@RequestMapping(value = "/listAllTransactions")
	public ModelAndView listAllTransactions(@ModelAttribute("userAttribute") User userAttribute) {
		List<Transaction> transaction = transactionService.getAllTransactionByIsDeletedAndUser(userAttribute);
		float exp=0,dep=0;
		ModelAndView model = new ModelAndView("listTransactions");
		model.addObject("transactionModel", transaction);
		
		for(Transaction t:transaction)
		{				
			if(t.getExpenseDeposit().equals("Expense"))
			{
				System.out.println("Inside Expense Loop");
				exp=exp+t.getTransactionAmount();
			}
			if(t.getExpenseDeposit().equals("Deposit"))
				dep=dep+t.getTransactionAmount();
		}

		model.addObject("TotalExpenses", exp);
		model.addObject("TotalDeposits", dep);
		model.addObject("TotalStandings", dep-exp);
		
		return model;
		
	}

	@RequestMapping(value = "/deleteTransaction/{id}")
	public ModelAndView deleteTransactionUsingList(@PathVariable("id") int id) {

		transactionService.deleteTransactionByID(id);
		List<Transaction> transaction = transactionService.getAllTransactionByIsDeleted();
		ModelAndView model = new ModelAndView("listTransactions");
		model.addObject("transactionModel", transaction);
		return model;
	}

	@RequestMapping("/ManageTransactionTypes/{expnseOrDeposit}")
	public ModelAndView manageTransactionTypes(@ModelAttribute("userAttribute") User userAttribute, @PathVariable("expnseOrDeposit")String expnseOrDeposit) {
		System.out.println("Insidde WebController Manage Transaction Types");
		System.out.println(userAttribute.getUsername());

		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUser(userAttribute,expnseOrDeposit);
		ModelAndView model = new ModelAndView("manageTransactionTypes");
		model.addObject("transactionTypeModel", transactionType);
		model.addObject("expenseOrDepositObject", expnseOrDeposit);
		
		System.out.println("jhasdbhdsajhasdb"+expnseOrDeposit);

		return model;
	}
	

	@RequestMapping(value = "/addTransactionTypes", method = RequestMethod.POST)
	public ModelAndView addTransactionTypes(@ModelAttribute("userAttribute") User userAttribute,
			@ModelAttribute("expenseOrDeposit") String expenseOrDeposit,
			@RequestParam("newTransactionType") String transactionTypeValue) {

		System.out.println("Inside WebController addTransactionTypes method");
		System.out.println("value of Expense/Deposit " + expenseOrDeposit);
		TransactionType transactiontype = new TransactionType();

		transactiontype.setTtypeExpenseDeposit(expenseOrDeposit);
		transactiontype.setTransactionTypeValue(transactionTypeValue);
		List<User> users = new ArrayList<>();
		users.add(userAttribute);
		transactiontype.setUsers(users);

		transactionTypeService.addTransactionType(transactiontype);
		System.out.println("End WebController addTransactionTypes method");
		return new ModelAndView("Home");
	}

	@RequestMapping("/deleteTransactionType/{expenseOrDeposit}/{id}")
	public ModelAndView deleteTransactionTypeUsingList(@PathVariable("expenseOrDeposit") String expenseOrDeposit, @PathVariable("id") String transactionTypeValue, @ModelAttribute("userAttribute") User userAttribute) {

		transactionTypeService.deleteTransactionTypeByTransactionTypeValue(transactionTypeValue);
		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUser(userAttribute,
				expenseOrDeposit);
		ModelAndView model = new ModelAndView("manageTransactionTypes");
		model.addObject("transactionTypeModel", transactionType);
		return model;
	}
	

//	@RequestMapping(value = "/addExpense", method = RequestMethod.POST)
//	public ModelAndView addExpense(@ModelAttribute("userAttribute") User userAttribute,
//			@ModelAttribute("expenseModelAttribute") Transaction transaction,
//			@RequestParam("transactionTypeList") String transactionTypeValue) {
//		transaction.setExpenseOrDeposit("Expense");
//		transaction.setUser(userAttribute);
//		transaction.setTransactionType(new TransactionType(transactionTypeValue));
//		transactionService.addTransaction(transaction);
//		return new ModelAndView("Home");
//	}
//
//	@RequestMapping(value = "/addDeposit", method = RequestMethod.POST)
//	public ModelAndView addDeposit(@ModelAttribute("userAttribute") User userAttribute,
//			@ModelAttribute("expenseModelAttribute") Transaction transaction,
//			@RequestParam("transactionTypeList") String transactionTypeValue) {
//		transaction.setExpenseOrDeposit("Deposit");
//		transaction.setUser(userAttribute);
//		transaction.setTransactionType(new TransactionType(transactionTypeValue));
//		transactionService.addTransaction(transaction);
//		return new ModelAndView("Home");
//	}

//	@RequestMapping("/ManageExpenseTypes")
//	public ModelAndView manageExpenseTypes(@ModelAttribute("userAttribute") User userAttribute) {
//		System.out.println("Insidde WebController Manage Expene Types");
//		System.out.println(userAttribute.getUsername());
//
//		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUserExpense(userAttribute,
//				"Expense");
//		ModelAndView model = new ModelAndView("manageExpenseTypes");
//		model.addObject("transactionTypeModel", transactionType);
//
//		return model;
//	}
//
//	@RequestMapping("/ManageDepositTypes")
//	public ModelAndView manageDepositTypes(@ModelAttribute("userAttribute") User userAttribute) {
//		System.out.println("Insidde WebController Manage Deposit Types");
//		System.out.println(userAttribute.getUsername());
//
//		List<TransactionType> transactionType = transactionTypeService.getAllTransactionTypeByUserDeposit(userAttribute,
//				"Deposit");
//		ModelAndView model = new ModelAndView("manageDepositTypes");
//		model.addObject("transactionTypeModel", transactionType);
//		return model;
//	}
	
//	@RequestMapping(value = "/addDepositTypes", method = RequestMethod.POST)
//	public ModelAndView addTransactionTypesDeposit(@ModelAttribute("userAttribute") User userAttribute,
//			@ModelAttribute("expenseOrDeposit") String expenseOrDeposit,
//			@RequestParam("newTransactionType") String transactionTypeValue) {
//		System.out.println("Inside WebController addDepositTypes method");
//		System.out.println("value of Expense/Deposit " + expenseOrDeposit);
//		TransactionType transactiontype = new TransactionType();
//
//		transactiontype.setTtypeExpenseDeposit(expenseOrDeposit);
//		transactiontype.setTransactionTypeValue(transactionTypeValue);
//		List<User> users = new ArrayList<>();
//		users.add(userAttribute);
//		transactiontype.setUsers(users);
//
//		transactionTypeService.addTransactionType(transactiontype);
//		System.out.println("End WebController addTransactionTypes method");
//		return new ModelAndView("Home");
//	}
}
