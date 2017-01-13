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
			System.out.println("ESA FUNCIÓN YA EXISTE");
		else {
			try {
				bw = new BufferedWriter(new FileWriter(f));
				//importar resto de funciones
				bw.write("from ./ import *\n\n\n");
				//empezar a crear funcion
				bw.write("def "+ nombre + "(A, B):\n");
				if(accion1.equals("Repetir")){
					bw.write("\taux = 0\n");
					bw.write("\tfor i in range("+p1+"):\n");
					if(!accion2.equals("")&&!p3.equals("")&&!p4.equals("")){
						bw.write("\t\taux="+accion2+"(aux,"+p4+")\n");
					}
					bw.write("\treturn aux\n\n\n");
				}
				//inicio nueva funcion
				bw.write("print(\"Introducir el valor para A:\")\n");
				bw.write("A = input()\n");
				bw.write("print(\"Introducir el valor para B:\")\n");
				bw.write("B = input()\n");
				//llamada a funcion interna
				bw.write("C = "+nombre+"(int(A), int(B))\n");
				//imprimir resultado
				bw.write("print(\"El resultado es: \", C)\n");
				
				
				
				/*
				if(!p1.equals("")&&p2.equals("")){
					bw.write("C = "+ accion1 + "(" + p1 + ")");
				}
				if(p1.equals("")&&p2.equals("")){
					
				}
				else if(p1.equals("")&&p2.equals("")){
					bw.close();
					throw new IOException();
				}
				*/
				bw.close();
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
