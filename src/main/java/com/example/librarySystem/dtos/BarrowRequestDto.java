package com.example.librarySystem.dtos;

import java.time.LocalDate;

public class BarrowRequestDto {

	private int bookId;
	private int userId;
	private LocalDate date;

	

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
