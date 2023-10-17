package MyMainThread;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import ObjetoPpal.ClaseObjectUsuario;

public class FileManagementHelpers {
	
	public static void main(String[] args) {
	final File File = null;
	}
	// Metodo crear un documento con datos aleatorios
	public static void rellenar (int total) {
	 FileWriter fichero = null;
     PrintWriter pw = null;
     try
     {
         fichero = new FileWriter("C:\\temp\\Clinica\\test.txt");
         pw = new PrintWriter(fichero);
		for (int i = 0; i < total; i++) {
			ClaseObjectUsuario usuario= new ClaseObjectUsuario ();
             pw.println("Usuario " + i + usuario.toString ());
        }
        System.out.println("Proceso de rellenado realizado con exito.");

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
        try {
        // Nuevamente aprovechamos el finally para 
        // asegurarnos que se cierra el fichero.
        if (null != fichero)
           fichero.close();
        } catch (Exception e2) {
           e2.printStackTrace();
        }
     }
	}

}