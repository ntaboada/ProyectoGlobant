package com.globantacademy.controller;

import java.util.ArrayList;
import java.util.Arrays;

import com.globantacademy.model.DataBase;
import com.globantacademy.resources.InvalidInputException;
import com.globantacademy.resources.ScannerClass;
import com.globantacademy.view.App;


public class Admin extends User{

	private String[] arrOptionsAdmin = {"1) List Users", "2) Add User", "3) Delete User", "4) Modify User", "5) List Comics", "6) Add Comic", "7) Delete Comic", "8) List Genres", "9) Add Genre","10) Delete Genre","11) List Loans", "12) Accept Loans", "13) Reject Loans", "14) Log Out"}; 
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
	
	try{	
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
			this.removeComic();
			break;
		case 8:
			this.listGenres();
			break;
		case 9:
			this.addGenre();
			break;
		case 10:
			this.removeGenre();
			break;
		case 11:
			this.listLoans();
			break;
		case 12:
			this.acceptLoanRequests();
			break;
		case 13: 
			this.rejectLoan();
			break;
		case 14:
			return;
		default:
			break;

		}
	
		if(userOption>=1 && userOption<=13)
		{
			App.interactingWithUser(Admin.getInstance(), true);
		}
		
		else
		{
			throw new InvalidInputException();
		}
	}
	
	catch(InvalidInputException ex){
		System.out.println(ex.getMessage());
		System.out.println("");
		App.interactingWithUser(Admin.getInstance(), true);
	}	
	
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
		System.out.println(newUser);
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
				
		if(!DataBase.users.isEmpty())
		{
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
		else{
			System.out.println("No users in the catalog. Try next time");
		}
		

	
	}

	public void modifyUser(){
		
		this.listUserCatalog();
		ArrayList<User> users = new ArrayList<User>(DataBase.users);
	
		
		System.out.println("");
		System.out.println("Select the user you want to modify: ");
		int userOption = ScannerClass.readInt();
		String user= users.get(userOption).getUsername();

		System.out.println("Enter new password for the user '"+ user + "'");
		String newPassword = ScannerClass.readString();

		
		if(DataBase.modifyUser(user,newPassword)){
			System.out.println("User modified correctly");
		}
		else{
			System.out.println("That's not a valid option. Try again");
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
	
	public void removeGenre() {
		
		if(DataBase.genres.size()!=0){
			System.out.println("Select the genre you want to delete");
			ArrayList<String> genres = DataBase.listComicGenres();
			System.out.println("");
			
			if(DataBase.removeGenre(genres.get(ScannerClass.readInt())))
			{
				System.out.println("Genre deleted successfully");
			}
			else
			{
				System.out.println("Genre couldn't be deleted. Try next time");
			}
		}
	
		System.out.println("No genres availables yet. Try next time");
	}
	
	
	public void listGenres(){

		if(DataBase.genres.size()!=0){
			System.out.println("Genres List: ");
			System.out.println("");		
			DataBase.listComicGenres();
		}
		
		System.out.println("No genres availables yet. Try next time");
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
	
	public void removeComic() {
		System.out.println("Select the comic you want to delete (All copies are going to be delete)");
		System.out.println("");
		ArrayList<Comic> comics = DataBase.listComicCatalog();
		System.out.println("");
		System.out.println("Your option:");
		if(DataBase.removeComic(comics.get(ScannerClass.readInt()))){
			System.out.println("Comic deleted succesfully");
		}
		else
		{
			System.out.println("Comic coulnd't be deleted. Try next time");
		}
	}
	
	
	public void listComics(){
		
		if(!DataBase.comics.isEmpty())
		{	System.out.println("Comic List: ");
			System.out.println("");
			DataBase.listComicCatalog();
		}
		else
		{
			System.out.println("No comics availables in the catalog");
		}
	}


	public void acceptLoanRequests() {
		
		//Llamo al metodo para obtener los prestamos pendientes de aprobacion
		ArrayList<Loan> loans = DataBase.listLoansApprobalPending();
		int i = 0;
		
		if (loans.size() == 0) {
			System.out.println("There are not loans with 'Pending Approval' status");
		}
		else{
			System.out.println("Select the loan you want to accept (Pending Approbal Loans)");
			System.out.println("");
			
			for (Loan loan : loans) {
				
				System.out.println(i + "- " +loan);
				i++;
			}
			
			System.out.println("");
			System.out.println("Your option:");
			int loanOption = ScannerClass.readInt();
			
			Loan loanSelected = loans.get(loanOption);
			//Llamo a los metodos para cambiar el estado del Loan a aceptado y los metodos correspondientes encargados de agregar el loan aceptado a la lista de Loans del Usuario
			if ((DataBase.addLoan(loans.get(loanOption)) && (loans.get(loanOption).getUser().assignAcceptedLoans(loanSelected)))) {
				System.out.println("Loan accepted succesfully");
			}
			else
			{	
				System.out.println("Sorry, we couldn't accept the loan. Try next time");
			}
			
		
		}
	
		
	}
	
	public void rejectLoan() {
		
		ArrayList<Loan> loans = DataBase.listLoansApprobalPending();
		int i = 0;
		
		if (loans.size() == 0) {
			System.out.println("There are not loans with 'Pending Approval' status");
		}
		else{
			
			System.out.println("Select the loan you want to accept (Pending Approbal Loans)");
			System.out.println("");
			
			for (Loan loan : loans) {
				
				System.out.println(i + "- " +loan);
				i++;
			}
			
			System.out.println("");
			System.out.println("Your option:");
			DataBase.removeLoan(loans.get(ScannerClass.readInt()));
			System.out.println("Loan rejected succesfully");
		}
	
	}
	public void listLoans(){
		
		if(DataBase.loans.size()!=0)
		{ 
			System.out.println("Loans List: ");
			System.out.println("");
			DataBase.listLoansCatalog();
		}
		else{
			System.out.println("No loans made yet");
		}
	}

	@Override
	public boolean assignAcceptedLoans(Loan loan) {
		return false;
		
	}

}
