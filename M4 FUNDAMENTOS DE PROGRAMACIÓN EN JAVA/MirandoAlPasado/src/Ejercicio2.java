import java.util.Set;
import java.util.TreeSet;

public class Ejercicio2 {
	// 1. Instanciar un treeset
	static Set<String> invitados = new TreeSet<String>();
	static Set<String> posiblesInvitados = new TreeSet<String>();

	public static void main(String[] args) {
		// 2. Añadir invitados por nombres
		invitados.add("Daniel");
		invitados.add("Paola");
		invitados.add("Facundo");
		invitados.add("Pedro");
		invitados.add("Jacinta");
		invitados.add("Florencia");
		invitados.add("Juan Pablo");

		// 3. Añardir posibles invitados
		posiblesInvitados.add("Jorge");
		posiblesInvitados.add("Francisco");
		posiblesInvitados.add("Marcos");

		invitados.addAll(posiblesInvitados);

		Ejercicio2.imprimir();

		// 4. Borrar a Jorge
		invitados.remove("Jorge");

		Ejercicio2.imprimir();
	}

	public static void imprimir() {
		System.out.println("");
		for (String s : invitados) {
			System.out.println("Invitado: " + s);
		}
	}
}
