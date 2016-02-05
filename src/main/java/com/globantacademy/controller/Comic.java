package com.globantacademy.controller;

public class Comic {
	
	private String title;
	private String description;
	private Genre genre;
	private int copies;
	
	
	public Comic(String name, String description, Genre genre) {
		this.title = name;
		this.genre = genre;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
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
	
}
