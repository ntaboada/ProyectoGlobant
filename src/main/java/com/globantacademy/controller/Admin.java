package com.globantacademy.controller;

import java.util.ArrayList;
import java.util.Arrays;


import com.globantacademy.model.DataBase;
import com.globantacademy.resources.ScannerClass;
import com.globantacademy.view.App;


public class Admin extends User{

	private String[] arrOptionsAdmin = {"1) List Users", "2) Add User", "3) Delete User", "4) Modify User", "5) List Comics", "6) Add Comic", "7) Delete Comic", "8) Modify Comic", "9) Add Genre","10) Delete Genre","11) List Genre", "12) Accept Loans", "13) Reject Loans", "14) Exit"}; 
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
			this.listUserCatalog();
			break;
		case 2:
			this.addNewUser();
			break;
		case 3:
			this.deleteUser();
			break;
		case 4:
			this.modifyUser();
			break;
		case 5:
			this.listComics();
			break;
		case 6:
			this.addComic();
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			this.addGenre();
			break;
		case 10:
			break;
		case 11:
			this.listGenres();
			break;
		default:
			break;

		}
	
		if(userOption>=1 && userOption<=11)
		App.interactingWithUser(Admin.getInstance(), true);
	}
	

	@Override
	public void changeUserType() {

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
			System.out.println("User already exists in the Catalog. Try Again");
		}
	}

	public void deleteUser(){
		ArrayList<User> usersArrList = DataBase.listUserCatalog();
		System.out.println("");
		
		System.out.println("Select the user you want to delete: ");
		int user = ScannerClass.readInt();
		if(DataBase.deleteUser(usersArrList.get(user).getUsername())){
			System.out.println("User deleted correctly");
		}
		else{
			System.out.println("User " +"'"+ user + "'" + " doesn't exist");
		}
	
	}

	public void modifyUser(){
		
		this.listUserCatalog();
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
	public void listUserCatalog(){
		//¿Como imprimo un acumulador?
		System.out.println("Users List:");
		System.out.println("");
		DataBase.listUserCatalog();
	}

	
	
	public void addGenre() {
		
		System.out.println("Add a new genre type: ");
		if(DataBase.addGenre(ScannerClass.readString()))
		{
			System.out.println("Genre added correctly");
		}
		else
		{
			System.out.println("Genre already exists in Catalog. Try Again");
		}
	
	}
	
	public void listGenres(){

		
		System.out.println("Genres List: ");
		System.out.println("");
		
		DataBase.listComicGenres();
	}
	
	public boolean noGenreAvailable(){

		if(DataBase.genres.size()==0){
			return true;
		}
		return false;
	}
	
	public void addComic(){
			
		if(noGenreAvailable()){
			System.out.println("No genres Availables. Add genres before you can add a comic");
		}
		else{
			System.out.println("Select a Genre for your comic: ");
			ArrayList<String> genresArrList = DataBase.listComicGenres();
			System.out.println("");
			int genero = ScannerClass.readInt();
			System.out.println("Enter comic title: ");
			String comicTitle = ScannerClass.readString();
			
			Comic comic = new Comic(comicTitle, genresArrList.get(genero));
			DataBase.addComic(comic);
			System.out.println("Comic added! ");	
		}
		
	}

	public void listComics(){
		System.out.println("Comic List: ");
		System.out.println("");
		DataBase.listComicCatalog();
	
	}
}
