import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class Inicio extends JPanel {

	/**
	 * Create the panel.
	 */
	public Inicio() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a tu agenda para registar eventos", SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(new Color(0, 120, 215));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 69, 790, 72);
		add(lblNewLabel);
		
		JLabel parrafo1 = new JLabel("<html><p>Realizar una agenda electronica donde me guarde eventos,<br> que permita guardar, actualizar, borrar y buscar cosas agendadas. <br> Mostradas en algo como un ejemplo (listbox, datagrid o tabla).. Debe tener un menu con los campos <p><html> ", SwingConstants.LEFT);
		parrafo1.setForeground(Color.WHITE);
		parrafo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		parrafo1.setBounds(51, 152, 681, 169);
		add(parrafo1);
		
		JLabel parrafo2 = new JLabel("<html><p><b>Acciones</b> <br> <br> Guardar <br> Actualizar <br> Buscar <br> Borrar <br><br> Informaci\u00F3n --esto mostrara la ventana con esta informaci\u00F3n <br> 1.Perfil del estudiante </p></html> ", SwingConstants.LEFT);
		parrafo2.setForeground(Color.WHITE);
		parrafo2.setBackground(Color.WHITE);
		parrafo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		parrafo2.setBounds(61, 317, 616, 260);
		add(parrafo2);

	}

}
