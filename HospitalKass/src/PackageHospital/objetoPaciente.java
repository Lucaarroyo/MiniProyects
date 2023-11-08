package PackageHospital;
import java.util.Random;

public class objetoPaciente {
	@Override
	public String toString() {
		return "objetoPaciente [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", motivo=" + motivo + ", gravedad=" + gravedad + ", seguro=" + seguro + ", covid=" + covid + "]";
	}

	// Atributos
	String nombre;
	String apellido1;
	String apellido2;
	String motivo;
	int gravedad;
	String seguro;
	boolean covid;
	
	public objetoPaciente() {
		super();
		String arraynombres[] = new String[60];
		arraynombres[0] = "Carmen";
		arraynombres[1] = "Lorena";
		arraynombres[2] = "Lucía";
		arraynombres[3] = "Paola";
		arraynombres[4] = "Olga";
		arraynombres[5] = "Alba";
		arraynombres[6] = "Aida";
		arraynombres[7] = "Adela";
		arraynombres[8] = "Ariadna";
		arraynombres[9] = "Macarena";
		arraynombres[10] = "Rocío";
		arraynombres[11] = "Alejandra";
		arraynombres[12] = "Carla";
		arraynombres[13] = "Daniela";
		arraynombres[14] = "Socorro";
		arraynombres[15] = "Javier";
		arraynombres[16] = "Miguel";
		arraynombres[17] = "Gabriel";
		arraynombres[18] = "Rafael";
		arraynombres[19] = "Gerardo";
		arraynombres[20] = "Juan";
		arraynombres[21] = "Francisco";
		arraynombres[22] = "Jorge";
		arraynombres[23] = "Raúl";
		arraynombres[24] = "Óscar";
		arraynombres[25] = "Álvaro";
		arraynombres[26] = "David";
		arraynombres[27] = "Adrián";
		arraynombres[28] = "Pablo";
		arraynombres[29] = "Pedro";
		arraynombres[30] = "Carmela";
		arraynombres[31] = "Irene";
		arraynombres[32] = "Sofía";
		arraynombres[33] = "Francisca";
		arraynombres[34] = "Manuela";
		arraynombres[35] = "Leticia";
		arraynombres[36] = "María José";
		arraynombres[37] = "Patricia";
		arraynombres[38] = "Charo";
		arraynombres[39] = "Margarita";
		arraynombres[40] = "Pilar";
		arraynombres[41] = "Carmen María";
		arraynombres[42] = "Hiniesta";
		arraynombres[43] = "Paula";
		arraynombres[44] = "Dolores";
		arraynombres[45] = "María del Carmen";
		arraynombres[46] = "Miguel Ángel";
		arraynombres[47] = "Alejandro";
		arraynombres[48] = "Ricardo";
		arraynombres[49] = "Jorge Javier";
		arraynombres[50] = "Juan José";
		arraynombres[51] = "Cristóbal";
		arraynombres[52] = "Jesús";
		arraynombres[53] = "Jacobo";
		arraynombres[54] = "Ignacio";
		arraynombres[55] = "Sancho";
		arraynombres[56] = "Íñigo";
		arraynombres[57] = "Borja";
		arraynombres[58] = "Francisco Javier";
		arraynombres[59] = "Alberto José";

		String arrayapellidos[] = new String[40];
		arrayapellidos[0] = "González";
		arrayapellidos[1] = "Fernández";
		arrayapellidos[2] = "Naranjo";
		arrayapellidos[3] = "Pérez";
		arrayapellidos[4] = "Sánchez";
		arrayapellidos[5] = "García";
		arrayapellidos[6] = "Gómez";
		arrayapellidos[7] = "Ortíz";
		arrayapellidos[8] = "Ortega";
		arrayapellidos[9] = "Garrido";
		arrayapellidos[10] = "Leal";
		arrayapellidos[11] = "Hormigo";
		arrayapellidos[12] = "Márquez";
		arrayapellidos[13] = "Rodríguez";
		arrayapellidos[14] = "Díez";
		arrayapellidos[15] = "Gamero";
		arrayapellidos[16] = "Almena";
		arrayapellidos[17] = "Fuentes";
		arrayapellidos[18] = "Espada";
		arrayapellidos[19] = "Cano";
		arrayapellidos[20] = "Serrano";
		arrayapellidos[21] = "Humanes";
		arrayapellidos[22] = "Virlán";
		arrayapellidos[23] = "Vázquez";
		arrayapellidos[24] = "Caballero";
		arrayapellidos[25] = "Montañez";
		arrayapellidos[26] = "Arroyo";
		arrayapellidos[27] = "Parreño";
		arrayapellidos[28] = "García";
		arrayapellidos[29] = "Rolo";
		arrayapellidos[30] = "Rodríguez";
		arrayapellidos[31] = "de la Vega";
		arrayapellidos[32] = "Pérez";
		arrayapellidos[33] = "Vega";
		arrayapellidos[34] = "Delgado";
		arrayapellidos[35] = "Rubio";
		arrayapellidos[36] = "Jiménez";
		arrayapellidos[37] = "Torres";
		arrayapellidos[38] = "Vélez";
		arrayapellidos[39] = "López";

		//Creamos un array del que vamos a tomar las enfermedades con las que los pacientes pueden llegar
		String arraymotivos[] = new String[27];
		arraymotivos[0] = "Migraña";
		arraymotivos[1] = "Síntomas Gripales";
		arraymotivos[2] = "Vómitos";
		arraymotivos[3] = "Diarrea";
		arraymotivos[4] = "Traumatismo Creaneal";
		arraymotivos[5] = "Accidente de Coche";
		arraymotivos[6] = "Apendicitis";
		arraymotivos[7] = "Peritonitis";
		arraymotivos[8] = "Rotura ósea";
		arraymotivos[9] = "Herida de bala";
		arraymotivos[10] = "Herida de arma blanca";
		arraymotivos[11] = "Coma etílico";
		arraymotivos[12] = "Coma diabético";
		arraymotivos[13] = "Hipo";
		arraymotivos[14] = "Amputación parcial de miembro";
		arraymotivos[15] = "Amputación total de miembro";
		arraymotivos[16] = "Objeto extraño en vías aéreas";
		arraymotivos[17] = "Pneumonía";
		arraymotivos[18] = "Hipotermia";
		arraymotivos[19] = "Golpe de calor";
		arraymotivos[20] = "Infección (fúngica o basteriana)";
		arraymotivos[21] = "Quemaduras";
		arraymotivos[22] = "Intoxicación medicamentosa";
		arraymotivos[23] = "Intento de suicidio";
		arraymotivos[24] = "Ataque de ansiedad";
		arraymotivos[25] = "Lupus";
		arraymotivos[26] = "Pendiente de pruebas";
		
		//Incluimos un array con los seguros, un amplia mayoría de las 
		//personas que asisten al hospital pertenecen a la Seguridad Social
		//Esto lo forzamos incluyendo más campos en el array 
		String arrayseguros[] = new String[10];
		arrayseguros[0] = "Asisa";
		arrayseguros[1] = "Sanitas";
		arrayseguros[2] = "Adeslas";
		arrayseguros[3] = "AXA";
		arrayseguros[4] = "Seguridad Social";
		arrayseguros[5] = "Seguridad Social";
		arrayseguros[6] = "Seguridad Social";
		arrayseguros[7] = "Seguridad Social";
		arrayseguros[8] = "Seguridad Social";
		arrayseguros[9] = "Seguridad Social";

		Random rd = new Random();

		this.nombre = arraynombres[(int) Math.floor(Math.random() * (59 - 0 + 1))];
		this.apellido1 = arrayapellidos[(int) Math.floor(Math.random() * (39 - 0 + 1))];
		this.apellido2 = arrayapellidos[(int) Math.floor(Math.random() * (39 - 0 + 1))];
		this.motivo = arraymotivos[(int) Math.floor(Math.random() * (27 - 0 + 1))];
		this.seguro = arrayseguros[(int) Math.floor(Math.random() * (9 - 0 + 1))];
		this.covid = rd.nextBoolean();
		this.gravedad = (int) Math.floor(Math.random() * (5 - 0 + 1));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public int getGravedad() {
		return gravedad;
	}

	public void setGravedad(int gravedad) {
		this.gravedad = gravedad;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public boolean isCovid() {
		return covid;
	}

	public void setCovid(boolean covid) {
		this.covid = covid;
	}

	public objetoPaciente(String nombre, String apellido1, String apellido2, String motivo, int gravedad, String seguro,
			boolean covid) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.motivo = motivo;
		this.gravedad = gravedad;
		this.seguro = seguro;
		this.covid = covid;
	}
	
	
}
