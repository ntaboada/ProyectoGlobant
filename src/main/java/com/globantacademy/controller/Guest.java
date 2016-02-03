package com.globantacademy.controller;

import java.security.InvalidParameterException;
import java.util.Scanner;

import com.globantacademy.model.UserNotFoundException;
import com.globantacademy.view.Login;

public class Guest {
	
	
	public void menuOptions(){

		System.out.println("Select your option: ");
		System.out.println("1) Log In");
		System.out.println("2) Visualize Comic Catalog");
		System.out.println("3) Exit");
		System.out.println("----------------------------------------");
		System.out.println("Your option: ");
		
	}
	
	public void userOption(int userOption){
		
		switch (userOption) {
			
			case 1:
				this.logIn();
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			default:
				break;
		}
	}
	
	
	public void logIn(){
		
		Scanner scan = new Scanner(System.in);
		String user;
		String password;
		boolean loginValidation;
		
		System.out.println("Enter your credentials");
		System.out.println("----------------------");
		System.out.println("User: ");
		user = scan.nextLine(); 
		System.out.println("Password:");
		password = scan.nextLine();
		
	
		try {
			loginValidation = Login.logValidation(user, password);
			
			if(loginValidation){
				
			}
			else{
				System.out.println("Try Again");
				this.logIn();
			}
			
		} catch (InvalidParameterException e) {
			System.out.println(e.getMessage());
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	

}

