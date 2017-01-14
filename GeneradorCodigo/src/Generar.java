import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generar {
	public static void crearFuncion (String nombre, String accion1, String accion2, String p1, String p2, String p3, String p4) {
		ControlarNombre(nombre);

		//HEATHER
		String dirh = "./Func/" + nombre + ".h";
		File fh = new File(dirh);
		BufferedWriter bwh;
		if (fh.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE");
		else {
			try {
				bwh = new BufferedWriter(new FileWriter(fh));
				//importar resto de funciones 
				bwh.write("#include <stdio.h>\n");
				bwh.write("#include <stdlib.h>\n");
				File f2 = new File("./Func");
				String[] ficheros = f2.list();
				for (int i = 0; i < ficheros.length; i++){
					if (ficheros[i].charAt(ficheros[i].length() - 1) == 'h')
						if (!ficheros[i].equals(nombre + ".h"))
							bwh.write("#include \""+ ficheros[i] +"\"\n");
				}

				//Declarar funcion y main

				
				/*
				bwh.write("\n\n\nint " + nombre + "(int A, int B);\n\n\n");

				bwh.write("\n\n\nint main(int argc, char *argv[]){\n");
				bwh.write("printf(\"Introducir el valor para A:\");\n");
				bwh.write("int A, B, C;\n");
				bwh.write("scanf(\"%d\", &A);\n");
				bwh.write("printf(\"Introducir el valor para B:\");\n");
				bwh.write("scanf(\"%d\", &B);\n");
				//llamada a funcion interna
				bwh.write("C = "+nombre+"(A, B);\n");
				//imprimir resultado
				bwh.write("printf(\"El resultado es: %d\", C);\n");
				bwh.write("}");
				
				
				*/

				//Escribir funcion

				bwh.write("\n\nint " + nombre + "(int A, int B){\n");
				
				if (accion1.equals("Repetir")){
					if(!accion2.equals("")){
						if(p1.equals("A")||p1.equals("B")||p1.equals("-A")||p1.equals("-B")){
							bwh.write("int aux = " + p1+";\n");
							bwh.write("int auxfin = 0;\n");
							if(p1.equals("-A")){
								bwh.write("A=A*(-1);\n");
								p1=p1.substring(1, 2);
							}
							else if(p1.equals("-B")){
								bwh.write("B=B*(-1);\n");
								p1=p1.substring(1, 2);
							}
							//0 falso, 1 verdadero
							bwh.write("while(repetirNumero(aux)==0){\n");
							bwh.write("aux-=1;\n");
							bwh.write("auxfin="+accion2+ "("+p3+","+p4+");\n");
							bwh.write("return auxfin;\n");
							bwh.write("}\n");
						}
						if(p1.equals("A<B")||p1.equals("A>B")){
							bwh.write("int aux = " + p3+"\n");
							bwh.write("while(repetirNumero("+p3+","+p4+","+p1.substring(1, 2)+")==0){\n");
							bwh.write("\taux-=1;\n");
							bwh.write("\t"+accion2+ "("+p3+","+p4+");\n");
							bwh.write("return auxfin;\n");
							bwh.write("}\n");
						}
					}
				}
				//bw.write("\t")
				else if(!accion1.equals("")){
					bwh.write("int auxfin = 0;\n");
					if(p1.equals("-A")){
						bwh.write("A=A*(-1);\n");
						p1=p1.substring(1, 2);
					}
					else if(p1.equals("-B")){
						bwh.write("B=B*(-1);\n");
						p1=p1.substring(1, 2);
					}
					bwh.write("auxfin="+accion1+ "("+p1+","+p2+");\n");
					if(!accion2.equals("")){
						bwh.write("auxfin+="+accion1+ "("+p3+","+p4+");\n");	
					}
					bwh.write("return auxfin;\n");
					bwh.write("}");
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


				bwh.close();
			} catch (IOException e) {
				System.out.println("SE FUE TODO A LA PUTA :(");
				System.exit(0);
			}
		}	



		//FUNCION MAIN
		String dirc = "./Func/" + nombre + ".c";
		File fc = new File(dirc);
		BufferedWriter bwc;
		if (fc.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE");
		else {
			try {
				bwc = new BufferedWriter(new FileWriter(fc));
				//importar resto de funciones 
				bwc.write("#include <stdio.h>\n");
				bwc.write("#include <stdlib.h>\n");
				bwc.write("#include \"" + nombre + ".h\"");
				
				/*
				File f2 = new File("./Func");
				String[] ficheros = f2.list();
				for (int i = 0; i < ficheros.length; i++){
					if (ficheros[i].charAt(ficheros[i].length() - 1) == 'h')
						bwc.write("#include \""+ ficheros[i] +"\"\n");
				}*/

				//Declarar funcion y main

				bwc.write("\n\n\nint main(int argc, char *argv[]){\n");
				bwc.write("printf(\"Introducir el valor para A:\");\n");
				bwc.write("int A, B, C;\n");
				bwc.write("scanf(\"%d\", &A);\n");
				bwc.write("printf(\"Introducir el valor para B:\");\n");
				bwc.write("scanf(\"%d\", &B);\n");
				//llamada a funcion interna
				bwc.write("C = "+nombre+"(A, B);\n");
				//imprimir resultado
				bwc.write("printf(\"El resultado es: %d\", C);\n");
				bwc.write("}");

				//Escribir funcion
				
				/*

				bwc.write("\n\nint " + nombre + "(int A, int B){\n");

				if (accion1.equals("Repetir")){
					if(!accion2.equals("")){
						if(p1.equals("A")||p1.equals("B")||p1.equals("-A")||p1.equals("-B")){
							bwc.write("int aux = " + p1+";\n");
							bwc.write("int auxfin = 0;\n");
							if(p1.equals("-A")){
								bwc.write("A=A*(-1);\n");
								p1=p1.substring(1, 2);
							}
							else if(p1.equals("-B")){
								bwc.write("B=B*(-1);\n");
								p1=p1.substring(1, 2);
							}
							//0 falso, 1 verdadero
							bwc.write("while(repetirNumero(aux)==0){\n");
							bwc.write("aux-=1;\n");
							bwc.write("auxfin="+accion2+ "("+p3+","+p4+");\n");
							bwc.write("return auxfin;\n");
							bwc.write("}\n");
						}
						if(p1.equals("A<B")||p1.equals("A>B")){
							bwc.write("int aux = " + p3+"\n");
							bwc.write("while(repetirNumero("+p3+","+p4+","+p1.substring(1, 2)+")==0){\n");
							bwc.write("\taux-=1;\n");
							bwc.write("\t"+accion2+ "("+p3+","+p4+");\n");
							bwc.write("return auxfin;\n");
							bwc.write("}\n");
						}
					}
				}
				//bw.write("\t")
				else if(!accion1.equals("")){
					bwc.write("int auxfin = 0;\n");
					if(p1.equals("-A")){
						bwc.write("A=A*(-1);\n");
						p1=p1.substring(1, 2);
					}
					else if(p1.equals("-B")){
						bwc.write("B=B*(-1);\n");
						p1=p1.substring(1, 2);
					}
					bwc.write("auxfin="+accion1+ "("+p1+","+p2+");\n");
					if(!accion2.equals("")){
						bwc.write("auxfin+="+accion1+ "("+p3+","+p4+");\n");	
					}
					bwc.write("return auxfin;\n");
					bwc.write("}");
				}
				*/

				bwc.close();
			} catch (IOException e) {
				System.out.println("SE FUE TODO A LA PUTA :(");
				System.exit(0);
			}
		}



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
