package cl.exql.sn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControlador {
	private final static Logger logger = LoggerFactory.getLogger(MainControlador.class);

	@RequestMapping(value= {"","/"})
	public String Main(Model modelo) {

		String archivo = "src/main/resources/static/noticias.txt";
		ArrayList<String> noticias = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				noticias.add(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
			
			String[] noticia1 = noticias.get(0).split("@@");
			String[] noticia2 = noticias.get(1).split("@@");
			String[] noticia3 = noticias.get(2).split("@@");
			String[] noticia4 = noticias.get(3).split("@@");
			String[] noticia5 = noticias.get(4).split("@@");
			
			modelo.addAttribute("noticia1Titulo", noticia1[0]);
			modelo.addAttribute("noticia1Texto", noticia1[1]);
			modelo.addAttribute("noticia1Imagen", noticia1[2]);
			
			modelo.addAttribute("noticia2Titulo", noticia2[0]);
			modelo.addAttribute("noticia2Texto", noticia2[1]);
			modelo.addAttribute("noticia2Imagen", noticia2[2]);
			
			modelo.addAttribute("noticia3Titulo", noticia3[0]);
			modelo.addAttribute("noticia3Texto", noticia3[1]);
			modelo.addAttribute("noticia3Imagen", noticia3[2]);
			
			modelo.addAttribute("noticia4Titulo", noticia4[0]);
			modelo.addAttribute("noticia4Texto", noticia4[1]);
			modelo.addAttribute("noticia4Imagen", noticia4[2]);
			
			modelo.addAttribute("noticia5Titulo", noticia5[0]);
			modelo.addAttribute("noticia5Texto", noticia5[1]);
			modelo.addAttribute("noticia5Imagen", noticia5[2]);
			logger.info("Se ha completado la carga de noticias");
		} catch (Exception e) {
			logger.error("Error al leer archivo: " + archivo + " - " + e);
		}
		

		return "main";
	}
}