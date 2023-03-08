package challengeConversor;


public class Moneda {
	private String nombreMoneda;
	private double valor;
	private String simbolo;

	

	public Moneda(String nombreMoneda, double valor, String simbolo) {
		super();
		this.nombreMoneda = nombreMoneda;
		this.valor = valor;
		this.simbolo = simbolo;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	

}
