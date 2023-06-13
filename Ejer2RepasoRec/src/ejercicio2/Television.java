package ejercicio2;

public class Television extends Electrodomestico {
	private double resolucion = 20;
	private boolean tdt = false;

	public Television() {
		super();
	}

	public Television(int codigo) {
		super(codigo);
	}

	public Television(int codigo, double precio, double peso) {
		super(codigo, precio, peso);
	}

	public Television(double resolucion, boolean tdt, int codigo, double precio, String color, char consumo,
			double peso) {
		super(codigo, precio, color, consumo, peso);
		if (resolucion > 0) {
			this.resolucion = resolucion;
		}
		this.tdt = tdt;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		if (resolucion > 0) {
			this.resolucion = resolucion;
		}
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	@Override
	public void precioFinal() {
		super.precioFinal();
		if (resolucion > 40) {
			precioBase += (precioBase / 100) * 30;
		}
		if (tdt) {
			precioBase += 50;
		}
	}

	public String toString() {
		String result = "";
		result = "Electrodoméstico: Televisión" + "\n" + super.toString() + "\n" + "Resolución: " + resolucion + "\n"
				+ "Sintonizador TDT: " + (tdt ? "Si" : "No");

		return result;
	}

}
