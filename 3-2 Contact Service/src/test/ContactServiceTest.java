/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

/**
 * @author connorscultho_snhu
 *
 */
class ContactServiceTest {
	
	private String testID = "ID New";
	private String testFirst = "FirstName";
	private String testLast = "LastName";
	private String testPhone = "1234567890";
	private String testAddress = "123456 Username Lane, Alabama";
	ContactService aContactService = new ContactService();
	
	@BeforeEach
	 void setupBase() {
		aContactService.addContact(testID, testFirst, testLast, testPhone, testAddress);
	}
	
	@Test
	void testCreateDuplicate() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.addContact(testID, testFirst, testLast, testPhone, testAddress);
		});}
	
	@Test
	void testCreateTooLongAllFields() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.addContact(testID + "OVERLOAD", testFirst + "OVERLOAD",
					testLast + "OVERLOAD", testPhone + "OVERLOAD", testAddress + "OVERLOAD");
		});}
	
	@Test
	void testDeleteExists() {
		assertNotNull(aContactService.lookupContact(testID));
		aContactService.deleteContact(testID);
		assertNull(aContactService.lookupContact(testID));
	}
	
	@Test
	void testDeleteNoExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.deleteContact("NoExist");
		});}
	
	@Test
	void testUpdateInvalidID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact("NoExist", 1, testFirst);
		});
		assertNull(aContactService.lookupContact("NoExist"));
	}
	
	@Test
	void testUpdateInvalidFirst() {
		Contact aContact = new Contact();
		assertEquals(aContact.getID(), "");
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 1, testFirst + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));
	}
	
	@Test
	void testUpdateInvalidLast() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 2, testLast + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));
	}
	
	@Test
	void testUpdateInvalidPhone() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 3, testPhone + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));		
	}
	
	@Test
	void testUpdateInvalidAddress() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 4, testAddress + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));	
	}
	
	@Test
	void testUpdateInvalidOutOfRange() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact("12345", 7, testAddress + "0");
		});
		assertNull(aContactService.lookupContact("12345"));
	}
	
	@Test
	void testUpdateValidFirst() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getfirstName();
		aContactService.updateContact(testID, 1, "newFirst");
		String afterString = aContact.getfirstName();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidLast() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getLastName();
		aContactService.updateContact(testID, 2, "newLast");
		String afterString = aContact.getLastName();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidPhone() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getPhoneNumber();
		aContactService.updateContact(testID, 3, "0987654321");
		String afterString = aContact.getPhoneNumber();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidAddress() {
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getAddress();
		aContactService.updateContact(testID, 4, "36 Doesnt Exist ln");
		String afterString = aContact.getAddress();
		assertNotEquals(beforeString, afterString); 
	}
}
