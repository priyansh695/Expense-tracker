package com.application.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController{

	@Autowired
	UserService userService;
	
	@RequestMapping("/user")
	public List<User> getAllUsers() {
		ArrayList<User> tr = (ArrayList<User>) userService.getAllUsers();
		return tr;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public String addUser(@RequestBody User user)
	{
		userService.addUser(user);
		return "User added successfully";
	}
	
}
