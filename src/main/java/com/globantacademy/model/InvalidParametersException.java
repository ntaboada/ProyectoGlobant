package com.globantacademy.model;

public class InvalidParametersException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidParametersException(){
	}
	
	public InvalidParametersException(String message) {
		super(message);
	}
}
