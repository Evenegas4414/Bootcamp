package cl.exql.ca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import cl.exql.ca.model.Alumno;
import cl.exql.ca.service.IAlumnoService;
import cl.exql.ca.service.IDireccionService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	IAlumnoService alumnoService;

	@Autowired
	IDireccionService direccionService;

	

	@GetMapping("/crearAlumno")
	public String crear(Model model) {
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("listaDirecciones", direccionService.findAll());
		return "crearAlumno";
	}

	@PostMapping("/guardarAlumno")
	public RedirectView guardar(Model model, @ModelAttribute Alumno alumno) {
		alumnoService.save(alumno);
		return new RedirectView("/alumno/alumnos");
	}
	
	@GetMapping("/alumnos")
	public String alumnos(Model model) {
		model.addAttribute("listaAlumnos", alumnoService.findAll());
		return "alumnos";
	}

}
