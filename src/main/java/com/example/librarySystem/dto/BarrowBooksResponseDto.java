package com.example.librarySystem.dto;

public class BarrowBooksResponseDto {
	private int  barrowId;
	private int bookId;
	private int barrowDate;
	private int bookname;
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
	public int getBarrowDate() {
		return barrowDate;
	}
	public void setBarrowDate(int barrowDate) {
		this.barrowDate = barrowDate;
	}
	public int getBookname() {
		return bookname;
	}
	public void setBookname(int bookname) {
		this.bookname = bookname;
	}

}
