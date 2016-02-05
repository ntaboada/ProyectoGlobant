package com.globantacademy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.globantacademy.controller.Comic;
import com.globantacademy.controller.Loan;
import com.globantacademy.controller.User;

public class DataBase {
	
	public static Set<User> users = new HashSet<User> ();
	public static TreeSet <Comic> comics = new TreeSet <Comic>();
	public static TreeSet <Loan> loans = new TreeSet <Loan>();
	public static TreeSet <Genre> genres = new TreeSet<Genre>;
	
	
public static boolean addUser(User user){
		
		if(DataBase.lookForUser(user.getUsername())==null)
		{	
			users.add(user);
			return true;
		}
		else
		{
			return false;
		}
		
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
	
public static boolean deleteUser(String user){
	
	
	if(DataBase.lookForUser(user)!=null)
	{	
		users.remove(DataBase.lookForUser(user));
		return true;
	}
	else
	{
		return false;
	}
}

public static boolean modifyUser(String oldUser, String newUser, String newPassword){
	
	if(DataBase.lookForUser(oldUser)!=null)
	{	
		DataBase.lookForUser(oldUser).setUsername(newUser);
		DataBase.lookForUser(oldUser).setPassword(newPassword);
		return true;
	}
	else
	{
		return false;
	}
	
}

public static void addComic(Comic comic) {
	if(comic!=null && !comics.add(comic))	comics.stream().filter(s-> s.equals(comic)).forEach(s->s.increaseCopies());
	
}
public static boolean removeComic(Comic comic) {
	if(comic == null)return false;
	if(loans.stream().filter(s->s.getComic().equals(comic)).count() >0)return false;
	return comics.remove(comic);
}

}
