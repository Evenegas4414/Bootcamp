
public class Visitas {

	public static void main(String[] args) {
		System.out.println("Para la entrada anterior, el resultado es: " + promedio(args));

	}
	
	public static int promedio(String[] visitasTexto) {
		
		int[] visitasEnteros = new int[visitasTexto.length];
		int sumaVisitas = 0;
		for (int i = 0; i < visitasTexto.length; i++) {
			visitasEnteros[i] = Integer.parseInt(visitasTexto[i]);
			sumaVisitas += visitasEnteros[i];
			
		}		
		return sumaVisitas / visitasEnteros.length;
	}
}
