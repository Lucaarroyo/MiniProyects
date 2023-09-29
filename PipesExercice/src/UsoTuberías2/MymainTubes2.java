package UsoTuberías2;

import java.util.*;


public class MymainTubes2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Lectura de Números enteros por teclado y almacenamiento en una arraylist
	 */
	public static ArrayList LlenadoTeclado () {
		ArrayList listanum = new ArrayList();
		//Declaramos un teclado
		Scanner teclado= new Scanner (System.in) ;
		int flag=1;
		while (flag != 1) {
			listanum.add (teclado.nextInt ());
		}
		return listanum;
	}

}
