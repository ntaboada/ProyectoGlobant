package com.globantacademy.controller;



public class Comic implements Comparable<Comic> {
	
	private String title;
	private String genre;
	private int copies;
	
	
	public Comic(String title, String genre) {
		this.title = title;
		this.genre = genre;
		this.copies = 1;
	}
	
	
	
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void increaseCopies() {
		this.copies++;
	}

	
	public boolean decreaseCopies() {
		if (copies >= 1) {
			this.copies--;
			return true;
		}
		return false;
	}

	public String toString(){
		return " Title:" + "'" + title + "'" + " Genre:"+ "'" + genre + "'" + "" + " Copies:" + "'" + copies + "'";
	}

	@Override
	public int compareTo(Comic o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	



}
