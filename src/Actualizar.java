import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Actualizar extends JPanel {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCargo;
	private JComboBox CBHorario;
	
	
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
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
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setColumns(10);
		txtId.setBounds(117, 225, 250, 40);
		add(txtId);
		
		
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(51, 307, 205, 46);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(237, 307, 495, 40);
		add(txtNombre);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(51, 394, 104, 46);
		add(lblHorario);
		
		CBHorario = new JComboBox();
		CBHorario.setEditable(true);
		CBHorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CBHorario.setBounds(133, 394, 241, 40);
		CBHorario.addItem("Elegir");
		CBHorario.addItem("Matutino");
		CBHorario.addItem("Vespertino");
		CBHorario.addItem("Nocturno");
		add(CBHorario);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(SystemColor.textHighlight);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(51, 471, 140, 46);
		add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 477, 248, 40);
		add(txtDireccion);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(SystemColor.textHighlight);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCargo.setBounds(51, 549, 72, 46);
		add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCargo.setColumns(10);
		txtCargo.setBounds(133, 555, 274, 40);
		add(txtCargo);
		
		JLabel lblActualizarUnRegistro = new JLabel("Actualizar un registro dentro de la agenda", SwingConstants.CENTER);
		lblActualizarUnRegistro.setForeground(Color.WHITE);
		lblActualizarUnRegistro.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblActualizarUnRegistro.setBackground(SystemColor.textHighlight);
		lblActualizarUnRegistro.setBounds(0, 24, 790, 72);
		add(lblActualizarUnRegistro);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				
				conexion = Conexion.conectar();
				
				try {
					preparedStatement = conexion.prepareStatement("select * from evento where id = ?");
					
					preparedStatement.setString(1, id);
					
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						   for (int x=1;x<=resultSet.getMetaData().getColumnCount();x++)
						     System.out.print(resultSet.getString(x)+ "\t");
						   
						   System.out.println(""); 
					
						   txtNombre.setText(resultSet.getString("nombre"));
						   CBHorario.addItem(resultSet.getString("Horario"));
						   txtDireccion.setText(resultSet.getString("direccion"));
						   txtCargo.setText(resultSet.getString("cargo"));
						}
						
					
						
					}catch(Exception i) {
						System.out.println(i);
						
					}
					
				}
				
		});
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(401, 225, 166, 40);
		add(btnBuscar);
		
		
		
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Id = txtId.getText();
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
							.prepareStatement("update evento set nombre = ?, horario = ?, direccion = ?, cargo = ? where id = ?");
					
					preparedStatement.setString(1, nombre);
					preparedStatement.setString(2, horario);
					preparedStatement.setString(3, direccion);
					preparedStatement.setString(4, cargo);
					preparedStatement.setString(5, Id);
					
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Evento actualizado correctamente");
						clear();
						conexion.close();
					}else{
						JOptionPane.showMessageDialog(null, "Error: el evento no se ha podido actualizar correctamente. Revise los datos");
					}
					
					
				}catch(Exception i){
					System.out.println(i);
				}
				
				
			}
		});
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setBounds(295, 622, 166, 40);
		add(btnActualizar);
	}
	
	
	
	private void clear() {
		txtNombre.setText(null);
		txtDireccion.setText(null);
		txtCargo.setText(null);
		CBHorario.setSelectedIndex(0);
	}

}
