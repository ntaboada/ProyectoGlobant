package com.globantacademy.controller;

import java.util.ArrayList;

public class Registered extends UserType {
	
	
	private ArrayList <Loan> comicLoans = new ArrayList <Loan> ();

	public ArrayList<Loan> getComicLoans() {
		return comicLoans;
	}

	public void setComicLoans(ArrayList<Loan> comicLoans) {
		this.comicLoans = comicLoans;
	}
}
