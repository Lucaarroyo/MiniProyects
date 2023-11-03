package ejercicioSAX;

public class ResultadosHandler extends ejercicioMarcadoresSAX {

	 private String equipoABuscar;
	    private boolean esPartido;
	    private boolean esEquipoLocal;
	    private boolean esEquipoVisitante;

	    public ResultadosHandler(String equipoABuscar) {
	        this.equipoABuscar = equipoABuscar;
	    }

	    @Override
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	        if (qName.equalsIgnoreCase("partido")) {
	            esPartido = true;
	        } else if (qName.equalsIgnoreCase("local")) {
	            esEquipoLocal = true;
	        } else if (qName.equalsIgnoreCase("visitante")) {
	            esEquipoVisitante = true;
	        }
	    }

	    @Override
	    public void characters(char[] ch, int start, int length) throws SAXException {
	        if (esPartido && (esEquipoLocal || esEquipoVisitante)) {
	            String equipo = new String(ch, start, length).trim();
	            if (equipo.equalsIgnoreCase(equipoABuscar)) {
	                System.out.println("Resultado del partido:");
	                System.out.println("Local: " + equipo);
	                // Aquí también puedes manejar más información sobre el partido si lo necesitas
	            }
	        }
	    }

	    @Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {
	        if (qName.equalsIgnoreCase("partido")) {
	            esPartido = false;
	        } else if (qName.equalsIgnoreCase("local")) {
	            esEquipoLocal = false;
	        } else if (qName.equalsIgnoreCase("visitante")) {
	            esEquipoVisitante = false;
	        }
	    }
	}
