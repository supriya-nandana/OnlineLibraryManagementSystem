package com.example.librarySystem.service;

import java.util.List;

import com.example.librarySystem.dto.BarrowBooksResponseDto;
import com.example.librarySystem.dto.BarrowRequestDto;
import com.example.librarySystem.exception.BookIdMatchException;
import com.example.librarySystem.exception.BooksNotFoundException;
import com.example.librarySystem.exception.InvalidBarrowDateException;
import com.example.librarySystem.exception.MoreBoooksException;

public interface BarrowService {

	boolean saveBarrowDetails(int bookId, BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException, BookIdMatchException;

	List<BarrowBooksResponseDto> getBarrowBooksByUserId(int userId) throws BooksNotFoundException;




}
