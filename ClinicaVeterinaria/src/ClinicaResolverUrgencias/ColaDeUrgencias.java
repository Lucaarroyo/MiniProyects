package ClinicaResolverUrgencias;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ColaDeUrgencias {

//ATRIBUTOS DE LA CLASE_______________________________________________________________________________________________
	private final int desborde=5;
	private Queue <objetoPaciente> urgencias = new LinkedList <> ();
	
	
//METODOS NECESARIOS PARA GESTIONAR LA COLA____________________________________________________________________________
	public Queue <objetoPaciente> getUrgencias() {
		return urgencias;
	}

	public void setUrgencias(Queue <objetoPaciente> urgencias) {
		this.urgencias = urgencias;
	}
	
	
	//Este es el método por el que entran los pacientes muy enfermitos a la clinica
	public synchronized void producirUrgencia () throws InterruptedException {
		//Vamos a hacer que se repita la orden mientras que sea verdad
		while (true) {
			//Mientar que las urgencias estén desbordadas toca esperar para que tomen nota
			while (urgencias.size()== desborde) {
				wait ();
			}
			//Cuando no estén desbordados, podemos permitir que entren nuevos pacientes la clinica
			/*
			 * ¿Cómo entran nuevos pacientes?
			 * Paso 1) Creamos el nuevo paciente de forma random con el Constructor por defecto
			 * Paso 2) Ponemos una notificación por pantalla con el "to String"
			 * Paso 3) Añadimos el objeto a la cola
			 */
			objetoPaciente usuario = new objetoPaciente();
			System.out.println("Doctor, tenemos una nueva urgencia: " +  usuario.toString());
			urgencias.add(usuario);
			//Notificamos al doctor que el paciente ha entrado malito
			notify ();
			//Esperamos antes de que entre otro (la auxiliar de veterinaria esta metiendo nuevos datos)
			Thread.sleep((int) Math.floor(Math.random() * (10000 - 0 + 1000)));
		}
	}
	
	//Este es el método por el que los doctores de la clínica van a ir resolviendo las incidencias
	public synchronized void resolverUrgencia () throws InterruptedException{
		//Vamos a hacer que se repita la orden mientras que sea verdad
		while (true) {
			//Mientar que las urgencias estén vacías los veterinarios se pueden tomar un descanso
			while (urgencias.size()== 0) {
				wait ();
			}
			//Declaramos un objeto de tipo usuario (animalito) que nos va a permitir "curar" un bichillo
			//El método poll de las colas, cogen el primero que ha entrado (FIFO)
			objetoPaciente usuario=urgencias.poll();
			System.out.println("El paciente: " +  usuario.toString() + " ya se puede ir a casa, muchas gracias");
			//Notificamos a el departamento de administración que hay un paciente en alta
			notify ();
			//Esperamos mientars curamos otro paciente 
			Thread.sleep((int) Math.floor(Math.random() * (10000 - 0 + 1000)));
		}
	}


}
