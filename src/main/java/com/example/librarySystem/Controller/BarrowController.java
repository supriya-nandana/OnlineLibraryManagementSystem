package com.example.librarySystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarySystem.dto.BarrowBooksResponseDto;
import com.example.librarySystem.dto.BarrowRequestDto;
import com.example.librarySystem.exception.BookIdMatchException;
import com.example.librarySystem.exception.BooksNotFoundException;
import com.example.librarySystem.exception.InvalidBarrowDateException;
import com.example.librarySystem.exception.MoreBoooksException;
import com.example.librarySystem.service.BarrowService;

@RestController
public class BarrowController {
	@Autowired
	BarrowService barrowService;
	
	@PostMapping("/book/{bookId}/barrow")
	public String barrowBook(@PathVariable("bookId") int bookId,@RequestBody BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException, BookIdMatchException {
		boolean save=barrowService.saveBarrowDetails(bookId,barrowRequestDto);
		if(save) {
			return "barrow book succussfull till one week";
			}
		return"barrow book not succussfull";
	}
	
	@ExceptionHandler(InvalidBarrowDateException.class)
	public ResponseEntity<String> exceptionHandler(InvalidBarrowDateException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MoreBoooksException.class)
	public ResponseEntity<String> exceptionHandler(MoreBoooksException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BookIdMatchException.class)
	public ResponseEntity<String> exceptionHandler(BookIdMatchException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/user/{userId}/barrowBookDetails")
	public List<BarrowBooksResponseDto> getBarrowBooks(@PathVariable("userId")int userId) throws BooksNotFoundException {
		return barrowService.getBarrowBooksByUserId(userId);
		
	}
	@ExceptionHandler(BooksNotFoundException.class)
	public ResponseEntity<String> exceptionHandler(BooksNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
