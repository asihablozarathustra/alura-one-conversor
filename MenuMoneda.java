package challengeConversor;


import javax.swing.JPanel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MenuMoneda extends JPanel {
	private String cantidadDinero;
	
	
	
	public MenuMoneda(String cantidadDinero) {
		super();
		this.cantidadDinero = cantidadDinero;
	}

	public String getCantidadDinero() {
		return cantidadDinero;
	}

	public void setCantidadDinero(String cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}

	
	
	/**
	 * Create the panel.
	 */
	public MenuMoneda() {
		setLayout(null);
		//Modelo y datos conversor
		Moneda ArrayMonedas[] = new Moneda[5];
		ArrayMonedas[0] = new Moneda("Dolares", 4787.09, "US$");
		ArrayMonedas[1] = new Moneda("Euros", 5088.57,"€" );
		ArrayMonedas[2] = new Moneda("UK libras", 5764.13 ,"£");
		ArrayMonedas[3] = new Moneda("Yen Japones", 35.21,"¥");
		ArrayMonedas[4] = new Moneda("Won Surcoreano", 3.69,"₩");
		
		JPanel panelMoneda = new JPanel();
		panelMoneda.setBounds(0, 0, 320, 174);
		add(panelMoneda);
		panelMoneda.setLayout(null);
		//Traemos el valor a convertir de la clase TipoConversor
		TipoConversor traer = new TipoConversor();
		cantidadDinero=traer.getcantidadIn();
		BigDecimal cantMonedaBig = new BigDecimal(cantidadDinero);
		
		JButton btnCancellMoneda = new JButton("Cancelar");
		btnCancellMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TipoConversor tipoConv = new TipoConversor();
				tipoConv.mostrarPanelTipo(panelMoneda);
				
				
			}
		});
		btnCancellMoneda.setBounds(188, 95, 89, 23);
		panelMoneda.add(btnCancellMoneda);
		
		JComboBox comboBoxMoneda = new JComboBox();
		comboBoxMoneda.setModel(new DefaultComboBoxModel(new String[] {"De Pesos a Dolares USA", "De Pesos a Euros", "De Pesos a Libras Esterlinas", "De Pesos a Yen Japones", "De Pesos a Won Surcoreano", "De Dolares USA a Pesos", "De Euros a Pesos", "De Libras Esterlinas a Pesos", "De Yen Japones a Pesos", "De Won Surcoreano a Pesos"}));
		comboBoxMoneda.setBounds(67, 37, 190, 22);
		panelMoneda.add(comboBoxMoneda);
		
		JButton btnOKmoney = new JButton("OK");
		btnOKmoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//conversion
				int tipoCambio = comboBoxMoneda.getSelectedIndex();// retorna index seleccionado al dar OK
				
				//Manejo de decimales y error: 5,RoundingMode.HALF_UP
				if (tipoCambio <= 4) {
					BigDecimal divisor = new BigDecimal(ArrayMonedas[tipoCambio].getValor());
					BigDecimal conversion= (cantMonedaBig.divide(divisor,5,RoundingMode.HALF_UP));
					JOptionPane.showMessageDialog(null, "El valor de COP$ " + cantMonedaBig + " pesos es de: "+ArrayMonedas[tipoCambio].getSimbolo()+" "
							+ conversion + " " + (ArrayMonedas[tipoCambio].getNombreMoneda()));
				} else {
					tipoCambio = tipoCambio - 5;
					BigDecimal divisor = new BigDecimal(ArrayMonedas[tipoCambio].getValor());
					BigDecimal conversion= (cantMonedaBig.multiply(divisor).setScale(3, RoundingMode.HALF_UP));
					JOptionPane.showMessageDialog(null,
							"El valor de "+ArrayMonedas[tipoCambio].getSimbolo()+" " + cantMonedaBig + " " + (ArrayMonedas[tipoCambio].getNombreMoneda())
									+ " es de: COP$ " +conversion + " pesos  ");
				}
				int continuar= JOptionPane.showConfirmDialog(btnOKmoney,"¿Desea continuar?", "CONTINUAR", JOptionPane.YES_NO_CANCEL_OPTION);
				if (continuar==JOptionPane.YES_OPTION) {
					
					TipoConversor tipoConv = new TipoConversor();
					tipoConv.mostrarPanelTipo(panelMoneda);
					
				}else if(continuar==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null,"Programa Terminado");
					System.exit(0);
				}
				
				
			}
		});
		btnOKmoney.setBounds(43, 95, 89, 23);
		panelMoneda.add(btnOKmoney);
		
		JLabel lblNewLabel = new JLabel("Elija la Conversión deseada");
		lblNewLabel.setBounds(53, 12, 160, 14);
		panelMoneda.add(lblNewLabel);
		
		

	}
}