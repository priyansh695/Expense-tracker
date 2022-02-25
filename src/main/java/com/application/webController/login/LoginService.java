package com.application.webController.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.users.User;
import com.application.users.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public boolean validateUser(String name, String password) {

		boolean checkUser = userRepository.existsUserByUsernameAndUserpasswordAndIsDeleted(name, password, 0);
		return checkUser;
	}

	public boolean validateUsername(String username) {
		boolean checkUsername = userRepository.existsUserByUsernameAndIsDeleted(username, 0);
		return checkUsername;
	}

	public boolean validateUseremail(String useremail) {

		boolean checkUseremail = userRepository.existsUserByUseremailAndIsDeleted(useremail, 0);
		return checkUseremail;

	}

	public void addUser(User user) {
		userRepository.save(user);
	}
}
