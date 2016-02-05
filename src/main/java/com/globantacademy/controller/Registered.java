package com.globantacademy.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class Registered extends UserType{
	
	private String[] arrOptionsRegistered  = {"1) Visualize Comic Catalog", "2) Make a loan", "3) Finish a Loan", "4) Exit"};
	private ArrayList<Loan> comicLoans = new ArrayList<Loan> ();
	

	
	
	public Registered(){
		arrOptions =  Arrays.copyOfRange(arrOptionsRegistered, 0, arrOptionsRegistered.length);
	}
	
	
	
	
	public ArrayList<Loan> getComicLoans() {
		return comicLoans;
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
		switch (userOption) {
		
		case 1:
			break;
		case 2:
			return;
		case 3:
			return;
		default:
			break;
	}
		
	}

	public UserType changeUserType() {
		return new Guest();
	}

	
	
	
}
