package Ejersisioh_Juan;

public class MainIMC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables que vamos a necesitar para la ejecución del programa
		int edad= 45;
		String DNI = "0000007D";
		String sexo= "Mujer";
		float peso= 15;
		int altura= 145;
		
		Personita P1= new Personita (edad, DNI, sexo, peso, altura);
		
		System.out.println("¿Cuál es el IMC de la Personita? " + P1.imccalculator(peso, altura));
		System.out.println ();
		System.out.println ();
		
		
		System.out.println("¿Tiene la personita introducida obesidad?");
		P1.obesityindicator (P1.getPeso(), P1.getAltura());
		System.out.println ();
		System.out.println ();
	}

}
