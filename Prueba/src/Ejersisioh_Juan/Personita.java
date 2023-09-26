package Ejersisioh_Juan;

import java.util.Random;

/* @ide: Eclipse 2023-09
 * @author: Aida Fernández
 * @Supervisor: Juan García
 * @date: 26/09/2023
 * @subject: Programación de Servicios y Procesos
 */

import java.lang.*;
import java.util.*;

public class Personita {

	//ATRIBUTOS
	int edad;
	String DNI;
	String sexo;
	float peso;
	int altura;

	
	//CONSTRUCTORES
	public Personita(int edad, String dNI, String sexo, float peso, int altura) {
		super();
		this.edad = edad;
		DNI = dNI;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Personita(int edad,  String sexo, float peso, int altura) {
		super();
		this.edad = edad;
		DNI = aleatDNI ();
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public Personita(int edad, String dNI, String sexo) {
		super();
		this.edad = edad;
		DNI = dNI;
		this.sexo = sexo;
		this.peso = 75;
		this.altura = 175;
	}
	
	public Personita() {
		super();
		this.edad = 35;
		DNI = "00000000A";
		this.sexo = "H";
		this.peso = 75;
		this.altura = 175;
	}

	//GETTER SETTER
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	
	
	//TO STRING
	@Override
	public String toString() {
		return "Personita [edad=" + edad + ", DNI=" + DNI + ", sexo=" + sexo + ", peso=" + peso + ", altura=" + altura
				+ "]";
	}
	
	
	//METODOS CUSTOM
	public boolean menor (int edad ) {
		boolean menor =true;
		if (edad>18) {
			menor=false;
		}
		return menor;
	}
	
	public String aleatDNI () {
		Random r = new Random();
		Integer numeroDNI = r.nextInt(99999999);
		final String [] letras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		int resto=0;
		resto = numeroDNI % 23;
		String dni= numeroDNI.toString ();
		String letra= letras[resto];
        String randomDNI= numeroDNI+letra;
		return randomDNI;
	}
	
	public static float imccalculator (float peso, int altura) {
		float altuu = altura/100;
		float imc=peso/(altuu*altuu);
		return imc;
	}
	
	public static void obesityindicator (float peso, int altura) {
		float imc= imccalculator (peso, altura);
		if (imc<18) {
			System.out.println("Esta usted en infrapeso");
		}
		else {
			if (imc <=18 || imc<25) {
				System.out.println("Esta usted en normopeso");
			}
			else {
				if (imc <=25|| imc<30) {
					System.out.println("Tiene usted un ligero sobrepeso");
				}
				else {
					if (imc <=30|| imc<35) {
						System.out.println("Tiene usted obesidad de tipo I");
					}
					else {
						if (imc <=35|| imc<40) {
							System.out.println("Tiene usted obesidad de tipo II");
						}
						else {
							System.out.println("Tiene usted obesidad de tipo III");
						}
					}
				}
			}
		}
	}
	
	public static boolean equals (Personita p1, Personita p2) {
		boolean igual=false;
		if(p1.getDNI()==p2.getDNI()) {
			igual=true;
		}
		return igual;
	}
	
}
