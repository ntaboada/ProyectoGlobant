package com.globantacademy.view;

import java.util.Scanner;

import com.globantacademy.controller.InvalidInputException;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.model.DataBase;

public class App {

	public static void main(String[] args) {

		User oneUser = new User("nicolas", "abc");
		User secondUser = new User("tato", "bbb");

		DataBase.addUser(oneUser);
		DataBase.addUser(secondUser);

		System.out.println("¡Welcome to the Comic loan catalog!");

		int userOption;
		boolean showMenu = true;
		Scanner scan = new Scanner(System.in);

		
		
		do{
			try {

				NoAdmin guestUser = new NoAdmin();
				guestUser.menuOptions();

				if (scan.hasNextInt()) {
					userOption = scan.nextInt();
					guestUser.userOption(userOption);

				} else {
					throw new InvalidInputException("'"+ scan.next()+ "'" +" is not a valid Input. Try again");
				}
			} catch (InvalidInputException ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		while (showMenu);
		
		scan.close();

	}

}
