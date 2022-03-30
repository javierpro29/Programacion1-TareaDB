import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Agregar extends JPanel {
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCargo;

	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private JComboBox CBHorario;
	
	
	
	
	public Agregar() {
		setBackground(Color.DARK_GRAY);
		setSize(791,681);
		setLayout(null);
		
		JLabel lblAgregarUnRegistro = new JLabel("Agregar un registro a la agenda de eventos", SwingConstants.CENTER);
		lblAgregarUnRegistro.setForeground(Color.WHITE);
		lblAgregarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAgregarUnRegistro.setBackground(SystemColor.textHighlight);
		lblAgregarUnRegistro.setBounds(0, 29, 790, 72);
		add(lblAgregarUnRegistro);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del evento:", SwingConstants.CENTER);
		lblIngreseLosDatos.setForeground(Color.WHITE);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIngreseLosDatos.setBackground(SystemColor.textHighlight);
		lblIngreseLosDatos.setBounds(0, 137, 790, 72);
		add(lblIngreseLosDatos);
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(28, 220, 205, 46);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(214, 220, 495, 40);
		add(txtNombre);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(28, 301, 104, 46);
		add(lblHorario);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(SystemColor.textHighlight);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(28, 378, 140, 46);
		add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(136, 384, 573, 40);
		add(txtDireccion);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(SystemColor.textHighlight);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCargo.setBounds(28, 456, 72, 46);
		add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCargo.setColumns(10);
		txtCargo.setBounds(110, 460, 274, 40);
		add(txtCargo);
		
		
		
		CBHorario = new JComboBox();
		CBHorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CBHorario.setBounds(110, 307, 241, 40);
		CBHorario.addItem("Elegir");
		CBHorario.addItem("Matutino");
		CBHorario.addItem("Vespertino");
		CBHorario.addItem("Nocturno");
		add(CBHorario);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = txtNombre.getText();
				String horario = (String) CBHorario.getSelectedItem();
				if(horario == "Elegir") {
					horario = "null";
				}
				String direccion = txtDireccion.getText();
				String cargo = txtCargo.getText();
				
				
				conexion = Conexion.conectar();
				
				try {
					
					preparedStatement = conexion
							.prepareStatement("insert into evento(nombre, horario, direccion, cargo) values(?,?,?,?)");
					
					preparedStatement.setString(1, nombre);
					preparedStatement.setString(2, horario);
					preparedStatement.setString(3, direccion);
					preparedStatement.setString(4, cargo);
					
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
						clear();
						conexion.close();
					}else{
						JOptionPane.showMessageDialog(null, "Error: el evento no se ha podido registrar correctamente. Revise los datos");
					}
					
					
				}catch(Exception i){
					System.out.println(i);
				}
				
				
			}

		});
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.setBounds(295, 564, 166, 40);
		add(btnAgregar);
	}
	
	private void clear() {
		txtNombre.setText(null);
		txtDireccion.setText(null);
		txtCargo.setText(null);
		CBHorario.setSelectedIndex(0);
	}
	
}
