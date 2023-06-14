package ejercicio2;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import ejercicio2.Electrodomestico.Color;
import ejercicio2.Electrodomestico.Consumo;

public class Main {
	static int opcion;
	static int codElectr;
	static String tipoElectr;
	static double cargaLavadora;
	static double precio;
	static String color;
	static char consumoEnergetico;
	static double peso;
	static double resolTele;
	static boolean tdtTele;
	static Scanner read = new Scanner(System.in);
	static LinkedHashSet<Electrodomestico> collection = new LinkedHashSet<Electrodomestico>();

	public static void main(String[] args) {
		leerFichero();
		do {
			menu();
			opcion = read.nextInt();
			read.nextLine();

			switch (opcion) {
			case 1:
				añadirElectrodomestico();
				break;
			case 2:
				for (Electrodomestico valores : collection) {
					System.out.println(valores.toString());
					System.out.println();
				}
				break;
			case 3:
				modificarElectrodomestico();
				break;
			case 4:
				eliminarElectrodomestico();
				break;
			case 5:
				guardarFichero(collection);
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 0);

	}

	public static LinkedHashSet<Electrodomestico> leerFichero() {
		try {
			String linea = "";
			String electr[];
			Electrodomestico e;
			Scanner sc = new Scanner(new FileReader("src\\ejercicio2\\Electrodomesticos.txt"));
			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				electr = linea.split(";");
				if (electr[0].equals("Lavadora")) {
					e = new Lavadora(Double.parseDouble(electr[7]), Integer.parseInt(electr[2]),
							Double.parseDouble(electr[3]), electr[4], electr[5].charAt(0),
							Double.parseDouble(electr[6]));
				} else if (electr[0].equals("Television")) {
					e = new Television(Double.parseDouble(electr[7]), Boolean.parseBoolean(electr[8]),
							Integer.parseInt(electr[2]), Double.parseDouble(electr[3]), electr[4], electr[5].charAt(0),
							Double.parseDouble(electr[6]));

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			System.out.println(e.getMessage());
		}

		return collection;
	}

	public static void guardarFichero(LinkedHashSet<Electrodomestico> collec) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio2\\Electrodomesticos.txt"));
			for (Electrodomestico valores : collec) {
				String cadena = valores.getCodigo() + ";" + valores.getPrecioBase() + ";" + valores.getColor() + ";"
						+ valores.getConsumoEnergetico() + ";" + valores.getPeso() + ";";

				if (valores instanceof Lavadora) {
					cadena = "Lavadora" + ";" + cadena + ((Lavadora) valores).getCarga();
				} else if (valores instanceof Television) {
					cadena = "Television" + ";" + cadena
							+ (((Television) valores).getResolucion() + ";" + ((Television) valores).isTdt());
				} else {
					cadena = "Electrodomestico" + ";" + cadena;
				}
				bw.write(cadena);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("No se encuentra el fichero");
			System.out.println(e.getMessage());
		}
	}

	public static void eliminarElectrodomestico() {
		System.out.println("Código del electrodoméstico a eliminar: ");
		codElectr = read.nextInt();
		read.nextLine();
		Electrodomestico e = new Electrodomestico(codElectr);
		if (collection.remove(e)) {
			System.out.println("Eliminado correctamente");
		} else {
			System.out.println("El electrodoméstico no existe");
		}
	}

	public static void modificarElectrodomestico() {
		System.out.println("Código del electrodoméstico a modificar: ");
		codElectr = read.nextInt();
		read.nextLine();
		Electrodomestico e = new Electrodomestico(codElectr);
		if (!collection.contains(e)) {
			System.out.println("El electrodoméstico no existe");
		} else {
			System.out.println("1. Precio");
			System.out.println("2. Color");
			System.out.println("3. Consumo");
			System.out.println("4. Peso");
			for (Electrodomestico electr : collection) {
				if (electr.equals(e)) {
					if (electr instanceof Lavadora) {
						System.out.println("5. Carga");
						System.out.println();
						System.out.println("Seleccione una opción: ");
						opcion = read.nextInt();
						read.nextLine();
						switch (opcion) {
						case 1:
							System.out.println("Nuevo precio: ");
							precio = read.nextDouble();
							read.nextLine();
							electr.setPrecioBase(precio);
							System.out.println("Modificado correctamente");
							break;
						case 2:
							System.out.println("Nuevo Color: ");
							color = read.next();
							read.nextLine();
							electr.setColor(color);
							System.out.println("Modificado correctamente");
							break;
						case 3:
							System.out.println("Nuevo Consumo: ");
							consumoEnergetico = read.next().charAt(0);
							read.nextLine();
							electr.setConsumoEnergetico(consumoEnergetico);
							System.out.println("Modificado correctamente");
							break;
						case 4:
							System.out.println("Nuevo Peso: ");
							peso = read.nextDouble();
							read.nextLine();
							electr.setPeso(peso);
							System.out.println("Modificado correctamente");
							break;
						case 5:
							System.out.println("Nueva carga: ");
							cargaLavadora = read.nextDouble();
							read.nextLine();
							((Lavadora) electr).setCarga(cargaLavadora);
							System.out.println("Modificado correctamente");
							break;
						default:
							System.out.println("Opción incorrecta");
						}
					} else if (electr instanceof Television) {
						System.out.println("5. Resolución");
						System.out.println("6. Sintonizador");
						System.out.println();
						System.out.println("Seleccione una opción");
						switch (opcion) {
						case 1:
							System.out.println("Nuevo precio: ");
							precio = read.nextDouble();
							read.nextLine();
							electr.setPrecioBase(precio);
							System.out.println("Modificado correctamente");
							break;
						case 2:
							System.out.println("Nuevo Color: ");
							color = read.next();
							read.nextLine();
							electr.setColor(color);
							System.out.println("Modificado correctamente");
							break;
						case 3:
							System.out.println("Nuevo Consumo: ");
							consumoEnergetico = read.next().charAt(0);
							read.nextLine();
							electr.setConsumoEnergetico(consumoEnergetico);
							System.out.println("Modificado correctamente");
							break;
						case 4:
							System.out.println("Nuevo Peso: ");
							peso = read.nextDouble();
							read.nextLine();
							electr.setPeso(peso);
							System.out.println("Modificado correctamente");
							break;
						case 5:
							System.out.println("Nueva resolución: ");
							resolTele = read.nextDouble();
							read.nextLine();
							((Television) electr).setResolucion(resolTele);
							System.out.println("Modificado correctamente");
							break;
						case 6:
							System.out.println("Sintonizador (True|False)");
							tdtTele = read.nextBoolean();
							read.nextLine();
							((Television) electr).setTdt(tdtTele);
							System.out.println("Modificado correctamente");
							break;
						default:
							System.out.println("Opción incorrecta");
						}
					}
				}
			}
		}
	}

	public static void añadirElectrodomestico() {
		System.out.println("Código del electrodoméstico a añadir: ");
		codElectr = read.nextInt();
		read.nextLine();
		Electrodomestico elec = new Electrodomestico(codElectr);
		if (collection.contains(elec)) {
			System.out.println("Ya existe el producto");
		} else {
			System.out.println("Precio del producto: ");
			precio = read.nextDouble();
			read.nextLine();
			System.out.println("Color: ");
			color = read.next();
			read.nextLine();
			System.out.println("Consumo energético: ");
			consumoEnergetico = read.next().charAt(0);
			read.nextLine();
			System.out.println("Peso: ");
			peso = read.nextDouble();
			read.nextLine();
			System.out.println("Tipo de electrodoméstico (Lavadora|Televisión): ");
			tipoElectr = read.next();
			read.nextLine();
			switch (tipoElectr) {
			case "Lavadora":
				System.out.println("Carga de la lavadora: ");
				cargaLavadora = read.nextDouble();
				read.nextLine();
				Lavadora lavadora = new Lavadora(cargaLavadora, codElectr, precio, color, consumoEnergetico, peso);
				collection.add(lavadora);
				break;
			case "Television":
				System.out.println("Resolución del televisor: ");
				resolTele = read.nextDouble();
				read.nextLine();
				System.out.println("Contiene sintonizador (True|False): ");
				tdtTele = read.nextBoolean();
				read.nextLine();
				Television tele = new Television(resolTele, tdtTele, codElectr, precio, color, consumoEnergetico, peso);
				collection.add(tele);
				break;
			default:
				System.out.println("Electrodoméstico no válido");
			}
		}
	}

	public static void menu() {
		System.out.println();
		System.out.println("1. Añadir electrodoméstico");
		System.out.println("2. Listar electrodomésticos");
		System.out.println("3. Modificar electrodoméstico");
		System.out.println("4. Eliminar electrodoméstico");
		System.out.println("5. Guardar en fichero");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Marque una opción: ");
	}

}
