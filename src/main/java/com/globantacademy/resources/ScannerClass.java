package com.globantacademy.resources;

import java.util.Scanner;

import com.globantacademy.controller.Guest;
import com.globantacademy.controller.NoAdmin;
import com.globantacademy.controller.User;
import com.globantacademy.controller.UserType;
import com.globantacademy.model.DataBase;
import com.globantacademy.view.Login;

public class ScannerClass {
	
	
	private static Scanner scan = new Scanner (System.in);
	
	
	public static Scanner getScan() {
		return scan;
	}

	public static void setScan(Scanner scan) {
		ScannerClass.scan = scan;
	}

	public static int readInt(){
		return scan.nextInt();
	}
	
	public static String readString(){
		return scan.next();
	}
	
	public static String readNextLine(){
		return scan.nextLine();
	}
	
	public static void hasNext(){
		while(scan.hasNext()) {
		
		}
		
	}
	public static void close(){
		scan.close();
	}

}
