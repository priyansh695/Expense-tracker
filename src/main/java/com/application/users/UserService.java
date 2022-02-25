package com.application.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ArrayList<User> getAllUsers() {
		ArrayList<User> tr = new ArrayList<User>();
		userRepository.findUserByIsDeleted(0).forEach(tr::add);
		for (User u : tr) {
			u.setUserpassword("Hidden");
		}
		return tr;
	}

//	public ArrayList<User> getAllUsersNames() {
//		ArrayList<User> tr = new ArrayList<User>();
//		userRepository.findUserByIsDeleted(0).forEach(tr::add);
//		return tr;
//	}

	public void addUser(User user) {
		userRepository.save(user);

	}

}
