package com.globantacademy.controller;

public abstract class UserType {

	
	protected String[] arrOptions;
	
	
	
	
	public abstract String[] getArrOptions();
	public abstract void userOption(int userOption);
}
