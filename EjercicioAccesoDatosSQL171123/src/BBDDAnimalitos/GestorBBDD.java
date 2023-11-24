package BBDDAnimalitos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBBDD {

// METODOS_________________________________________________________________________________________
	static void crearTabla() {
		// La tabla debería estar creada en el Workbench
	}

	static void insertar(int id, Connection conexion) {
		Animalitos usuario = new Animalitos();
		int pk = id;
		String nombre = usuario.getNombre();
		String apellido1 = usuario.getApellido1();
		String apellido2 = usuario.getApellido2();
		String tipo = usuario.getTipo();
		String pet = usuario.getPet();
		String seguro = usuario.getSeguro();
		String vacunas = usuario.isVacunas();
		String castrado = usuario.isCastrado();

		// Creamos la query
		String query = "INSERT INTO Usuarios (nombre, apellido1, apellido2, tipo, pet, seguro, vacunas, castrado) VALUES"
				+ nombre + " , " + apellido1 + " , " + apellido2 + " , " + tipo + " , " + pet + " , " + seguro + " , "
				+ vacunas + " , " + castrado + ";";
		try (PreparedStatement statement = conexion.prepareStatement(query)) {
			statement.setInt(1, id);
			int filasAfectadas = statement.executeUpdate(); // Ejecutar una actualzación en la BBDD
			if (filasAfectadas > 0) {
				System.out.println("Registro insertado con éxito");
			}
		} catch (SQLException e) {
			System.err.println("Error al insertar el registro: ");
		}
	}

	// Pendiente de testing
	static void insertarAPartir(Connection conexion) {
		// Obtener las claves generadas (en este caso, el ID del usuario)
		try {
			ResultSet generatedKeys = Statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				int idGenerado = generatedKeys.getInt(1); // 1 indica la fila afectada por la
				insertar(idGenerado);
			}
		} catch (SQLException e) {
			System.out.println("No se ha podido encontrar el último registro");
		}

	}

	static void ponervacuna(int id, Connection conexion) throws SQLDataException { // Si no existe pedimos que nos lance
																					// una excepción
		String updateQuery = "UPDATE usuarios SET vacunas = Si  WHERE id = " + id;
		try (PreparedStatement statement = conexion.prepareStatement(updateQuery)) {
			statement.setInt(1, id);

			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Registro actualizado");
			} else {
				System.out.println("No se encontró el registro ");
			}
		} catch (SQLException e) {
			System.err.println("Error al actualizar el registro: ");
		}
	}//Fin del método Modificar

	static void eliminar(int registro, Connection conexion) throws SQLDataException { // Si no existe pedimos que nos
																						// lance una excepción{
		// Sentencia SQL para eliminar el registro por su ID
		String deleteQuery = "DELETE FROM usuarios WHERE id = " + registro;

		try (PreparedStatement statement = conexion.prepareStatement(deleteQuery)) {
			statement.setInt(1, registro);

			int filasAfectadas = statement.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Registro eliminado");
			} else {
				System.out.println("No se encontró el registro ");
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar el registro: ");
		}
	} // Fin Eliminar

}// Fin Class
