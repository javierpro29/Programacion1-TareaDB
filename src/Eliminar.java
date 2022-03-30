import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Eliminar extends JPanel {
	private JTextField txtCargo;
	private JTextField txtDireccion;
	private JTextField txtNombre;
	private JTextField txtId;

	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	private JLabel lblHorario;
	private JComboBox CBHorario;
	
	public Eliminar() {
		setBackground(Color.DARK_GRAY);
		setSize(791, 681);
		setLayout(null);
		
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCargo.setColumns(10);
		txtCargo.setBounds(133, 563, 274, 40);
		add(txtCargo);
		
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
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 485, 248, 40);
		add(txtDireccion);
		
		CBHorario = new JComboBox();
		CBHorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CBHorario.setEditable(true);
		CBHorario.setBounds(133, 402, 241, 40);
		add(CBHorario);
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(51, 402, 104, 46);
		add(lblHorario);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(237, 315, 495, 40);
		add(txtNombre);
		
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
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(117, 233, 250, 40);
		add(txtId);
		
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
		
		

		JButton btnActualizar = new JButton("Eliminar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Id = txtId.getText();
				
				
				conexion = Conexion.conectar();
				
				try {
					
					preparedStatement = conexion
							.prepareStatement("delete from evento where id = ?");
					
					preparedStatement.setString(1, Id);
					
					int resultado = preparedStatement.executeUpdate();
					if(resultado > 0) {
						JOptionPane.showMessageDialog(null, "Evento Eliminado correctamente");
						clear();
						conexion.close();
					}else{
						JOptionPane.showMessageDialog(null, "Error: el evento no se ha podido eliminar correctamente. Revise los datos");
					}
					
					
				}catch(Exception i){
					System.out.println(i);
				}
				
				
			}
		});
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setBounds(295, 630, 166, 40);
		add(btnActualizar);
		
		
	}
	
	private void clear() {
		txtNombre.setText(null);
		txtDireccion.setText(null);
		txtCargo.setText(null);
		CBHorario.setSelectedIndex(0);
	}

}
