package FileMagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyMainManagement {
// A la wena mañana
	//Soy er Yaco
	//Soy er Yaco en eclipse

	public static void main(String[] args) {
		FileManagementHelpers helpers = new FileManagementHelpers();
		// Vamos a ir haciendo un poco de todo recopilatorio de lo necesario
		// Cositas que vamos a ir necesitando
		Scanner teclado = new Scanner(System.in);
		File origen = new File("C:\\temp\\mis_archivos\\origen.txt");
		origen.setReadOnly();

		File directorio = new File("C:\\temp\\mis_archivos");
		if (!directorio.exists()) {
			if (directorio.mkdirs()) {
				System.out.println("Directorio creado");
			} else {
				System.out.println("Error al crear directorio");
			}
		}

		// Una vez creado el directorio creamos el archivo
		File datos = new File("C:\\temp\\mis_archivos\\datos.txt");
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		// Vamos a comprobar que se ha creado correctamente uno y otro
		try {
			if (datos.createNewFile()) {
				System.out.println("Archivo creado: " + datos.getName());
			} else {
				System.out.println("El archivo datos ya existe.");
			}
			if (origen.createNewFile()) {
				System.out.println("Archivo creado: " + origen.getName());
			} else {
				System.out.println("El archivo origen ya existe.");
			}

			// Imprimimos la ruta del archivo y hacemos un 2x1, de esta forma comprobamos
			// que esta
			// dónde está y que todo es como debe
			System.out.println("Archivo datos: " + datos.getAbsolutePath());
			System.out.println("Archivo origen: " + origen.getAbsolutePath());
		}

		catch (IOException e) {
			System.out.println("Algo ha ocurrido en el proceso de creación de los archivos.");	
		}
		// Fin del Try-Catch de creado del archivo

		// Ya que tenemos el archivo creado, vamos a escribir en él. El cómo, va a ser
		// usando el método de copia
		helpers.copiar_documento(origen, datos);
		helpers.lectura_doc(origen, datos);
		helpers.cont_words(datos);
		helpers.permisos(origen);
		helpers.permisos();
		helpers.mover(origen);
	}

//_______METODOS CUSTOM___________________________________________________________________________________________________________________

	/*
	// Método Insertar por copia
	public static void copiar_documento(File origen, File destino) {
		try {
			InputStream in = new FileInputStream(origen);
			OutputStream out = new FileOutputStream(destino);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			System.out.println("Proceso de copia realizado con exito.");
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Algo ha ocurrido en la ejecición de copiar.");
			e.printStackTrace();
		}
	}

	// Método para contar palabras
	public static void cont_words(File archivo) {
		try {

			String linea;
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			int cont = 0;

			// Vamos a ir recorriendo el documento línea a línea hasta que sea null (es
			// decir, que no haya niguna más
			while ((linea = br.readLine()) != null) {

				for (int i = 0; i < linea.length(); i++) {
					if (i == 0) {
						if (linea.charAt(i) != ' ')
							cont++;
					} else {
						if (linea.charAt(i - 1) == ' ') {
							if (linea.charAt(i) != ' ') {
								cont++;
							}
						}
					}
				}
			}
			System.out.println("Son " + cont + " palabras");

			fr.close();
		} catch (IOException cont) {
			System.out.println(cont);
		}
	}

	// Método de lectura de archivo. Hemos optado por que al usuario se le muestre
	// el original o la copia, de modo que sea
	// como sea pueda tener el contenido del documento
	public static void lectura_doc(File datos, File origen) {
		File archivoLectura = datos.exists() ? datos : origen;

		if (archivoLectura.exists()) {
			try (FileReader fr = new FileReader(archivoLectura); BufferedReader br = new BufferedReader(fr)) {
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			} catch (IOException e) {
				System.out.println("Ha ocurrido un error al leer el archivo.");
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo no se encuentra. Por favor, seleccione otra opción.");
		}
	}

	// Método para ver los permisos de todos los archivos de una carpeta
	public static void permisos() {
		File dir = new File("C:\\temp\\mis_archivos");
		File[] files = dir.listFiles();
		for (File file : files) {
			Path path = Paths.get(file.toString());
			boolean hid = file.isHidden();
			boolean rid = file.canRead();
			boolean rit = file.canWrite();
			System.out.println();
			System.out.println(file.getName() + " propiedades : ");
			System.out.println(file.getName() + " oculto: " + hid);
			System.out.println(file.getName() + " lectura: " + rid);
			System.out.println(file.getName() + " escritura: " + rit);
			System.out.println();
		}
	}

	// Método para ver os permisos para un solo archivo
	public static void permisos(File origen) {
		System.out.println();
		boolean hid = origen.isHidden();
		boolean rid = origen.canRead();
		boolean rit = origen.canWrite();
		System.out.println(origen.getName() + " propiedades : ");
		System.out.println(origen.getName() + " oculto: " + hid);
		System.out.println(origen.getName() + " lectura: " + rid);
		System.out.println(origen.getName() + " escritura: " + rit);
		System.out.println();
	}

	// Método para mover de un sitio a otro los archivos
	public static void mover(File origen) {

		File destino = new File("C:\\temp\\destino.txt");
		try {
			if (destino.createNewFile()) {
				System.out.println("Archivo creado: " + destino.getName());
			} else {
				System.out.println("El archivo datos ya existe.");
			}
			// Imprimimos la ruta del archivo y hacemos un 2x1, de esta forma comprobamos
			// que esta
			// dónde está y que todo es como debe
			System.out.println("Archivo datos: " + destino.getAbsolutePath());
		}

		catch (IOException e) {
			System.out.println("Algo ha ocurrido en el proceso de creación de los archivos.");
		}
		// Fin del Try-Catch de creado del archivo

		try {
			Files.move(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("El archivo se ha movido de forma satisfactoria.");
		} catch (IOException e) {
			System.out.println("El archivo no se ha podido mover. Error: " + e);
		}
	}
	*/
}
