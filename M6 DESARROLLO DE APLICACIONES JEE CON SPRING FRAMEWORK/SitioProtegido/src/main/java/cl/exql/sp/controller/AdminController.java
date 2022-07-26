package cl.exql.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class AdminController {
	
	@GetMapping("/admin")
	public ModelAndView homeAdmin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}

}
