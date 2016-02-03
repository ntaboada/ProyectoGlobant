package com.globantacademy.controller;
import java.util.Scanner;

import com.globantacademy.controller.InvalidInputException;
import com.globantacademy.view.App;

public abstract class User  {
	
	private String username;
	private String password;
	protected String[] arrOptions;
	
	public User(){
		
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void returnHome(){
		App.welcome();
	}
	
	
	//Muestro el los Strings con las opciones disponibles
	public void showMenuOptions(String[] arrOptions){
		System.out.println("Select your option: ");
		for (String option : arrOptions) {
			System.out.println(option);
			
		}
		System.out.println("----------------------------------------");
		System.out.println("Your option: ");
	}

	//Llamo a un scanner con la opcion seleccionada del User
	public void userSelectOption(User user){
		Scanner scan = new Scanner(System.in);
		int option;
		
		try{	
			if (scan.hasNextInt()) {
				option = scan.nextInt();
				user.userOption(option);

			} else {
				throw new InvalidInputException("'" + scan.next() + "'" + " is not a valid Input. Try again");
				}
			}catch (InvalidInputException ex) {
				System.out.println(ex.getMessage());}
	
		scan.close();
	}

	//Llama a los metodos para la opcion seleccionada
	public abstract void userOption(int option);
	
}
