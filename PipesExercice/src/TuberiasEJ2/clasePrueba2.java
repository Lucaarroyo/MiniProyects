package TuberiasEJ2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class clasePrueba2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Vamos a proceder a crear una lista de numeros enteros");
		ArrayList listanumuser1 = LlenadoTeclado();
		Impresioncol (listanumuser1);
		System.out.println ();
		System.out.println("Vamos a proceder a ordenar su lista");
		System.out.println ();
		ImpresionOL (listanumuser1);
		System.out.println ();
		System.out.println ();
		
		
		System.out.println("Vamos a proceder a crear una lista de 40 numeros enteros");
		ArrayList listanumuser2 = LlenadoTecladoAlternativo();
		Impresioncol (listanumuser2);
		System.out.println ();
		System.out.println("Vamos a proceder a ordenar su lista");
		System.out.println ();
		ImpresionOL (listanumuser2);
		System.out.println ();
		System.out.println ();
		
	}
		/*
		 * Lectura interactiva de Números enteros por teclado y almacenamiento en una arraylist
		 */
		public static ArrayList LlenadoTeclado () {
			ArrayList listanum = new ArrayList();
			//Declaramos un teclado
			Scanner teclado= new Scanner (System.in) ;
			int flag=1;
			while (flag != 0) {
				listanum.add (teclado.nextInt ());
				System.out.println("¿Desea usted continuar? Pulse 0 para detener la entrada de datos");
				flag=teclado.nextInt ();
			}
			//Una vez rellenada la revolvemos por parámetros =)
			return listanum;
		}
		
		/*
		 * Lectura de un número predeterminado de números y almacenamiento en una arraylist
		 * Optamos por un arraylist para poder hacerlo escalable
		 * optamos por un for por la misma razón, que solo cambiando el término de tope del i
		 * podremos escalar la funcionalidad del método
		 */
		public static ArrayList LlenadoTecladoAlternativo () {
			ArrayList listanum = new ArrayList();
			//Declaramos un teclado
			Scanner teclado= new Scanner (System.in) ;
			for (int i=0; i<40;i++) {
				listanum.add (teclado.nextInt ());
			}
			return listanum;
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
			
		//IMPRESION ORDENADA
			
		/*
		* Vamos a crear un sistema de impresión standard ordenado por columna 
		*/
			public static void ImpresioncolOL (ArrayList aleat) {
				Collections.sort(aleat);
				for (int i=0; i<aleat.size(); i++) {
						System.out.println (aleat.get (i));
				}
			}
				
		/*
		* Vamos a crear nuestro propio sistema de imprimir ordenador para darle el formato 
		* deseado todo suuuuuper cute para que no nos quede terrible, todo pegado... 
		*/
			public static void ImpresionOL (ArrayList aleat) {
				Collections.sort(aleat);
				for (int i=0; i<aleat.size(); i++) {
						System.out.print (" " + aleat.get (i)+ ",");
				}
			}

		
}
