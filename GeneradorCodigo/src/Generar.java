import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generar {
	public static void crearFuncion (String nombre, String accion1, String accion2, String p1, String p2, String p3, String p4) {
		ControlarNombre(nombre);

		//FUNCION hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
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

				//Declarar funcion
				bwh.write("\n\n\nint " + nombre + "(int A, int B);\n\n\n");


				//Escribir funcion nueva
				bwh.write("\n\nint " + nombre + "(int A, int B){\n");
				
				if (accion1.equals("Repetir")){
					if(!accion2.equals("")){
						if(p1.equals("A")||p1.equals("B")||p1.equals("-A")||p1.equals("-B")){
							//auxiliares
							bwh.write("\tint aux = " + p1+";\n");
							bwh.write("\tint auxfin = 0;\n");
							//variables negativas
							if(p1.equals("-A")){
								bwh.write("\tA = A * (-1);\n");
								p1=p1.substring(1, 2);
							}
							else if(p1.equals("-B")){
								bwh.write("\tB = B * (-1);\n");
								p1=p1.substring(1, 2);
							}
							//0 falso, 1 verdadero
							bwh.write("\twhile(repetirNumero(aux)==0){\n");
							bwh.write("\t\taux-=1;\n");
							bwh.write("\t\tauxfin="+accion2+ "("+p3+",auxfin);\n");
							bwh.write("\t}\n");
							bwh.write("\treturn auxfin;\n");
							bwh.write("}\n");
						}
						if(p1.equals("A<B")||p1.equals("A>B")){
							bwh.write("\tint aux = " + p3+"\n");
							bwh.write("\tint auxfin = 0;\n");
							bwh.write("\twhile(repetirNumero(aux,"+p4+","+p1.substring(1, 2)+")==0){\n");
							bwh.write("\t\taux-=1;\n");
							bwh.write("\t\t"+accion2+ "("+p3+","+p4+");\n");
							bwh.write("\t}\n");
							bwh.write("\treturn auxfin;\n");
							bwh.write("}\n");
						}
					}
				}
				else if(!accion1.equals("")){
					bwh.write("\tint auxfin = 0;\n");
					//variables negativas
					if(p1.equals("-A")){
						bwh.write("\tA = A * (-1);\n");
						p1=p1.substring(1, 2);
					}
					else if(p1.equals("-B")){
						bwh.write("\tB = B * (-1);\n");
						p1=p1.substring(1, 2);
					}
					if(p2.equals("-A")){
						bwh.write("\tA = A * (-1);\n");
						p2=p2.substring(1, 2);
					}
					else if(p2.equals("-B")){
						bwh.write("\tB = B * (-1);\n");
						p2=p2.substring(1, 2);
					}
					bwh.write("\tauxfin="+accion1+ "("+p1+","+p2+");\n");
					if(!accion2.equals("")){
						bwh.write("\tauxfin+="+accion1+ "("+p3+","+p4+");\n");	
					}
					bwh.write("\treturn auxfin;\n");
					bwh.write("}");
				}
				bwh.close();
			} catch (IOException e) {
				System.out.println("SE FUE TODO A LA PUTA :(");
				System.exit(0);
			}
		}	



		//FUNCION cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
		String dirc = "./Func/" + nombre + ".c";
		File fc = new File(dirc);
		BufferedWriter bwc;
		if (fc.exists())
			System.out.println("ESA FUNCIÓN YA EXISTE");
		else {
			try {
				bwc = new BufferedWriter(new FileWriter(fc));
				//importar funcion .h
				bwc.write("#include <stdio.h>\n");
				bwc.write("#include <stdlib.h>\n");
				
				//Declarar funcion
				bwc.write("#include \"" + nombre + ".h\"");
				
				//main
				bwc.write("\n\n\nint main(int argc, char *argv[]){\n");
				bwc.write("\tint A, B, C;\n");
				bwc.write("\tprintf(\"Introducir el valor para A:\");\n");
				bwc.write("\tscanf(\"%d\", &A);\n");
				bwc.write("\tprintf(\"Introducir el valor para B:\");\n");
				bwc.write("\tscanf(\"%d\", &B);\n");
				//llamada a funcion interna
				bwc.write("\tC = "+nombre+"(A, B);\n");
				//imprimir resultado
				bwc.write("\tprintf(\"El resultado es: %d\", C);\n");
				bwc.write("}");

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
