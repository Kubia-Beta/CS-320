////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
////////////////////////

package main;

import java.util.HashMap;
import java.util.Scanner;

public class ContactService {
	private HashMap<String, Contact> Contacts = new HashMap<String, Contact>();
	// Stores Contacts by ID as a key.
	
	//====================================
	// Public Methods
	//====================================

	/**
	 * Checks for a unique ID and reserves that ID if it is unused
	 * @param str ID, str First, str Last, str Phone, str Address
	 * @return N/A
	 */
	public void addContact(String newID, String newFirst, String newLast, String newPhone,
			String newAddress) {
		// Call uniqueness check
		boolean isPresent = Contacts.containsValue(newID);
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists.");
		}
		// Call constructor for contact obj
		Contact tempContact = new Contact(newID, newFirst, newLast, newPhone, newAddress);
		// Add new contact obj to Contacts
		Contacts.put(newID, tempContact);
		return;
	}
	
	public void deleteContact(String ID) {
		// Make sure the ID exist, throw exception if it doesn't. Implicit else continues
		boolean	isPresent = Contacts.containsValue(ID);
			if (isPresent == false) {
				throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
			}
		Contacts.remove(ID); // Remove the object by ID
		return;
	}
	
	public void updateContact() {
		Scanner in = new Scanner(System.in);
		System.out.println("Select field to update:" + "\r\n" + "[1] First Name"  + "\r\n" +
				 "\r\n" + "[2] Last Name" + "\r\n" + "[3] Phone Number" + "\r\n" + "[4] Address");
		String userMsg = in.nextLine();
		int choice = Integer.valueOf(userMsg);
		// switch for choosing field to update
		switch(choice) { // TODO: Add case for exit[5]
		// case 1: update First
		case 1:
			
			break;
		// case 2: update Last
		case 2: 
			
			break;
		// case 3: update Phone
		case 3:
			
			break;
		// case 4: update Address
		case 4:
			
			break;
		default:
			System.out.println("Invalid selection.");
		}
	}
	
}
