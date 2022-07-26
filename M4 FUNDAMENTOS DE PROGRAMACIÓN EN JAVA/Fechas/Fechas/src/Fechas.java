import java.util.Scanner;

public class Fechas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*****************************************");
		System.out.println("*             Quién es mayor            *");
		System.out.println("*****************************************");
		System.out.println();
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese la primera fecha como DD/MM/AAAA:");
		String primeraFecha = sc.nextLine();
		
		
		int dia1 = Integer.parseInt(primeraFecha.substring(0, 2));
		int mes1 = Integer.parseInt(primeraFecha.substring(3, 5));
		int anio1 = Integer.parseInt(primeraFecha.substring(6));
		
		System.out.print("Ingrese la segunda fecha como DD/MM/AAAA:");
		String segundaFecha = sc.nextLine();
		
		int dia2 = Integer.parseInt(segundaFecha.substring(0, 2));
		int mes2 = Integer.parseInt(segundaFecha.substring(3, 5));
		int anio2 = Integer.parseInt(segundaFecha.substring(6));
		
		//System.out.println("Fecha 1: " + dia1 + mes1 + anio1);
		//System.out.println("Fecha 2: " + dia2 + mes2 + anio2);
		
		if ( anio1 < anio2) {
			System.out.print("Persona 1 es mayor.");
		} else if ( anio2 < anio1 ) {
			System.out.print("Persona 2 es mayor.");
		} else {
			if ( mes1 < mes2) {
				System.out.print("Persona 1 es mayor.");
			} else if ( mes2 < mes1 ) {
				System.out.print("Persona 2 es mayor.");
			} else {
				if ( dia1 < dia2) {
					System.out.print("Persona 1 es mayor.");
				} else if ( dia2 < dia1 ) {
					System.out.print("Persona 2 es mayor.");
				} else {
					System.out.print("Tienen la misma edad.");
				}
			}
		}		
	}
}
