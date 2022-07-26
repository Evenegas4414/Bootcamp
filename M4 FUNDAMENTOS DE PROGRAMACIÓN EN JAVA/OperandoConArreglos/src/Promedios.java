import java.util.ArrayList;

public class Promedios {
	
	static ArrayList<Integer> listaMultiplosDeTres = new ArrayList<Integer>();

	public static void main(String[] args) {
		System.out.println("La suma de los numero que son multiplos de 3 es: " + suma(args));
		System.out.println("El promedio de los numero que son multiplos de 3 es: " + promedio(args));
	}

	public static int suma(String[] listaTextoNumeros) {
		int sumaTotal = 0;
		 
		for (String multiploDeTres : listaTextoNumeros) {
			if ( Integer.parseInt(multiploDeTres) % 3 == 0) {
				//System.out.println(Integer.parseInt(multiploDeTres));
				listaMultiplosDeTres.add(Integer.parseInt(multiploDeTres));
			}
		} 
		for (int numeros : listaMultiplosDeTres) {
			sumaTotal += numeros;  
		}
		//System.out.println(listaMultiplosDeTres.size());
		return sumaTotal;
	}
	
	public static int promedio (String[] listaTextoNumeros) {		
		return suma(listaTextoNumeros) / listaMultiplosDeTres.size();
	}
}
