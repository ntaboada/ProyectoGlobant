package com.globantacademy.controller;

import java.util.ArrayList;
import com.globantacademy.resources.InvalidInputException;

public abstract class UserType {

	
	protected String[] arrOptions;
	protected ArrayList<Loan> comicLoans = new ArrayList<Loan> ();
	
	public ArrayList<Loan> getComicLoans() {
		return comicLoans;
	}
	public void setComicLoans(ArrayList<Loan> comicLoans) {
		this.comicLoans = comicLoans;
	}
	public void setArrOptions(String[] arrOptions) {
		this.arrOptions = arrOptions;
	}
	
	public boolean loanAccepted (Loan loan){
		
		if(this.lookForLoan(loan.getID())== null)
		{ 	comicLoans.add(loan);
			return true;
		}
	
	return false;
	}
	
	public Loan lookForLoan(int ID){
		Loan loanFound = null;
		ArrayList<Loan> arrLoanList = new ArrayList<Loan>(comicLoans);
		
		for (Loan loan : arrLoanList) {
			if(loan.getID()==ID){
				loanFound=loan;
			}
		}
		
		return loanFound;
	}
	
	public abstract UserType changeUserType();
	public abstract String[] getArrOptions();
	public abstract void  userOption(int userOption) throws InvalidInputException;
	
	
}
