import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Actualizar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Actualizar() {
		setBackground(Color.DARK_GRAY);
		setSize(791, 681);
		setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(51, 219, 106, 46);
		add(lblId);
		
		JLabel lblIngreseElId_1 = new JLabel("Ingrese el ID del evento que desea actualizar:", SwingConstants.CENTER);
		lblIngreseElId_1.setForeground(Color.WHITE);
		lblIngreseElId_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIngreseElId_1.setBackground(SystemColor.textHighlight);
		lblIngreseElId_1.setBounds(0, 128, 790, 72);
		add(lblIngreseElId_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(117, 225, 250, 40);
		add(textField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(401, 225, 166, 40);
		add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(51, 307, 205, 46);
		add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(237, 307, 495, 40);
		add(textField_1);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(51, 394, 104, 46);
		add(lblHorario);
		
		JComboBox CBHorario = new JComboBox();
		CBHorario.setBounds(133, 394, 241, 40);
		add(CBHorario);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(SystemColor.textHighlight);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(51, 471, 140, 46);
		add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(159, 477, 248, 40);
		add(textField_2);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(SystemColor.textHighlight);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCargo.setBounds(51, 549, 72, 46);
		add(lblCargo);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(133, 555, 274, 40);
		add(textField_3);
		
		JLabel lblActualizarUnRegistro = new JLabel("Actualizar un registro dentro de la agenda", SwingConstants.CENTER);
		lblActualizarUnRegistro.setForeground(Color.WHITE);
		lblActualizarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblActualizarUnRegistro.setBackground(SystemColor.textHighlight);
		lblActualizarUnRegistro.setBounds(0, 24, 790, 72);
		add(lblActualizarUnRegistro);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setBounds(295, 622, 166, 40);
		add(btnActualizar);
	}

}
