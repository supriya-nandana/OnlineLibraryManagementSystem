package com.example.librarySystem.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarySystem.dtos.Credentials;
import com.example.librarySystem.exceptions.InvalidCredentialsException;
import com.example.librarySystem.exceptions.ResourceNotFoundException;
import com.example.librarySystem.service.UserService;


@RestController
public class UserController {
	
	private static Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
	UserService userService;
	
	/**
	 * @param credentials
	 * @return String
	 * @throws InvalidCredentialsException
	 */
    @PostMapping("/users/login")
    public ResponseEntity<String> login(@Valid @RequestBody Credentials credentials){
        logger.info("authenticating the user");
    	boolean isExists = userService.authenticate(credentials.getUserName(), credentials.getPassword());
       
        if(isExists)
        	return new ResponseEntity<String>("login succcesfully",HttpStatus.OK);      
        else{
        	throw new ResourceNotFoundException("Please enter valid credentials");
        }
    }
	
}
