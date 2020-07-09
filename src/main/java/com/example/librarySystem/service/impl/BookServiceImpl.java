package com.example.librarySystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarySystem.dao.BookDao;
import com.example.librarySystem.dtos.BookRequestDto;
import com.example.librarySystem.dtos.BookResponseDto;
import com.example.librarySystem.model.Book;
import com.example.librarySystem.service.BookService;

/**
 * @author bhavani
 *
 */
@Service
public class BookServiceImpl implements BookService {

	 @Autowired
	    BookDao bookDao;

	/**
	 * RequestBody BookRequestDto
	 *return bookResponseDtoList
	 */
	@Override
	public List<BookResponseDto> getBooksByauthorNameAndcategoryNameAndbookTitle(BookRequestDto bookrequestDto) {
		
		     List<BookResponseDto> bookResponseDtoList = new ArrayList<BookResponseDto>();
		       String booktitle=  bookrequestDto.getBookTitle();
		       String AuthorName=  bookrequestDto.getAuthorName();
		       String CategoryName= bookrequestDto.getCategoryName();
		        Optional<List<Book>> bookdetails = bookDao.getBooksByauthorNameAndcategoryNameAndbookTitle(booktitle,AuthorName,CategoryName);
		        if (bookdetails.isPresent()) {
		            return bookdetails.get().stream().map(bookdetail -> getBookResponseDto(bookdetail)).collect(Collectors.toList());
		        } else {
		            return bookResponseDtoList;
		        }
		    }
		        /**
		         * @param books
		         * @return bookResponseDto
		         */
		        private BookResponseDto getBookResponseDto(Book books)
		        {
		            BookResponseDto bookResponseDto = new BookResponseDto();
		            BeanUtils.copyProperties(books, bookResponseDto);
		            return bookResponseDto;
		        }
	}

