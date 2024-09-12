package com.example.librarySystem.service;

import java.util.List;

import com.example.librarySystem.dtos.BookRequestDto;
import com.example.librarySystem.dtos.BookResponseDto;

public interface BookService {

	public List<BookResponseDto> getBooksByauthorNameAndcategoryNameAndbookTitle(BookRequestDto bookrequestDto) ;
		

}
