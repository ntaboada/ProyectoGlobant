package com.globantacademy.view;

import com.globantacademy.controller.Admin;
import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.model.DataBase;
import com.globantacademy.resources.ScannerClass;

public class App {

	//Metodo que muestra las opciones respectivas a cada tipo de usuario y lee la entrada elegida por el mismo
	public static void interactingWithUser(User user, boolean showMenu) {
		
		boolean showMenuOptions = showMenu;

		do {
				user.showMenuOptions();
				showMenuOptions=user.userSelectOption(user, showMenu);
		}
		
		while (showMenuOptions);
	}

	public static void main(String[] args) {
		System.out.println("¡Welcome to the Comic loan catalog!");
		
		User myUser = new NoAdmin( new Guest());
		//Agrego a la BD al Admin (usuario que esta por default)
		DataBase.addUser(Admin.getInstance());
		
		interactingWithUser(myUser, true);
		
		if (Login.userLogged!=null){
				
			System.out.println("Welcome Sr: " + Login.userLogged.getUsername());
			System.out.println("");
				
				if(Login.userLogged.adminPriviliges())
				{
					interactingWithUser(Admin.getInstance(), true);
				}
				else
				{
					myUser.changeUserType();
					interactingWithUser(myUser, true);
				}
		
		    Login.userLogged=null;
		}		
		
		System.out.println("");
		System.out.println("You are in the Guest view. Want to continue?");
		System.out.println("Press 'y' if Yes. Enter another key to exit.");
		String option = ScannerClass.readString();
		
		if (option.equals("y"))
			{
			String[]arr = {};
			App.main(arr);
			}
	
		
		System.out.println("¡Bye, Bye! --- See you next time");

	}
}