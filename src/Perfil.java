import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Font;

public class Perfil extends JPanel {

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
	}

}
