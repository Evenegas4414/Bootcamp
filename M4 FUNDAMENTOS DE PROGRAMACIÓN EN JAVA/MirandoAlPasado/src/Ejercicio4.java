import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio4 {
	// 1. Instanciar LinkedList
	static Queue<String> juegos = new LinkedList<String>();

	public static void main(String[] args) {

		// 2. Agregar juegos
		juegos.add("Tombo");
		juegos.add("Congelado");
		juegos.add("Quemaditas");
		juegos.add("Cachipún");
		juegos.add("Pillarse");

		// 3. Imprimir la cantidad de juegos.
		System.out.println("La cantidad de juegos es: " + juegos.size());
	}
}
