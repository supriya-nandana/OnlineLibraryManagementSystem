package com.example.librarySystem.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarySystem.dtos.BarrowBooksResponseDto;
import com.example.librarySystem.dtos.BarrowRequestDto;
import com.example.librarySystem.exceptions.BookIdMatchException;
import com.example.librarySystem.exceptions.BooksNotFoundException;
import com.example.librarySystem.exceptions.InvalidBarrowDateException;
import com.example.librarySystem.exceptions.MoreBoooksException;
import com.example.librarySystem.service.BorrowService;

@RestController
public class BorrowController {

	private static Log logger = LogFactory.getLog(UserController.class);
	
	
	@Autowired
	BorrowService borrowService;
	
	/**
	 * @param barrowRequestDto
	 * @return
	 * @throws InvalidBarrowDateException
	 * @throws MoreBoooksException
	 * @throws BookIdMatchException
	 */
	@PostMapping("/book/borrow")
	public String barrowBook(@RequestBody BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException, BookIdMatchException {
		logger.info("inside the barrowbook method");
		boolean save=borrowService.saveBarrowDetails(barrowRequestDto);
		if(save) {
			return "you have successfully borrowed the book ";
			}
		return"borrow book not successful";
	}
	
	/**
	 * @param userId
	 * @return
	 * @throws BooksNotFoundException
	 */
	@GetMapping("/user/{userId}/borrowBookDetails")
	public List<BarrowBooksResponseDto> getBarrowBooks(@PathVariable("userId")int userId) throws BooksNotFoundException {
		return borrowService.getBarrowBooksByUserId(userId);
		
	}
		
	
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(InvalidBarrowDateException.class)
	public ResponseEntity<String> exceptionHandler(InvalidBarrowDateException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(MoreBoooksException.class)
	public ResponseEntity<String> exceptionHandler(MoreBoooksException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(BookIdMatchException.class)
	public ResponseEntity<String> exceptionHandler(BookIdMatchException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(BooksNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(BooksNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
