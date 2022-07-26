
import java.util.InputMismatchException;
import java.util.Scanner;

public class Patrones {
	static Scanner sc = new Scanner(System.in);
	static int n = 0;

	public static void main(String[] args) {

		System.out.println("****************************");
		System.out.println("*                          *");
		System.out.println("*        Patrones:         *");
		System.out.println("*    1.  *.*.*.*.*.*.*     *");
		System.out.println("*    2.  12341234          *");
		System.out.println("*    3.  ||*||*||*||*      *");
		System.out.println("*                          *");
		System.out.println("****************************");
		System.out.println();

		Patrones.validarEntrada("Ingrese la cantidad de caracteres: ");

		System.out.println("");

		Patrones.imprimirPatron1();
		System.out.println("");
		Patrones.imprimirPatron2();
		System.out.println("");
		Patrones.imprimirPatron3();

		sc.close();
	}

	public static void imprimirPatron1() {
		for (int i = 0; i < Patrones.n; i++) {
			if (i % 2 == 0)
				System.out.print("*");
			else
				System.out.print(".");
		}
		System.out.println("");
	}

	public static void imprimirPatron2() {
		int c = 1;
		for (int i = 0; i < Patrones.n; i++) {
			System.out.print(c);
			c++;
			if (c == 5) {
				c = 1;
			}
		}
		System.out.println("");
	}

	public static void imprimirPatron3() {
		int c = 1;
		for (int i = 0; i < Patrones.n; i++) {
			switch (c) {
			case 1:
				System.out.print("|");
				break;
			case 2:
				System.out.print("|");
				break;
			case 3:
				System.out.print("*");
				break;
			}
			c++;
			if (c == 4) {
				c = 1;
			}
		}
		System.out.println("");
	}

	public static void validarEntrada(String cantidad) {
		do {
			try {
				System.out.print(cantidad);
				n = sc.nextInt();
				if (n < 1) {
					System.out.println("\nEntrada no es un entero positivo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nEntrada no es un entero positivo.");
			}
			sc.nextLine();
		} while (n <= 0);
	}
}