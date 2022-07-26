package cl.exql.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	
	@GetMapping("/error403")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView("error403");
		return modelAndView;
	}

}
