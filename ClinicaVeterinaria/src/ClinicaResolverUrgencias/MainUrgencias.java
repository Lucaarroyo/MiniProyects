package ClinicaResolverUrgencias;

public class MainUrgencias {

	public static void main(String[] args) {
		// Este es el main que va a gestionar los hilos de las urgencias
		ColaDeUrgencias colaur= new ColaDeUrgencias ();
		//Creamos el hilo de las entradas de los pacientes y le damos las funcionalidades
		Thread pacientes = new Thread ( () -> {
			try {
				colaur.producirUrgencia ();
			}catch (InterruptedException e){
				throw new RuntimeException (e);
			}
			
		});
		//CReamos el hilo de los pacientes que se van de alta y le damos las funcionalidades
		Thread altas=new Thread ( () -> {
			try {
				colaur.resolverUrgencia ();
			}catch (InterruptedException e){
				throw new RuntimeException (e);
			}
			
		});
		
		pacientes.start();
		altas.start();
	}

}
