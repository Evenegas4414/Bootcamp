import java.util.Scanner;

public class SecuenciaFibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int primerTermino = 0;
		int segundoTermino = 1;
		int siguienteTermino;
		int n;
		
		System.out.println("Secuencia Fibonacci; Se calcula hasta...");
		System.out.print("Ingrese la cantidad a mostrar: ");
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(primerTermino);
			
			siguienteTermino = primerTermino + segundoTermino;
			primerTermino = segundoTermino;
			segundoTermino = siguienteTermino;			
		}
		scanner.close();
	}
}
