import java.util.Scanner;

public class SumaImpar {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int sumaImpar = 0;
		int n;

		System.out.println("Suma Impares: Suma los impares hasta...");
		do {
			System.out.print("Ingrese un número entero positivo: ");
			n = scanner.nextInt();
		} while (n < 0);
		for (int i = 0; i <= n; i++) {
			if ((i % 2) == 1) {
				sumaImpar = sumaImpar + i;
			}
		}
		System.out.println(sumaImpar);
		scanner.close();
	}
}
