package challengeConversor;


import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class TipoConversor extends JPanel {
	//VARIABLES
	private static String cantidadIn;
	
	public static String getcantidadIn() {
		return cantidadIn;
	}


	public static void setcantidadIn(String cantidadIn) {
		TipoConversor.cantidadIn = cantidadIn;
	}
	//Metodo que maneja errore por input vacio o con letras!!!!!
	private static boolean isNumeric(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			
			return false;
		}
	}
	
	public void mostrarPanelTipo(JPanel p) {
		TipoConversor tipoConv = new TipoConversor();
		tipoConv.setBounds(0, 0, 320, 174);
		tipoConv.setSize(320, 174);
		tipoConv.setLocation(0, 0);
		p.removeAll();
		p.setLayout(null);
		p.add(tipoConv);
		p.revalidate();
		p.repaint();
		
	}
	
	

	/**
	 * Create the panel.
	 */
	public TipoConversor() {
		setLayout(null);
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBounds(0, 0, 320, 174);
		add(panelTipo);
		panelTipo.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Convertir Dinero", "Convertir Distancias"}));
		comboBox.setBounds(67, 37, 190, 22);
		panelTipo.add(comboBox);
		
		JButton btnOKtipo = new JButton("OK");
		btnOKtipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tipoConver = comboBox.getSelectedIndex();// retorna index seleccionado al dar OK
				if (tipoConver==0) {
					cantidadIn = JOptionPane.showInputDialog(null, "Ingrese la cantidad de dinero a convertir:");
					if (cantidadIn!=null) {
						if (TipoConversor.isNumeric(cantidadIn)&& Double.parseDouble(cantidadIn)>0) {
							
							MenuMoneda menuMon = new MenuMoneda();
							menuMon.setBounds(0, 0, 320, 174);
							menuMon.setSize(320, 174);
							menuMon.setLocation(0, 0);
							panelTipo.removeAll();
							panelTipo.setLayout(null);
							panelTipo.add(menuMon);
							panelTipo.revalidate();
							panelTipo.repaint();
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe introducir una cifra positiva en numeros");
						}
					}
					
					
					
					}
				if (tipoConver==1) {
					cantidadIn = JOptionPane.showInputDialog(null, "Ingrese la Distancia a convertir:");
					if (cantidadIn!=null) {
						if (TipoConversor.isNumeric(cantidadIn)&& Double.parseDouble(cantidadIn)>0) {
							
							MenuDistancia menuDis = new MenuDistancia();
							menuDis.setBounds(0, 0, 320, 174);
							menuDis.setSize(320, 174);
							menuDis.setLocation(0, 0);
							panelTipo.removeAll();
							panelTipo.setLayout(null);
							panelTipo.add(menuDis);
							panelTipo.revalidate();
							panelTipo.repaint();
						
						}
						else {
							JOptionPane.showMessageDialog(null, "Debe introducir una cifra positiva en numeros");
						}
					}
				}
				
			}
		});
		btnOKtipo.setBounds(43, 95, 89, 23);
		panelTipo.add(btnOKtipo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Programa Terminado");
				System.exit(0);
			}
		});
		btnSalir.setBounds(188, 95, 89, 23);
		panelTipo.add(btnSalir);
		
		JLabel lbMenuPpal = new JLabel("Seleccione una opción de Conversión");
		lbMenuPpal.setBounds(53, 12, 214, 14);
		panelTipo.add(lbMenuPpal);

	}

}
