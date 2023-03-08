package challengeConversor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDistancia extends JPanel {
	private String cantidadDist;

	/**
	 * Create the panel.
	 */
	public MenuDistancia() {
		setLayout(null);
		// Modelo y datos conversor
		Distancia ArrayDistancia[] = new Distancia[4];
		ArrayDistancia[0] = new Distancia("Kilometros", 1.609, "Millas");
		ArrayDistancia[1] = new Distancia("Metros", 1.094, "Yardas");
		ArrayDistancia[2] = new Distancia("Metros", 3.281, "Pies");
		ArrayDistancia[3] = new Distancia("Centimetros", 2.54, "Pulgadas");

		JPanel panelDistancia = new JPanel();
		panelDistancia.setBounds(0, 0, 320, 174);
		add(panelDistancia);
		panelDistancia.setLayout(null);
		// Traemos el valor a convertir de la clase TipoConversor
		TipoConversor traer = new TipoConversor();
		cantidadDist = traer.getcantidadIn();
		BigDecimal cantidadDistBig = new BigDecimal(cantidadDist);

		JComboBox comboBoxDistancia = new JComboBox();
		comboBoxDistancia.setModel(new DefaultComboBoxModel(
				new String[] { "Kilometros a Millas", "Metros a Yardas", "Metros a Pies ", "Centímetros a Pulgadas ",
						"Millas a Kilometros", "Yardas a Metros", "Pies a Metros", "Pulgadas a Centímetros" }));
		comboBoxDistancia.setBounds(67, 37, 190, 22);
		panelDistancia.add(comboBoxDistancia);

		JButton btnOKdist = new JButton("OK");
		btnOKdist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// conversion
				int tipoCambio = comboBoxDistancia.getSelectedIndex();// retorna index seleccionado al dar OK

				// Manejo de decimales y error: 3,RoundingMode.HALF_UP
				if (tipoCambio <= 3) {
					BigDecimal divisor = new BigDecimal(ArrayDistancia[tipoCambio].getFactor());
					BigDecimal conversion = (cantidadDistBig.divide(divisor, 3, RoundingMode.HALF_UP));
					JOptionPane.showMessageDialog(null, cantidadDist + " " + ArrayDistancia[tipoCambio].getDistancia1()
							+ " equivalen a: " + conversion + "  " + (ArrayDistancia[tipoCambio].getDistancia2()));
				} else {
					tipoCambio = tipoCambio - 4;
					BigDecimal divisor = new BigDecimal(ArrayDistancia[tipoCambio].getFactor());
					BigDecimal conversion = (cantidadDistBig.multiply(divisor).setScale(3, RoundingMode.HALF_UP));
					JOptionPane.showMessageDialog(null,
							cantidadDist + " " + (ArrayDistancia[tipoCambio].getDistancia2()) + " equivalen a: "
									+ conversion + " " + (ArrayDistancia[tipoCambio].getDistancia1()));
				}
				int continuar = JOptionPane.showConfirmDialog(btnOKdist, "¿Desea continuar?", "CONTINUAR",
						JOptionPane.YES_NO_CANCEL_OPTION);
				if (continuar == JOptionPane.YES_OPTION) {
					TipoConversor tipoConv = new TipoConversor();
					tipoConv.mostrarPanelTipo(panelDistancia);
					;
//					
				} else if (continuar == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Programa Terminado");
					System.exit(0);
				}

			}
		});
		btnOKdist.setBounds(43, 95, 89, 23);
		panelDistancia.add(btnOKdist);

		JButton btnCancelDist = new JButton("Cancelar");
		btnCancelDist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoConversor tipoConv = new TipoConversor();
				tipoConv.mostrarPanelTipo(panelDistancia);
			}
		});
		btnCancelDist.setBounds(188, 95, 89, 23);
		panelDistancia.add(btnCancelDist);

		JLabel lblNewLabel = new JLabel("Elija la Conversión deseada");
		lblNewLabel.setBounds(53, 12, 214, 14);
		panelDistancia.add(lblNewLabel);

	}
}
