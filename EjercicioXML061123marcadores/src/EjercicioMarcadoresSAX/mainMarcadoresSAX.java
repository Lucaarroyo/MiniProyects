package EjercicioMarcadoresSAX;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class mainMarcadoresSAX {

	public static void main(String[] args) {
		try {
			File archivoXML = new File("marcadores.xml");
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			System.out.println("Introduce el nombre del equipo a buscar: ");
			Scanner scanner = null;
			String equipoABuscar = scanner.nextLine();
			ResultadosHandler handler = new ResultadosHandler("equipoABuscar");

			saxParser.parse(archivoXML, handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
