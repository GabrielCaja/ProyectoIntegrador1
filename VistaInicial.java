package ProyectoIntegrador;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import java.awt.Color;

public class VistaInicial {

	JFrame frame;
	private Button button_1;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel modelo;
	// Gestor de los Recursos
	private Recursos recursos = new Recursos();
	private ArrayList<Recursos> listaDisponibles = new ArrayList<>();
	// Creamos la lista de no disponibles
	private ArrayList<Recursos> listaNoDisponibles = new ArrayList<>();

	static VistaInicial window = new VistaInicial();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public VistaInicial() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Estadisticas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(139, 23, 146, 35);
		frame.getContentPane().add(lblNewLabel);

		// añadismos la lista de recursos a la lista local
		listaDisponibles = recursos.getListaDisponibles();
		listaNoDisponibles = recursos.getListaNoDisponibles();

		// Creamos la lista de diasponibles

		System.out.println(listaDisponibles);

		// listaDisponibles.get(0).getNombre()
		modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Ubicacion", "Fecha", "codigoPostal", "disponibilidad" });

		// Recursos
		Recursos batmovil = new Recursos("Batmovil", "Gotam", "27/02/1924", 67425, false,1);
		Recursos batCinturon = new Recursos("Bat Cinturon", "Gotam", "27/02/1924", 67425, false,2);
		Recursos bastonAbuela = new Recursos("Baston de la abuela", "NYC", "19/04/1965", 38402, false,2);
		Recursos chancla = new Recursos("Chancla", "Bogota", "18/12/1999", 33202, false,3);
		Recursos capaSuperman = new Recursos("Capa de Superman", "LongVille", "12/02/1979", 49310, false,4);
		Recursos raton = new Recursos("Lab Rat (Eduardo)", "EEUU", "10/01/1889", 37921, false,5);

		recursos.anadirDis(batmovil);
		recursos.anadirDis(batCinturon);
		recursos.anadirDis(bastonAbuela);
		recursos.anadirDis(chancla);
		recursos.anadirDis(capaSuperman);
		recursos.anadirDis(raton);
		// Innicializar datos metodo
		Object[] obj = new Object[5];

		// inicializamos datos en la tabla
		inicializarDatos();

		// Volver
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cerrarVista();
			}
		});
		btnNewButton_1.setBounds(176, 382, 80, 21);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Ver Recursos");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				mostrarDisponibles();

			}
		});
		btnNewButton_1_1.setBounds(139, 350, 146, 21);
		frame.getContentPane().add(btnNewButton_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 80, 344, 188);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		table_1.setModel(modelo);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 255, 0));
		progressBar.setBounds(49, 291, 344, 14);
		frame.getContentPane().add(progressBar);
		
		
		JLabel lblNewLabel_1 = new JLabel("0");
		lblNewLabel_1.setBounds(49, 279, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("5");
		lblNewLabel_1_1.setBounds(386, 279, 19, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Ver Estadisticas");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int val = 0;
				val = verEstadisticas(textField.getText());
				System.out.println(val);
				progressBar.setValue(val*20);
			}
		});
		btnNewButton.setBounds(273, 316, 120, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(75, 320, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(119, 316, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

	}

	// mostrar los recursos
	public void mostrarDisponibles() {
		// Innicializar datos metodo
		Object[] obj = new Object[5];

		// Vaciamos la tabla
		vaciarTabla(table_1);

		for (int i = 0; i < listaDisponibles.size(); i++) {

			obj[0] = listaDisponibles.get(i).getNombre();
			obj[1] = listaDisponibles.get(i).getUbicacion();
			obj[2] = listaDisponibles.get(i).getFecha();
			obj[3] = listaDisponibles.get(i).getCodigoPostal();
			obj[4] = listaDisponibles.get(i).getDisponibilidad();

			modelo.addRow(obj);

		}
	}

	public void inicializarDatos() {

		Object[] obj = new Object[5];

		for (int i = 0; i < listaDisponibles.size(); i++) {

			obj[0] = "";
			obj[1] = "";
			obj[2] = "";
			obj[3] = "";
			obj[4] = "";

			modelo.addRow(obj);

		}
	}

	public void vaciarTabla(JTable table) {
		DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		int filas = table.getRowCount();

		for (int i = 0; filas > i; i++) {
			tabla.removeRow(0);
		}
	}
	
	public void cerrarVista() {

		window.frame.setVisible(false);

	}

	public void abrirVista() {

		window.frame.setVisible(true);

	}
	
	public Integer verEstadisticas(String nombre) {
		int valoracion = 0 ;
		for (int i = 0; i < listaDisponibles.size(); i++) {
			if (nombre.toLowerCase() .equals((listaDisponibles.get(i).getNombre()).toLowerCase()) ) {
				 valoracion = listaDisponibles.get(i).getVal();
			}
		}
		return valoracion;
		
	}
	

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public JTable getTable() {
		return getTable();
	}
}
