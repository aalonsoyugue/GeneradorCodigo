import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generar {
	public static void crearFuncion (String nombre, String accion1, String accion2, String p1, String p2, String p3, String p4) {
		String dir = "./Funciones/" + nombre + ".py";
		File f = new File(dir);
		
		BufferedWriter bw;
		if (f.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE, JODER");
		else {
			try {
				bw = new BufferedWriter(new FileWriter(f));
				
			} catch (IOException e) {
				System.out.println("SE FUE TODO A LA PUTA :(");
				System.exit(0);
			}
		}
		//hay que meter los includes
		//bw.write("print()");
	}
}
