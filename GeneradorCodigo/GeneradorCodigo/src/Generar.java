import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generar {
	public static void crearFuncion (String nombre, String accion1, String accion2, String p1, String p2, String p3, String p4) {
		ControlarNombre(nombre);
		String dir = "./Func/" + nombre + ".c";
		File f = new File(dir);
		BufferedWriter bw;
		if (f.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE");
		else {
			try {
				bw = new BufferedWriter(new FileWriter(f));
				//importar resto de funciones 
				bw.write("#include <stdio.h>\n");
				bw.write("#include <stdlib.h>\n");
				File f2 = new File("./Func");
				String[] ficheros = f2.list();
				for (int i = 0; i < ficheros.length; i++){
					bw.write("#include <"+ ficheros[i] +">\n");
				}
				
				//Declarar funcion y main
				
				bw.write("\n\n\nint " + nombre + "(int A, int B);\n\n\n");
				
				bw.write("\n\n\nint main(int argc, char *argv[]){\n");
				bw.write("printf(\"Introducir el valor para A:\");\n");
				bw.write("int A,B;\n");
				bw.write("scanf(\"%d\", &A);\n");
				bw.write("print(\"Introducir el valor para B:\");\n");
				bw.write("scanf(\"%d\", &B);\n");
				//llamada a funcion interna
				bw.write("C = "+nombre+"(A, B);\n");
				//imprimir resultado
				bw.write("print(\"El resultado es: %d\", C);\n");
				bw.write("}");
				
				//Escribir funcion
				
				bw.write("\n\nint " + nombre + "(int A, int B){\n");
				
				if (accion1.equals("Repetir")){
					if(!accion2.equals("")){
						if(p1.equals("A")||p1.equals("B")||p1.equals("-A")||p1.equals("-B")){
							bw.write("int aux = " + p1+"\n");
							bw.write("int auxfin = 0\n");
							if(p1.equals("-A")){
								bw.write("A=A*(-1)");
								p1=p1.substring(1, 2);
							}
							else if(p1.equals("-B")){
								bw.write("B=B*(-1)");
								p1=p1.substring(1, 2);
							}
							//0 falso, 1 verdadero
							bw.write("while(repetirNumero(aux)==0){\n");
							bw.write("aux-=1;\n");
							bw.write("auxfin="+accion2+ "("+p3+","+p4+");\n");
							bw.write("return auxfin\n");
							bw.write("}\n");
						}
						if(p1.equals("A<B")||p1.equals("A>B")){
							bw.write("int aux = " + p3+"\n");
							bw.write("while(repetirNumero("+p3+","+p4+","+p1.substring(1, 2)+")==0){\n");
							bw.write("\taux-=1;\n");
							bw.write("\t"+accion2+ "("+p3+","+p4+");\n");
							bw.write("return auxfin\n");
							bw.write("}\n");
						}
					}
				}
				//bw.write("\t")
				else if(!accion1.equals("")){
					bw.write("int auxfin = 0\n");
					if(p1.equals("-A")){
						bw.write("A=A*(-1)");
						p1=p1.substring(1, 2);
					}
					else if(p1.equals("-B")){
						bw.write("B=B*(-1)");
						p1=p1.substring(1, 2);
					}
					bw.write("auxfin="+accion1+ "("+p1+","+p2+");\n");
					if(!accion2.equals("")){
						bw.write("auxfin+="+accion1+ "("+p3+","+p4+");\n");	
					}
					bw.write("return auxfin\n");
				}
				
				
				
				
				
				
				
				
				/*//importar resto de funciones
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
				bw.write("print(\"El resultado es: \", C)\n");*/
				
				
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
