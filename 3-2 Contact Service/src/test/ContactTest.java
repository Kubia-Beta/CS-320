/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

import main.Contact;
import org.junit.jupiter.api.Test;

/**
 * @author connorscultho_snhu
 *
 */
public class ContactTest {
	
	public String testID = "ID New";
	public String testFirst = "FirstName";
	public String testLast = "LastName";
	public String testPhone = "1234567890";
	public String testAddress = "123456 Username Ln, Alabama";
	public String nullString = null;
	
	@Test
	void testContactClass() {
		Contact contacts = new Contact(testID, testFirst, testLast, testPhone,
				testAddress);
		assertTrue(contacts.getAddress().equals(testAddress));
		assertTrue(contacts.getfirstName().equals(testFirst));
		assertTrue(contacts.getID().equals(testID));
		assertTrue(contacts.getLastName().equals(testLast));
		assertTrue(contacts.getPhoneNumber().equals(testPhone));
	}
	
	@Test
	void testTooLongContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID + "OVERLOAD",
				testFirst, testLast, testPhone,	testAddress);
		});}
	
	@Test
	void testTooLongContactFirst() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID,
				testFirst + "OVERLOAD"
				,testLast, testPhone, testAddress);
		});}
	
	@Test
	void testTooLongContactLast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst
					,testLast + "OVERLOAD"
					,testPhone, testAddress);
		});}

	
	@Test
	void testTooLongContactPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst, testLast,
				testPhone + "OVERLOAD"
				,testAddress);
		});}

	@Test
	void testTooLongContactAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst, testLast, testPhone,
				testAddress + "OVERLOAD");
		});}
	
	@Test
	void testDefaultConstructor() {
		Contact contact = new Contact();
		assertEquals("", contact.getID());
		assertEquals("", contact.getfirstName());
		assertEquals("", contact.getLastName());
		assertEquals("", contact.getPhoneNumber());
		assertEquals("", contact.getAddress());
	}
	
	@Test
	void testNullContactID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(nullString,
				testFirst, testLast, testPhone,	testAddress);
		});}
	
	@Test
	void testNullContactFirst() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID,
				nullString
				,testLast, testPhone, testAddress);
		});} 
	
	@Test
	void testNullContactLast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst
					,nullString
					,testPhone, testAddress);
		});}

	
	@Test
	void testNullContactPhone() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst, testLast,
				nullString
				,testAddress);
		});}

	@Test
	void testNullContactAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		new Contact(testID, testFirst, testLast, testPhone,
				nullString);
		});}
}
