package com.application.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<User> findUserByIsDeleted(int id);

	public boolean existsUserByUsernameAndUserpasswordAndIsDeleted(String user,String pass,int i);
	public Optional<User> findUserByUsernameAndUserpassword(String name, String pass);
	
	public boolean existsUserByUsernameAndIsDeleted(String user,int i);
	
	public boolean existsUserByUseremailAndIsDeleted(String user,int i);



}
