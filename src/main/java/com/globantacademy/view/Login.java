package com.globantacademy.view;
import com.globantacademy.controller.User;
import com.globantacademy.model.DataBase;



public class Login {
	
	

	public static boolean logValidation(String username, String password) {
		
		
		boolean permissionAccepted = false;
		
		User userInDB = DataBase.lookForUser(username);
		
		if (userInDB == null){
			permissionAccepted = false;
		}
		else{
			String userInDBusername = userInDB.getUsername();
			String userInDBpassword = userInDB.getPassword();
			
			if (username.equals(userInDBusername)&& (password.equals(userInDBpassword)))  {
				System.out.println("You Access!");
				permissionAccepted =true;
			}
			else {
				permissionAccepted = false;
			}
			}
		return permissionAccepted;
		}

