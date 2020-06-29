package com.example.librarySystem.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Barrow {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int barrowId;
	public int getBarrowId() {
		return barrowId;
	}
	public void setBarrowId(int barrowId) {
		this.barrowId = barrowId;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private int bookid;
	private int userid;
	private LocalDate date;

}
