package com.example.librarySystem.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarySystem.controller.UserController;
import com.example.librarySystem.dao.BarrowDao;
import com.example.librarySystem.dtos.BarrowBooksResponseDto;
import com.example.librarySystem.dtos.BarrowRequestDto;
import com.example.librarySystem.exceptions.BookIdMatchException;
import com.example.librarySystem.exceptions.BooksNotFoundException;
import com.example.librarySystem.exceptions.InvalidBarrowDateException;
import com.example.librarySystem.exceptions.MoreBoooksException;
import com.example.librarySystem.model.Borrow;
import com.example.librarySystem.service.BorrowService;

/**
 * @author AnilKumar
 *
 */
@Service
public class BorrowServiceImpl implements BorrowService {
		
	private static Log logger = LogFactory.getLog(UserController.class);
	
		@Autowired
		BarrowDao barrowDao;

		/**
		 * RequestBody BarrowRequestDto
		 * return boolean
		 */
		@Override
		public boolean saveBarrowDetails(BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException,BookIdMatchException {
			
			LocalDate date;
			date = LocalDate.now();
			LocalDate date1 = date.plusDays(1);
			LocalDate date2 = date.plusDays(2);
	     //   List<Integer> id=barrowDao.findbookIdByuserId(barrowRequestDto);
			Borrow barrow = new Borrow();
		
			barrow.setBookId(barrowRequestDto.getBookId());
			barrow.setUserId(barrowRequestDto.getUserId());
			if (barrowRequestDto.getDate().equals(date) || barrowRequestDto.getDate().equals(date1)
					|| barrowRequestDto.getDate().equals(date2)) {
				barrow.setDate(barrowRequestDto.getDate());
			} else {
				throw new InvalidBarrowDateException("Borrow is with in 3 days from today only ");
			}
			Borrow barrow1 = barrowDao.save(barrow);
			if (barrow1 != null)
				return true;

			return false;
		}

		/**
		 *pathVariable userId
		 *return barrowBooks
		 */
		@Override
		public List<BarrowBooksResponseDto> getBarrowBooksByUserId(int userId) throws BooksNotFoundException {
			logger.info("inside getBarrowBooksByUserId method");
			Optional<List<Borrow>> getBarrowBookOptional = barrowDao.findAllByBarrowId(userId);
			if (getBarrowBookOptional.isPresent()) {
				List<Borrow> barrowBooks = getBarrowBookOptional.get();
				return barrowBooks.stream().map(barrowBook -> getOrderResponse(barrowBook)).collect(Collectors.toList());
			}
			throw new BooksNotFoundException("No books found with the userid:"+userId);
		}

		/**
		 * @param borrow
		 * @return barrowBooksResponseDto
		 */
		private BarrowBooksResponseDto getOrderResponse(Borrow borrow) {
			logger.info("inside the getOrderResponse");
			BarrowBooksResponseDto barrowBooksResponseDto = new BarrowBooksResponseDto();
			BeanUtils.copyProperties(borrow, barrowBooksResponseDto);
			return barrowBooksResponseDto;
		}

	}


