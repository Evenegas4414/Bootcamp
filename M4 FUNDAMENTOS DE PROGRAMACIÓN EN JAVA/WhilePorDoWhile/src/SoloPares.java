import java.util.Scanner;

public class SoloPares {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n;

		System.out.println("Solo Pares: Muestra los pares hasta...");
		do {
			System.out.print("Ingrese un número entero positivo: ");
			n = scanner.nextInt();
		} while (n < 0);
		for (int i = 0; i < n; i++) {
			System.out.println(i * 2);
		}
		scanner.close();
	}
}
