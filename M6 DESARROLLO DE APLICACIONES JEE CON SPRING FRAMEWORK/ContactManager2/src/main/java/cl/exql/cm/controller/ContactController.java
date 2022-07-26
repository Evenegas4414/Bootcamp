package cl.exql.cm.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.exql.cm.model.Contacto;
import cl.exql.cm.service.ContactService;

@Controller
@RequestMapping("/contactManager")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value={"", "/"},  method=RequestMethod.GET)
	public String getContactList(ModelMap model) {
		
		model.put("listaContactos", contactService.getContactList());		
		return "contactManager";
	}
	
	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contacto") Contacto contactoIngresado) {
		contactService.addContact(contactoIngresado);
		model.put("listaContactos", contactService.getContactList());		
		return "contactManager";
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") String idSeleccionado) {
		contactService.deleteContact(idSeleccionado);
		model.put("listaContactos", contactService.getContactList());			
		return "contactManager";
	}
}
