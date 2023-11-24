package AidaFdzFilosofos;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public class Filosofos implements Runnable {
	int id;
	Lock palitoIzquierdo;
	Lock palitoDerecho;
	static Set<Integer> turnos;
    static final Object lock = new Object();


	public Filosofos(int id, Lock palitoIzquierdo, Lock palitoDerecho) {
		turnos = new HashSet<>();
		int miTurno;
		//Atributos propios de la clase de forma "clásica" 
		this.id = id;
		this.palitoIzquierdo = palitoIzquierdo;
		this.palitoDerecho = palitoDerecho;
	}

	private void comer() {
		System.out.println("Filósofo " + id + " está comiendo");
	}

	private void pensar() {
		System.out.println("Filósofo " + id + " está pensando");
	}

    @Override
    public void run() {
        while (true) {
            pensar();
			// Esperar el turno del filósofo
            synchronized (lock) {
                while (!turnos.contains(id)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("El Filósofo " + id + " está esperando para comer");
                    }
                }
            }

            // Intentar adquirir el tenedor izquierdo
            if (palitoIzquierdo.tryLock()) {
                try {
                    // Intentar adquirir el palito derecho
                    if (palitoDerecho.tryLock()) {
                        try {
                            // Filósofo está comiendo
                            comer();
                        } finally {
                            // Liberar el palito derecho después de comer
                            palitoDerecho.unlock();
                            System.out.println("El Filósofo " + id + " ha liberado el palito derecho");
                        }
                    }
                } finally {
                    // Liberar el palito izquierdo después de comer o si no puede adquirir el palito derecho
                    palitoIzquierdo.unlock();
                    System.out.println("El Filósofo " + id + " ha liberado el palito izquierdo");
                }
            }

            // Actualizar el turno
            synchronized (lock) {
                turnos.remove(id);
                turnos.notifyAll(); // Notificar a los demás filósofos que pueden verificar sus turnos
            }
        }
	}// Fin del Run

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Lock getPalitoIzquierdo() {
		return palitoIzquierdo;
	}

	public void setPalitoIzquierdo(Lock palitoIzquierdo) {
		this.palitoIzquierdo = palitoIzquierdo;
	}

	public Lock getPalitoDerecho() {
		return palitoDerecho;
	}

	public void setPalitoDerecho(Lock palitoDerecho) {
		this.palitoDerecho = palitoDerecho;
	}

	public Set<Integer> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Integer> turnos) {
		this.turnos = turnos;
	}

}
