package com.example.librarySystem.exceptions;

public class BookIdMatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
	public BookIdMatchException(String message) {
		super();
		this.message = message;
	}
	public BookIdMatchException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
