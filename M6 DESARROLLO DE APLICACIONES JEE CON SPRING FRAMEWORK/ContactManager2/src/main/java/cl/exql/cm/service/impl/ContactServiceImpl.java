package cl.exql.cm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.cm.model.Contacto;
import cl.exql.cm.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	Contacto contacto;
	static int idSiguiente = 1;
	private List<Contacto> listaContactos = new ArrayList<Contacto>();
	
	@Override
	public List<Contacto> getContactList() {		
		return listaContactos;		
	}
	
	@Override
	public boolean addContact(Contacto c) {
		c.setIdContacto(idSiguiente++);
		listaContactos.add(c);
		if (listaContactos.isEmpty()) {
			return false;
		}
		return true;		
	}

	@Override
	public boolean deleteContact(String id) {		
		Contacto contactoEliminado = new Contacto();
		for (Contacto c : listaContactos) {
			if ( c.getIdContacto() == Integer.parseInt(id)) {
				contactoEliminado = c;
			}
		}		
		return listaContactos.remove(contactoEliminado);
	}
}
