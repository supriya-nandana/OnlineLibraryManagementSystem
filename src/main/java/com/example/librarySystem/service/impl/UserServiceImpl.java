package com.example.librarySystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarySystem.dao.UserDao;
import com.example.librarySystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean authenticate(String userName, String password) {
		if (userDao.findByUserNameAndPassword(userName,password)!= null)
            return true;
        return false;
 }

}
