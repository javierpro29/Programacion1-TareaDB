import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Perfil extends JPanel {
	private JTable table;

	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet rs = null;

	private DefaultTableModel modelo;

	public Perfil() {
		setBackground(Color.DARK_GRAY);
		setSize(791, 681);
		setLayout(null);
		
		JLabel lblPerfilDelEstudiante = new JLabel("Perfil del estudiante", SwingConstants.CENTER);
		lblPerfilDelEstudiante.setForeground(Color.WHITE);
		lblPerfilDelEstudiante.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPerfilDelEstudiante.setBackground(SystemColor.textHighlight);
		lblPerfilDelEstudiante.setBounds(0, 56, 790, 72);
		add(lblPerfilDelEstudiante);
		
		JLabel lblEventosRegistrados = new JLabel("Eventos Registrados:", SwingConstants.LEFT);
		lblEventosRegistrados.setForeground(SystemColor.textHighlight);
		lblEventosRegistrados.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEventosRegistrados.setBackground(SystemColor.textHighlight);
		lblEventosRegistrados.setBounds(23, 161, 767, 72);
		add(lblEventosRegistrados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 281, 749, 310);
		add(scrollPane);
		
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		modelo = new DefaultTableModel();
		table.setModel(modelo);
		
		modelo.addColumn("ID");
		modelo.addColumn("Evento");
		modelo.addColumn("Horario");
		modelo.addColumn("Dirrección");
		modelo.addColumn("Cargo");
		
		TableColumnModel columnModel = table.getColumnModel();

	    columnModel.getColumn(0).setPreferredWidth(1);
	    columnModel.getColumn(1).setPreferredWidth(100);
	    columnModel.getColumn(2).setPreferredWidth(1);
	    columnModel.getColumn(3).setPreferredWidth(1);
	    columnModel.getColumn(4).setPreferredWidth(1);
		
	    
		scrollPane.setViewportView(table);
			
		
	
		conexion = Conexion.conectar();
		
		try {
			preparedStatement = conexion.prepareStatement("select * from evento");
			
			rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				
				Object[] fila = new Object[5];
				 fila[0] = rs.getString("id");
				 fila[1] = rs.getString("nombre");
				 fila[2] = rs.getString("horario");
				 fila[3] = rs.getString("direccion");
				 fila[4] = rs.getString("cargo");
				 modelo.addRow(fila);
				
			}
				
				
			}catch(Exception i) {
				System.out.println(i);
				
			}
		
	}
}
