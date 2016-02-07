package com.globantacademy.view;
import java.util.InputMismatchException;
import com.globantacademy.controller.User;
import com.globantacademy.model.DataBase;



public class Login {
	
	public static User userLogged = null;
	
	public static User getUserLogged() {
		return userLogged;
	}


	public static void setUserLogged(User userLogged) {
		Login.userLogged = userLogged;
	}


	public static User logValidation(String username, String password) {

		User userInDB = DataBase.lookForUser(username);
		
		if (userInDB!=null){

			String userInDBusername = userInDB.getUsername();
			String userInDBpassword = userInDB.getPassword();
			
			if (username.equals(userInDBusername)&& (password.equals(userInDBpassword)))  {
				
				System.out.println("Logged In");
				System.out.println("----------------------------------------");
			}
			else
			{
				userInDB = null;
			}
		}
		return userInDB;
		}

	
	public static void loginToTCatalog(String user, String password){

				try {
					//Valido datos en mi Login
					 userLogged =(Login.logValidation(user, password));
					 
					
				} catch(InputMismatchException ex){
					System.out.println(ex.getMessage());
				}
			
}
}
