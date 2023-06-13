package ejercicio2;

public class Lavadora extends Electrodomestico {
	private double carga = 5;

	public Lavadora() {
		super();
	}

	public Lavadora(int codigo) {
		super(codigo);
	}

	public Lavadora(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}

	public Lavadora(double carga, int codigo, double precio, String color, char consumo, double peso) {
		super(codigo, precio, color, consumo, peso);
		if (carga > 0) {
			this.carga = carga;
		}
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		if (carga > 0) {
			this.carga = carga;
		}
	}

	@Override
	public void precioFinal() {
		super.precioFinal();
		if (carga > 30) {
			precioBase += 50;
		}
	}

	public String toString() {
		String result = "";
		result = "Electrodoméstico: Lavadora" + "\n" + super.toString() + "\n" + "Carga: " + carga;
		return result;
	}

}
