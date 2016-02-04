package com.globantacademy.controller;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.globantacademy.view.App;
import com.globantacademy.view.Login;

public class Guest extends UserType{

	private String[] arrOptionsGuest  = {"1) Log In", "2) Visualize Comic Catalog", "3) Exit"};
	
	
	
	public Guest(){
		arrOptions =  Arrays.copyOfRange(arrOptionsGuest, 0, arrOptionsGuest.length);
	}
	
	
	public String[] getArrOptions() {
		return arrOptionsGuest;
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
	
		System.out.println("----------------------------------------");
		System.out.println("Select your option: ");
		System.out.println("1) Enter your credentials");
		System.out.println("2) Return ");
		System.out.println("----------------------------------------");
		System.out.println("Your option: ");
		
		switch (scan.nextInt()) {
		case 1:
			String user;
			String password;
			boolean loginValidation;
			
			System.out.println("User: ");
			user = scan.next(); 
			System.out.println("Password:");
			password = scan.next();
			
		
			try {
				//Valido datos en mi Login
				loginValidation = Login.logValidation(user, password);
				
				if(loginValidation){
					
				}
				else{
					System.out.println("Login Failed. Rewrite your credentials.");
					
					this.logIn();
				}
				
			} catch(InputMismatchException ex){
				System.out.println(ex.getMessage());
			}
	
			break;

		case 2:
			UserType guest = new Guest();
			User guestUser = new NoAdmin(guest);
			App.interactingWithUser(guestUser);
			break;
		}
		
		
		
	}
	
	

}

