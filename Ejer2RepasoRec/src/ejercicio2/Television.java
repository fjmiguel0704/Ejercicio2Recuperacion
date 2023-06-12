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

	public Television(double resolucion, boolean tdt, int codigo, double precio, double peso) {
		super(codigo, precio, peso);
		if (resolucion > 0) {
			this.resolucion = resolucion;
		}
		this.tdt = tdt;
	}

	public double getResolucion() {
		return resolucion;
	}

	public void setResolucion(double resolucion) {
		this.resolucion = resolucion;
	}

	public boolean isTdt() {
		return tdt;
	}

	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}

	public String toString() {
		String result = "";
		result = "Electrodoméstico: Televisión" + super.toString() + "\n" + "Resolución: " + resolucion + "\n"
				+ "Sintonizador TDT: " + (tdt ? "Si" : "No");

		return result;
	}

}
