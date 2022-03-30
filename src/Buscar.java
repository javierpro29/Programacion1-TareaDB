import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buscar extends JPanel {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCargo;

	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	public Buscar() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 791, 681);
		setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar un registro dentro de la agenda", SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBuscar.setBackground(new Color(0, 120, 215));
		lblBuscar.setBounds(0, 38, 790, 72);
		add(lblBuscar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(51, 233, 106, 46);
		add(lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtId.setColumns(10);
		txtId.setBounds(117, 239, 250, 40);
		add(txtId);
		
		JLabel lblIngreseElId = new JLabel("Ingrese el ID del evento que desea buscar:", SwingConstants.CENTER);
		lblIngreseElId.setForeground(Color.WHITE);
		lblIngreseElId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIngreseElId.setBackground(SystemColor.textHighlight);
		lblIngreseElId.setBounds(0, 142, 790, 72);
		add(lblIngreseElId);
		
		JLabel lblNombre = new JLabel("Nombre del evento:");
		lblNombre.setForeground(SystemColor.textHighlight);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(51, 321, 205, 46);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(237, 321, 495, 40);
		add(txtNombre);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setForeground(SystemColor.textHighlight);
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHorario.setBounds(51, 402, 104, 46);
		add(lblHorario);
		
		JComboBox CBHorario = new JComboBox();
		CBHorario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CBHorario.setBounds(133, 408, 241, 40);
		add(CBHorario);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(SystemColor.textHighlight);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setBounds(51, 479, 140, 46);
		add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(159, 485, 573, 40);
		add(txtDireccion);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(SystemColor.textHighlight);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCargo.setBounds(51, 557, 72, 46);
		add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCargo.setEditable(false);
		txtCargo.setColumns(10);
		txtCargo.setBounds(133, 573, 274, 40);
		add(txtCargo);
		
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = txtId.getText();
				
				conexion = Conexion.conectar();
				
				try {
					//preparedStatement = conexion.prepareStatement("select(nombre) from evento where('"+id+"')");
					
					//preparedStatement.setString(1, id);
					
					
					
					
					/*resultSet = preparedStatement.executeQuery();
					
					if(resultSet.next()) {
						System.out.println(id);
						System.out.println(resultSet.getString("nombre"));
	
					}else {
						
					}*/
					
				
					preparedStatement = conexion.prepareStatement("select * from evento where id = ?");
					
					preparedStatement.setString(1, id);
					
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						   for (int x=1;x<=resultSet.getMetaData().getColumnCount();x++)
						     System.out.print(resultSet.getString(x)+ "\t");
						   
						   System.out.println(""); 
						   
						/*
						String a = resultSet.getString("nombre");
						System.out.println("El valor de a es:"+a);
						
						String d = resultSet.getString("horario");
						System.out.println(d);
						
						String b = resultSet.getString("direccion");
						System.out.println("El valor de b es:"+a);
						
						String c = resultSet.getString("cargo");
						System.out.println("El valor de a es:"+c);
						*/
						
						
						
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
		btnBuscar.setBounds(401, 239, 166, 40);
		add(btnBuscar);
		
		
	}
}
