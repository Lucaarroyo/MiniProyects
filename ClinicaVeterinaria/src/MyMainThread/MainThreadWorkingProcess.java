package MyMainThread;
import java.io.File;
//import FileManagementProject.FileManagementHelper;
import java.io.FileNotFoundException;

public class MainThreadWorkingProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//vamos a generar un numero aleatorio de casos para testear
		int rannd= (int) Math.floor(Math.random() * (50-0+1));
		File test= new File ("C:\\temp\\Clinica\\test.txt");
		File test2= new File ("C:\\temp\\Clinica\\test2.txt");
		File test3= new File ("C:\\temp\\Clinica\\predefined.txt");
		FileManagementHelpers.rellenar (rannd);
		/* Una vez generado el documento, vamos a crear dos copias del documento, de modo que operaremos con la copia y
		 * tendremos el original como backup
		 */
		//FileManagementHelper fmh = new FileManagementHelper();
		//fmh.copiar_documento (test, test2);
	}

}
