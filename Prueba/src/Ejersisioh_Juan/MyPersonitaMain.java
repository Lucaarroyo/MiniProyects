package Ejersisioh_Juan;

/* @ide: Eclipse 2023-09
 * @author: Aida Fernández
 * @Supervisor: Juan García
 * @date: 26/09/2023
 * @subject: Programación de Servicios y Procesos
 */

import java.util.*;

public class MyPersonitaMain {

	public static void main(String[] args) {	
		//Variables que vamos a necesitar para la ejecución del programa
		int edad;
		String DNI;
		String sexo;
		float peso;
		int altura;
		//Declaramos entrada por teclado
		Scanner read= new Scanner (System.in);
		//Pedimos los datos al usuario
		
		System.out.println("Vamos a proceder a ejecutar Personita, su asistente de peso personal");
		System.out.println("Por favor introduzca su edad");
		edad=read.nextInt();
		System.out.println("Por favor introduzca su DNI");
		DNI=read.next();
		System.out.println("Por favor introduzca su Peso en KG");
		peso=read.nextFloat();
		System.out.println("Por favor introduzca su Género");
		sexo=read.next();  
		System.out.println("Por favor introduzca su Altura en CM");
		altura=read.nextInt();
		System.out.println ();
		System.out.println ();
		
		//Instanciamos los 3 objetos que se nos piden
		Personita P1= new Personita (edad, DNI, sexo, peso, altura);
		Personita P11= new Personita (edad, DNI, sexo);
		Personita P2= new Personita (edad, sexo, peso, altura);
		Personita P0= new Personita ();
		
		//Mostramos con To String los tres objetos requeridos
		System.out.println("Persona  Personalizada: " + P1.toString ());
		System.out.println("Persona  Genérica: " + P11.toString ());
		System.out.println("Persona  con DNI Aleatorio: " + P2.toString ());
		System.out.println("Persona  por Defecto: " + P0.toString ());
		System.out.println ();
		System.out.println ();
		
		//Vamos a probar los diferentes métodos con la persona personalizada que hemos creado
		System.out.println("¿Es la personita introducida menor de edad?");
		if (P1.menor (P1.getEdad())==true){
			System.out.print("Si");
		}
		else {
			System.out.print("No");
		}
		System.out.println ();
		System.out.println ();
		
		System.out.println("¿Cuál es el IMC de la Personita? " + P1.imccalculator(peso, altura));
		System.out.println ();
		System.out.println ();
		
		
		System.out.println("¿Tiene la personita introducida obesidad?");
		P1.obesityindicator (P1.getPeso(), P1.getAltura());
		System.out.println ();
		System.out.println ();
		
		
		System.out.println("¿Son las personitas 1 y 2 iguales según su DNI?");
		if (P1.equals(P1, P2)){
			System.out.print("Si");
		}
		else {
			System.out.print("No");
		}
		System.out.println ();
		System.out.println ();
		
		System.out.println("Gracias por usar nuestros servicios");
		
	}
}
