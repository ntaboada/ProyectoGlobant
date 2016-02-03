package com.globantacademy.model;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException(){
	}
	
	public UserNotFoundException(String message) {
		super(message);
	}

	
}
