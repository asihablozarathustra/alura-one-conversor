package challengeConversor;

public class Distancia {
	private String Distancia1;
	private double factor;
	private String Distancia2;
	
	public Distancia(String distancia1, double factor, String distancia2) {
		super();
		Distancia1 = distancia1;
		this.factor = factor;
		Distancia2 = distancia2;
	}

	public String getDistancia1() {
		return Distancia1;
	}

	public void setDistancia1(String distancia1) {
		Distancia1 = distancia1;
	}

	public double getFactor() {
		return factor;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public String getDistancia2() {
		return Distancia2;
	}

	public void setDistancia2(String distancia2) {
		Distancia2 = distancia2;
	}
	
	
	
	

}


