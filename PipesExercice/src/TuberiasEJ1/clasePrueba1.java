package TuberiasEJ1;

import java.util.ArrayList;
import java.util.Random;

public class clasePrueba1 {

	public static void main(String[] args) {
		
		ArrayList aleatorios = new ArrayList(); 

		//Procedemos a llamar a los métodos que hemos creado previamente:
		
		LlenarArrayAleatorios (aleatorios);
		LlenarArrayAleatorios ();
		
		Impresioncol (aleatorios);
		Impresion (aleatorios);
		
		
	}
	
	//Creamos un método que nos genere números aleatorios. 
	public static int Generador () {
		Random r = new Random();
		Integer numero = r.nextInt(99999999);
		return numero ;
	}
	
	
	/*
	 * Vamos a crear un método alternativo en el ejercicio que nos genere un array cada vez con números
	 * aleatorios y que no se almacena,es decir, cada vez que lo usemos será un array nuevo.
	 * Esto nos va a permitir comparar el generado aleatoriamente y guardado con el temporal, Aumentando la
	 * escalabilidad y futuras funcionalidades del proyecto
	 */
	public static void LlenarArrayAleatorios () {
		for (int i=0; i<40; i++) {
			ArrayList aleatorios2 = new ArrayList(); 
			aleatorios2.add (Generador ());
		}
	}
	
	/*
	 * Creamos un método que rellene un arraylist con números aleatorios
	 * Tomamos la decisión de hacerlo con arraylist para que el proyecto sea fácilmente
	 * escalable en un futuro, pero se puede trabajar de la misma manera con array. 
	 * 
	 * Nos vamos a beneficiar igualmente del método add de la clase arraylist para rellenar
	 */

	public static void LlenarArrayAleatorios (ArrayList aleatorios) {
		for (int i=0; i<40; i++) {
			aleatorios.add (Generador ());
		}
	}

	
	/*
	 * Vamos a crear un sistema de impresión standard 
	 */
		public static void Impresioncol (ArrayList aleat) {
			for (int i=0; i<aleat.size(); i++) {
				System.out.println (aleat.get (i));
			}
	}
		
		/*
	 * Vamos a crear nuestro propio sistema de imprimir para darle el formato deseado
	 * todo suuuuuper cute para que no nos quede terrible, todo pegado... 
	 */
		public static void Impresion (ArrayList aleat) {
			for (int i=0; i<aleat.size(); i++) {
				System.out.print (" " + aleat.get (i)+ ",");
			}
	}

}
