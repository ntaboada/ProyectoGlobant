package com.globantacademy.view;




import com.globantacademy.controller.Admin;
import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.controller.UserType;
import com.globantacademy.model.DataBase;
import com.globantacademy.resources.ScannerClass;

public class App {

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
		
		UserType guest = new Guest();
		User myUser = new NoAdmin(guest);
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
		
		System.out.println("You are in the Guest view. Want to continue?");
		System.out.println("Press '1' if Yes. Press another value to exit");
		
		if (ScannerClass.readInt()==1)
		{
			String[]arr = {};
			App.main(arr);
		}
		
		System.out.println("¡Bye, Bye! --- See you next time");

	}
}