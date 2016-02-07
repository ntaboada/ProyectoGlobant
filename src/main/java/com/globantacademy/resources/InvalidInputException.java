package com.globantacademy.resources;

public class InvalidInputException extends Exception{
	
	public InvalidInputException(){
			super( "Please select a valid number option");
		}
}
