package com.globantacademy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.globantacademy.controller.Comic;
import com.globantacademy.controller.Loan;
import com.globantacademy.controller.User;

public class DataBase {
	
	public static Set<User> users = new HashSet<User> ();
	public static ArrayList <Comic> comics = new ArrayList <Comic>();
	public static ArrayList <Loan> loans = new ArrayList <Loan>();
	
	
	
	public static void addUser(User user){
		users.add(user);
	}
	
	public static User lookForUser(){
		
		Iterator<User> iterator = users.iterator();
		
		while (iterator.hasNext()) {
			
			User user = (User) iterator.next();
			
		}
		
		
		/*
		 * Set<Foo> set = new HashSet<Foo>();
    set.add(new Foo("Hello"));

    for (Iterator<Foo> it = set.iterator(); it.hasNext(); ) {
        Foo f = it.next();
        if (f.equals(new Foo("Hello")))
            System.out.println("foo found");
    }
		 */
	}
	
}
