import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class Eliminar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Eliminar() {
		setBackground(Color.DARK_GRAY);
		setSize(791, 681);
		setLayout(null);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setBounds(295, 630, 166, 40);
		add(btnActualizar);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 563, 274, 40);
		add(textField);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(SystemColor.textHighlight);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCargo.setBounds(51, 557, 72, 46);
		add(lblCargo);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(SystemColor.textHighlight);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(51, 479, 140, 46);
		add(lblDireccion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 485, 248, 40);
		add(textField_1);
		
		JComboBox CBHorario = new JComboBox();
		CBHorario.setEditable(true);
		CBHorario.setBounds(133, 402, 241, 40);
		add(CBHorario);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(51, 402, 104, 46);
		add(lblHorario);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(237, 315, 495, 40);
		add(textField_2);
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(51, 315, 205, 46);
		add(lblNombre);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(51, 227, 106, 46);
		add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(117, 233, 250, 40);
		add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(401, 233, 166, 40);
		add(btnBuscar);
		
		JLabel lblIngreseElId_1 = new JLabel("Ingrese el ID del evento que desea eliminar:", SwingConstants.CENTER);
		lblIngreseElId_1.setForeground(Color.WHITE);
		lblIngreseElId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIngreseElId_1.setBackground(SystemColor.textHighlight);
		lblIngreseElId_1.setBounds(0, 136, 790, 72);
		add(lblIngreseElId_1);
		
		JLabel lblEliminarUnRegistro = new JLabel("Eliminar un registro dentro de la agenda", SwingConstants.CENTER);
		lblEliminarUnRegistro.setForeground(Color.WHITE);
		lblEliminarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEliminarUnRegistro.setBackground(SystemColor.textHighlight);
		lblEliminarUnRegistro.setBounds(0, 32, 790, 72);
		add(lblEliminarUnRegistro);
	}

}
