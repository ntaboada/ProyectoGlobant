package com.globantacademy.view;

import java.util.Scanner;

import com.globantacademy.controller.Admin;
import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.controller.UserType;
import com.globantacademy.model.DataBase;

public class App {

	public static void interactingWithUser(User user) {
		
		boolean showMenu = true;

		do {
			
				user.showMenuOptions();
				user.userSelectOption(user);
		}
		
		while (showMenu);
	}

	public static void main(String[] args) {
		System.out.println("¡Welcome to the Comic loan catalog!");
		
		UserType guest = new Guest();
		User guestUser = new NoAdmin(guest);
		
		interactingWithUser(guestUser);
		

}
}