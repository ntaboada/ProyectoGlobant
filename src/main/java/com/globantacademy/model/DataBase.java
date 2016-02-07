package com.globantacademy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.globantacademy.controller.Comic;
import com.globantacademy.controller.Loan;
import com.globantacademy.controller.User;

public class DataBase {
	
	public static Set<User> users = new HashSet<User> ();
	public static Set<Comic> comics = new HashSet<Comic> ();
	public static Set<Loan> loans = new HashSet <Loan>();
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
		ArrayList<Loan> list = new ArrayList<Loan>();
		loans.stream().filter(s->s.getUser().equals(user)).forEach(s->list.add(s));
		list.stream().forEach(s->removeLoan(s));
		users.remove(DataBase.lookForUser(user));
		return true;
	}
	else
	{
		return false;
	}
}

public static boolean modifyUser(String user, String newPassword){

	
	if(DataBase.lookForUser(user)!=null)
	{	
		DataBase.lookForUser(user).setUsername(newPassword);
		
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
	
	return false;
	
}

public static boolean removeGenre(String genre){
	
	if(comics.stream().filter(s->s.getGenre().equals(genre)).count()>0)
		{
		return false;
		}
	return genres.remove(genre);
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

public static boolean removeComic(Comic comic) {
	if(loans.stream().filter(s->s.getComic().equals(comic)).count() >0)
	{
		return false;
	}
	return comics.remove(comic);
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


public static Loan lookForLoan(int id){
	Loan loanFound = null;
	ArrayList<Loan> arrLoanList = new ArrayList<Loan>(loans);
	
	for (Loan loan : arrLoanList) {
		if(loan.getID()==id){
			loanFound=loan;
		}
	}
	
	return loanFound;
	
}
public static boolean newRequestLoan(Loan loan){
	
	if(lookForLoan(loan.getID())== null)
		{ 	loans.add(loan);
			return true;
		}
	
	return false;
}
public static boolean addLoan(Loan loan) {
	if(loan != null && loan.getComic().decreaseCopies()) { 
	  loan.setStatus("Accepted");
	  return true;
	}
	
	return false;
}

public static boolean removeLoan(Loan loan){
	if(loan == null)
	{
		return false;
	}
	if(loan.getStatus().equals("Accepted"))
	{
		loan.getComic().increaseCopies();
	}
	return loans.remove(loan);
}


public static ArrayList<Comic> listAvailableComics()
{	//Solo muestro los comics disponibles (con posibilidad de solicitar su prestamo)
	
	ArrayList<Comic> comicArrList = new ArrayList<Comic>(comics.stream().filter(s -> s.getCopies()!=0).collect(Collectors.toList()));	
	return comicArrList;
}
public static ArrayList<Comic> listComicCatalog(){
	ArrayList<Comic> comicArrList = new ArrayList<Comic>(DataBase.comics);
	int i=0;
	
	for (Comic comic : comics) {
		
		System.out.println(i++ +"-" + comic.toStringWithCopies() );
	}
	
	return comicArrList;
}

public static ArrayList<User>  listUserCatalog(){
	ArrayList<User> usersArrList = new ArrayList<User>(DataBase.users);
	int i=0;
	
	for (User user : users) {
		System.out.println(i++ +"- " + user );
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

public static ArrayList<Loan> listLoansCatalog(){
	
	
	int i=0;
	ArrayList<Loan> loansArrList = new ArrayList<Loan>(DataBase.loans);
	
	for (Loan loan : loans) {
		System.out.println(i++ +"- "+ loan);
	}
	
	return loansArrList;
}

public static ArrayList<Loan> listLoansApprobalPending(){
	ArrayList<Loan> loansList = new ArrayList<Loan>(loans.stream()
			.filter(s -> s.getStatus().equals("Pending Approval")).collect(Collectors.toList()));	
	
	return loansList;
	
}

}
