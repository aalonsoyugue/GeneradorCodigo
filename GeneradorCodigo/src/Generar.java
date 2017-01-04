import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generar {
	public static void crearFuncion (String nombre, String accion1, String accion2, String p1, String p2, String p3, String p4) {
		ControlarNombre(nombre);
		String dir = "./GeneradorCodigo/Funciones/" + nombre + ".py";
		File f = new File(dir);
		BufferedWriter bw;
		if (f.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE, JODER");
		else {
			try {
				bw = new BufferedWriter(new FileWriter(f));
				bw.write("print(HEEYYY)");
			} catch (IOException e) {
				System.out.println("SE FUE TODO A LA PUTA :(");
				System.exit(0);
			}
		}
		//hay que meter los includes
		//bw.write("print()");
	}

	private static void ControlarNombre(String nombre) {
		boolean fallo=false;
		if(nombre.equals("")){
			System.out.println("No se permite dejar el nombre de función en blanco");
			fallo=true;
		}
		if(nombre.indexOf(" ")>0){
			System.out.println("No se permiten espacios");
			fallo=true;
		}
		if(fallo==true){
			System.out.println("Hay fallos en el nombre");
			System.exit(0);
		}
	}
}
