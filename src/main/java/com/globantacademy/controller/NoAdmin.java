package com.globantacademy.controller;

public class NoAdmin extends User {
	
	
	private Guest type; 
	
	public NoAdmin(String user, String password){
		super(user, password);
	}
	
	public NoAdmin(){
		type = new Guest();
	}
	
	public Guest getType() {
		return type;
	}

	public void setType(Guest type) {
		this.type = type;
	}

	public void menuOptions(){

		type.menuOptions();
		
	}
	
	public void userOption(int userOption){
		type.userOption(userOption);
	}
	
	
	

}
	
	
	
