package PackageHospital;
import java.util.LinkedList;
import java.util.Queue;

public class urgenciasKass {
	
	//ATRIBUTOS DE LA CLASE_______________________________________________________________________________________________
		private final int desborde=5;
		private Queue <objetoPaciente> urgencias = new LinkedList <> ();
		
		
	//METODOS NECESARIOS PARA GESTIONAR LA COLA____________________________________________________________________________
		public Queue <objetoPaciente> getUrgencias() {
			return urgencias;
		}

	//Este es el método por el que entran los pacientes con diferentes graados de gravedad en el hospital
	public synchronized void producirUrgencia () throws InterruptedException {
		//Vamos a hacer que se repita la orden mientras que sea verdad
		while (true) {
			//Mientar que las urgencias estén desbordadas toca esperar para que tomen nota
			while (urgencias.size()== desborde) {
				wait ();
			}
			//Cuando no estén desbordados de trabajo, podemos permitir que entren nuevos pacientes
			//Esto simularía el momento de picos de trabajo del COVID
			objetoPaciente paciente1 = new objetoPaciente();
			System.out.println("Espere en la sala: " +  paciente1.toString());
			urgencias.add(paciente1);
			//Notificamos al doctor que el paciente ha entrado en el hospital
			//Con el system out en esta posición se ve claramente que hay una comunicación entre los hilos
			notify ();
			System.out.println("Doctor, tenemos un nuevo paciente. Hágalo pasar cuando usted pueda.");
			//Esperamos un tiempo aleatorio antes de que entre otro 
			Thread.sleep((int) Math.floor(Math.random() * (10000 - 0 + 1000)));
		}
	}
	
	//Este es el método por el que los doctores de la clínica van a ir resolviendo las incidencias
	public synchronized void resolverUrgencia () throws InterruptedException{
		//Vamos a hacer que se repita la orden mientras que sea verdad
		while (true) {
			//Mientar que las urgencias estén vacías los doctores y mir se pueden tomar un descanso
			while (urgencias.size()== 0) {
				wait ();
			}
			//Declaramos un objeto de tipo paciente  que nos va a permitir hacer el diagnótico y darlo de alta
			//también le vamos a indicar una nueva medicación para mandarlo a casa
			//El método poll de las colas es un método que coge el primero que haya guardad y automáticamente
			//hace avanzar la cola
			objetoPaciente paciente2=urgencias.poll();
			System.out.println("El paciente: " +  paciente2.toString() + " ya tene el alta.");
			//Notificamos a el departamento de administración que hay un paciente en alta
			//Con el system out en esta posición se ve claramente que hay una comunicación entre los hilos
			//Y que devuelve un mensaje 
			notify ();
			System.out.println("En recepción le daremos la medicación y las instrucciones");
			//Esperamos mientars curamos otro paciente 
			//Hemos puesto que no se puedan curar más rápido de lo que se generan , porque siempre hay trabajo realmente
			Thread.sleep((int) Math.floor(Math.random() * (1000 - 0 + 500)));
		}
	}

}

