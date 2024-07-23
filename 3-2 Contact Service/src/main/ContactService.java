////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
////////////////////////

package main;

import java.util.HashMap;
//import java.util.Scanner;

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
		boolean isPresent = Contacts.containsKey(newID);
		if (isPresent == true) { // No duplicates allowed!
			throw new IllegalArgumentException("Invalid ID; This ID already exists.");
		}
		// Call constructor for contact obj
		Contact tempContact = new Contact(newID, newFirst, newLast, newPhone, newAddress);
		// Add new contact obj to Contacts
		Contacts.put(newID, tempContact);
		return;
	}
	
	/**
	 * Deletes a contact at specified address
	 * @param str ID
	 * @return N/A
	 */
	public void deleteContact(String ID) {
		// Make sure the ID exist, throw exception if it doesn't. Implicit else continues
		boolean	isPresent = Contacts.containsKey(ID);
			if (isPresent == false) {
				throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
			}
		Contacts.remove(ID); // Remove the object by ID
		return;
	}
	
	/**
	 * Updates a contact based on input ID
	 * @param str ID, int Type, str updateValue. Type ID: [1] First, [2] Last, [3] Phone, [4] Address 
	 * @return N/A
	 */
	public void updateContact(String ID, int fieldType, String updatedField) { // TODO: Split this into 4 functions based on type?
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		//Scanner in = new Scanner(System.in);
		//System.out.println("Select field to update:" + "\r\n" + "[1] First Name"  + "\r\n" +
		//		 "\r\n" + "[2] Last Name" + "\r\n" + "[3] Phone Number" + "\r\n" + "[4] Address");
		//String userMsg = in.nextLine(); // Basic user input until a UI is present, todo: switch on input toupdateContact(int anint, str id)
		//int choice = Integer.valueOf(userMsg);
		// switch for choosing field to update
		switch(fieldType) {
		// case 1: update First
		case 1:
			//System.out.println("Enter the new first name:");
			//userMsg = in.nextLine();
			tempContact.setFirstName(updatedField);
			Contacts.put(ID, tempContact);
			break;
		// case 2: update Last
		case 2: 
			tempContact.setLastName(updatedField);
			Contacts.put(ID, tempContact);
			break;
		// case 3: update Phone
		case 3:
			tempContact.setPhoneNumber(updatedField);
			Contacts.put(ID, tempContact);
			break;
		// case 4: update Address
		case 4:
			tempContact.setAddress(updatedField);
			Contacts.put(ID, tempContact);
			break;
		default:
			System.out.println("Invalid selection.");
		}
	}
	
}
