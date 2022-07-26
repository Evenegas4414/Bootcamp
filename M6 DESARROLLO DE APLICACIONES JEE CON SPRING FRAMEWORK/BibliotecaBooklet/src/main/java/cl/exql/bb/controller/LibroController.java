package cl.exql.bb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.exql.bb.model.Libro;
import cl.exql.bb.model.LibroBoolean;
import cl.exql.bb.service.ILibroService;
import cl.exql.bb.vo.LibroVO;

@Controller 
public class LibroController {

	private static final Logger log = LoggerFactory.getLogger(LibroController.class);

	@Autowired
	private ILibroService svc;

	@GetMapping({ "", "/", "/main", "/home" })
	public String home(Model model) {
		model.addAttribute("VO", svc.findAll());
		return "home";
	}

	@GetMapping("/agregarForm")
	public String agregarForm(Model model) {
		return "agregar";
	}

	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute LibroBoolean libroBoolean, Model model) {
		Libro libro = new Libro();
		libro.setAnio(libroBoolean.getAnio());
		libro.setAutor(libroBoolean.getAutor());
		libro.setTitulo(libroBoolean.getTitulo());
		libro.setImprenta(libroBoolean.getImprenta());
		if (libroBoolean.getDisponibilidad() == true) {
			libro.setDisponibilidad(1);
		} else if (libroBoolean.getDisponibilidad() == false) {
			libro.setDisponibilidad(0);
		}
		LibroVO respuestaServicio = svc.add(libro);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	@GetMapping("/editarForm")
	public ModelAndView editarForm(Model model, @RequestParam Integer id) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		respuestaServicio = svc.findById(id);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", new LibroBoolean(respuestaServicio.getLibros().get(0)));
		return new ModelAndView("editar");
	}

	@PostMapping("/editar")
	public ModelAndView editar(@ModelAttribute LibroBoolean libroBoolean, Model model) {
		Libro libro = new Libro();
		libro.setIdLibro(libroBoolean.getIdLibro());
		libro.setAnio(libroBoolean.getAnio());
		libro.setAutor(libroBoolean.getAutor());
		libro.setTitulo(libroBoolean.getTitulo());
		libro.setImprenta(libroBoolean.getImprenta());

		if (libroBoolean.getDisponibilidad() == true) {
			libro.setDisponibilidad(1);
		} else if (libroBoolean.getDisponibilidad() == false) {
			libro.setDisponibilidad(0);
		}
		LibroVO respuestaServicio = svc.update(libro);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/editarForm");
		}
	}

	@GetMapping("/eliminar")
	public ModelAndView eliminar(Model model, @RequestParam String id) {
		LibroVO respuestaServicio = new LibroVO();
		respuestaServicio.setMensaje("No se pudo eliminar el libro, intente nuevamente.");
		try {
			Libro eliminado = new Libro();
			eliminado.setIdLibro(Integer.parseInt(id));
			respuestaServicio = svc.delete(eliminado);
			model.addAttribute("mensaje", respuestaServicio.getMensaje());
			return new ModelAndView("redirect:/home");
		} catch (Exception e) {
			log.error("Error en LibroController eliminar", e);
		}
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		respuestaServicio = svc.findAll();
		model.addAttribute("VO", respuestaServicio);
		return new ModelAndView("redirect:/home");
	}

	@PostMapping("/buscar")
	public String buscarSubmit(Model model, @RequestParam String textoBuscado) {
		System.out.println(textoBuscado);
		LibroVO respuestaServicio = svc.findByTituloOrAutor(textoBuscado);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		model.addAttribute("VO", respuestaServicio);
		return "home";
	}
}
