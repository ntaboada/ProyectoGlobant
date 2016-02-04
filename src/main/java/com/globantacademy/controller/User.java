package com.globantacademy.controller;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.globantacademy.resources.InvalidInputException;
import com.globantacademy.view.App;

public abstract class User  {
	
	protected String username;
	protected String password;
	protected String[] arrOptions;
	
	public User(){
		
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public boolean adminPriviliges(){
		if(username.equals("Sheldon")&&  password.equals("Bazzinga")){
			return true;
		}
		return false;
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
	
	//Muestro el los Strings con las opciones disponibles
	public void showMenuOptions(){
		
		System.out.println("Select your option: ");
		for (String option : arrOptions) {
			System.out.println(option);
			
		}
		System.out.println("----------------------------------------");
		System.out.println("Your option: ");
	}

	//Llamo a un scanner con la opcion seleccionada del User
	public boolean userSelectOption(User user, boolean showMenu){
		Scanner scan = new Scanner(System.in);
		int option;
		
		while (scan.hasNext()) {
			try{
			option = scan.nextInt();
			user.userOption(option);
			showMenu = false;
			return showMenu;
			}
			catch(NoSuchElementException ex){
				System.out.println(ex.getMessage());
			}
		}
		scan.close();
		return showMenu;
	}

	//Llama a los metodos para la opcion seleccionada
	public abstract void  userOption(int option);
	public abstract void  changeUserType();
}
