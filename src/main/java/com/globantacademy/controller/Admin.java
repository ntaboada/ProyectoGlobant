package com.globantacademy.controller;

import java.util.Arrays;
import java.util.Scanner;

import com.globantacademy.model.DataBase;
import com.globantacademy.resources.ScannerClass;
import com.globantacademy.view.App;

public class Admin extends User{

	private String[] arrOptionsAdmin = {"1) Listar Usuarios", "2) Add User", "3) Delete User", "4) Modify User", "5) Add Comic", "6) Delete Comic", "7) Modify Comic", "8) Add Genre","9) Delete Genre", "10) Accept Loans", "11) Reject Loans", "12) Exit"}; 
	private static Admin adm;
	
	
	private Admin(){
		arrOptions = Arrays.copyOfRange(arrOptionsAdmin, 0, arrOptionsAdmin.length);
		username = "Sheldon";
		password = "Bazzinga";
	}
	
	public static Admin getInstance(){
		if(adm==null)
			adm = new Admin();
		return adm;
	}
	
	
	public void showMenuOptions(){
		System.out.println("");
		super.showMenuOptions();
	}
	
	
	
	@Override
	public void userOption(int userOption) {
		
		switch (userOption) {
		
		case 1:
			this.showUserCatalog();
			break;
		case 2:
			this.addNewUser();
		case 3:
			this.deleteUser();
		case 4:
			this.modifyUser();
			
		default:
			break;
	
		
		}
	
		if(userOption>=1 && userOption<=11)
		App.interactingWithUser(Admin.getInstance(), true);
	}
	

	@Override
	public void changeUserType() {
		// TODO Auto-generated method stub
		
	}
	
	public void addNewUser(){
		System.out.println("Enter Username and Password");
		System.out.println("----------------------------------------");
		System.out.println("Username: ");
		String username = ScannerClass.readString();
		System.out.println("Password: ");
		String password = ScannerClass.readString();
		
		User newUser = new NoAdmin (new Registered(), username, password);
		
		if(DataBase.addUser(newUser))
		{
			System.out.println("User added correctly");
		}
		else
		{
			System.out.println("User is already exists in the Catalog. Try Again");
		}
	}
	
	public void deleteUser(){
		this.showUserCatalog();
		System.out.println("");
		
		System.out.println("Select the user you want to delete: ");
		String user = ScannerClass.readString();
		if(DataBase.deleteUser(user)){
			System.out.println("User deleted correctly");
		}
		else{
			System.out.println("User " +"'"+ user + "'" + " doesn't exist");
		}
	
	}
	
	public void modifyUser(){
		
		this.showUserCatalog();
		System.out.println("");
		
		System.out.println("Select the user you want to modify: ");
		String user = ScannerClass.readString();
		System.out.println("Enter new Username: ");
		String newUserName = ScannerClass.readString();
		System.out.println("Enter new Password: ");
		String newPassword = ScannerClass.readString();
		
		if(DataBase.modifyUser(user, newUserName, newPassword)){
			System.out.println("User modified correctly");
		}
		else{
			System.out.println("User " +"'"+ user + "'" + " doesn't exist");
		}
	}
	
	
	public void showUserCatalog(){
		//¿Como imprimo un acumulador?
		System.out.println("Users List:");
		System.out.println("");
		DataBase.users.stream().forEach(user -> System.out.println("User: " + user.username));
		
		
	}
}
