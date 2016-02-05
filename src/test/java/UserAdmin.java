package com.globant.training.glb_training.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.globant.training.glb_training.model.Catalog;
import com.globant.training.glb_training.view.Reader;
import com.globant.training.glb_training.view.Writer;

public class UserAdmin extends User {
	final private static String user = "Sheldon";
	final private static String pass = "Bazinga";
	final private String[] operaciones = {"( 0 ) Ver Listado de Usuarios.",
										"( 1 ) Agregar Usuario.",
										"( 2 ) Modificar Usuario.",
										"( 3 ) Borrar Usuario.",
										"( 4 ) Ver Listado de Comics.",
										"( 5 ) Agregar Comic.",
										"( 6 ) Modificar Comic.",
										"( 7 ) Borrar Comic.",
										"( 8 ) Ver Listado de Préstamos.",
										"( 9 ) Aceptar Préstamo.",
										"( 10 ) Rechazar Préstamo.",
										"( 11 ) Ver Listado de Géneros.",
										"( 12 ) Agregar Género.",
										"( 13 ) Modificar Género.",
										"( 14 ) Borrar Género.",
										"( 15 ) Log Out.",
										"( 16 ) Salir."};
	
	final private Action[] methods = new Action[]{
			new Action(){public Person method(){ return listOfUsers();}},//0 
			new Action(){public Person method(){ return addUser();}},//1 
			new Action(){public Person method(){ return editUser();}},//2 
			new Action(){public Person method(){ return removeUser();}},//3 
			new Action(){public Person method(){ return listOfComics();}},//4 
			new Action(){public Person method(){ return addComic();}},//5 
			new Action(){public Person method(){ return editComic();}},//6
			new Action(){public Person method(){ return removeComic();}},//7
			new Action(){public Person method(){ return listOfLoans();}},//8 
			new Action(){public Person method(){ return acceptLoan();}},//9 
			new Action(){public Person method(){ return rejectLoan();}},//10 
			new Action(){public Person method(){ return listOfGenres();}},//11 
			new Action(){public Person method(){ return addGenre();}},//12 
			new Action(){public Person method(){ return editGenre();}},//13 
			new Action(){public Person method(){ return removeGenre();}},//14 
			new Action(){public Person method(){ return logOut();}},//15  
			new Action(){public Person method(){ return exit();}},//16 
	}; 

	public UserAdmin() {
		super("Sheldon", "Bazinga");
	}

