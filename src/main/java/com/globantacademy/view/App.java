package com.globantacademy.view;




import com.globantacademy.controller.Admin;
import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.controller.UserType;
import com.globantacademy.model.DataBase;

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
		User reg = new NoAdmin("Nicolas", "Hola");
		
		
		DataBase.addUser(reg);
		DataBase.addUser(Admin.getInstance());
		
	
		interactingWithUser(myUser, true);
		
		if (Login.userLogged!=null){
				
			System.out.println("Welcome Sr: " + Login.userLogged.getPassword());
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

			
			
			
		}		
		System.out.println("¡Bye, Bye! --- See you next time");

}
}