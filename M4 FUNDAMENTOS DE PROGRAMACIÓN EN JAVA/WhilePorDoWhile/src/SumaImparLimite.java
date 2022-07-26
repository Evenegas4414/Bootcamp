import java.util.Scanner;

public class SumaImparLimite {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int sumaImpar = 0;
		int i;
		int n;

		System.out.println("Suma Impares Limites: Suma los impares desde ... hasta...");
		do {
			System.out.print("Ingrese el número minimo que sea un entero positivo: ");
			i = scanner.nextInt();
		} while (i < 0);
		do {
			System.out.print("Ingrese el número maximo que sea un entero positivo: ");
			n = scanner.nextInt();
		} while (n <= i);

		for (int j = i; j <= n; j++) {
			if ((j % 2) == 1) {
				sumaImpar = sumaImpar + j;
			}
		}
		System.out.println(sumaImpar);
		scanner.close();
	}
}
