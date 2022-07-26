import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LeerEscribir {

	static File directorio;
	static File fichero;
	static ArrayList<String> lista = new ArrayList<String>();

	public static void main(String[] args) {

		lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato"); 
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");
		
		crearArchivo("directorio", "fichero");
		escribirTexto(fichero, lista);
		for (String texto : args) {
			buscarTexto(fichero, texto);
		}

	}

	public static void crearArchivo(String directorio, String fichero) {
		
		LeerEscribir.directorio = new File("src/" + directorio);
		if (LeerEscribir.directorio.exists() == false) {
			LeerEscribir.directorio.mkdir();
		} else {
			System.out.println("Error al crear directorio.");
			System.out.println("El directorio ya existe.");
		}
		
		LeerEscribir.fichero = new File("src/" + directorio + "/" + fichero + ".txt");
		if (LeerEscribir.fichero.exists() == false) {
			try {
				LeerEscribir.fichero.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear archivo.");
				System.out.println("Error: " + e);
			}
		} else {
			System.out.println("Error al crear archivo.");
			System.out.println("El archivo ya existe.");
		}

	}
	
	public static void buscarTexto(File nombreFichero, String texto) {
		
		int cantidadRepetida = 0;
		String lineaArchivo = null;
		
		try {
			FileReader fr = new FileReader(nombreFichero);
			BufferedReader br = new BufferedReader(fr);			
			try {
				while ( (lineaArchivo = br.readLine()) != null) {
					if (texto.equalsIgnoreCase(lineaArchivo)) {
						cantidadRepetida += 1;
					}					
				}
			} catch (IOException e) {
				System.out.println("Error al leer linea.");
				System.out.println("Error: " + e);
			}
			System.out.println("Texto buscado: " + texto);
			System.out.println("Cantidad de repeticiones del texto -> " + cantidadRepetida);
			
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar BufferedReader.");
				System.out.println("Error: " + e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
			System.out.println("Error: " + e);
		}		
	}
	
	public static void escribirTexto(File nombreFichero, ArrayList<String> listaTexto) {
		//File writer
		Iterator<String> it = listaTexto.iterator();
		try {
			FileWriter fw = new FileWriter(nombreFichero);
			BufferedWriter bw = new BufferedWriter(fw);
			
			while (it.hasNext()) {
				
				bw.write(it.next());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir archivo.");
			System.out.println("Error: " + e);
		}	
	}
}
