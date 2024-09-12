package com.example.librarySystem.exceptions;

public class BooksNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
	public BooksNotFoundException(String message) {
		super();
		this.message = message;
	}
	public BooksNotFoundException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
