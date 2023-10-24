package ObjetosNecesarios;

import java.util.Random;

public class ClassPet extends ClassOwner {
	// Atributos
	String tipo;
	String pet;
	String seguro;
	boolean vacunas;
	boolean castrado;

	public ClassPet(int identificador, String nombre, String apellido1, String apellido2) {
		super(identificador, nombre, apellido1, apellido2);
		
		String arraytipos[] = new String[25];
		arraytipos[0] = "Perro, (pequeño)";
		arraytipos[1] = "Gato, (o. desconocido))";
		arraytipos[2] = "Perro (mediano)";
		arraytipos[3] = "Gato, (feral) Loro";
		arraytipos[4] = "Perro, (grande)";
		arraytipos[5] = "Gato, (criadero)";
		arraytipos[6] = "Perro, (pequeño)";
		arraytipos[7] = "Perro, (PPP)";
		arraytipos[8] = "Cobaya";
		arraytipos[9] = "Loro Yaco";
		arraytipos[10] = "Perro, (pequeño)";
		arraytipos[11] = "Perro, (mediano)";
		arraytipos[12] = "Roedor, (otros";
		arraytipos[13] = "Tortuga";
		arraytipos[14] = "Papagayo";
		arraytipos[15] = "Conejo";
		arraytipos[16] = "Caballo";
		arraytipos[17] = "Hurón";
		arraytipos[18] = "Chinchilla";
		arraytipos[19] = "Agaporni";
		arraytipos[20] = "Periquito";
		arraytipos[21] = "Hamster";
		arraytipos[22] = "Reptil, (otros)";
		arraytipos[23] = "Serpiente";
		arraytipos[24] = "Nutria";

		String arraypets[] = new String[35];
		arraypets[0] = "Lola";
		arraypets[1] = "Luna";
		arraypets[2] = "Café";
		arraypets[3] = "Oreo";
		arraypets[4] = "Fujur";
		arraypets[5] = "Thor";
		arraypets[6] = "Aguachirri";
		arraypets[7] = "Gabriela";
		arraypets[8] = "Goran";
		arraypets[9] = "Lady";
		arraypets[10] = "Tequi";
		arraypets[11] = "Gordo";
		arraypets[12] = "Pelusa";
		arraypets[13] = "Punky";
		arraypets[14] = "Triana";
		arraypets[15] = "Falete";
		arraypets[16] = "Freja";
		arraypets[17] = "Ambar";
		arraypets[18] = "Neo";
		arraypets[19] = "Wheje";
		arraypets[20] = "Kala";
		arraypets[21] = "Cuqui";
		arraypets[22] = "Leo";
		arraypets[23] = "Mimi";
		arraypets[24] = "Chico";
		arraypets[25] = "Bola";
		arraypets[26] = "Moro";
		arraypets[27] = "Negri";
		arraypets[28] = "Nala";
		arraypets[29] = "Simba";
		arraypets[30] = "Peque";
		arraypets[31] = "Bu";
		arraypets[32] = "Nala";
		arraypets[33] = "Mérida";
		arraypets[34] = "Elsa";

		String arrayseguros[] = new String[10];
		arrayseguros[0] = "Terranea";
		arrayseguros[1] = "Barkibu";
		arrayseguros[2] = "Petplan";
		arrayseguros[3] = "SantéVet";
		arrayseguros[4] = "Confort";
		arrayseguros[5] = "Mascotsegur";
		arrayseguros[6] = "Mapfre";
		arrayseguros[7] = "AON";
		arrayseguros[8] = "Asisa";
		arrayseguros[9] = "Verti";
		
		
		Random rd = new Random();
		// Nos creamos un random para aplicar funcion gausiana al array de anialitos
		// para la creación del fichero
		this.tipo = arraytipos[gausiana()];
		this.pet = arraypets[(int) Math.floor(Math.random() * (34 - 0 + 1))];
		this.seguro = arrayseguros[(int) Math.floor(Math.random() * (9 - 0 + 1))];
		this.vacunas = rd.nextBoolean();
		this.castrado = rd.nextBoolean();
	}

	public ClassPet(int identificador, String nombre, String apellido1, String apellido2, String tipo, String pet,
			String seguro, boolean vacunas, boolean castrado) {
		super(identificador, nombre, apellido1, apellido2);
		this.tipo = tipo;
		this.pet = pet;
		this.seguro = seguro;
		this.vacunas = vacunas;
		this.castrado = castrado;
	}
	
	private static int gausiana() {
		double rand = 0;
		Random gau = new Random();
		double perct = gau.nextGaussian();
		rand = (int) Math.floor(Math.random() * (24 - 0 + 1));
		rand = rand * perct;
		int devolver = (int) rand;
		if (devolver < 0) {
			devolver = devolver * (-1);
		}
		return devolver;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPet() {
		return pet;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public boolean isVacunas() {
		return vacunas;
	}

	public void setVacunas(boolean vacunas) {
		this.vacunas = vacunas;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	
	
	
	

}
