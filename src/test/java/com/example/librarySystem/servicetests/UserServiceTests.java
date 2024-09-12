package com.example.librarySystem.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.librarySystem.dao.UserDao;
import com.example.librarySystem.dtos.Credentials;
import com.example.librarySystem.model.User;
import com.example.librarySystem.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	Credentials credentials;

	@BeforeEach
	public void setUp() {

		credentials = new Credentials();
		credentials.setUserName("test");
		credentials.setPassword("test");


	}

	
	@Test	
	public void authenticateTest()  {
		User user = new User();
		user.setUserName("test");
		user.setPassword("test");
		when(userDao.findByUserNameAndPassword("test", "test")).thenReturn(user);
		userServiceImpl.authenticate("test", "test");
		verify(userDao).findByUserNameAndPassword("test", "test");
		assertEquals(true,userServiceImpl.authenticate("test", "test"));
		
	}
	
	
	@Test
	
	public void authenticateTest1()  {
		User user = new User();
		user.setUserName("manasa");
		user.setPassword("1234");
		when(userDao.findByUserNameAndPassword("test", "test")).thenReturn(null);
		userServiceImpl.authenticate("test", "test");
		verify(userDao).findByUserNameAndPassword("test", "test");
		assertEquals(false,userServiceImpl.authenticate("test", "test"));
		
	}
}
