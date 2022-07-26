import java.util.Scanner;

public class SoloPares2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;

		System.out.println("Solo Pares2: Muestra los pares (sin cero) hasta...");

		do {
			System.out.print("Ingrese un número entero positivo: ");
			n = scanner.nextInt();
		} while (n < 0);
		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) * 2);
		}
		scanner.close();

	}

}
