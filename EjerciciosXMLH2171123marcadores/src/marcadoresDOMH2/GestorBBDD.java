package marcadoresDOMH2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// DEV by: Sleepy Kitty Dev

public class GestorBBDD {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// El main nos va a tirar directamente una excepción si no conecta con la BBDD o si no encuentra la clase
		//Sugerenia de Chat GPT
		Class.forName("org.h2.Driver"); //Nos lanza la excepcion de que no la encuentra
		// Conexion con la BBDD
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/testbd", "sa", "");
		// Comenzamos con el tratamiento de las posibles excepciones al cargar el
		// archivo
		try {
			// Cargar el archivo XML
			File archivoXML = new File("marcadores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(archivoXML);

			// Normalizar el documento
			doc.getDocumentElement().normalize();

			// Método para obtener la lista de nodos del documento XML
			NodeList nodeList = doc.getDocumentElement().getChildNodes();

			// Llamar a una función recursiva para insertar toda la jerarquía
			insertarJerarquia(nodeList, 1, conn);
			System.out.println();
			System.out.println();

			// Llamamos al método del menú
			menu(conn);
			System.out.println();

		} /* Fin del Try */catch (Exception e) {
			e.printStackTrace();
		} // Fin catch

	}// Fin Main

	// METODOS

	// Menú fino y elegante por detrás y por
	// delante_______________________________________
	static void menu(Connection conn) {
		int seguir = 1;
		while (seguir != 0) {
			Scanner scanner = new Scanner(System.in);
			System.out.println();
			System.out.println("Seleccione la opción que desee introduciendo el número");
			System.out.println("1) Buscar los resultados de un equipo");
			System.out.println("2) Buscar un evento ");
			System.out.println("3) Mostrar la clasificación ");
			System.out.println("Pulse 0 para salir");
			switch (seguir) {
			case 1:
				buscarEquipo(conn);
			case 2:
				buscarEvento(conn);
			case 3:
				buscarClasificacion(conn);
			default:
				System.out.println("Creo que es usted gilipollas, pulse 1, 2, 3 o  en su defecto, 0 para salir");
			}
			System.out.println();
			System.out.println();
		}
	}

	// ____________________________________________________________________________________
	// Función recursiva para meter los datos del XML en la tabla SQL
	// Sabemos que el node 0 es una tabla

	public static void insertarJerarquia(NodeList nodeList, int nivel, Connection conn) {
		for (int i = nivel; i < nodeList.getLength(); i++) {
			Node nodo = nodeList.item(i);
			// Mostrar el nombre del nodo y el nivel para saber lo que estamos metiendo en
			// la tabla
			System.out.println("Marcador LVL " + nivel + ": " + nodo.getNodeName());

			// Creamos una "Statement", o "Query" es decir, una sentencia SQL
			Statement statement;
			try {
				statement = conn.createStatement();
				// Para la Query buscamos el nombre del nodo (columna) y el elemento que vamos a
				// poner
				String name = nodo.getNodeName();
				String value = nodo.getNodeValue();
				String query = "INSERT INTO marcadores " + name + " VALUES " + value + ";";
				int respuesta = statement.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("No se ha podido crear o insertar la consulta SQL");
			}

			// Llamar recursivamente a la función para los nodos hijos
			if (nodo.hasChildNodes()) {
				insertarJerarquia(nodo.getChildNodes(), nivel + 1, conn);
			}
		}
	} // Fin de la función de insertar la jerarquía

	// Metodo Buscar equipo____________________________________________________
	static void buscarEquipo(Connection conn) {
		System.out.println("Introduce el nombre del equipo a buscar: ");
		Scanner scanner = null;
		String equipoABuscar = scanner.nextLine();
		// Creamos la query
		Statement statement;
		try {
			statement = conn.createStatement();
			String query = "SELECT * FROM marcadores WHERE equipolocal  =  " + equipoABuscar + " OR equipovisitante = " + equipoABuscar + ";" ;    
			//El metodo Execute Query devuelve el resultado de la consulta
			ResultSet resultSet = statement.executeQuery(query);
			//Aqui debemos procesar los datos de salida 
			while (resultSet.next()) {
				System.out.println(resultSet.toString());//Puede ser una opcion
				//resultSet.getArray(query); //Paln B
			}//Fin del while
		} catch (SQLException e) {
			System.out.println("No se ha podido hacer consulta SQL referente al equipo que busca ");
		}

	}// Fin de la función de Buscar por equipos

	// Buscar Evento____________________________________________________________
	static void buscarEvento(Connection conn) {
		System.out.println("Introduce el id del evento a buscar: ");
		Scanner scanner = null;
		String eventoABuscar = scanner.nextLine();
		// Creamos la query
		Statement statement;
		try {
			statement = conn.createStatement();
			String query = "SELECT * FROM marcadores WHERE eventoid = " + eventoABuscar + ";";
			//El metodo Execute Query devuelve el resultado de la consulta
			ResultSet resultSet = statement.executeQuery(query);
			//Aqui debemos procesar los datos de salida 
			while (resultSet.next()) {
				System.out.println(resultSet.toString());//Puede ser una opcion ????????????? 
			}//Fin del while
		} catch (SQLException e) {
			System.out.println("No se ha podido hacer consulta SQL referente al evento que busca ");
		}

	}// Fin de la función de Buscar por eventos

	// Buscar Clasificación_____________________________________________________
	static void buscarClasificacion(Connection conn) {
		// No se que son los datos de una clasificación
		System.out.println("No hay datos disponibles en este preciso momento");
	}// Fin de la función de Buscar la clasificación

}// Fin Class
