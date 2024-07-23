////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
////////////////////////

package main;

import java.util.HashMap;
//import java.util.HashSet;

public class ContactService {
	//private HashSet<String> IDTable = new HashSet<String>(); // This holds our ID's to verify uniqueness
	private HashMap<String, Contact> Contacts = new HashMap<String, Contact>();
	// Stores Contacts by ID as a key.
	
	//====================================
	// Public Methods
	//====================================

	/**
	 * Checks for a unique ID and reserves that ID if it is unused
	 * @param String ID
	 * @return N/A
	 */
	public void uniquenessCheck(String newID) {
	boolean isPresent = IDTable.contains(newID); // Checks if the ID exists already
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists");
		}
		IDTable.add(newID); // Add the ID to the table to reserve it
	}

	public HashSet<Contact> getContacts() {
		return Contacts;
	}
	
	public void addContact(String newID, String newFirst, String newLast, String newPhone,
			String newAddress) {
		// Call uniqueness check
		boolean isPresent = IDTable.contains(newID);
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists.");
		}
		IDTable.add(newID); // Add the ID to the table to reserve it
		// Call constructor for contact obj
		Contact tempContact = new Contact(newID, newFirst, newLast, newPhone, newAddress);
		// Add new contact obj to Contacts
		Contacts.add(tempContact);
		return;
	}
	
	public void deleteContact(String ID) {
		// call Contacts.contains(id);
		boolean	isPresent = 
		// if false, throw exception. Implicit else continues
		// Remove the object by ID from both tables
		Contacts.remove(ID);
		IDTable.remove(ID);
	}
	
	public void updateContact() {
		// switch for choosing field to update
		// case 1: update ID
		// case 2: update First
		// case 3: update Last
		// case 4: update Phone
		// case 5: update Address
		// case else: exit function
	}
	
}
