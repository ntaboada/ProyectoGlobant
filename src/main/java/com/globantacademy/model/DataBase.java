package com.globantacademy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.globantacademy.controller.Comic;
import com.globantacademy.controller.Loan;
import com.globantacademy.controller.User;

public class DataBase {
	
	public static Set<User> users = new HashSet<User> ();
	public static ArrayList <Comic> comics = new ArrayList <Comic>();
	public static ArrayList <Loan> loans = new ArrayList <Loan>();
	
	
	
	public static void addUser(User user){
		users.add(user);
	}
	
	public static User lookForUser(String username){
		User userFound = null;
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			
			User user =  iterator.next();
			
			if (username.equals(user.getUsername())){
				userFound = user;
			}
			
		}
		return userFound;
	}
	
}
