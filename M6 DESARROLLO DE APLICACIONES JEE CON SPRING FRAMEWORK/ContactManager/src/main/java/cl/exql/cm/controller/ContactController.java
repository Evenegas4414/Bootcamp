package cl.exql.cm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.exql.cm.model.Contacto;

@Controller
@RequestMapping("/contactManager")
public class ContactController {
	
	@Autowired
	Contacto contacto;
	static int idSiguiente = 1;
	private List<Contacto> listaContactos = new ArrayList<Contacto>();
	
	@RequestMapping(value={"", "/"},  method=RequestMethod.GET)
	public String getContactList(ModelMap model) {
		
		model.put("listaContactos", listaContactos);		
		//return "hola";
		return "contactManager";
	}
	
	@RequestMapping(value="/addContact", method=RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contacto") Contacto contactoIngresado) {
		
		contactoIngresado.setIdContacto(idSiguiente++);
		listaContactos.add(contactoIngresado);
		model.put("listaContactos", listaContactos);		
		return "contactManager";
	}
	
	@RequestMapping(value="/deleteContact", method=RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") String idSeleccionado) {
		Contacto contactoEliminado = new Contacto();
		for (Contacto c : listaContactos) {
			if ( c.getIdContacto() == Integer.parseInt(idSeleccionado)) {
				contactoEliminado = c;
			}
		}		
		listaContactos.remove(contactoEliminado);
		model.put("listaContactos", listaContactos);			
		return "contactManager";
	}
}
