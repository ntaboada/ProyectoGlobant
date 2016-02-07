package com.globantacademy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import com.globantacademy.model.DataBase;
import com.globantacademy.resources.InvalidInputException;
import com.globantacademy.resources.ScannerClass;
import com.globantacademy.view.App;
import com.globantacademy.view.Login;

public class Registered extends UserType{
	
	private String[] arrOptionsRegistered  = {"1) Visualize Comic Catalog", "2) Visualize your Loans", "3) Make a loan", "4) Finish a Loan", "5) Log Out"};

	public Registered(){
		arrOptions =  Arrays.copyOfRange(arrOptionsRegistered, 0, arrOptionsRegistered.length);
	}
	
	
	
	public String[] getArrOptionsRegistered() {
		return arrOptionsRegistered;
	}

	public void setArrOptionsRegistered(String[] arrOptionsRegistered) {
		this.arrOptionsRegistered = arrOptionsRegistered;
	}


	@Override
	public String[] getArrOptions() {
		return arrOptionsRegistered;
	}


	@Override
	public void userOption(int userOption) {
		try{
		switch (userOption) {
		
		case 1:
			System.out.println("Comic catalog");
			System.out.println("");
			DataBase.listComicCatalog();
			System.out.println("");
			break;
		case 2:
			this.visualizeUserLoans();
			System.out.println("");
			break;
		case 3:
			this.addLoan();
			System.out.println("");
			break;
		case 4:
			this.removeLoan();
			break;
		case 5:
			return;
		default:
			break;
		
	}
	
		if(userOption>=1 && userOption<=4){
			App.interactingWithUser(Login.userLogged, true);
		}
		else{
			throw new InvalidInputException();
		}
	}
	catch(InvalidInputException ex){
		System.out.println(ex.getMessage());
		System.out.println("");
		App.interactingWithUser(Login.userLogged, true);
	}	
	
	}

	public UserType changeUserType() {
		return new Guest();
	}
	
	public void visualizeUserLoans(){
		
		if(comicLoans.size()!=0){
			System.out.println("Your Loans: ");
			System.out.println("");
			for (Loan comic : comicLoans) {
				System.out.println(comic);
			}
		}
		else{
			System.out.println("You don't have any Loan available");
		}
		
		
	}
	
	public void addLoan() {
		ArrayList<Comic> arrListComics = DataBase.listAvailableComics();
		int i=0;
		
		if(arrListComics.isEmpty()){
			System.out.println("No comics availables yet. Try next time");
		}
		else{
			System.out.println("");
			System.out.println("Select from the comic list the one you want to request");
			
			for (Comic comic : arrListComics) {
					System.out.println(i++ +"-" + comic );
			}

			
			System.out.println("Your option:");
			Comic comic = arrListComics.get(ScannerClass.readInt());
			Loan loan = new Loan(comic, Login.userLogged);
			
			if (DataBase.newRequestLoan(loan)) {
				System.out.println("Loan request was successfully created");
			}
			else{
				System.out.println("The loan request coulndn' t be created");	
			}
			
		}
		
	}
	
	public void removeLoan() {
		int i=0;
		
		if(comicLoans.isEmpty()){
			System.out.println("You dont't have any loan. Try next time");
			System.out.println("");
		}
		else{
			System.out.println("Select a loan from the list");
			System.out.println("");
			ArrayList<Loan> userLoans = new ArrayList<Loan> (comicLoans);
			
			for (Loan comicLoan : userLoans) {
				System.out.println(i + "- " + comicLoan);
			}
			
			System.out.println("Selection your option: ");
			System.out.println("");
			int userLoanRemoveOption = ScannerClass.readInt();
			DataBase.removeLoan(userLoans.get(userLoanRemoveOption));
			userLoans.remove(userLoans.get(userLoanRemoveOption));
		}
	
	
	}
}
