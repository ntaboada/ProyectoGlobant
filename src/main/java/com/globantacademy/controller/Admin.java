package com.globantacademy.controller;

import java.util.Arrays;

public class Admin extends User{

	private String[] arrOptionsAdmin = {"1) Listar Usuarios", "2) Agregar Usuarios", "3) Eliminar Usuarios", "4) Modificar Usuario", "5) Agregar Comic", "6) Eliminar Comic", "7) Modificar Comic", "8) Agregar Genero","9) Eliminar Genero", "10) Aceptar Prestamos", "11) Rechazar Prestamos", "12) Exit"}; 
	
	
	
	public Admin(){
		arrOptions = Arrays.copyOfRange(arrOptionsAdmin, 0, arrOptionsAdmin.length);
	}
	
	
	public void showMenuOptions(){
		super.showMenuOptions();
	}


	@Override
	public void userOption(int option) {
		
	}
	

	
}
