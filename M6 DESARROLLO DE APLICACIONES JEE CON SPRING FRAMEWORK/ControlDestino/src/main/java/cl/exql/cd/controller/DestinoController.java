package cl.exql.cd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import cl.exql.cd.model.Destino;
import cl.exql.cd.service.IDestinoService;
import cl.exql.cd.service.IPasajeroService;

@Controller
@RequestMapping("/destino")
public class DestinoController {
		
		@Autowired
		IDestinoService destinoService;
		
		@Autowired
		IPasajeroService pasajeroService;


		@GetMapping("/crearDestino")
		public String crear(Model model) {
			model.addAttribute("destino", new Destino());
			model.addAttribute("listaPasajeros", pasajeroService.findAll());
			return "crearDestino";
		}
		
		@PostMapping("/guardarDestino")
		public RedirectView guardar(Model model, @ModelAttribute Destino destino) {
			destinoService.save(destino);
			pasajeroService.save(destino.getPasajero());
		return new RedirectView("/destino/destinos");
		}
		

		@GetMapping("/destinos")
		public String destinos(Model model) {
			model.addAttribute("listaDestinos", destinoService.findAll());
		return "destinos";	
		}
	
}
