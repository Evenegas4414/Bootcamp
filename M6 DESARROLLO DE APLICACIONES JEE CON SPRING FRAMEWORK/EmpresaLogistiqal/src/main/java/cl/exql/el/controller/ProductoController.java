package cl.exql.el.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.exql.el.model.Producto;
import cl.exql.el.service.IProductoService;
import cl.exql.el.service.impl.ProductoServiceImpl;
import cl.exql.el.vo.ProductoVO;

@Controller
public class ProductoController {

	private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	private IProductoService svc;

	@GetMapping({ "", "/", "/home" })
	public String home(ModelMap model) {
		model.put("VO", svc.getAllProductos());
		return "home";
	}

	@GetMapping("/agregarForm")
	public String agregarForm(ModelMap model) {
		return "agregar";
	}

	@PostMapping("/agregar")
	public ModelAndView agregarSubmit(@ModelAttribute Producto producto, RedirectAttributes ra) {
		ProductoVO respuestaServicio = svc.add(producto);
		ra.addFlashAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/agregarForm");
		}
	}

	@GetMapping("/modificarForm")
	public ModelAndView editarForm(ModelMap model, @RequestParam Integer idProducto) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de edición, intente nuevamente.");
		respuestaServicio = svc.findById(idProducto);
		model.put("mensaje", respuestaServicio.getMensaje());
		model.put("producto", respuestaServicio.getProductos().get(0));
		return new ModelAndView("modificar");
	}

	@PostMapping("/modificar")
	public ModelAndView editarSubmit(@ModelAttribute Producto producto, Model model) {
		ProductoVO respuestaServicio = svc.update(producto);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/modificarForm");
		}
	}

	@GetMapping("/eliminarForm")
	public ModelAndView eliminar(ModelMap model, @RequestParam Integer idProducto) {
		ProductoVO respuestaServicio = new ProductoVO();
		respuestaServicio.setMensaje("No se pudo cargar la vista de eliminacion, intente nuevamente.");
		respuestaServicio = svc.findById(idProducto);
		model.put("mensaje", respuestaServicio.getMensaje());
		model.put("producto", respuestaServicio.getProductos().get(0));
		return new ModelAndView("eliminar");
	}

	@PostMapping("/eliminar")
	public ModelAndView eliminarSubmit(@ModelAttribute Producto producto, Model model) {
		ProductoVO respuestaServicio = svc.delete(producto);
		model.addAttribute("mensaje", respuestaServicio.getMensaje());
		if (respuestaServicio.getCodigo().equals("0")) {
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/eliminarForm");
		}
	}

	@PostMapping("/buscar")
	public String buscarSubmit(ModelMap model, @RequestParam String textoBuscado) {
		ProductoVO respuestaServicio = svc.findByNombre(textoBuscado);
		System.out.println(respuestaServicio.toString());
		model.put("mensaje", respuestaServicio.getMensaje());
		model.put("VO", respuestaServicio);
		return "buscar";
	}

}
