package EjercicioMarcadoresSAX;

import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * DefaultHandler es una clase proporcionada por la biblioteca SAX que es una clase 
 * base para manejar eventos SAX. Cuando estás trabajando con SAX, puedes crear tu 
 * propia clase que extienda DefaultHandler para manejar eventos específicos mientras se
 * procesa un archivo XML, que es lo que vamos a hacer. 
 */

public class ResultadosHandler extends DefaultHandler {

	private String equipoABuscar;
	private boolean esPartido;
	private boolean esEquipoLocal;
	private boolean esEquipoVisitante;

	public ResultadosHandler(String equipoABuscar) {
		this.equipoABuscar = equipoABuscar;
	}

	// @Override (Me pide que lo elimine pero no se por qué)
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// Código para manejar el inicio de un elemento (etiqueta) en el XML.
		// Vamos a empezar a buscar por los eventos
		if (qName.equalsIgnoreCase("equipolocal")) {
	        // Estamos dentro de un elemento <local>.
			//Aqui podríamos operar, si supirera exactamente cómo
	        esEquipoLocal = true;
	        esEquipoVisitante = false;
	    } else if (qName.equalsIgnoreCase("equipovisitante")) {
	        // Estamos dentro de un elemento <visitante>
	    	// Aqui ponemos operar, si supirera exactamente cómo
	        esEquipoLocal = false;
	        esEquipoVisitante = true;
	    }
				
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// Código para manejar los datos dentro de un elemento en el XML.
		// No se cómo se hace
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// Código para manejar el final de un elemento (etiqueta) en el XML.
		//San Chat GPT no explica como se hace realmente
	}
}
