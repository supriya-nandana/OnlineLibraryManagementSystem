package com.example.librarySystem.dto;

import java.time.LocalDate;

public class BarrowRequestDto {
	private int userId;
	private LocalDate date;

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
