package com.example.librarySystem.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.librarySystem.dao.BarrowDao;
import com.example.librarySystem.dto.BarrowBooksResponseDto;
import com.example.librarySystem.dto.BarrowRequestDto;
import com.example.librarySystem.exception.BooksNotFoundException;
import com.example.librarySystem.exception.InvalidBarrowDateException;
import com.example.librarySystem.exception.MoreBoooksException;
import com.example.librarySystem.model.Barrow;
import com.example.librarySystem.service.BarrowService;

@Service
public class BarrowServiceImpl implements BarrowService {

	@Autowired
	BarrowDao barrowDao;

	@Override
	public boolean saveBarrowDetails(int bookId, BarrowRequestDto barrowRequestDto) throws InvalidBarrowDateException, MoreBoooksException {
		LocalDate date;
		date = LocalDate.now();
		LocalDate date1 = date.plusDays(1);
		LocalDate date2 = date.plusDays(2);

		Barrow barrow = new Barrow();
		if (barrowDao.findbookIdByuserId(barrowRequestDto.getUserId()).size() > 3) {
			barrow.setBookid(bookId);
		} else {
			throw new MoreBoooksException("user  barrow 3 books only");
		}
		barrow.setUserid(barrowRequestDto.getUserId());
		if (barrowRequestDto.getDate() == date || barrowRequestDto.getDate() == date1
				|| barrowRequestDto.getDate() == date2) {
			barrow.setDate(barrowRequestDto.getDate());
		} else {
			throw new InvalidBarrowDateException("Barrow is with in 3 days from today only ");
		}
		Barrow barrow1 = barrowDao.save(barrow);
		if (barrow1 != null)
			return true;

		return false;
	}

	@Override
	public List<BarrowBooksResponseDto> getBarrowBooksByUserId(int userId) throws BooksNotFoundException {
		Optional<List<Barrow>> getBarrowBookOptional = barrowDao.findAllByHotelId(userId);
		if (getBarrowBookOptional.isPresent()) {
			List<Barrow> barrowBooks = getBarrowBookOptional.get();
			return barrowBooks.stream().map(barrowBook -> getOrderResponse(barrowBook)).collect(Collectors.toList());
		}
		throw new BooksNotFoundException("No books found with the userid:");
	}

	private BarrowBooksResponseDto getOrderResponse(Barrow barrow) {
		BarrowBooksResponseDto barrowBooksResponseDto = new BarrowBooksResponseDto();
		BeanUtils.copyProperties(barrow, barrowBooksResponseDto);
		return barrowBooksResponseDto;
	}
}
