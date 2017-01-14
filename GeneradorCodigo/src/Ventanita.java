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

public class Ventanita {

	private JFrame frame;
	private JTextField nombreFuncion;
	private JComboBox<String> funcion1CB;
	private JComboBox<String> funcion2CB;

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
		funcion1CB = new JComboBox<String>();
		funcion1CB.setBounds(58, 169, 172, 22);
		frame.getContentPane().add(funcion1CB);

		funcion2CB = new JComboBox<String>();
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
		crearFuncionBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nombre = nombreFuncion.getText();
				String accion1 = funcion1CB.getSelectedItem().toString();
				String accion2 = funcion2CB.getSelectedItem().toString();
				String p1 = variable1.getSelectedItem().toString();
				String p2 = variable2.getSelectedItem().toString();
				String p3 = variable3.getSelectedItem().toString();
				String p4 = variable4.getSelectedItem().toString();
				System.out.println("Los valores introducidos son:\n\t"+nombre+", "+accion1+", "+accion2+", "+p1+", "+p2+", "+p3+", "+p4);
				Generar.crearFuncion(nombre,accion1,accion2,p1,p2,p3,p4);
				actualizarComboBox();
			}
		});
		
		crearFuncionBoton.setBounds(229, 312, 97, 47);
		frame.getContentPane().add(crearFuncionBoton);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nombreFuncion, funcion1CB, funcion2CB, crearFuncionBoton}));
		
		//A�ADIR OPCIONES COMBO BOX PEQUE�OS
		String[] combobox = {"", "A", "B", "-A", "-B", "A<B", "A>B"};
		for(int i=0; i<combobox.length;i++){
			variable1.addItem(combobox[i]);
			variable2.addItem(combobox[i]);
			variable3.addItem(combobox[i]);
			variable4.addItem(combobox[i]);
		}

		/*	AÑADIR OPCIONES COMBO BOX GRANDES	*/
		actualizarComboBox();	
	}

	private void actualizarComboBox () {
		File f = new File("./Func");
		String[] ficheros = f.list();
		if (ficheros == null)
			System.out.println("NO HAY, VETE A LA MIERDA :D");
		else {
			funcion1CB.removeAllItems();
			funcion2CB.removeAllItems();
			funcion1CB.addItem("");
			funcion2CB.addItem("");
			for (int i = 0; i < ficheros.length; i++){
				if (ficheros[i].charAt(ficheros[i].length() - 1) == 'h'){
					funcion1CB.addItem(ficheros[i].substring(0, ficheros[i].length() - 2));
					funcion2CB.addItem(ficheros[i].substring(0, ficheros[i].length() - 2));
				}
			}
		}
		frame.repaint();
	}
	
	
}
