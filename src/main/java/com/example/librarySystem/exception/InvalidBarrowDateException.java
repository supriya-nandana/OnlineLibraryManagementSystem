package com.example.librarySystem.exception;

public class InvalidBarrowDateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public InvalidBarrowDateException(String message) {
		super();
		this.message = message;
	}
	public InvalidBarrowDateException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
