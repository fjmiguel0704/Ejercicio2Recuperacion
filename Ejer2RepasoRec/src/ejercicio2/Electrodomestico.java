package ejercicio2;

import java.util.Objects;

public class Electrodomestico implements Comparable<Electrodomestico> {
	protected int codigo;
	protected double precioBase = 100;
	protected Color color = Color.Blanco;
	protected Consumo consumoEnergetico = Consumo.F;
	protected double peso = 5;

	enum Color {
		Blanco, Negro, Rojo, Azul, Gris
	};

	enum Consumo {
		A, B, C, D, E, F
	}

	public Electrodomestico() {
		super();
	}

	public Electrodomestico(int codigo) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	public Electrodomestico(int codigo, double precioBase, double peso) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		if (precioBase > 0) {
			this.precioBase = precioBase;
		}
		if (peso > 0) {
			this.peso = peso;
		}
	}

	public Electrodomestico(int codigo, double precioBase, String color, char consumoEnergetico, double peso) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		if (precioBase > 0) {
			this.precioBase = precioBase;
		}
		comprobarColor(color);
		comprobarConsumoEnergetico(consumoEnergetico);
		if (precioBase > 0) {
			this.precioBase = precioBase;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		if (precioBase > 0) {
			this.precioBase = precioBase;
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(String color) {
		comprobarColor(color);
	}

	public Consumo getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		comprobarConsumoEnergetico(consumoEnergetico);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso > 0) {
			this.peso = peso;
		}
	}

	@Override
	public boolean equals(Object o) {
		boolean estado = false;
		Electrodomestico elec = (Electrodomestico) o;
		if (this.codigo == elec.codigo) {
			estado = true;
		}

		return estado;
	}

	@Override
	public int compareTo(Electrodomestico o) {
		int result = 0;
		result = this.codigo - o.codigo;
		return result;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	private Consumo comprobarConsumoEnergetico(char letra) {
		switch (letra) {
		case 'A', 'B', 'C', 'D', 'E', 'F':
			consumoEnergetico = Consumo.valueOf(String.valueOf(letra));
			break;
		default:
			consumoEnergetico = Consumo.F;
		}

		return consumoEnergetico;
	}

	private Color comprobarColor(String color) {
		if (color.equals("Blanco") || color.equals("Negro") || color.equals("Rojo") || color.equals("Azul")
				|| color.equals("Gris")) {
			this.color = Color.valueOf(color);
		} else {
			this.color = Color.Blanco;
		}

		return this.color;
	}

	public void precioFinal() {
		switch (consumoEnergetico) {
		case A:
			precioBase += 100;
		case B:
			precioBase += 80;
		case C:
			precioBase += 60;
		case D:
			precioBase += 50;
		case E:
			precioBase += 30;
		case F:
			precioBase += 10;
		default:
			System.out.println("El consumo energético no existe");
		}

		if (peso > 0 && peso <= 19) {
			precioBase += 10;
		} else if (peso >= 20 && peso <= 49) {
			precioBase += 50;
		} else if (peso >= 50 && peso <= 79) {
			precioBase += 80;
		} else if (peso > 80) {
			precioBase += 100;
		}
	}

	public String toString() {
		String result = "";
		result = "Código: " + codigo + "\n" + "Precio Base: " + precioBase + "\n" + "Color: " + color + "\n"
				+ "Consumo: " + consumoEnergetico + "\n" + "Peso: " + peso;

		return result;
	}

}
