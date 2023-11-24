package BBDDAnimalitos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainVetDB {

	public static void main(String[] args) {
		//Ceeamos un objeto de tipo gestor
		GestorBBDD gestor= new GestorBBDD ();
		
		//CReamos lo necesario para conectar
		String url = "jdbc:mysql://localhost:0668/VetDB"; //Localhost 0668 vecino de satanás 
	    String usuario = "admin";
	    String contraseña = "admin";
	    
	    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
	        System.out.println("Conexión establecida con éxito con VET DB");

	        for (int i=0; i<=10; i++) {
	        // Aqui es donde vamos a realizar la inserción con el id autoacumulado
	        gestor.insertar(i);
	        }
	        //Ejemplo de modificación
	        gestor.ponervacuna(1, conexion);
	        gestor.ponervacuna(4, conexion);
	        gestor.ponervacuna(8, conexion);
	        
	        //Eliminar un registro
	        gestor.eliminar(2, conexion);
	        
	    } catch (SQLException e) {
	        System.err.println("Error de conexión: " + e.getMessage());
	    }

	}

}
