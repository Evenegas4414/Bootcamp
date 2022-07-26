package cl.exql.cd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import cl.exql.cd.model.Pasajero;
import cl.exql.cd.service.IDestinoService;
import cl.exql.cd.service.IPasajeroService;

@Controller
@RequestMapping("/pasajero")
public class PasajeroController {
		
		@Autowired
		IPasajeroService pasajeroService;

		@Autowired
		IDestinoService destinoService;

		

		@GetMapping("/crearPasajero")
		public String crear(Model model) {
			model.addAttribute("pasajero", new Pasajero());
			model.addAttribute("listaDestinos", destinoService.findAll());
			return "crearPasajero";
		}

		@PostMapping("/guardarPasajero")
		public RedirectView guardar(Model model, @ModelAttribute Pasajero pasajero) {
			pasajeroService.save(pasajero);
			return new RedirectView("/pasajero/pasajeros");
		}
		
		@GetMapping("/pasajeros")
		public String pasajeros(Model model) {
			model.addAttribute("listaPasajeros", pasajeroService.findAll());
			return "pasajeros";
		}
}
