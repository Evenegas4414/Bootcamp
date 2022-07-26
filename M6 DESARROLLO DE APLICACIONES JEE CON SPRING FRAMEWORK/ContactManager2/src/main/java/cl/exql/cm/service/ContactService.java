package cl.exql.cm.service;

import java.util.List;

import cl.exql.cm.model.Contacto;

public interface ContactService {
	
	List<Contacto> getContactList();
	boolean addContact(Contacto c);
	boolean deleteContact(String id);

}
