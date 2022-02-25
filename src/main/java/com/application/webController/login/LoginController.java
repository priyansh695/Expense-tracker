package com.application.webController.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.application.transactionTypes.TransactionTypeService;
import com.application.users.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes("userAttribute")
@Slf4j
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	TransactionTypeService transactionTypeService;

	@ModelAttribute("userAttribute")
	public User setAttribute() {
		System.out.println("Inside LoginController default empty attribute setter");
		return new User();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model, @ModelAttribute("userAttribute") User userAttribute) {

		System.out.println("In LoginController GET Method");
		System.out.println("ater reset Value of Attribute in GET method " + userAttribute.getUsername());

		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		boolean isValidUser = loginService.validateUser(name, password);

		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "Login";
		}

		User userAttribute = new User();
		userAttribute.setUsername(name);

		System.out.println("ater reset Value of Attribute " + userAttribute.getUsername());

		model.addAttribute("userAttribute", userAttribute);

		return "Home";
	}

	@RequestMapping("/logout")
	public String closeSession(SessionStatus sessionStatus, @ModelAttribute("userAttribute") User userAttribute) {
		System.out.println("In LoginController logout mapping");
		sessionStatus.setComplete();
		userAttribute.setUsername(null);
		System.out.println("Current status of user in logout Controller " + userAttribute.getUsername());
		return "Login";
	}

	@RequestMapping(value = "/register")
	public ModelAndView addExpenseRedirectRedirectDeposit(@ModelAttribute("userAttribute") User userAttribute) {

		return new ModelAndView("register");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addTransaction(@ModelAttribute("registerModelAttribute") User user, ModelMap model) {

		boolean isValidUsername = loginService.validateUsername(user.getUsername());
		boolean isValidUseremail = loginService.validateUseremail(user.getUseremail());

		if (isValidUsername) {
			System.out.println("username exist");

			model.put("userExist", "Username already exist");
			return "register";
		}

		if (isValidUseremail == true) {
			System.out.println("useremail exist");
			model.put("userEmailExist", "User email already exist");
			return "register";

		} else {
			loginService.addUser(user);
			model.put("errorMessage", "Account registered successfully ");
			return "Login";
		}

	}
}
