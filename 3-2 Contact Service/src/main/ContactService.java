////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
////////////////////////

package main;

import java.util.HashSet;

public class ContactService {
	private HashSet<String> IDTable = new HashSet<String>(); // This holds our ID's to verify uniqueness
	private HashSet<Contact> Contacts = new HashSet<Contact>();
	
	//====================================
	// Public Methods
	//====================================
	
	/**
	 * Checks for a unique ID and reserves that ID if it is unused
	 * @param String ID
	 * @return N/A
	 */
	public void uniqueness(String NewID) {
	boolean isPresent = IDTable.contains(NewID); // Check if the ID exists already
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists");
		}
		IDTable.add(NewID); // Add the ID to the table to reserve it
	}
	
	public void checkUniqueness(String NewID){
		
	}

	public HashSet<Contact> getContacts() {
		return Contacts;
	}
	
	public void addContact(String ID, String First, String Last, String Phone,
			String Address) {
		
	}
	
	
}
