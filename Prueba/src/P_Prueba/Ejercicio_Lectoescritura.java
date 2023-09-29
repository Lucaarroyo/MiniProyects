package P_Prueba;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

public class Ejercicio_Lectoescritura {

	public static void main(String[] args) {
		
		Integer sui;
		Scanner teclao = new Scanner (System.in);
		//Creamos un switch case menú para ver cada uno de los ejercicios
		do {
		System.out.println("Seleccione el ejercicio que desea visualizar. Pulse 0 para terminar");
		sui = teclao.nextInt();
		
			switch (sui) {
				case (sui=1):
					//Ejercicio 1 (Crear el archivo HoliOScar.txt e Imprimir la ruta de HoliOscar.txt)
						ex1 ();	
					break;
				case (sui=2):		
					//Ejercicio 2 (Utiliza FileWriter para crear un nuevo fichero llamado "numeros.txt" y escribe 
					//los números del 1 al 10, cada uno en una línea distinta.)
						ex2 ();
					break;
				case (sui=3):		
					//Ejercicio 3 (Lee el fichero "numeros.txt" con FileReader y muestra su contenido por pantalla.)
						ex3 () ;
					break;
				case (sui=4):		
					//Ejercicio 4 (Lee los primeros 100 bytes del fichero "imagen.jpg" usando FileInputStream y 
					//guárdalos en un array de bytes.)
						ex4 () ;
					break;
				case (sui=5):		
					//Ejercicio 5 (Usa RandomAccessFile para posicionar el puntero en el byte 50 de "fichero.dat" 
					//y lee los 10 bytes siguientes en un array.)
						ex5 () ; 
					break;
				case (sui=6):		
					//Ejercicio 6 (Crea un BufferedReader para mejorar el rendimiento de la lectura del fichero "grande.txt")
						ex6 () ; 
					break;
				default:
					System.out.println("Eh uhté sunnormá");
			}	
		}//Fin der du
		while (sui!=0); 
		
	}// Fin der main
	
	public static void ex1 () {
		//Creamos un Try-Catch para crear el archivo
				try {
				      File Holi = new File ("C:\\Users\\HoliOscar.txt");;
				      if (Holi.createNewFile()) {
				        System.out.println("Arshivo creado: " + Holi.getName());
				      } else {
				        System.out.println("Niña, estas cuajá, eso ya esite.");
				      }
				      
				    //Ejercicio 1 (Imprimir la ruta de HoliOscar.txt)
						System.out.println("Er arshivo HoliOscar esta: " + Holi.getAbsolutePath ());
				    } 
				
				
				catch (IOException e) {
				      System.out.println("Argo ha ocurrío.");
				      e.printStackTrace();
				    }
				//Fin del Try-Catch de creado del archivo
				
	}
	
	public static void ex2 () {
			    try {
			      FileWriter mynum = new FileWriter("numeros.txt");
			        System.out.println("Amo a rellená er arshivo" );
			        for (int i=0; i<=10; i++) {
			        	mynum.write (i + '\n');
			        }
			        mynum.close();
			        System.out.println("Po ya ehta ehcrito");
			    } catch (IOException e) {
			      System.out.println("A ocurrío un erró.");
			      e.printStackTrace();
			    }
	}
		
	public static void ex3 () {
	    try {
	    	//faltaría buscar el archivo en una ruta concreta
	        File mynum = new File("numeros.txt");
	        Scanner milecto = new Scanner(mynum);
	        while (milecto.hasNextLine()) {
	          String data = milecto.nextLine();
	          System.out.println(data);
	        }
	        milecto.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Argo ha ocurrío.");
	        e.printStackTrace();
	      }
	}
	
	public static void ex4 () {
		try {
	    	//faltaría buscar el archivo en una ruta concreta
			byte cachitoimagen [];
			cachitoimagen = new byte [100];
	        File myimage = new File("imagen.jpg");
	        Scanner milecto = new Scanner(myimage);
	        for (int i=0;i<100;i++) {
	        	cachitoimagen [i] = ;
	        }
	        milecto.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Argo ha ocurrío.");
	        e.printStackTrace();
	      }
	}
			
	public static void ex5 () {
	}
	
	public static void ex6 () {
	}

	}

