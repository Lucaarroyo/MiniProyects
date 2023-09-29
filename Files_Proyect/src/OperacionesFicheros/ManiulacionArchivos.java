package OperacionesFicheros;
/*
 * @author: Sleepy Kitty Dev
 * @tuthor: Oscar Munoz
 * @date: 29/09/23
 */
import java.io.*;
import java.util.*;

public class ManiulacionArchivos {

	public static void main(String[] args) throws IOException {
		// Cositas que vamos a ir necesitando
		int sui=0;
		Scanner teclao = new Scanner (System.in);
		File Holi = new File ("C:\\Users\\HoliOscar.txt");
		File Holi2 = new File ("C:\\Users\\HoliOscar2.txt");
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
		
		//Vamos a comprobar que se ha creado correctamente uno y otro
				try {
				      if (Holi.createNewFile()) {
				        System.out.println("Arshivo creado: " + Holi.getName());
				      } else {
				        System.out.println("Niña, estas cuajá, eso ya esite.");
				      }
				      
				    //Ejercicio 1 (Imprimir la ruta de HoliOscar.txt) De esta forma también comprobamos que esta
				    //dónde está y que todo es maravilloso
						System.out.println("Er arshivo HoliOscar esta: " + Holi.getAbsolutePath ());
				    } 
				
				catch (IOException e) {
				      System.out.println("Argo ha ocurrío.");
				      e.printStackTrace();
				    }
				//Fin del Try-Catch de creado del archivo 1
				
				try {
				      if (Holi2.createNewFile()) {
				        System.out.println("Arshivo creado: " + Holi2.getName());
				      } else {
				        System.out.println("Niña, estas cuajá, eso ya esite.");
				      }
				      
				    //Ejercicio 1 (Imprimir la ruta de HoliOscar.txt) De esta forma también comprobamos que esta
				    //dónde está y que todo es maravilloso
						System.out.println("Er arshivo HoliOscar2 esta: " + Holi2.getAbsolutePath ());
				    } 
				
				catch (IOException e) {
				      System.out.println("Argo ha ocurrío.");
				      e.printStackTrace();
				    }
				//Fin del Try-Catch de creado del archivo 2
				
				
		// Hacemos un do:while para que nuestro programa tenga un cierto sentido
		do {
		System.out.println("Seleccione el ejercicio que desea visualizar. Pulse 0 para terminar");
		System.out.println("EJ1: Rellena el archivo con la palabra Línea más el número de la línea");
		System.out.println("EJ2: Rellena el párrafo");
		System.out.println("EJ3: Lectura del fichero 2");
		System.out.println("EJ4: Cuenta de Caracteres");
		
		sui = teclao.nextInt();
		
			//Creamos un switch case menú para ver cada uno de los ejercicios
			switch (sui) {
//__________________________________________________________________________________________________________________________
				case (sui=1):
					System.out.println("Introduzca el numero de párrafos del documento");
					int lineas1= teclao.nextInt();
					//Ejercicio 2 (El usuario introduce un numero de párrafos del documento)
					if(Holi.exists()){
						if(Holi.canWrite()) {
							FileWriter fichero1 = null;
					        PrintWriter pw = null;
					        fichero1 = new FileWriter(Holi.getAbsolutePath ());
							PrintWriter pw1 = new PrintWriter(fichero1);

					            for (int i = 0; i < lineas1; i++) {
					                pw1.println("Linea " + i);
					        } 
					            //Una vez escrito lo cerramos y rezamos porque todo haya ido bien 
					            fichero1.close();
						}
						else {
							System.out.println("Argo ha ocurrío. Er arshivo no se pue ehcribí.");
						}
					}
					else {
						System.out.println("Argo ha ocurrío. Er arshivo no se encuentra.");
					}
				
					break;
//__________________________________________________________________________________________________________________________
				case (sui=2):		
					int lineas2= teclao.nextInt();
					//Ejercicio 2 (Escribir en el las líneas del usuario )
					if(Holi.exists()){
						if(Holi2.canWrite()) {
							FileWriter fichero1 = null;
					        PrintWriter pw = null;
					        fichero1 = new FileWriter(Holi2.getAbsolutePath ());
							PrintWriter pw1 = new PrintWriter(fichero1);

					            for (int i = 0; i < lineas2; i++) {
					                pw1.println(teclao.next ());
					        } 
					            //Una vez escrito lo cerramos y rezamos porque todo haya ido bien 
					            fichero1.close();
						}
						else {
							System.out.println("Argo ha ocurrío. Er arshivo no se pue ehcribí.");
						}
					}
					else {
						System.out.println("Argo ha ocurrío. Er arshivo no se encuentra.");
					}
				
					break;
//__________________________________________________________________________________________________________________________
				case (sui=3):		
					//Ejercicio 3 (Lee el fichero "HoliOscar2.txt" con FileReader y muestra su contenido por pantalla.)
					//Si no existe propone la lectura de "HoliOscar1.txt"
					int flag=0;
					if(Holi2.exists()){
					 try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         Holi = new File (Holi2.getAbsolutePath ());
				         fr = new FileReader (Holi2);
				         br = new BufferedReader(fr);

				         // Lectura del fichero
				         String linea;
				         while((linea=br.readLine())!=null)
				            System.out.println(linea);
				      }
				      catch(Exception e){
				         e.printStackTrace();
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion. Mejor hacerlo limpiamente, leche
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				            e2.printStackTrace();
				         }
				      }
				   }else {
					   System.out.println("Argo ha ocurrío. Er arshivo no se encuentra.");
					   System.out.println("¿Intentamos mostrarle HoliOscar.txt?.");
					   if(Holi.exists()){
							 try {
						         // Apertura del fichero y creacion de BufferedReader para poder
						         // hacer una lectura comoda (disponer del metodo readLine()).
						         Holi = new File (Holi.getAbsolutePath ());
						         fr = new FileReader (Holi);
						         br = new BufferedReader(fr);

						         // Lectura del fichero
						         String linea;
						         while((linea=br.readLine())!=null)
						            System.out.println(linea);
						      }
						      catch(Exception e){
						         e.printStackTrace();
						      }finally{
						         // En el finally cerramos el fichero, para asegurarnos
						         // que se cierra tanto si todo va bien como si salta 
						         // una excepcion.
						         try{                    
						            if( null != fr ){   
						               fr.close();     
						            }                  
						         }catch (Exception e2){ 
						            e2.printStackTrace();
						         }
						      }
						   }else {
							   System.out.println("Argo ha ocurrío. Er arshivo no se encuentra.");
							   System.out.println("Lo sentimoh musho, selesione otra opsió");
						   }
				   }
					break;
//___________________________________________________________________________________________________________________________________
				/*
				case (sui=4):		
					//(https://javiergarciaescobedo.es/programacion-en-java/15-ficheros/42-leer-un-fichero-caracter-a-caracter)
					int cont =0;
					//char carcateres;
					 try {
				         // Apertura del fichero y creacion de BufferedReader para poder
				         // hacer una lectura comoda (disponer del metodo readLine()).
				         archivo = new File (Holi2.getAbsolutePath ());
				         fr = new FileReader (archivo);
				         br = new BufferedReader(fr);
				         // Lectura del fichero
				         String linea;
				         while((linea=br.readLine())!=null) {
				        	 char caracteres = fr.read();
								while(caracteres != null) {
									cont ++;
								    caracteres = fr.read();
								}
				         }
					 }
				      catch(Exception e){
				         e.printStackTrace();
				      }finally{
				         // En el finally cerramos el fichero, para asegurarnos
				         // que se cierra tanto si todo va bien como si salta 
				         // una excepcion.
				         try{                    
				            if( null != fr ){   
				               fr.close();     
				            }                  
				         }catch (Exception e2){ 
				            e2.printStackTrace();
				         }
				      }	
					System.out.println("El arhivo HoliOScar2 tiene " + cont + "caracteres");
					break;
					*/
//___________________________________________________________________________________________________________________________________
				case (sui=5):		
					//Ejercicio 5 
					break;
				case (sui=6):		
					//Ejercicio 6 
					break;
				default:
					System.out.println("Eh uhté sunnormá");
			}	
		}//Fin der du
		while (sui!=0); 
	}
	

}
