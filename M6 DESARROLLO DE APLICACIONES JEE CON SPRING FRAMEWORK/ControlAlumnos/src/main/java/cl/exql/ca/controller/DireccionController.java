package cl.exql.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import cl.exql.ca.model.Direccion;
import cl.exql.ca.service.IAlumnoService;
import cl.exql.ca.service.IDireccionService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	IDireccionService direccionService;
	
	@Autowired
	IAlumnoService alumnoService;


	@GetMapping("/crearDireccion")
	public String crear(Model model) {
		model.addAttribute("direccion", new Direccion());	
		model.addAttribute("tipos", (new Direccion()).getTipo().values());	
		return "crearDireccion";
	}
	
	@PostMapping("/guardarDireccion")
	public RedirectView guardar(Model model, @ModelAttribute Direccion direccion) {
		direccionService.save(direccion);
	return new RedirectView("/direccion/direcciones");
	}
	

	@GetMapping("/direcciones")
	public String direcciones(Model model) {
		model.addAttribute("listaDirecciones", direccionService.findAll());
	return "direcciones";	
	}
}
