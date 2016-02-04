package com.globantacademy.controller;

import java.util.Arrays;

public class NoAdmin extends User {
	
	
	private UserType type;

	public NoAdmin(UserType type){
		this.type=type;
		arrOptions = Arrays.copyOfRange(type.getArrOptions(), 0, type.getArrOptions().length);
	}
	public NoAdmin(UserType type, String user, String password){
		super(user, password);
		this.type=type;
		arrOptions = Arrays.copyOfRange(type.getArrOptions(), 0, type.getArrOptions().length);
		
	}
	
	public NoAdmin(String user, String password){
		super(user, password);
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public void changeUserType(){
		type = type.changeUserType();
		arrOptions = Arrays.copyOfRange(type.getArrOptions(), 0, type.getArrOptions().length);
		
	}

	
	public void showMenuOptions(){
		super.showMenuOptions();
	}
	
	
	public void userOption(int userOption){
		type.userOption(userOption);
	}
	
	

}
	
	
	
