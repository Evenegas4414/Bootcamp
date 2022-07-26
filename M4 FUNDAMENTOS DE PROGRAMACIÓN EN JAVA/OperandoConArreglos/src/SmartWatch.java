import java.util.ArrayList;

public class SmartWatch {

	public static void main(String[] args) {
		System.out.println("El promedio de los pasos es: " + promedio(clearSteps(args)));
	}
	
	public static ArrayList<Integer> clearSteps(String[] listaPasos) {
		
		ArrayList<Integer> listaPasosFiltrados = new ArrayList<Integer>();
		
		for (String pasos : listaPasos) {
			if ( 200 <= Integer.parseInt(pasos) && 100_000 >= Integer.parseInt(pasos) ) {
				//System.out.println(Integer.parseInt(pasos));
				listaPasosFiltrados.add(Integer.parseInt(pasos));
			}
		}
		return listaPasosFiltrados;
	}
	
	public static int promedio(ArrayList<Integer> listaPasosFiltrados) {
		
		int sumaPasos = 0;
		
		for (int pasos : listaPasosFiltrados) {
			sumaPasos += pasos;  
		}
		//System.out.println(listaPasosFiltrados.size());
		return sumaPasos / listaPasosFiltrados.size();
	}
}
