package com.example.librarySystem.exception;

public class MoreBoooksException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	public MoreBoooksException(String message) {
		super();
		this.message = message;
	}
	public MoreBoooksException() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
