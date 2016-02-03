package com.globantacademy.view;
import java.security.InvalidParameterException;

import com.globantacademy.controller.User;
import com.globantacademy.model.DataBase;
import com.globantacademy.model.UserNotFoundException;


public class Login {
	
	

	public static boolean logValidation(String username, String password) throws InvalidParameterException, UserNotFoundException{
		
		
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
		/*
		 * catch(UserNotFoundException ex){
		
			System.out.println(ex.getMessage());
		}
		catch(InvalidParameterException ex){
			System.out.println(ex.getMessage());
		}
		throw new InvalidParameterException("Your credentials dont match");
		throw new UserNotFoundException("User doest not exist in our DB");
		 */
}
