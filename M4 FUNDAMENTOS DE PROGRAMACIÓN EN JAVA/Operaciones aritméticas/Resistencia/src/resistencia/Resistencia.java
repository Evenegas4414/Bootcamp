package resistencia;

import java.util.*;
public class Resistencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******************************");
		System.out.println("Calcular Resistencia Electrica");
		System.out.println("******************************");
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
	    float[] res = new float[3];
		for (int i = 0; i < 3; i++) {
			
			do {
				System.out.print("Ingrese la resistencia " + (i+1) +":");
				res[i] = sc.nextFloat();
			} while (res[i] <= 0);
		}		
		sc.close();
		
		float total = 1 / ( (1/res[0]) + (1/res[1]) + (1/res[2]) );
		System.out.println();
		System.out.println("******************************");
		System.out.printf("La resistencia total es de %.2f", total);
		System.out.println();
		System.out.println("******************************");
		
		
	}

}
