package com.example.librarySystem.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.librarySystem.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	/**
	 * @param userName
	 * @param password
	 * @return
	 */
	public User findByUserNameAndPassword(String userName, String password);

}
