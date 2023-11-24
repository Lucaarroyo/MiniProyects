package ChatAidaFDZ;
import java.io.*;
import java.net.*;
public class Cliente {
    public static void main(String[] args) {

        final String servidorIP = "localhost";
        final int puerto = 12345;

        try {
            // Conectar con el servidor
            Socket socket = new Socket(servidorIP, puerto);
            System.out.println("Conectado al servidor en " + servidorIP + ":" + puerto);

            // Establecer flujos de entrada y salida
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Leer mensajes del usuario y enviarselos al servidor
            BufferedReader lectorUsuario = new BufferedReader(new InputStreamReader(System.in));
            String mensajeUsuario;
            while (true) {
                System.out.print("Cliente: ");
                mensajeUsuario = lectorUsuario.readLine();

                // Enviar mensaje al servidor
                salida.println(mensajeUsuario);

                // Recibir respuesta del servidor
                String respuestaServidor = entrada.readLine();
                System.out.println("Servidor: " + respuestaServidor);

                // Comprobar el comando para cerrar la conexión
                if (mensajeUsuario.equalsIgnoreCase("salir()")) {
                    System.out.println("Cerrando la conexión con el servidor...");
                    break;
                }
            }

            // Cerrar recursos
            lectorUsuario.close();
            entrada.close();
            salida.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
