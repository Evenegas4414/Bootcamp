package cl.exql.ab.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cl.exql.ab.model.Material;

@Controller
public class MaterialController {
	
	@GetMapping("/materiales")
	public ModelAndView inicio(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("materiales");
		modelAndView.addObject("material", new Material());
		modelAndView.addObject("materiales", session.getAttribute("materiales"));
		return modelAndView;
	}

	@PostMapping("/materiales/agregar")
	public RedirectView inicio(HttpSession session, @ModelAttribute Material material) {
		List<Material> listaMateriales = new ArrayList<>();
		if (session.getAttribute("materiales") != null)
			listaMateriales.addAll((List<Material>) session.getAttribute("materiales"));
		
		material.setFecha((new Date())+"");
		listaMateriales.add(material);
		session.setAttribute("materiales", listaMateriales);
		return new RedirectView("/materiales");
	}
}
