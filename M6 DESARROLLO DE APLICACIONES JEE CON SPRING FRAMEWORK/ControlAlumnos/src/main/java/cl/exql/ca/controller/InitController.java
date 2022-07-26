package cl.exql.ca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class InitController {
	
	@RequestMapping({"/",""})
	public RedirectView ini() {	
	 return new RedirectView("/direccion/direcciones");
	}

}
