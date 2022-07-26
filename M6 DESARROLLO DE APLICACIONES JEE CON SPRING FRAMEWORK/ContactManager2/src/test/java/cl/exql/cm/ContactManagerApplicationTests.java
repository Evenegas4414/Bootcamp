package cl.exql.cm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.exql.cm.model.Contacto;
import cl.exql.cm.service.ContactService;

@SpringBootTest
class ContactManagerApplicationTests {

	@Autowired
	private ContactService contactService;
	@Autowired
	Contacto contacto;
	static int idSiguiente = 1;
	
	
	@Test
	void getContactListTest() {
		assertTrue(contactService.getContactList().isEmpty());
		contactService.addContact(new Contacto());
		assertFalse(contactService.getContactList().isEmpty());
	}
	
	@Test
	void addContactTest() {		
		assertTrue(contactService.addContact(new Contacto()));
	}
	
	@Test
	void deleteContact() {	
		contactService.addContact(new Contacto());
		contactService.getContactList().get(0).setIdContacto(1000);
		assertTrue(contactService.deleteContact("1000"));
	}

}
