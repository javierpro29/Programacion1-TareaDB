import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frame;
	private JDesktopPane Vista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1080, 720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 273, 681);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setBounds(22, 167, 251, 284);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAgregar = new JLabel("Agregar");
		lblAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agregar agregar = new Agregar();
				showpane(agregar);
			}
		});
		lblAgregar.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/add (1).png")));
		lblAgregar.setForeground(Color.WHITE);
		lblAgregar.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAgregar.setBounds(10, 11, 227, 55);
		panel_3.add(lblAgregar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Buscar buscar = new Buscar();
				showpane(buscar);
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/search.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(10, 77, 227, 55);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Actualizar");
		lblNewLabel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Actualizar actualizar = new Actualizar();
				showpane(actualizar);
			}
		});
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/actualizar.png")));
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(10, 143, 227, 55);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Eliminar");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Eliminar eliminar = new Eliminar();
				showpane(eliminar);
			}
		});
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/eliminar.png")));
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(10, 209, 227, 55);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 537, 273, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(0, 151, 273, 2);
		panel_1.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inicio inicio = new Inicio();
				showpane(inicio);
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/inicio.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(22, 91, 227, 55);
		panel_1.add(lblNewLabel);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblSalir.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/salir (1).png")));
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSalir.setBounds(28, 550, 227, 55);
		panel_1.add(lblSalir);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(Color.WHITE);
		separator_1_1.setBounds(0, 621, 273, 2);
		panel_1.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBackground(Color.WHITE);
		separator_1_2.setBounds(0, 78, 273, 2);
		panel_1.add(separator_1_2);
		
		JLabel lblPerfilDelEstudiante = new JLabel("Perfil del estudiante");
		lblPerfilDelEstudiante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Perfil perfil = new Perfil();
				showpane(perfil);
			}
		});
		lblPerfilDelEstudiante.setIcon(new ImageIcon(Main.class.getResource("/Imagenes/user (1).png")));
		lblPerfilDelEstudiante.setForeground(Color.WHITE);
		lblPerfilDelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPerfilDelEstudiante.setBounds(0, 471, 273, 55);
		panel_1.add(lblPerfilDelEstudiante);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBackground(Color.WHITE);
		separator_1_2_1.setBounds(0, 458, 273, 2);
		panel_1.add(separator_1_2_1);
		
		Vista = new JDesktopPane();
		Vista.setBounds(273, 0, 791, 681);
		panel.add(Vista);
		
		Inicio inicio = new Inicio();
		showpane(inicio);
	}
	
	
	
	private void showpane(JPanel a){
		a.setSize(791, 681);
		a.setLocation(0, 0);
	
		Vista.removeAll();
		Vista.add(a, BorderLayout.CENTER);
		Vista.revalidate();
		Vista.repaint();
	}
}
