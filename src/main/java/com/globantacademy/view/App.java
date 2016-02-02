package com.globantacademy.view;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
       
    	int userOption;
		boolean showMenu = true;
		Scanner scan = new Scanner(System.in);
		
		while (showMenu) {
			
			
			System.out.println("¡¡¡Welcome to the Comic loan catalog!!!");
			System.out.println("Press '1' to show the Menu Options");
			
			userOption = scan.nextInt();
			
			switch (userOption) {
			case 1:
				MenuOptions.showMenuOptions();
				break;
			case 2:
				System.out.println("Visualizing Comic Catalog");
				break;
			case 3:
				System.out.println("Exit");
				showMenu=false;
				break;
			default:
				showMenu=false;
				break;
			}
		
		
			
		}
			scan.close();
    	
    	
    	
       
    }
}
