package com.globantacademy.controller;

import java.util.concurrent.atomic.AtomicInteger;


public class Loan {
	
	private static final AtomicInteger count= new AtomicInteger(0); 
	private int ID;
	private Comic comic;
	private User user = new NoAdmin(new Registered());
	private String status;
	
	
	public Loan(Comic comic, User user) {
		this.comic = comic;
		this.user = user;
		status = "Pending Approval";
		ID = count.incrementAndGet();
	}
	


	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public Comic getComic() {
		return comic;
	}
	public void setComic(Comic comic) {
		this.comic = comic;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return comic.toString() + user.toString() +"Status:" + "'" + status + "'";
	}
	
	
}
