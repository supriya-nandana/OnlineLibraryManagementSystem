package com.example.librarySystem.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarySystem.dtos.BookRequestDto;
import com.example.librarySystem.dtos.BookResponseDto;
import com.example.librarySystem.service.BookService;

@RestController
public class BookController {
	private static Log logger = LogFactory.getLog(UserController.class);
	
	@Autowired
    BookService bookService;
    
	@GetMapping("/books/bookdetails")
     public List<BookResponseDto> getBooksByauthorNameAndcategoryNameAndbookTitle(@RequestBody BookRequestDto bookrequestDto)
        {
		logger.info("inside the getbooksbyauthornameandcategorynameandbooktitle method");
            return bookService.getBooksByauthorNameAndcategoryNameAndbookTitle(bookrequestDto);
        }
}
