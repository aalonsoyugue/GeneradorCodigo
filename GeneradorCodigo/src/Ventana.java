import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana {

	private JFrame frame;
	private JTextField nombreFuncion;
	
	private static String nombre, accion1, accion2, p1, p2MASk2, p3, p4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox funcion1CB = new JComboBox();
		funcion1CB.setBounds(58, 169, 172, 22);
		frame.getContentPane().add(funcion1CB);

		JComboBox funcion2CB = new JComboBox();
		funcion2CB.setBounds(324, 169, 172, 22);
		frame.getContentPane().add(funcion2CB);

		nombreFuncion = new JTextField();
		nombreFuncion.setBounds(58, 106, 438, 22);
		frame.getContentPane().add(nombreFuncion);
		nombreFuncion.setColumns(10);

		JButton crearFuncionBoton = new JButton("Crear");
		crearFuncionBoton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				System.out.println("Hago algo en mi vida.");
			}
		});
		crearFuncionBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Hago algo en mi vida.");
				nombre = nombreFuncion.getText();
				//accion1 = funcion1CB.
				//accion2 = 
				//p1
				//p2MASk2
				//p3
				//p4
				crearFuncion();
			}
		});
		
		crearFuncionBoton.setBounds(229, 312, 97, 47);
		frame.getContentPane().add(crearFuncionBoton);

		JComboBox variable1 = new JComboBox();
		variable1.setBounds(58, 237, 70, 25);
		frame.getContentPane().add(variable1);

		JComboBox variable2 = new JComboBox();
		variable2.setBounds(160, 238, 70, 25);
		frame.getContentPane().add(variable2);

		JComboBox variable3 = new JComboBox();
		variable3.setBounds(324, 238, 70, 25);
		frame.getContentPane().add(variable3);

		JComboBox variable4 = new JComboBox();
		variable4.setBounds(426, 238, 70, 25);
		frame.getContentPane().add(variable4);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nombreFuncion, funcion1CB, funcion2CB, crearFuncionBoton}));

		/*	AÑADIR OPCIONES COMBO BOX PEQUEÑOS	*/

		variable1.addItem("");
		variable1.addItem("A");
		variable1.addItem("B");
		variable1.addItem("A>B");
		variable1.addItem("A<B");

		variable2.addItem("");
		variable2.addItem("A");
		variable2.addItem("B");
		variable2.addItem("A>B");
		variable2.addItem("A<B");

		variable3.addItem("");
		variable3.addItem("A");
		variable3.addItem("B");
		variable3.addItem("A>B");
		variable3.addItem("A<B");

		variable4.addItem("");
		variable4.addItem("A");
		variable4.addItem("B");
		variable4.addItem("A>B");
		variable4.addItem("A<B");


		/*	AÑADIR OPCIONES COMBO BOX GRANDES	*/

		actualizarComboBox(funcion1CB, funcion2CB);
		
		
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void actualizarComboBox (JComboBox funcion1CB, JComboBox funcion2CB) {
		File f = new File("./Funciones");

		String[] ficheros = f.list();

		if (ficheros == null)
			System.out.println("NO HAY, VETE A LA MIERDA :D");
		else {
			for (int i = 0; i < ficheros.length; i++){
				funcion1CB.addItem(ficheros[i].substring(0, ficheros[i].length() - 3));
				funcion2CB.addItem(ficheros[i].substring(0, ficheros[i].length() - 3));
			}
		}
		
		frame.repaint();
	}
	
	
	private void crearFuncion () {
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
