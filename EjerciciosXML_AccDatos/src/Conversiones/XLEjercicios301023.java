package Conversiones;

import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XLEjercicios301023 {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			// populateXML(builder);

			// EJ1________________________________________________________________________________
			Document xmlFile = builder.parse(new File("C:/temp/XMLfiles/books.xml"));
			String nodeList = "book";
			String textToFind = "Don Quijote";
			System.out.println("Ejercicio 1: " + getIdNodo(xmlFile, nodeList, textToFind));

			// EJ2________________________________________________________________________________
			xmlFile = builder.parse(new File("C:/temp/XMLfiles/movies.xml"));
			nodeList = "movies";
			textToFind = "tt0133093";
			System.out.println("Ejercicio 2: " + getText(xmlFile, nodeList, textToFind));

			// EJ3________________________________________________________________________________
			xmlFile = builder.parse(new File("C:/temp/XMLfiles/students.xml"));
			System.out.println("Ejercicio 3: " + getNumNodo(xmlFile));

			// EJ4________________________________________________________________________________
			xmlFile = builder.parse(new File("C:/temp/XMLfiles/products.xml"));
			nodeList = "prices";
			System.out.println("Ejercicio 4: " + getAllText(xmlFile, nodeList));

			// EJ5________________________________________________________________________________
			xmlFile = builder.parse(new File("C:/temp/XMLfiles/data.xml"));
			//System.out.println("Ejercicio 5: " + getAllNodes(xmlFile));
			
			// EJ6________________________________________________________________________________
			// EJ7________________________________________________________________________________
			// EJ8________________________________________________________________________________
			// EJ9________________________________________________________________________________
			// EJ10_______________________________________________________________________________
			// EJ11_______________________________________________________________________________
			// EJ12_______________________________________________________________________________
			// EJ13_______________________________________________________________________________
			// EJ14_______________________________________________________________________________
			// EJ15_______________________________________________________________________________
			// EJ16_______________________________________________________________________________
			// EJ17_______________________________________________________________________________
			// EJ18_______________________________________________________________________________
			// EJ19_______________________________________________________________________________
			// EJ20_______________________________________________________________________________

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//CUSTOM METHODS___________________________________________________________________________________
	// Método para rellenar los XML
	private static void populateXML(DocumentBuilder builder) {
		File xmlTemplate = new File("");
		FileWriter fichero = null;
		PrintWriter pw = null;
		// Document doc = builder.parse(xmlTemplate);

		// Creamos el XML de los libros
		String books = "<books>\r\n" + "  <book id=\"bk101\">\r\n" + "    <title>Don Quijote</title>\r\n"
				+ "    <author>Cervantes</author>\r\n" + "  </book>\r\n" + "</books>";
		xmlTemplate = new File("C:/temp/XMLfiles/books.xml");
		try {
			fichero = new FileWriter("C:/temp/XMLfiles/books.xml");
			pw = new PrintWriter(fichero);
			pw.print(books);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// EJ1________________
	// Lee el archivo books.xml y obten el valor del atributo id del nodo <book> con
	// título "Don Quijote".
	private static String getIdNodo(Document document, String nodeListToFind, String textToFind) {
		String idNodo = "Not found";
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName(nodeListToFind);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			if (e.getElementsByTagName("title").item(0).getTextContent().equals(textToFind)) {
				idNodo = e.getAttribute("id");
				break;// Sale del bucle con que encuentre la primera coincidencia
			}
		}
		return idNodo;
	}

	// EJ2________________
	// Lee el archivo movies.xml y obten el texto dentro del nodo <title> de la
	// película con id "tt0133093".
	private static String getText(Document document, String nodeListToFind, String textToFind) {
		String nameNodo = "Not found";
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName(nodeListToFind);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			if (e.getElementsByTagName("id").item(0).getTextContent().equals(textToFind)) {
				nameNodo = e.getAttribute("title");
				break; // Sale del bucle con que encuentre la primera coincidencia
			}
		}
		return nameNodo;
	}

	// EJ3________________
	// Lee el archivo students.xml y cuenta cuántos nodos <student> hay.
	private static int getNumNodo(Document document) {
		int numNodo = 0;
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName("student");

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			if (e.getNodeName().equals("student")) {	
			numNodo++;
			}
		}
		return numNodo;
	}

	// EJ4________________
	// Lee el archivo products.xml y obten todos los valores de los nodos <price>
	private static String getAllText(Document document, String nodeListToFind) {
		String pricelist = "";
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName(nodeListToFind);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			pricelist += pricelist + e.getElementsByTagName("price") + ", ";
		}
		return pricelist;
	}
	
	// EJ5________________
	//Lee el archivo data.xml, recorre todos sus nodos y muestra sus nombres y valores.
	private static void getAllNodes(Document document) {
		
		Element root = document.getDocumentElement();
		NodeList nodeList = (NodeList) root.getAttributeNode(null);

		for (int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			
			
		}
	}

	// EJ6________________

	// EJ7________________

	// EJ8________________

	// EJ9________________

	// EJ10________________

	// EJ11________________

	// EJ12________________

	// EJ13________________

	// EJ14________________

	// EJ15________________

	// EJ16________________

	// EJ17________________

	// EJ18________________

	// EJ19________________

	// EJ20________________

}
