package com.globantacademy.controller;

public abstract class UserType {

	
	private String[] arrOptions;
	
	public abstract String[] getArrOptions();
	public abstract void userOption(int userOption);
}
