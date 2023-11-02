package ejercicioSAX;

//Hacemos los import necesarios para trabar con el proyecto
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* Escribe un programa en Java que lea y analice el fichero marcadores.xml.
El programa debe listar la jerarquía y estructura del XML, mostrando los
niveles y los nodos en cada nivel.
Específicamente, tu programa debe identificar y listar todos los nodos
"competicion", mostrando sus atributos "id" y "nombre".
Además de mostrar la información por terminal, crea un nuevo archivo XML
que contenga la salida del análisis y asegúrate de que este archivo esté
formateado para una correcta visualización.

Buscar todos los resultados de un equipo a elegir. 
Para ello se debe solicitar por terminal el equipo.*/


public class ejercicioMarcadoresSAX {

	public static void main(String[] args) {
		 try {
	            // Cargar el archivo XML
	            File archivoXML = new File("ruta/al/archivo.xml");

	            // Crear un manejador SAX para procesar el XML
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();
	            ResultadosHandler handler = new ResultadosHandler("Equipo a buscar");

	            // Analizar el archivo XML utilizando el manejador SAX
	            saxParser.parse(archivoXML, handler);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	}
	// METODOS ____________________________________________________________________________________
}
