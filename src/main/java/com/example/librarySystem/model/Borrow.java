package com.example.librarySystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int barrowId;
	public int getBarrowId() {
		return barrowId;
	}
	public void setBarrowId(int barrowId) {
		this.barrowId = barrowId;
	}
	
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
	private int bookId;
	private int userId;
	private LocalDate date;

}
