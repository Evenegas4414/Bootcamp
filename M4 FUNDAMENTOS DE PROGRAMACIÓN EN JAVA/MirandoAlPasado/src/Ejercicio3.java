import java.util.Map;
import java.util.TreeMap;

public class Ejercicio3 {
	// 1. Instanciar un TreeMap
	static Map<String, Integer> golosinas = new TreeMap<String, Integer>();
	static Map<String, Integer> golosinasBaratas = new TreeMap<String, Integer>();

	public static void main(String[] args) {

		// 2. Añadir golosinas
		golosinas.put("Chocman", 100);
		golosinas.put("Trululú", 100);
		golosinas.put("Centella", 100);
		golosinas.put("Kilate", 50);
		golosinas.put("Miti Miti", 30);
		golosinas.put("Traga Traga", 150);
		golosinas.put("Tabletón", 5);

		// 3. Filtrar golosinas menores a 100
		for (Map.Entry<String, Integer> e : golosinas.entrySet()) {
			if (e.getValue() < 100) {
				golosinasBaratas.put(e.getKey(), e.getValue());
			}
		}
		System.out.println("Golosinas menores a 100: ");
		for (Map.Entry<String, Integer> e : golosinasBaratas.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
