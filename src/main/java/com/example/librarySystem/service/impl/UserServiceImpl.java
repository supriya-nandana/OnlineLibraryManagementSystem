package com.example.librarySystem.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarySystem.controller.UserController;
import com.example.librarySystem.dao.UserDao;
import com.example.librarySystem.service.UserService;

/**
 * @author Nandana
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserDao userDao;
	
	/**
	 *return boolean
	 */
	@Override
	public boolean authenticate(String userName, String password) {
		logger.info("inside the findbyusernameandpassword method");
		if (userDao.findByUserNameAndPassword(userName,password)!= null)
            return true;
        return false;
 }

}
