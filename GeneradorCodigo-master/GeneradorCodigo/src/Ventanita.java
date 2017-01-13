import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventanita {

	private JFrame frame;
	private JTextField nombreFuncion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanita window = new Ventanita();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventanita() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//FRAME
		
		frame = new JFrame();
		frame.setBounds(50, 50, 600, 450);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//VARIABLES GRANDES
		
		JComboBox<String> funcion1CB = new JComboBox<String>();
		funcion1CB.setBounds(58, 169, 172, 22);
		frame.getContentPane().add(funcion1CB);

		JComboBox<String> funcion2CB = new JComboBox<String>();
		funcion2CB.setBounds(324, 169, 172, 22);
		frame.getContentPane().add(funcion2CB);

		nombreFuncion = new JTextField();
		nombreFuncion.setBounds(58, 106, 438, 22);
		frame.getContentPane().add(nombreFuncion);
		nombreFuncion.setColumns(10);

		//VARIABLES PEQUE�AS

		JComboBox<String> variable1 = new JComboBox<String>();
		variable1.setBounds(58, 237, 70, 25);
		frame.getContentPane().add(variable1);

		JComboBox<String> variable2 = new JComboBox<String>();
		variable2.setBounds(160, 238, 70, 25);
		frame.getContentPane().add(variable2);

		JComboBox<String> variable3 = new JComboBox<String>();
		variable3.setBounds(324, 238, 70, 25);
		frame.getContentPane().add(variable3);

		JComboBox<String> variable4 = new JComboBox<String>();
		variable4.setBounds(426, 238, 70, 25);
		frame.getContentPane().add(variable4);
		
		//BOTON

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
				String nombre = nombreFuncion.getText();
				String accion1 = funcion1CB.getSelectedItem().toString();
				String accion2 = funcion2CB.getSelectedItem().toString();
				String p1 = variable1.getSelectedItem().toString();
				String p2 = variable2.getSelectedItem().toString();
				String p3 = variable3.getSelectedItem().toString();
				String p4 = variable4.getSelectedItem().toString();
				System.out.println("Los valores introducidos son:\n\t"+nombre+", "+accion1+", "+accion2+", "+p1+", "+p2+", "+p3+", "+p4);
				Generar.crearFuncion(nombre,accion1,accion2,p1,p2,p3,p4);
			}
		});
		
		crearFuncionBoton.setBounds(229, 312, 97, 47);
		frame.getContentPane().add(crearFuncionBoton);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nombreFuncion, funcion1CB, funcion2CB, crearFuncionBoton}));
		//A�ADIR OPCIONES COMBO BOX PEQUE�OS
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
		File f = new File("./GeneradorCodigo/Funciones");

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
	
	
}
