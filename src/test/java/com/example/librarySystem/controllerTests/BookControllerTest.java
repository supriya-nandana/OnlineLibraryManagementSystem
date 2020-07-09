package com.example.librarySystem.controllerTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.librarySystem.controller.BookController;
import com.example.librarySystem.dtos.BookRequestDto;
import com.example.librarySystem.dtos.BookResponseDto;
import com.example.librarySystem.model.Book;
import com.example.librarySystem.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nandana
 *
 */
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	ObjectMapper objectMapper;

	@Mock
	BookService bookService;

	@InjectMocks
	BookController bookController;

	MockMvc mockMvc;

	/**
	 * @throws Exception
	 */
	@Test
	public void findHotelsByLocationTest() throws Exception {
	List<Book> books = new ArrayList<Book>();


	BookRequestDto bookrequest=new BookRequestDto();
	BookResponseDto bookresponse=new BookResponseDto();
	bookrequest.setAuthorName("j.b.gupta");
	bookrequest.setBookTitle("netork analysis");
	bookrequest.setCategoryName("Electricals");
	bookresponse.setBookDescription("good knowledgeable");
	bookresponse.setBookId(1);
	bookresponse.setNoOfCopies(4);
	
	
	 
	}

}
