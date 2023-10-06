package ObjetoPpal;

import java.util.Random;

public class ClaseObjectUsuario {
	//Atributos
	String nombre;
	String pet;
	String seguro;
	boolean vacunas;
	boolean castrado;
	
	public ClaseObjectUsuario(String nombre, String pet, String seguro, boolean vacunas, boolean castrado) {
		super();
		this.nombre = nombre;
		this.pet = pet;
		this.seguro = seguro;
		this.vacunas = vacunas;
		this.castrado = castrado;
	}
	
	public ClaseObjectUsuario() {
		super();
		String arraynombres []= new String [30];
		arraynombres [0]= "Carmen";
		arraynombres [1]= "Lorena";
		arraynombres [2]= "Lucía";
		arraynombres [3]= "Paola";
		arraynombres [4]= "Olga";
		arraynombres [5]= "Alba";
		arraynombres [6]= "Aida";
		arraynombres [7]= "Adela";
		arraynombres [8]= "Ariadna";
		arraynombres [9]= "Macarena";
		arraynombres [10]= "Rocío";
		arraynombres [11]= "Alejandra";
		arraynombres [12]= "Carla";
		arraynombres [13]= "Daniela";
		arraynombres [14]= "Socorro";
		arraynombres [15]= "Javier";
		arraynombres [16]= "Miguel";
		arraynombres [17]= "Gabriel";
		arraynombres [18]= "Rafael";
		arraynombres [19]= "Gerardo";
		arraynombres [20]= "Juan";
		arraynombres [21]= "Francisco";
		arraynombres [22]= "Jorge";
		arraynombres [23]= "Raúl";
		arraynombres [24]= "Óscar";
		arraynombres [25]= "Álvaro";
		arraynombres [26]= "David";
		arraynombres [27]= "Adrián";
		arraynombres [28]= "Pablo";
		arraynombres [29]= "Pedro";
		
		String arraypets []= new String [30];
		arraypets [0]= "Lola";
		arraypets [1]= "Luna";
		arraypets [2]= "Café";
		arraypets [3]= "Oreo";
		arraypets [4]= "Fujur";
		arraypets [5]= "Thor";
		arraypets [6]= "Aguachirri";
		arraypets [7]= "Gabriela";
		arraypets [8]= "Goran";
		arraypets [9]= "Lady";
		arraypets [10]= "Tequi";
		arraypets [11]= "Gordo";
		arraypets [12]= "Pelusa";
		arraypets [13]= "Punky";
		arraypets [14]= "Triana";
		arraypets [15]= "Falete";
		arraypets [16]= "Freja";
		arraypets [17]= "Ambar";
		arraypets [18]= "Neo";
		arraypets [19]= "Wheje";
		arraypets [20]= "Kala";
		arraypets [21]= "Cuqui";
		arraypets [22]= "Leo";
		arraypets [23]= "Mimi";
		arraypets [24]= "Chico";
		arraypets [25]= "Bola";
		arraypets [26]= "Moro";
		arraypets [27]= "Negri";
		arraypets [28]= "Nala";
		arraypets [29]= "Simba";
		
		String arrayseguros []= new String [10];
		arrayseguros [0] = "Terranea";
		arrayseguros [1] = "Barkibu";
		arrayseguros [2] = "Petplan";
		arrayseguros [3] = "SantéVet";
		arrayseguros [4] = "Confort";
		arrayseguros [5] = "Mascotsegur";
		arrayseguros [6] = "Mapfre";
		arrayseguros [7] = "AON";
		arrayseguros [8] = "Asisa";
		arrayseguros [9] = "Verti";

		Random rd = new Random();
		
		this.nombre = arraynombres [(int) Math.floor(Math.random() * (29-0+1))];
		this.pet = arraypets [(int) Math.floor(Math.random() * (29-0+1))];
		this.seguro = arrayseguros[(int) Math.floor(Math.random() * (10-0+1))];
		this.vacunas = rd.nextBoolean();
		this.castrado = rd.nextBoolean();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public boolean isVacunas() {
		return vacunas;
	}

	public void setVacunas(boolean vacunas) {
		this.vacunas = vacunas;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}

	@Override
	public String toString() {
		return "ClaseObjectUsuario [nombre=" + nombre + ", pet=" + pet + ", seguro=" + seguro + ", vacunas=" + vacunas
				+ ", castrado=" + castrado + "]";
	}
	
	
	
	
	
}
