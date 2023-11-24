import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        final int puerto = 12345;

        try {
            // Crear socket del servidor
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto " + puerto);

            // Esperar la conexión del cliente
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress());

            // Establecer flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            // Comunicación con el cliente
            String mensajeCliente;
            while ((mensajeCliente = entrada.readLine()) != null) {
                System.out.println("Cliente: " + mensajeCliente);

                // Enviar respuesta al cliente
                salida.println("Mensaje recibido: " + mensajeCliente);

                // Comprobar el comando para cerrar la conexión
                if (mensajeCliente.equalsIgnoreCase("salir()")) {
                    System.out.println("Cerrando la conexión con el cliente...");
                    break;
                }
            }

            // Cerrar recursos
            entrada.close();
            salida.close();
            clienteSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}