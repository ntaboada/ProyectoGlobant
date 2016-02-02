package com.globantacademy.view;

import java.util.Scanner;

public class MenuOptions {
	

	public static void showMenuOptions(){
		
		
		System.out.println("Select your option: ");
		System.out.println("1) Log In");
		System.out.println("2) Visualize Comic Catalog");
		System.out.println("3) Exit");
		System.out.println("----------------------------------------");
		System.out.println("Your option: ");
		
	}
	
	
	public static void loginUsers(){
		
		Scanner scan = new Scanner(System.in);
		String user;
		String password;
		
		System.out.println("Enter your credentials");
		System.out.println("----------------------");
		System.out.println("User: ");
		user = scan.nextLine(); 
		System.out.println("Password:");
		password = scan.nextLine();
		
		Login userLog = new Login(user, password);
		
		
		
	}
	

}
