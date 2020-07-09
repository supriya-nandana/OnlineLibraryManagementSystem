package com.example.librarySystem.controllerTests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.librarySystem.controller.BorrowController;
import com.example.librarySystem.service.BorrowService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author anilkumar
 *
 */
@ExtendWith(MockitoExtension.class)
public class BorrowControllerTest {

	ObjectMapper objectMapper;

	@Mock
	BorrowService borrowService;

	@InjectMocks
	BorrowController borrowController;

	MockMvc mockMvc;

	/*BarrowRequestDto barrowRequest=new BarrowRequestDto();
	barrowRequest
	@Test
	public void borrowBook() throws Exception {
		// given
		when(borrowService.saveBarrowDetails()
				.authenticate("sai", "1234")).thenReturn(true);

		// when and then
		mockMvc.perform(post("/users/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(credentials))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("you have successfully borrowed the book")));

		verify(userService).authenticate("sai", "1234");
	}
	
	*/
}
