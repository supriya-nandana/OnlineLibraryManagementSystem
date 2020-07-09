package com.example.librarySystem.service;

import java.util.List;

import com.example.librarySystem.dtos.BarrowBooksResponseDto;
import com.example.librarySystem.dtos.BarrowRequestDto;
import com.example.librarySystem.exceptions.BookIdMatchException;
import com.example.librarySystem.exceptions.BooksNotFoundException;
import com.example.librarySystem.exceptions.InvalidBarrowDateException;
import com.example.librarySystem.exceptions.MoreBoooksException;


public interface BorrowService {

	boolean saveBarrowDetails(BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException, BookIdMatchException;

	List<BarrowBooksResponseDto> getBarrowBooksByUserId(int userId) throws BooksNotFoundException;

}
