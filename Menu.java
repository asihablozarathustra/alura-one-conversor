package challengeConversor;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Menu() {

		setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Contstructor

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 326, 190);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel contenido = new JPanel();
		contenido.setBounds(0, 0, 320, 174);
		panel.add(contenido);
		contenido.setLayout(null);

		TipoConversor tipoConv = new TipoConversor();
		tipoConv.mostrarPanelTipo(contenido);

	}

}
