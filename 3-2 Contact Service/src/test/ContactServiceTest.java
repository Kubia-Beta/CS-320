////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
////////////////////////

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
	// Vars used to compare and create contacts to reduce magic values
	private String testID = "ID New";
	private String testFirst = "FirstName";
	private String testLast = "LastName";
	private String testPhone = "1234567890";
	private String testAddress = "123456 Username Lane, Alabama";
	ContactService aContactService = new ContactService(); // Empty parent
	
	@BeforeEach
	 void setupBase() { // Create a baseline contact to work with
		aContactService.addContact(testID, testFirst, testLast, testPhone, testAddress);
	}
	
	@Test
	void testCreateDuplicate() { // Checks that duplicate rejection is funcitoning
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.addContact(testID, testFirst, testLast, testPhone, testAddress);
		});}
	
	@Test
	void testCreateTooLongAllFields() { // Checks that fields that are too long are not accepted by addContact
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.addContact(testID + "OVERLOAD", testFirst + "OVERLOAD",
					testLast + "OVERLOAD", testPhone + "OVERLOAD", testAddress + "OVERLOAD");
		});}
	
	@Test
	void testDeleteExists() { // Checks that the contact exists, deletes it, verifies its null
		assertNotNull(aContactService.lookupContact(testID));
		aContactService.deleteContact(testID);
		assertNull(aContactService.lookupContact(testID));
	}
	
	@Test
	void testDeleteNoExist() { // Checks that non-existent contacts cant be reached by deleteContact
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.deleteContact("NoExist");
		});}
	
	@Test
	void testUpdateInvalidID() { // Checks that non-existent contacts cant be reached by updateContact
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact("NoExist", 1, testFirst);
		});
		assertNull(aContactService.lookupContact("NoExist"));
	}
	
	@Test
	void testUpdateInvalidFirst() { // Checks that invalid first names are rejected by updateContact
		Contact aContact = new Contact();
		assertEquals(aContact.getID(), "");
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 1, testFirst + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));
	}
	
	@Test
	void testUpdateInvalidLast() { // Checks that invalid last names are rejected by updateContact
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 2, testLast + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));
	}
	
	@Test
	void testUpdateInvalidPhone() {  // Checks that invalid phone numbers are rejected by updateContact
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 3, testPhone + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));		
	}
	
	@Test
	void testUpdateInvalidAddress() { // Checks that invalid addresses are rejected by updateContact
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact(testID, 4, testAddress + "OVERLOAD");
		});
		assertEquals(aContact, aContactService.lookupContact(testID));	
	}
	
	@Test
	void testUpdateInvalidOutOfRange() { // Checks that the switch case does not misfire
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aContactService.updateContact("12345", 7, testAddress + "0");
		});
		assertNull(aContactService.lookupContact("12345"));
	}
	
	@Test
	void testUpdateValidFirst() { // Checks updateContact's first name function works when valid
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getfirstName();
		aContactService.updateContact(testID, 1, "newFirst");
		String afterString = aContact.getfirstName();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidLast() { // Checks updateContact's last name function works when valid
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getLastName();
		aContactService.updateContact(testID, 2, "newLast");
		String afterString = aContact.getLastName();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidPhone() { // Checks updateContact's phone function works when valid
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getPhoneNumber();
		aContactService.updateContact(testID, 3, "0987654321");
		String afterString = aContact.getPhoneNumber();
		assertNotEquals(beforeString, afterString); 
	}
	
	@Test
	void testUpdateValidAddress() { // Checks updateContact's address function works when valid
		Contact aContact = new Contact();
		aContact = aContactService.lookupContact(testID);
		String beforeString = aContact.getAddress();
		aContactService.updateContact(testID, 4, "36 Doesnt Exist ln");
		String afterString = aContact.getAddress();
		assertNotEquals(beforeString, afterString); 
	}
}