	public String[] getOperaciones() {
		return operaciones;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	public Person method(int index) {
		return methods[index].method();
	}

	// 0
	public Person listOfUsers() {
		Writer.write("\n--Listado de Usuarios--\n");
		Catalog.getUsers().forEach(s -> Writer.write(s.toString()));
		return this;
	}

	// 1
	public Person addUser() {
		Writer.write("\n--Agregar Usuario--\n");
		Writer.write("\n--Ingrese Usuario y Contraseña del nuevo Usuario--\n");
		Catalog.addUser(new User(Reader.readString(), Reader.readString()));
		return this;
	}

	// 2
	public Person editUser() {
		Writer.write("\n--Modificar usuario--\n");
		Writer.write("\n--El usuario deberá reingresar todos sus préstamos--\n¿Continuar?(y/n)");
		switch (Reader.readString().toLowerCase()) {
		case "y":
			this.removeUser();
			this.addUser();
			break;
		case "n":
			break;
		default:
			return this.editUser();
		}
		return this;
	}

	// 3
	public Person removeUser() {
		Writer.write("\n--Borrar Usuario--\n");
		if (Catalog.getUsers().size() == 0) {
			Writer.write("No hay usuarios.\n");
			return this;
		}
		Writer.write("\n--Elija un usuario de la lista para borrar--\n");
		ArrayList<User> usuarios = new ArrayList<User>(Catalog.getUsers());
		for (int i = 0; i < usuarios.size(); i++)
			Writer.write(i + " " + usuarios.get(i).toString());
		if (Catalog.removeUser(usuarios.get(Reader.readInt()))) {
			Writer.write("\n--Usuario borrado--\n");
			return this;
		}
		Writer.write("\n--El Usuario no pudo ser borrado--\n");
		return this;
	}

	// 4
	/*
	 * public void listOfComics(){
	 * 
	 * }Ya está en person
	 */

	// 5
	public Person addComic() {
		Writer.write("\n--Agregar Comic--\n");
		Writer.write("\n--Elija un género--\n");
		ArrayList<String> generos = new ArrayList<String>(Catalog.getGenres());
		for (int i = 0; i < generos.size(); i++) {
			Writer.write(i + " " + generos.get(i));
		}
		int genero = Reader.readInt();
		generos.get(genero);
		Writer.write("\n--Ingrese Nombre(no se admiten espacios, usar '-') y Volumen--\n");
		Comic comic = new Comic(Reader.readString(), generos.get(genero), Reader.readInt());
		Catalog.addComic(comic);
		return this;
	}

	// 6
	public Person editComic() {
		Writer.write("\n--Modificar Comic--\n");
		ArrayList<Comic> comics = new ArrayList<Comic>(Catalog.getComics());
		Writer.write("\n--Elija el Comic que desea editar--\n");
		for (int i = 0; i < comics.size(); i++)
			Writer.write(i + " " + comics.get(i));
		Comic originalComic = comics.get(Reader.readInt());
		if (Catalog.getComics().contains(originalComic)) {
			Writer.write("\n--Ingrese nuevo Nombre (no se admiten espacios, usar '-') y Volumen--\n");
			Catalog.editComic(originalComic, Reader.readString(), Reader.readInt());
			Writer.write("\n--Edición Exitosa--\n");
			return this;
		}
		Writer.write("\n--Edición Fallida--\n");
		return this;
	}

	// 7
	public Person removeComic() {
		Writer.write("\n--Borrar Comic--\n");
		Writer.write("\n--Se borrarán todos los ejemplares del Comic--\n¿Continuar?(y/n)");
		switch (Reader.readString().toLowerCase()) {
		case "y":
			ArrayList<Comic> comics = new ArrayList<Comic>(Catalog.getComics());
			Writer.write("\n--Elija el Comic que desea borrar--\n");
			for (int i = 0; i < comics.size(); i++)
				Writer.write(i + " " + comics.get(i));
			if (Catalog.removeComic(comics.get(Reader.readInt()))) {
				Writer.write("\n--El comic se borró exitosamente--\n");
				return this;
			}
			Writer.write("\n--El comic no pudo ser borrado--\n");
			break;
		case "n":
			break;
		default:
			return this.removeComic();
		}
		return this;
	}

	// 8
	public Person listOfLoans() {
		Writer.write("\n--Listado de Préstamos--\n");
		Catalog.getLoans().stream().forEach(s -> Writer.write(s.toString()));
		return this;
	}

	// 9
	public Person acceptLoan() {
		Writer.write("\n--Aceptar Préstamo--\n");
		ArrayList<Loan> loans = new ArrayList<Loan>(Catalog.getLoans().stream()
				.filter(s -> s.getStatus().equals("Pending Approval")).collect(Collectors.toList()));
		if (loans.size() == 0) {
			Writer.write("\n--No hay préstamos pendientes de aprobación--\n");
			return this;
		}
		for (int i = 0; i < loans.size(); i++) {
			Writer.write(i + " " + loans.get(i));
		}
		if (Catalog.addLoan(loans.get(Reader.readInt()))) {
			Writer.write("\n--Préstamo aceptado--\n");
			return this;
		}
		Writer.write("\n--El préstamo no pudo aceptarse--\n");
		return this;
	}

	// 10
	public Person rejectLoan() {
		Writer.write("\n--Rechazar Préstamo--\n");
		ArrayList<Loan> loans = new ArrayList<Loan>(Catalog.getLoans().stream()
				.filter(s -> s.getStatus().equals("Pending Approval")).collect(Collectors.toList()));
		if (loans.size() == 0) {
			Writer.write("\n--No hay préstamos pendientes de aprobación--\n");
			return this;
		}
		for (int i = 0; i < loans.size(); i++) {
			Writer.write(i + " " + loans.get(i));
		}
		Catalog.removeLoan(loans.get(Reader.readInt()));
		return this;
	}

	// 11
	public Person listOfGenres() {
		Writer.write("\n--Listado de Géneros--\n");
		Catalog.getGenres().forEach(s -> Writer.write(s.toString()));
		return this;
	}

	// 12
	public Person addGenre() {
		Writer.write("\n--Agregar un Género--\n");
		Writer.write("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		Catalog.addGenre(Reader.readString());
		return this;
	}

	// 13
	public Person editGenre() {
		Writer.write("\n--Modificar un Género --\n");
		Writer.write("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		String originalGenre = Reader.readString();
		if (Catalog.getGenres().contains(originalGenre)) {
			Writer.write("\n--Ingrese el nuevo género (no se admiten espacios, usar '-')--\n");
			Catalog.editGenre(originalGenre, Reader.readString());
			Writer.write("\n--Edición Exitosa--\n");
			return this;
		}
		Writer.write("\n--Edición Fallida--\n");
		return this;
	}

	// 14
	public Person removeGenre() {
		Writer.write("\n--Borrar un Género--\n");
		Writer.write("\n--Ingrese un género (no se admiten espacios, usar '-')--\n");
		if (Catalog.removeGenre(Reader.readString())) {
			Writer.write("\n--Se borró el género de manera satisfactoria--\n");
			return this;
		}
		Writer.write("\n--No se pudo borrar el género--\n(No existe o hay comics ingresados con ese género)");
		return this;
	}
}
