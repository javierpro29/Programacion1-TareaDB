import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Perfil extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
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
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Evento", "Horario", "Direccion", "Cargo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(185);
		table.getColumnModel().getColumn(1).setPreferredWidth(102);
		table.getColumnModel().getColumn(2).setPreferredWidth(171);
		scrollPane.setViewportView(table);
	}
}
