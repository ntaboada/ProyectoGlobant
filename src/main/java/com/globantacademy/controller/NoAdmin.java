package com.globantacademy.controller;

import java.util.Arrays;

public class NoAdmin extends User {
	
	
	private UserType type;
	

	
	public NoAdmin(UserType type){
		this.type=type;
		arrOptions = Arrays.copyOfRange(type.getArrOptions(), 0, type.getArrOptions().length);
	}
	
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	
	public void showMenuOptions(){
		super.showMenuOptions(type.getArrOptions());
	}
	
	
	public void userOption(int userOption){
		type.userOption(userOption);
	}
	
	
	

}
	
	
	
