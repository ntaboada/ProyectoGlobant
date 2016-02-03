package com.globantacademy.view;

import java.util.Scanner;

import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.controller.UserType;
import com.globantacademy.model.DataBase;

public class App {

	public static void welcome() {
		System.out.println("¡Welcome to the Comic loan catalog!");
		boolean showMenu = true;

		do {
				UserType guest = new Guest();
				User guestUser = new NoAdmin(guest);
				guestUser.showMenuOptions();
				guestUser.userSelectOption(guestUser);
		}
		
		while (showMenu);
	}

	public static void main(String[] args) {

		User oneUser = new User("nicolas", "abc");
		User secondUser = new User("tato", "bbb");

		DataBase.addUser(oneUser);
		DataBase.addUser(secondUser);

		welcome();
		

}
}