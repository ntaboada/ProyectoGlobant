package com.globant.training.glb_training.model;

import java.util.ArrayList;
import java.util.TreeSet;

import com.globant.training.glb_training.controller.Comic;
import com.globant.training.glb_training.controller.Loan;
import com.globant.training.glb_training.controller.User;

public class Catalog {
	private static TreeSet<Comic> comics = new TreeSet<Comic>();
	private static TreeSet<Loan> loans = new TreeSet<Loan>();
	private static TreeSet<User> users = new TreeSet<User>();
	private static TreeSet<String> genres = new TreeSet<String>();

	public static TreeSet<Comic> getComics() {
		return comics;
	}

	public static TreeSet<Loan> getLoans() {
		return loans;
	}

	public static TreeSet<User> getUsers() {
		return users;
	}

	public static TreeSet<String> getGenres() {
		return genres;
	}

	public static void addComic(Comic comic) {
		if(comic!=null && !comics.add(comic))	comics.stream().filter(s-> s.equals(comic)).forEach(s->s.increaseCopies());
		
	}

	public static boolean addLoan(Loan loan) {
		if(loan != null && !loan.getComic().decreaseCopies()) return false;
		loan.setStatus("Accepted");
		return true;
	}
	public static boolean askLoan(Loan loan){
		if(loan !=null)	return loans.add(loan);
		return false;
	}
	public static void addUser(User user) {
		if(user !=null)users.add(user);
	}

	public static void addGenre(String genre) {
		if(genre !=null)genres.add(genre);
	}

	public static boolean removeComic(Comic comic) {
		if(comic == null)return false;
		if(loans.stream().filter(s->s.getComic().equals(comic)).count() >0)return false;
		return comics.remove(comic);
	}

	public static boolean removeUser(User user) {
		if(user == null)return false;
		ArrayList<Loan> list = new ArrayList<Loan>();
		loans.stream().filter(s->s.getUser().equals(user)).forEach(s->list.add(s));
		list.stream().forEach(s->Catalog.removeLoan(s));
		return users.remove(user);
	}
	public static boolean removeLoan(Loan loan){
		if(loan == null)return false;
		if(loan.getStatus().equals("Accepted"))loan.getComic().increaseCopies();
		return loans.remove(loan);
	}
	public static boolean removeGenre(String genre){
		if(genre == null)return false;
		if(comics.stream().filter(s->s.getGenre().equals(genre)).count()>0)return false;
		return genres.remove(genre);
	}
	public static void editGenre(String originalGenre, String genre){
		if(originalGenre ==null || genre == null || originalGenre =="" || genre =="")return;
		comics.stream().filter(s->s.getGenre().equals(originalGenre)).forEach(s->s.setGenre(genre));
		genres.stream().filter(s->s.equals(originalGenre)).forEach(s->s=genre);
	}

	public static void editComic(Comic originalComic, String name, int volume) {
		if(originalComic ==null || name == null || name == "") return;
		Comic comic = new Comic(name, originalComic.getGenre(),volume,originalComic.getCopies());
		loans.stream().filter(s->s.getComic().equals(originalComic)).forEach(s->s.setComic(comic));
		comics.stream().filter(s->s.equals(originalComic)).forEach(s->{s.setName(name);s.setVolume(volume);});
		
	}
}
