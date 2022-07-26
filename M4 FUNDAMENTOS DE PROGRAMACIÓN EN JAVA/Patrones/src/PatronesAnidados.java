
import java.util.InputMismatchException;
import java.util.Scanner; 

public class PatronesAnidados {
	static Scanner sc = new Scanner(System.in);
	static String cadenaCantidad = "Ingresa la cantidad de\ncaracteres para mostrar: ";
	static String cadenaPatron = "Ingresa el patron para mostrar: ";
	static int n = 0;
	static int e = 0;

	public static void main(String[] args) {

		System.out.println("****************************");
		System.out.println("*                          *");
		System.out.println("*     Patrones Anidados:   *");
		System.out.println("*    1.  Cuadrado          *");
		System.out.println("*    2.  Zeta              *");
		System.out.println("*    3.  Equis             *");
		System.out.println("*    4.  Torre             *");
		System.out.println("*    5.  Todos             *");
		System.out.println("*                          *");
		System.out.println("****************************");
		System.out.println();
		
		PatronesAnidados.validarEntrada("Ingrese el patron para mostrar: ", 0, 6);
		System.out.println("");
		PatronesAnidados.validarEntrada("Ingrese la cantidad de caracteres: ", 0);

		System.out.println("");

		switch (e) {
		case 1:
			PatronesAnidados.imprimirPatron1();
			break;
		case 2:
			PatronesAnidados.imprimirPatron2();
			break;
		case 3:
			PatronesAnidados.imprimirPatron3();
			break;
		case 4:
			PatronesAnidados.imprimirPatron4();
			break;
		case 5:
			PatronesAnidados.imprimirPatron1();
			PatronesAnidados.imprimirPatron2();
			PatronesAnidados.imprimirPatron3();
			PatronesAnidados.imprimirPatron4();
			break;
		}

		sc.close();

	}

	public static void imprimirPatron1() {
		if (n == 1) {
			System.out.println("*");
		} else {
			// -------------------------------------
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println("");
			// -------------------------------------
			for (int i = 0; i < n - 2; i++) {
				System.out.print("*");

				for (int j = 0; j < n - 2; j++) {
					System.out.print(" ");
				}
				System.out.println("*");
			}
			// -------------------------------------
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println("");
			// -------------------------------------
		}
		System.out.println("");
	}

	public static void imprimirPatron2() {

		if (n == 1) {
			System.out.println("*");
		} else {
			// -------------------------------------
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println("");
			// -------------------------------------
			for (int i = n - 2; i > 0; i--) {
				for (int j = i; j > 0; j--) {
					System.out.print(" ");
				}
				System.out.println("*");
			}
			// -------------------------------------
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println("");
			// -------------------------------------
		}
		System.out.println("");
	}

	public static void imprimirPatron3() {

		if (n == 1) {
			System.out.println("x");
		} else {
			// -------------------------------------
			System.out.print("x");
			for (int i = 0; i < n - 2; i++) {
				System.out.print(" ");
			}
			System.out.println("x");
			// -------------------------------------
			for (int i = 1; i <= n - 2; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == j || i + j == n - 1) {
						System.out.print("x");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println("");
			}
			// -------------------------------------
			System.out.print("x");
			for (int i = 0; i < n - 2; i++) {
				System.out.print(" ");
			}
			System.out.println("x");
			// -------------------------------------
		}
		System.out.println("");
	}

	public static void imprimirPatron4() {

		if (n == 1) {
			System.out.println("*");

		} else {
			// -------------------------------------
			for (int i = 1; i < n; i++) {
				System.out.print("*");
			}
			System.out.println(" ");
			// -------------------------------------
			for (int i = 0; i < n - 2; i++) {
				System.out.print(" ");
				for (int j = 0; j < n - 2; j++) {
					System.out.print("*");
				}
				System.out.println(" ");
			}
			// -------------------------------------
			System.out.print(" ");
			for (int i = 1; i < n; i++) {
				System.out.print("*");
			}
			// -------------------------------------
		}
		System.out.println("");
	}

	public static void validarEntrada(String cantidad, int minimo) {
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
		} while (n <= minimo);
	}

	public static void validarEntrada(String tipo, int minimo, int maximo) {
		do {
			try {
				System.out.print(tipo);
				e = sc.nextInt();
				if (e <= minimo || e >= maximo) {
					System.out.println("\nEntrada no es un patron disponible.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nEntrada no es un patron disponible.");
			}
			sc.nextLine();
		} while (e <= minimo || e >= maximo);
	}
}