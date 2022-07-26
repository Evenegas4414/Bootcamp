import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
	// 1. Instanciar arraylist
	static List<String> marcas = new ArrayList<String>();
	static List<String> posiblesMarcas = new ArrayList<String>();

	public static void main(String[] args) {

		System.out.println("Ejercicio 1");

		// 2. Añadir 10 marcas
		marcas.add("Nintendo");
		marcas.add("Sega");
		marcas.add("Nokia");
		marcas.add("Motorola");
		marcas.add("MSN");
		marcas.add("Yahoo");
		marcas.add("Palm");
		marcas.add("RIM");
		marcas.add("Polaroid");
		marcas.add("Canon");

		Ejercicio1.imprimir();

		// 3. Añadir 3 marcas
		marcas.add("Blokbaster");
		marcas.add("Carrefour");
		marcas.add("Jetix");

		Ejercicio1.imprimir();

		// 4. Cambiar Blokbaster por Blockbuster
		int index;
		if ((index = marcas.indexOf("Blokbaster")) != -1) {
			marcas.set(index, "Blockbuster");
		}

		Ejercicio1.imprimir();

		// 5. Borra carrefour
		marcas.remove("Carrefour");

		Ejercicio1.imprimir();

		// 6. Agregar marcas a segundo ArrayList y luego añadirlas al primero
		posiblesMarcas.add("HTC");
		posiblesMarcas.add("LG");
		posiblesMarcas.add("Panasonic");

		marcas.addAll(posiblesMarcas);

		Ejercicio1.imprimir();

		// 7. Imprimir cantidad en la lista
		System.out.println("");
		System.out.println("La cantidad de marcas es: " + marcas.size());
	}

	public static void imprimir() {
		System.out.println("");
		for (String s : marcas) {
			System.out.println("Marca: " + s);
		}
	}
}
