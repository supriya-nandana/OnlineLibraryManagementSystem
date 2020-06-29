package com.example.librarySystem.controllerTests;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.librarySystem.controller.UserController;
import com.example.librarySystem.dtos.Credentials;
import com.example.librarySystem.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

	ObjectMapper objectMapper;

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	Credentials credentials;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		credentials = new Credentials();
		credentials.setPassword("1234");
		credentials.setUserName("sai");

	}

	@Test
	public void loginTest() throws Exception {
		// given
		when(userService.authenticate("sai", "1234")).thenReturn(true);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(credentials))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("login succcesfully")));

		verify(userService).authenticate("sai", "1234");
	}

	
}
