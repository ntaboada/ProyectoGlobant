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
	public static Set<Comic> comics = new HashSet<Comic> ();
	public static Set<Loan> loans = new TreeSet <Loan>();
	public static Set<String> genres = new TreeSet<String> ();
	
	
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


public static String lookForGenre(String lookedGenre){
	
	String genreFound = null;
	Iterator<String> iterator = genres.iterator();
	
	while (iterator.hasNext()) {
		
		String genre =  iterator.next();
		
		if (genre.equals(lookedGenre)){
			genreFound = genre;
		}
		
	}
	return genreFound;
	
}

public static boolean addGenre(String genre){
	
	if(DataBase.lookForGenre(genre)==null)
	{	
		genres.add(genre);
		return true;
	}
	else
	{
		return false;
	}
}

public static void addComic(Comic comic) {
	
	if(lookForComic(comic.getTitle())==null)	
	{
		comics.add(comic);
	}
	else
	{
		comics.stream().filter(c-> c.getTitle().equals(comic.getTitle())).forEach(c->c.increaseCopies());
		
	}
}

public static Comic lookForComic(String lookedComic){
	
	Comic comicFound = null;
	Iterator<Comic> iterator = comics.iterator();
	
	while (iterator.hasNext()) {
		
		Comic comic=  iterator.next();
		
		if (comic.getTitle().equals(lookedComic)){
			comicFound = comic;
		}
		
	}
	
	return comicFound;
	
}


public static ArrayList<Comic> listComicCatalog(){
	ArrayList<Comic> comicArrList = new ArrayList<Comic>(DataBase.comics);
	int i=0;
	
	for (Comic comic : comics) {
		System.out.println(i++ +"-" + comic );
	}
	
	return comicArrList;
}

public static ArrayList<User>  listUserCatalog(){
	ArrayList<User> usersArrList = new ArrayList<User>(DataBase.users);
	int i=0;
	
	for (User user : users) {
		System.out.println(i++ +"" + user );
	}
	
	
	return usersArrList;
}

public static ArrayList<String> listComicGenres(){
	
	int i=0;
	ArrayList<String> genresArrList = new ArrayList<String>(DataBase.genres);
	
	for (String genre : genres) {
		System.out.println(i++ +"- "+ genre);
	}
	
	return genresArrList;
	
}
	
	

}
