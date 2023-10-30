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
			Document xmlFile = builder.parse(new File("C:/temp/XMLfiles/books.xml"));
			String nodeList = "book";
			String textToFind = "Don Quijote";
			System.out.println("Ejercicio 1: " + getIdNodo(xmlFile, nodeList, textToFind));
			
			//populateXML(builder);
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}
//CUSTOM METHODS___________________________________________________________________________________

	//Método para rellenar los XML
	private static void populateXML(DocumentBuilder builder){
		File xmlTemplate = new File("");
		FileWriter fichero = null;
		PrintWriter pw = null;
		//Document doc = builder.parse(xmlTemplate);
		
		//Creamos el XML de los libros
		String books= "<books>\r\n"
				+ "  <book id=\"bk101\">\r\n"
				+ "    <title>Don Quijote</title>\r\n"
				+ "    <author>Cervantes</author>\r\n"
				+ "  </book>\r\n"
				+ "</books>";
		xmlTemplate = new File("C:/temp/XMLfiles/books.xml");
		try {
			fichero = new FileWriter("C:/temp/XMLfiles/books.xml");
			pw = new PrintWriter(fichero);
			pw.print(books);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		//Creamos el XML de las Películas
		String movies = "<movies>\r\n"
				+ "  <movie id=\"tt0133093\">\r\n"
				+ "    <title>The Matrix</title>\r\n"
				+ "    <year>1999</year>\r\n"
				+ "  </movie>\r\n"
				+ "</movies>";
		xmlTemplate = new File("../filesXML/movies.xml");
		
		//Creamos el XML de los estudiantes
		String students ="<students>\r\n"
				+ "  <student>\r\n"
				+ "    <name>John</name>\r\n"
				+ "    <age>20</age> \r\n"
				+ "  </student>\r\n"
				+ "  <student>  \r\n"
				+ "    <name>Sarah</name>\r\n"
				+ "    <age>19</age>\r\n"
				+ "  </student>\r\n"
				+ "</students>";
		xmlTemplate = new File("../filesXML/students.xml");
		
		//Creamos el XML de los Productos
		String products ="<products>\r\n"
				+ "  <product>\r\n"
				+ "    <name>Product 1</name>\r\n"
				+ "    <price>10.5</price>\r\n"
				+ "  </product>\r\n"
				+ "  <product>\r\n"
				+ "    <name>Product 2</name>\r\n"
				+ "    <price>15</price>\r\n"
				+ "  </product>\r\n"
				+ "</products>";
		xmlTemplate = new File("../filesXML/products.xml");
		
		*/
	}
	
	// EJ1________________
	//Lee el archivo books.xml y obten el valor del atributo id del nodo <book> con título "Don Quijote".
	private static String  getIdNodo (Document document, String nodeListToFind, String textToFind) {
		String idNodo= "Not found";
		Element root = document.getDocumentElement();
		NodeList nodeList = root.getElementsByTagName(nodeListToFind);
		
		for(int i = 0; i < nodeList.getLength(); i++) {
			Element e = (Element) nodeList.item(i);
			if(e.getElementsByTagName("title").item(0).getTextContent().equals(textToFind)) {
				idNodo = e.getAttribute("id");
				break;
			}
		}
		
		return idNodo;

	}

	// EJ2________________

	// EJ3________________

	// EJ4________________

	// EJ5________________

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
