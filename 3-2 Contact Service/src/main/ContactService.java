////////////////////////////
// By:                   //
// Connor Sculthorpe    //
// 22 June 2024        //
// TO: 25 Aug 2024    //
///////////////////////

package main;

import java.util.HashMap;
//import java.util.Scanner;

public class ContactService {
	private HashMap<String, Contact> Contacts = new HashMap<String, Contact>();
	// Stores Contacts by ID as a key.
	//ContactService(){
	//	// TODO: Default constructor
	//}
	
	
	//====================================
	// Public Methods
	//====================================

	/**
	 * Checks for a unique ID and reserves that ID if it is unused
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
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
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
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
	 * Fetches a contact by ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID
	 * @return Contact object
	 */
	public Contact lookupContact(String ID) {
		Contact tempContact = new Contact();
		tempContact = Contacts.get(ID);
		return tempContact;
	}
	
	/**
	 * DEPRECATED: Updates a contact based on input ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, int Type, str updateValue. Type ID: [1] First, [2] Last, [3] Phone, [4] Address 
	 * @return N/A
	 */
	public void updateContact(String ID, int fieldType, String updatedField) { // TODO: Split this into 4 functions based on type?
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
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
		}
	}
	
	/**
	 * Updates an address associated with a contact object based on input ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, str updatedAddress.
	 * @return N/A
	 */
	public void updateAddress(String ID, String updatedAddress){
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempContact.setAddress(updatedField);
		Contacts.put(ID, tempContact);
	}
	
	/**
	 * Updates a first name associated with a contact object based on input ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, str updatedAddress.
	 * @return N/A
	 */
	public void updateFirstName(String ID, String updatedFirstName){
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempContact.setFirstName(updatedFirstName);
		Contacts.put(ID, tempContact);
	}
	
	/**
	 * Updates a last name associated with a contact object based on input ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, str updatedAddress.
	 * @return N/A
	 */
	public void updateLastName(String ID, String updatedLastName){
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempContact.setLastName(updatedLastName);
		Contacts.put(ID, tempContact);
	}
	
	/**
	 * Updates an address associated with a contact object based on input ID
	 * Time: O(1), θ(1), Ω(1)
	 * Space: O(n)
	 * @param str ID, str updatedAddress.
	 * @return N/A
	 */
	public void updatePhoneNumber(String ID, String updatedPhoneNumber){
		Contact tempContact = new Contact(); // Holds the searched contact's values
		tempContact = Contacts.get(ID); // Assign the data
		if (tempContact == null) { // If no data was assigned
			throw new IllegalArgumentException("Invalid ID; This ID does not exist.");
		}
		tempContact.setPhoneNumber(updatedPhoneNumber);
		Contacts.put(ID, tempContact);
	}	
}
